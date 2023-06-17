# Raspberry Pi Zero W


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

To check dependencies:
```
bitbake -p mc:raspberrypi0-wifi:ros2-image
```

To build:
```
bitbake mc:raspberrypi0-wifi:ros2-image
```


## Flashing to SD Card

Execute the following command:
```
bzcat project/yocto/build/tmp/deploy/images/raspberrypi0-wifi/ros-image-core-humble-raspberrypi0-wifi-*.rootfs.wic.bz2 | sudo dd bs=4M iflag=fullblock oflag=direct status=progress of=/dev/sdX; sudo sync
```


## Testing

Insert SD card and power on Raspberry Pi Zero W. Access serial console and login with `root` user. Then, follow [Testing](../common/testing.md) instructions.
