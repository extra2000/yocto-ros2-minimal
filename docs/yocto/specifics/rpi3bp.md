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
    localhost/extra2000/yocto-toolkit:latest \
    bash
source layers/poky/oe-init-build-env build
```

Check dependencies:
```
bitbake -p mc:raspberrypi3-64:ros2-image
```

Build:
```
bitbake mc:raspberrypi3-64:ros2-image
```

To build SDK and extract into `[PROJECT_ROOT]/project/yocto/build/sdk-rpi3bp` directory:
```
bitbake mc:raspberrypi3-64:ros2-image -c populate_sdk
./tmp-glibc/deploy/sdk/oecore-x86_64-cortexa53-toolchain-nodistro.0.sh -d sdk-rpi3bp
```

Replace `FIXMESTAGINGDIRHOST` with `project/yocto/build/sdk-rpi3bp/sysroots` in all `cmake` files in the `sdk-rpi3bp`:
```
find sdk-rpi3bp -type f -name *.cmake -print0 | xargs -0 sed -i 's,FIXMESTAGINGDIRHOST,'"$(readlink -f sdk-rpi3bp/sysroots/x86_64-oesdk-linux)"',g'
```


## Flashing to SD Card

Execute the following command:
```
bzcat project/yocto/build/tmp-glibc/deploy/images/raspberrypi3-64/ros2-image-humble-raspberrypi3-64-*.rootfs.wic.bz2 | sudo dd bs=4M iflag=fullblock oflag=direct status=progress of=/dev/sdX; sudo sync
```


## Testing

Insert SD card and power on Raspberry Pi 3B+. Access serial console and login as `yocto` user with password `yocto`. Then, follow [Testing](../common/testing.md) instructions.


## Cross-Compiling C++ Applications

Open a new terminal and execute the following command (without using Podman):
```
source project/yocto/build/sdk-rpi3bp/environment-setup-cortexa53-oe-linux
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
scp -P 22 ./ds-helloworld-cpp yocto@raspberrypi3-64.lan:
ssh -p 22 yocto@raspberrypi3-64.lan
./ds-helloworld-cpp
```

**NOTE: If `raspberrypi3-64.lan` is not resolvable by your network, you need to replace `raspberrypi3-64.lan` according to your target device IP address.**

To cleanup the `datastruct-cpp` project:
```
cd ..
rm -rf ./build/
```


## Cross-Compiling ROS2 C++ Applications

Open a new terminal and execute the following command (without using Podman):
```
source project/yocto/build/sdk-rpi3bp/environment-setup-cortexa53-oe-linux
source project/yocto/build/sdk-rpi3bp/sysroots/x86_64-oesdk-linux/etc/profile.d/ros/setup.bash
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

Execute the following command to upload to QEMU and execute the binary:
```
scp -P 22 ../install/ros2-helloworld-cpp/lib/ros2-helloworld-cpp/main yocto@raspberrypi3-64.lan:
ssh -p 22 yocto@raspberrypi3-64.lan
./main
```

To cleanup the `ros2-helloworld-cpp` project:
```
rm -rf ../build/ ../install/ ../log/
```


## Cross-Compiling Kria ROS Perception

Open a new terminal and execute the following command (without using Podman):
```
source project/yocto/build/sdk-rpi3bp/environment-setup-cortexa53-oe-linux
source project/yocto/build/sdk-rpi3bp/sysroots/x86_64-oesdk-linux/etc/profile.d/ros/setup.bash
cd project/yocto/layers/meta-user/recipes-apps/kria-ros-perception/files/kria_ros_perception/
rm -rf src/image_proc src/tracetools_image_pipeline src/vitis_common src/tracing src/image_pipeline_examples
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

Execute the following command to upload to QEMU and execute the binary:
```
scp -P 22 ../install/ros2-helloworld-cpp/lib/ros2-helloworld-cpp/main yocto@raspberrypi3-64.lan:
ssh -p 22 yocto@raspberrypi3-64.lan
./main
```

To cleanup the `ros2-helloworld-cpp` project:
```
rm -rf ../build/ ../install/ ../log/
```
