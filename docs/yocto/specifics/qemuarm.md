# QEMU ARM 32-bit


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
bitbake -p mc:qemuarm:ros2-image
```

Build:
```
bitbake mc:qemuarm:ros2-image
```

To build SDK and extract into `[PROJECT_ROOT]/project/yocto/build/sdk-qemuarm` directory:
```
bitbake mc:qemuarm:ros2-image -c populate_sdk
./tmp-glibc/deploy/sdk/oecore-x86_64-cortexa15t2hf-neon-toolchain-nodistro.0.sh -d sdk-qemuarm
```

Replace `FIXMESTAGINGDIRHOST` with `project/yocto/build/sdk-qemuarm/sysroots` in all `cmake` files in the `sdk-qemuarm`:
```
find sdk-qemuarm -type f -name *.cmake -print0 | xargs -0 sed -i 's,FIXMESTAGINGDIRHOST,'"$(readlink -f sdk-qemuarm/sysroots/x86_64-oesdk-linux)"',g'
```


## Testing

The following `runqemu` commands should be executed using `yocto-toolkit` Podman container.

To start QEMU with SELinux enforcing, use the following `runqemu` command:
```
runqemu \
    qemuarm \
    slirp \
    nographic \
    qemuparams="-m 512 -net nic -net user,hostfwd=tcp:127.0.0.1:1534-:1534,hostfwd=tcp:127.0.0.1:22222-:22,hostfwd=tcp:127.0.0.1:2345-:2345"
```

To start QEMU with SELinux permissive, use the following `runqemu` command:
```
runqemu \
    qemuarm \
    slirp \
    nographic \
    qemuparams="-m 512 -net nic -net user,hostfwd=tcp:127.0.0.1:1534-:1534,hostfwd=tcp:127.0.0.1:22222-:22,hostfwd=tcp:127.0.0.1:2345-:2345" \
    bootparams="selinux=1 enforcing=0"
```

**NOTE: If the port forwarding doesn't work, try shutdown QEMU, respawn the `yocto-toolkit` Podman container, and re-execute the same `runqemu` command again.**

Login as `yocto` user with password `yocto`. Then follow testing instructions in [Testing](../common/testing.md).


## Cross-Compiling C++ Applications

Open a new terminal and execute the following command (without using Podman):
```
source project/yocto/build/sdk-qemuarm/environment-setup-cortexa15t2hf-neon-oe-linux-gnueabi
cd project/yocto/layers/meta-user/recipes-apps/datastruct-cpp/files
mkdir -pv build
cd build
cmake \
    -G "Eclipse CDT4 - Unix Makefiles" \
    -DCMAKE_BUILD_TYPE=Debug \
    ../datastruct-cpp
make -j $(($(nproc) -1))
```

Execute the following command to upload to QEMU and execute the binary:
```
scp -P 22222 ./ds-helloworld-cpp yocto@127.0.0.1:
ssh -p 22222 yocto@127.0.0.1
./ds-helloworld-cpp
```

To cleanup the `datastruct-cpp` project:
```
cd ..
rm -rf ./build/
```


## Cross-Compiling ROS2 C++ Applications

Open a new terminal and execute the following command (without using Podman):
```
source project/yocto/build/sdk-qemuarm/environment-setup-cortexa15t2hf-neon-oe-linux-gnueabi
source project/yocto/build/sdk-qemuarm/sysroots/x86_64-oesdk-linux/etc/profile.d/ros/setup.bash
cd project/yocto/layers/meta-user/recipes-apps/ros2-helloworld-cpp/files/ros2-helloworld-cpp/
colcon \
    --log-base ../log \
    build \
    --build-base ../build \
    --install-base ../install \
    --cmake-args \
    -G "Eclipse CDT4 - Unix Makefiles" \
    -DPython3_FIND_STRATEGY=LOCATION \
    -DBUILD_TESTING=OFF
```

Within the `yocto-toolkit` Podman container, start QEMU using the following command:
```
runqemu \
    qemuarm \
    slirp \
    nographic \
    qemuparams="-m 512 -net nic -net user,hostfwd=tcp:127.0.0.1:1534-:1534,hostfwd=tcp:127.0.0.1:22222-:22,hostfwd=tcp:127.0.0.1:2345-:2345" \
    bootparams="selinux=1 enforcing=0"
```

From host, execute the following command to upload to QEMU and execute the binary:
```
scp -P 22222 ../install/ros2-helloworld-cpp/lib/ros2-helloworld-cpp/main yocto@127.0.0.1:
ssh -p 22222 yocto@127.0.0.1
./main
```

To cleanup the `ros2-helloworld-cpp` project:
```
rm -rf ../build/ ../install/ ../log/
```
