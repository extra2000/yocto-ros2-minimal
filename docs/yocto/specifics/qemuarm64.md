# QEMU ARM 64-bit


## Building

Create container:
```
podman run -it --rm \
    --network=host \
    --userns="keep-id:uid=1000,gid=1000" \
    -v ${PWD}/project:${PWD}/project:rw \
    --workdir ${PWD}/project/yocto \
    --security-opt label=disable \
    localhost/extra2000/yocto-toolkit:latest \
    bash
source layers/poky/oe-init-build-env build
```

Check dependencies:
```
bitbake -p mc:qemuarm64:ros2-image
```

Build:
```
bitbake mc:qemuarm64:ros2-image
```


## Testing

The following `runqemu` commands should be executed using `yocto-toolkit` Podman container.

To start QEMU with SELinux enforcing, use the following `runqemu` command:
```
runqemu \
    qemuarm64 \
    slirp \
    nographic \
    qemuparams="-m 512 -net nic -net user,hostfwd=tcp:127.0.0.1:1534-:1534,hostfwd=tcp:127.0.0.1:22222-:22,hostfwd=tcp:127.0.0.1:2345-:2345"
```

To start QEMU with SELinux permissive, use the following `runqemu` command:
```
runqemu \
    qemuarm64 \
    slirp \
    nographic \
    qemuparams="-m 512 -net nic -net user,hostfwd=tcp:127.0.0.1:1534-:1534,hostfwd=tcp:127.0.0.1:22222-:22,hostfwd=tcp:127.0.0.1:2345-:2345" \
    bootparams="selinux=1 enforcing=0"
```

**NOTE: If the port forwarding doesn't work, try shutdown QEMU, respawn the `yocto-toolkit` Podman container, and re-execute the same `runqemu` command again.**

Login as `yocto` user with password `yocto`. Then follow testing instructions in [Testing](../common/testing.md).
