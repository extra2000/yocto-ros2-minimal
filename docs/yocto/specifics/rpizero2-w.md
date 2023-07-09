# Raspberry Pi Zero 2 W


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
bitbake -p mc:raspberrypi0-2w-64:ros2-image
```

Build:
```
bitbake mc:raspberrypi0-2w-64:ros2-image
```

To build SDK and extract into `[PROJECT_ROOT]/project/yocto/build/sdk-rpizero2-w` directory:
```
bitbake mc:raspberrypi0-2w-64:ros2-image -c populate_sdk
./tmp-glibc/deploy/sdk/oecore-x86_64-cortexa53-toolchain-nodistro.0.sh -d sdk-rpizero2-w
```

**NOTE: To use the SDK for cross-compiling, use the following command to `source` SDK environment**:
```
source sdk-rpizero2-w/environment-setup-cortexa53-oe-linux
```


## Flashing to SD Card

Execute the following command:
```
bzcat project/yocto/build/tmp-glibc/deploy/images/raspberrypi0-2w-64/ros2-image-humble-raspberrypi0-2w-64-*.rootfs.wic.bz2 | sudo dd bs=4M iflag=fullblock oflag=direct status=progress of=/dev/sdX; sudo sync
```


## Testing

Insert SD card and power on Raspberry Pi Zero 2 W. Access serial console and login as `yocto` user with password `yocto`. Then, follow [Testing](../common/testing.md) instructions.
