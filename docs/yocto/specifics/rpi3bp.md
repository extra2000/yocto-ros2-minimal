# Raspberry Pi 3B+


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
bitbake -p mc:raspberrypi3-64:ros-core
```

Build:
```
bitbake mc:raspberrypi3-64:ros-image-core
```

## Flashing to SD Card

Execute the following command:
```
bzcat project/yocto/build/tmp/deploy/images/raspberrypi3-64/ros-image-core-humble-raspberrypi3-64-*.rootfs.wic.bz2 | sudo dd bs=4M iflag=fullblock oflag=direct status=progress of=/dev/sdX; sudo sync
```


## Testing

Insert SD card and power on Raspberry Pi 3B+. Access serial console and login with `root` user. Then, follow [Testing](../common/testing.md) instructions.