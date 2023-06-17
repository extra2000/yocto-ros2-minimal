# Raspberry Pi 4B


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

Check dependencies:
```
bitbake -p mc:raspberrypi4-64:ros2-image
```

Build:
```
bitbake mc:raspberrypi4-64:ros2-image
```

## Flashing to SD Card

Execute the following command:
```
bzcat project/yocto/build/tmp/deploy/images/raspberrypi4-64/ros-image-core-humble-raspberrypi4-64-*.rootfs.wic.bz2 | sudo dd bs=4M iflag=fullblock oflag=direct status=progress of=/dev/sdX; sudo sync
```


## Testing

Insert SD card and power on Raspberry Pi 4B. Access serial console and login with `root` user. Then, follow [Testing](../common/testing.md) instructions.
