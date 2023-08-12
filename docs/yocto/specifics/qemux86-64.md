# x86_64


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
bitbake -p mc:qemux86-64:ros2-image
```

Build:
```
bitbake mc:qemux86-64:ros2-image
```

To build SDK and extract into `[PROJECT_ROOT]/project/yocto/build/sdk-qemux86-64` directory:
```
bitbake mc:qemux86-64:ros2-image -c populate_sdk
./tmp-glibc/deploy/sdk/oecore-x86_64-cortexa57-toolchain-nodistro.0.sh -d sdk-qemux86-64
```

Replace `FIXMESTAGINGDIRHOST` with `project/yocto/build/sdk-qemux86-64/sysroots` in all `cmake` files in the `sdk-qemux86-64`:
```
find sdk-qemux86-64 -type f -name *.cmake -print0 | xargs -0 sed -i 's,FIXMESTAGINGDIRHOST,'"$(readlink -f sdk-qemux86-64/sysroots)"',g'
```


## Testing

The following `runqemu` commands should be executed using `yocto-toolkit` Podman container.

To start QEMU with SELinux enforcing, use the following `runqemu` command:
```
runqemu \
    qemux86-64 \
    slirp \
    nographic \
    qemuparams="-m 4096 -net nic -net user,hostfwd=tcp:127.0.0.1:1534-:1534,hostfwd=tcp:127.0.0.1:22222-:22,hostfwd=tcp:127.0.0.1:2345-:2345"
```

To start QEMU with SELinux permissive, use the following `runqemu` command:
```
runqemu \
    qemux86-64 \
    slirp \
    nographic \
    qemuparams="-m 4096 -net nic -net user,hostfwd=tcp:127.0.0.1:1534-:1534,hostfwd=tcp:127.0.0.1:22222-:22,hostfwd=tcp:127.0.0.1:2345-:2345" \
    bootparams="selinux=1 enforcing=0"
```

**NOTE: If the port forwarding doesn't work, try shutdown QEMU, respawn the `yocto-toolkit` Podman container, and re-execute the same `runqemu` command again.**

Login as `yocto` user with password `yocto`. Then follow testing instructions in [Testing](../common/testing.md).


## Testing ROS2 Perception Node

Create container with X11 forwarding:
```
podman run -it --rm \
    -e DISPLAY=$DISPLAY \
    --device=/dev/dri \
    --device=/dev/kvm \
    --network=host \
    --userns="keep-id:uid=1000,gid=1000" \
    -v ${PWD}/project:${PWD}/project:rw \
    --workdir ${PWD}/project/yocto \
    --security-opt label=disable \
    --name=ros2 \
    localhost/extra2000/yocto-toolkit:latest \
    bash
source layers/poky/oe-init-build-env build
```

Start QEMU with SELinux permissive:
```
runqemu \
    qemux86-64 \
    kvm \
    nographic \
    slirp \
    qemuparams="-m 4096 -net nic -net user,hostfwd=tcp:127.0.0.1:22222-:22,hostfwd=tcp:127.0.0.1:11345-:11345,hostfwd=udp:127.0.0.1:7400-:7400,hostfwd=udp:127.0.0.1:7401-:7401,hostfwd=udp:127.0.0.1:7410-:7410,hostfwd=udp:127.0.0.1:7411-:7411" \
    bootparams="selinux=1 enforcing=0"
```

SSH into QEMU and run simulation:
```
source /etc/profile.d/ros/setup.bash
DISPLAY=:0 GAZEBO_RESOURCE_PATH="/usr/share/gazebo-11:/usr/share/OGRE/Media/ShadowVolume" ros2 launch perception_2nodes simulation.launch.py headless:='True'
```

Open another terminal and SSH into QEMU. Then, run Rectify and Resize example:
```
source /etc/profile.d/ros/setup.bash
DISPLAY=:0 GAZEBO_RESOURCE_PATH="/usr/share/gazebo-11:/usr/share/OGRE/Media/ShadowVolume" ros2 launch perception_2nodes trace_rectify_resize.launch.py
```

On host, allow X11 forwarding from local non-network connections:
```
xhost +local:
```

Then execute the following command:
```
podman run -it --rm \
    -e DISPLAY=$DISPLAY \
    --device=/dev/dri \
    --network=host \
    --userns="keep-id:uid=1000,gid=1000" \
    --security-opt label=disable \
    --name=ros2-workstation \
    localhost/extra2000/ros2-gazebo11-classic:latest \
    bash
source /opt/ros/humble/setup.bash
rqt
```

Open another terminal and execute the following command:
```
podman exec -it ros2-workstation bash
source /opt/ros/humble/setup.bash
GAZEBO_MASTER_URI=http://127.0.0.1:11345 gzclient --verbose
```


## Cross-Compiling C++ Applications

Open a new terminal and execute the following command (without using Podman):
```
source project/yocto/build/sdk-qemux86-64/environment-setup-cortexa57-oe-linux
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
source project/yocto/build/sdk-qemux86-64/environment-setup-cortexa57-oe-linux
source project/yocto/build/sdk-qemux86-64/sysroots/x86_64-oesdk-linux/etc/profile.d/ros/setup.bash
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
    qemux86-64 \
    slirp \
    nographic \
    qemuparams="-m 4096 -net nic -net user,hostfwd=tcp:127.0.0.1:1534-:1534,hostfwd=tcp:127.0.0.1:22222-:22,hostfwd=tcp:127.0.0.1:2345-:2345" \
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
