# Rock64


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
bitbake -p mc:rock64:ros2-image
```

To build:
```
bitbake mc:rock64:ros2-image
```


## Flashing to SD Card

Execute the following command:
```
sudo dd bs=4M iflag=fullblock oflag=direct status=progress if=project/yocto/build/tmp/deploy/images/rock64/ros-image-core-humble-rock64-*.rootfs.wic of=/dev/sdX; sudo sync
```


## Testing

Insert SD card and power on Rock64. Access serial console and login with `root` user. Then, follow [Testing](../common/testing.md) instructions.
