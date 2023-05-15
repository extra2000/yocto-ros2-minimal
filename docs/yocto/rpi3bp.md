# Raspberry Pi 3B+


## Prerequisites

* [extra2000/xilinx-toolkit v3.x image](https://github.com/extra2000/xilinx-toolkit)
* SDCard with at least 4GB.
* Digilent Analog Discovery 2 for accessing serial console through UART pins.


## Building

Allow source files to be mounted into container:
```
chcon -R -t container_file_t project
```

Create container:
```
podman run -it --rm \
    --network=host \
    --userns="keep-id:uid=1000,gid=1000" \
    -v ${PWD}/project:${PWD}/project:rw \
    --workdir ${PWD}/project/yocto/rpi3bp \
    --security-opt label=type:xilinx_toolkit_podman.process \
    localhost/extra2000/xilinx-toolkit:latest \
    bash
source layers/poky/oe-init-build-env build
```

Check dependencies:
```
bitbake -p ros-core
```

Build:
```
bitbake ros-image-core
```

Flash to SD card:
```
bzcat project/yocto/rpi3bp/build/tmp/deploy/images/raspberrypi3-64/ros-image-core-humble-raspberrypi3-64-*.rootfs.wic.bz2 | sudo dd bs=4M iflag=fullblock oflag=direct status=progress of=/dev/sdX; sudo sync
```


## Testing

Insert SD card and power on Raspberry Pi 3B+. Access serial console and login with `root` user. Then, follow [Testing](common/testing.md) instructions.


## Cleaning Up

To clean build:
```
rm -rf project/yocto/rpi3bp/build/{sstate-cache,tmp}
```


## Known Issues

When entering ROS2 environment using command:
```
source /etc/profile.d/ros/setup.bash
```

there will be errors such that:
```
Usage: head [OPTIONS] [FILE]...
head: invalid option -- 'c'
```
