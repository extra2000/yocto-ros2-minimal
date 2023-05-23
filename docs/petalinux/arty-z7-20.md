# Arty Z7-20


## Prerequisites

Requirements:
* [extra2000/xilinx-toolkit v3.x image](https://github.com/extra2000/xilinx-toolkit)
* Vitis and PetaLinux `v2022.2`
* Arty Z7-20 board version: `digilentinc.com:arty-z7-20:part0:1.1`

Allow X11 for Podman:
```
xhost +local:
```


## Creating Hardware

Create Vivado build directory:
```
mkdir -pv project/vivado/run/arty-z7-20
```

From the project root directory, execute the following commands:
```
podman run -it --rm \
    -e DISPLAY=$DISPLAY \
    --device=/dev/dri \
    --network=host \
    --userns="keep-id:uid=1000,gid=1000" \
    -v ${PWD}/project:${PWD}/project:rw \
    -v xilinx-tools-v2022-2:/tools/Xilinx:ro \
    --workdir ${PWD}/project/vivado/run/arty-z7-20 \
    --security-opt label=disable \
    localhost/extra2000/xilinx-toolkit:latest \
    bash
source /tools/Xilinx/Vitis/2022.2/settings64.sh
vivado \
    -mode batch \
    -source ../../script/arty-z7-20.tcl \
    -notrace \
    -tclargs \
    --project_name ros2-minimal
vivado -mode gui ros2-minimal/ros2-minimal.xpr
```

Do the followings to generate XSA file:
* "PROGRAM AND DEBUG" > Generate Bitstream
* "IP INTEGRATOR" > "Export Platform" with the following options:
    * Platform type: Hardware
    * Platform state: Pre-synthesis
    * Include bitstream: `true`
    * You may change "Platform properties" details such as Platform Name, Vendor, Board, Version, and Description
    * Leave other options as default

Exit the container
```
exit
```


## Building PetaLinux

Spawn new container:
```
podman run -it --rm \
    --network=host \
    --userns="keep-id:uid=1000,gid=1000" \
    -v ${PWD}/project:${PWD}/project:rw \
    -v xilinx-tools-v2022-2:/tools/Xilinx:ro \
    --workdir ${PWD}/project/petalinux/arty-z7-20 \
    --security-opt label=disable \
    localhost/extra2000/xilinx-toolkit:latest \
    bash
source /tools/Xilinx/PetaLinux/2022.2/tool/settings.sh
```

Create PetaLinux metadata file:
```
mkdir -pv .petalinux
echo "PETALINUX_VER=2022.2" > .petalinux/metadata
```

Get hardware description:
```
petalinux-config --get-hw-description ../../vivado/run/arty-z7-20/ros2-minimal/
```

Build and package `rootfs`, and then build for WIC `images/linux/petalinux-sdimage.wic` for SD card:
```
petalinux-build
petalinux-package \
    --boot \
    --fsbl images/linux/zynq_fsbl.elf \
    --fpga images/linux/system.bit \
    --u-boot
petalinux-package --wic
```

Build and package `sysroot` (SDK):
```
petalinux-build --sdk
petalinux-package --sysroot
```

**NOTE: Later to source SDK:**
```
source images/linux/sdk/environment-setup-cortexa9t2hf-neon-xilinx-linux-gnueabi
```

To package for QEMU:
```
chmod u+r images/linux/sdk/sysroots/cortexa9t2hf-neon-xilinx-linux-gnueabi/usr/bin/sudo
petalinux-package \
    --prebuilt \
    --fpga ./images/linux/system.bit \
    --add images/linux/image.ub:images/image.ub
```

Exit the container or otherwise continue to next Section to test with QEMU


## Testing ROS2 with QEMU

Start QEMU which binds TCF Agent port `1534` for Vitis development and debugging. Default user is `petalinux`:
```
petalinux-boot \
    --qemu \
    --prebuilt 3 \
    --qemu-args \
    "-net nic,netdev=eth0 -netdev user,id=eth0,hostfwd=tcp:127.0.0.1:1534-:1534 -net nic"
```

Source ROS2 environment:
```
source /etc/profile.d/ros/setup.bash
```

To list packages and executables (the package `ros2-helloworld-cpp` should appear):
```
ros2 pkg list
ros2 pkg executables
```

To run the simple Hello World example:
```
ros2 run ros2-helloworld-cpp main
```

To shutdown QEMU, execute `sudo poweroff`. Wait for `System halted`, and then to terminate QEMU, do `CTRL + A` and type `X`.

Exit the container.


## Flashing to SD Card

Insert SD card and execute the following command:
```
sudo dd \
    bs=4M \
    if=project/petalinux/arty-z7-20/images/linux/petalinux-sdimage.wic \
    iflag=fullblock \
    oflag=direct \
    status=progress \
    of=/dev/sdX
sudo sync
```

Insert SD card into Arty Z7-20 board, connect USB to your computer, and power on the board. Use the following `screen` command to access shell:
```
screen /dev/ttyUSB1 115200
```

To exit from `screen,` do `CTRL` + `A` and then type `:quit`.
