# Yocto Building for All Targets


## Prerequisites

* [extra2000/xilinx-toolkit v3.x image](https://github.com/extra2000/xilinx-toolkit)
* Available disk space: at least 350GB
* SDCard with at least 4GB.
* Digilent Analog Discovery 2 for accessing serial console through UART pins.


## Building

Create container:
```
podman run -it --rm \
    --network=host \
    --userns="keep-id:uid=1000,gid=1000" \
    -v ${PWD}/project:${PWD}/project:rw \
    --workdir ${PWD}/project/yocto \
    --security-opt label=disable \
    localhost/extra2000/xilinx-toolkit:latest \
    bash
source layers/poky/oe-init-build-env build
```


## Building for All Targets

Check dependencies:
```
bitbake -p mc:*:ros-core
```

Build:
```
bitbake mc:*:ros-image-core
```


## Testing with QEMU

To start QEMU, use the following `runqemu` command:
```
runqemu qemuarm slirp nographic
```

Login with `root` without password. Then follow testing instructions in [Testing](common/testing.md).


## Flashing to SD Card

Image files and instructions how to flash to SD card are as follows:
* Raspberry Pi Zero W image file: `project/yocto/build/tmp/deploy/images/raspberrypi0-wifi/ros-image-core-humble-raspberrypi0-wifi-*.rootfs.wic.bz2`. See [Flashing to SD Card for Raspberry Pi Zero W](specifics/rpizero-w.md#flashing-to-sd-card);
* Raspberry Pi Zero 2 W image file: `project/yocto/build/tmp/deploy/images/raspberrypi0-2w-64/ros-image-core-humble-raspberrypi0-2w-64-*.rootfs.wic.bz2`. See [Flashing to SD Card for Raspberry Pi Zero 2 W](specifics/rpizero2-w.md#flashing-to-sd-card);
* Raspberry Pi 3 B+ image file: `project/yocto/build/tmp/deploy/images/raspberrypi3-64/ros-image-core-humble-raspberrypi3-64-*.rootfs.wic.bz2`. See [Flashing to SD Card for Raspberry Pi 3 B+](specifics/rpi3bp.md#flashing-to-sd-card);
* Raspberry Pi 4 B image file: `project/yocto/build/tmp/deploy/images/raspberrypi4-64/ros-image-core-humble-raspberrypi4-64-*.rootfs.wic.bz2`. See [Flashing to SD Card for Raspberry Pi 4 B](specifics/rpi4b.md#flashing-to-sd-card);
* Rock64 image file: `project/yocto/build/tmp/deploy/images/rock64/ros-image-core-humble-rock64-*.rootfs.wic`. See [Flashing to SD Card for Rock64](specifics/rock64.md#flashing-to-sd-card);


## Testing for Specific Boards

To test on specific boards, see the following list:
* [Testing for Raspberry Pi Zero W](specifics/rpizero-w.md#testing);
* [Testing for Raspberry Pi Zero 2 W](specifics/rpizero2-w.md#testing);
* [Testing for Raspberry Pi 3 B+](specifics/rpi3bp.md#testing);
* [Testing for Raspberry Pi 4 B](specifics/rpi4b.md#testing);
* [Testing for Rock64](specifics/rock64.md#testing);


## Cleaning Up

To clean build:
```
rm -rf project/yocto/build/{sstate-cache,tmp}
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
