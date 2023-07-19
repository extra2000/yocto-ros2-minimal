# Changelog

## [5.0.1](https://github.com/extra2000/yocto-ros2-minimal/compare/v5.0.0...v5.0.1) (2023-07-19)


### Documentations

* **podman:** rename from `xilinx-toolkit` to `yocto-toolkit` ([2300669](https://github.com/extra2000/yocto-ros2-minimal/commit/23006690a998e91eb52f8b68292d37ab72b44e52))
* **README:** move prerequisites to `README.md` ([3bf3f5b](https://github.com/extra2000/yocto-ros2-minimal/commit/3bf3f5b2039b304948c4502a8eca9197c05e67c2))
* **yocto/qemu:** add all instructions for QEMU 32-bit and QEMU 64-bit ([ba5db09](https://github.com/extra2000/yocto-ros2-minimal/commit/ba5db0906275d0e7213552339903a8c3c03d5c89))

## [5.0.0](https://github.com/extra2000/yocto-ros2-minimal/compare/v4.2.0...v5.0.0) (2023-07-18)


### ⚠ BREAKING CHANGES

* **petalinux:** All PetaLinux instructions and projects have been moved to [extra2000/petalinux-ros2-minimal](https://github.com/extra2000/petalinux-ros2-minimal) repository

### Features

* **yocto/libcamera:** enable camera for `raspberrypi0-wifi`, `raspberrypi3-64`, and `raspberrypi4-64` ([fe83bf0](https://github.com/extra2000/yocto-ros2-minimal/commit/fe83bf096fb334e6839b3c9339abfcba91550db8))
* **yocto/selinux:** add SELinux for `rock64` ([0805a9e](https://github.com/extra2000/yocto-ros2-minimal/commit/0805a9e51e1ffd9b9277ae7c59e71d33fdd31a93))


### Documentations

* **yocto/local.conf:** add instructions for `bitbake` Parallelism Options ([84bda28](https://github.com/extra2000/yocto-ros2-minimal/commit/84bda2803d27340972f18f2c9fd917dd31409f34))


### Fixes

* **yocto/license:** add `synaptics-killswitch` license flag for `raspberrypi0-wifi`, `raspberrypi3-64`, and `raspberrypi4-64` ([ee28c34](https://github.com/extra2000/yocto-ros2-minimal/commit/ee28c340cd2ebec847b73dab4e91c832d3abea4a))
* **yocto/netplan:** add driver fixes for `raspberrypi0-wifi`, `raspberrypi3-64`, and `raspberrypi4-64` ([d969a22](https://github.com/extra2000/yocto-ros2-minimal/commit/d969a225d140950148db4563307e82af10185ea0))
* **yocto:** add group `video` to allow libcamera access without `sudo` ([0d0b538](https://github.com/extra2000/yocto-ros2-minimal/commit/0d0b538c151692821851f7552af3b25e50aeb31e))


### Code Refactoring

* **petalinux:** move all PetaLinux instructions and projects to [extra2000/petalinux-ros2-minimal](https://github.com/extra2000/petalinux-ros2-minimal) repository ([ac74617](https://github.com/extra2000/yocto-ros2-minimal/commit/ac7461732a3b3190a43d80d95df1dfca81ea9856))
* **yocto/netplan:** using `OVERRIDES` variables instead conditional `[@bb](https://github.com/bb).utils.contains()` ([3efd4f7](https://github.com/extra2000/yocto-ros2-minimal/commit/3efd4f70ce8d59e9559107e823c6acfb813c560d))

## [4.2.0](https://github.com/extra2000/yocto-ros2-minimal/compare/v4.1.1...v4.2.0) (2023-07-10)


### Features

* **yocto:** add `datastruct-cpp` example project ([d7d8925](https://github.com/extra2000/yocto-ros2-minimal/commit/d7d89252f7aed210f4c48834a5268a22dc59f51f))
* **yocto:** add `ssh-server-openssh` for port forwarding ([d304d4a](https://github.com/extra2000/yocto-ros2-minimal/commit/d304d4a6f851ff89e2c6a6a641db093eb2785ea5))
* **yocto:** add TCF Agent for remote debugging via Eclipse, and add instructions how to build SDK for Eclipse/CMake ([bd1d6ef](https://github.com/extra2000/yocto-ros2-minimal/commit/bd1d6efb3ec4118d1519ea0ca420ef98682b669a))


### Documentations

* **yocto:** add instructions how to extract SDK for RPi Zero 2W ([2ce196d](https://github.com/extra2000/yocto-ros2-minimal/commit/2ce196dd925eed9fa1f7bf0e3a2487bd6af2a17b))


### Fixes

* **yocto/netplan:** fix RPi Zero 2W WiFi driver issue with WPA2 EAP TLS access point ([b14cf39](https://github.com/extra2000/yocto-ros2-minimal/commit/b14cf39280ef98ef68ee7d529300deddd538545c))

## [4.1.1](https://github.com/extra2000/yocto-ros2-minimal/compare/v4.1.0...v4.1.1) (2023-06-19)


### Documentations

* **yocto/cleanup:** add `.log` to cleanup command ([742f99a](https://github.com/extra2000/yocto-ros2-minimal/commit/742f99afd9ef7be7d710f2e8187b8e3a163b600f))
* **yocto:** fix WIC image path ([1a0ebe4](https://github.com/extra2000/yocto-ros2-minimal/commit/1a0ebe496921590a6fcc1a38c222dbb545bf313b))


### Fixes

* **yocto/raspberrypi:** fix SELinux not enabled by adding missing `CMDLINE` options ([4d38bf6](https://github.com/extra2000/yocto-ros2-minimal/commit/4d38bf6911a77abe151291927fe2578d7aa83fb1))
* **yocto/raspberrypi:** fix SELinux not enabled in kernel build configuration ([c322c23](https://github.com/extra2000/yocto-ros2-minimal/commit/c322c23a72c66d5efa0d51890b4426956872a3c4))

## [4.1.0](https://github.com/extra2000/yocto-ros2-minimal/compare/v4.0.0...v4.1.0) (2023-06-18)


### Features

* **yocto/security:** add SELinux by including `meta-selinux` layer and its dependency layer `meta-clang` ([080683e](https://github.com/extra2000/yocto-ros2-minimal/commit/080683e479dde46d56c2c630f97e62f125ff0793))
* **yocto/security:** harden image by adding `meta-security` layer to create admin user `yocto` and disable `root` login ([4acf310](https://github.com/extra2000/yocto-ros2-minimal/commit/4acf310e5e599083ceb26b8166cc74d222b2dd6b))

## [4.0.0](https://github.com/extra2000/yocto-ros2-minimal/compare/v3.0.2...v4.0.0) (2023-06-18)


### ⚠ BREAKING CHANGES

* **yocto/image:** no longer using `ros-image-core.bbappend` with default `core-image-minimal`, now using custom `ros2-image` with `core-image-base`

### Code Refactoring

* **yocto/image:** remove `ros-image-core.bbappend` and use custom `ros2-image` ([b98ae2d](https://github.com/extra2000/yocto-ros2-minimal/commit/b98ae2d3260d10fdbd7fed753ed80fec79b17817))


### Fixes

* **yocto/image:** add missing `python3-rospkg` and `python3-pip` ([ace14cd](https://github.com/extra2000/yocto-ros2-minimal/commit/ace14cd66e74f35aca43f0f3060bf01aca114309))


### Maintenance

* **gitignore:** ignore `/project/yocto/build/tmp*` ([0d1f86a](https://github.com/extra2000/yocto-ros2-minimal/commit/0d1f86a3f9c806e18244e5f579f690ad8ef14b12))


### Documentations

* **yocto:** add more cleanup paths `project/yocto/build/{cache,downloads,tmp-*}` ([0a339fb](https://github.com/extra2000/yocto-ros2-minimal/commit/0a339fbe591b207c63ffadc20543919e2c3356e2))

## [3.0.2](https://github.com/extra2000/yocto-ros2-minimal/compare/v3.0.1...v3.0.2) (2023-06-18)


### Documentations

* **yocto/qemuarm:** add example how to set custom memory size ([f4b9225](https://github.com/extra2000/yocto-ros2-minimal/commit/f4b9225587867d92f3da1b4e9b04a819f9c821e0))
* **yocto/testing:** add Known Issues for Python examples ([eebce9f](https://github.com/extra2000/yocto-ros2-minimal/commit/eebce9ff653d2fc9c5ae300811b001ccb85bc10b))
* **yocto:** remove ROS2 Known Issues ([ba43942](https://github.com/extra2000/yocto-ros2-minimal/commit/ba4394290d4c081564a10a4076a715f5b0718d9e))


### Code Refactoring

* **yocto/local.conf:** remove `sysvinit` ([95e8982](https://github.com/extra2000/yocto-ros2-minimal/commit/95e89828f83ad061f5996e2f162b45de865655c9))

## [3.0.1](https://github.com/extra2000/yocto-ros2-minimal/compare/v3.0.0...v3.0.1) (2023-06-17)


### Fixes

* **yocto/local.conf:** rename deprecated `ABORT` to `HALT` as required by Langdale ([22112a5](https://github.com/extra2000/yocto-ros2-minimal/commit/22112a5a8d48d522034e72a38403212bfff0843c))

## [3.0.0](https://github.com/extra2000/yocto-ros2-minimal/compare/v2.1.0...v3.0.0) (2023-06-14)


### ⚠ BREAKING CHANGES

* **yocto:** meta-ros repository from https://github.com/ros/meta-ros have been replaced with meta-ros from https://github.com/Xilinx/meta-ros/ for Langdale

### Features

* **meta-arm:** upgrade from Honister to Langdale ([928a20d](https://github.com/extra2000/yocto-ros2-minimal/commit/928a20d1d1890975a83fcc292dd7ec53c87b931b))
* **meta-openembedded:** upgrade from Honister to Langdale ([3c74d49](https://github.com/extra2000/yocto-ros2-minimal/commit/3c74d49b71778a68ada88b8da4708ed88b1f02ab))
* **meta-raspberrypi:** upgrade from Honister to Langdale ([9e8045a](https://github.com/extra2000/yocto-ros2-minimal/commit/9e8045a423b01c38c223752a26e6d3cffed09a53))
* **meta-rockchip:** upgrade from Honister to Langdale ([bff3915](https://github.com/extra2000/yocto-ros2-minimal/commit/bff3915b61872a62966358706679b169ed8ed20d))
* **meta-user:** add support for Langdale ([c30ac49](https://github.com/extra2000/yocto-ros2-minimal/commit/c30ac494d9837178e501d54d87850142d52e0cae))
* **poky:** upgrade from Honister to Langdale ([319ccdb](https://github.com/extra2000/yocto-ros2-minimal/commit/319ccdb504e6fe7da2163c23fab2f96f8ca0a72c))
* **yocto:** add libcamera and libcamera-apps ([48520ff](https://github.com/extra2000/yocto-ros2-minimal/commit/48520ff8275daea8589a5c40ca5b761343df6c76))


### Code Refactoring

* **yocto:** replace ros/meta-ros with Xilinx/meta-ros for Langdale ([18694b9](https://github.com/extra2000/yocto-ros2-minimal/commit/18694b949374303801dc8e3adfe32ee9647d5bb0))


### Fixes

* **ros2:** fix `uncrustify` compile issue ([5ef367b](https://github.com/extra2000/yocto-ros2-minimal/commit/5ef367b99db502d01f2bfda1504881a541c645f9))
* **rpizero-2w:** allow synaptics-killswitch license for Langdale ([84f3042](https://github.com/extra2000/yocto-ros2-minimal/commit/84f3042df817bcc398b410f024756dcf475f423b))
* **yocto/local.conf:** fix systemd not included for Langdale ([3458767](https://github.com/extra2000/yocto-ros2-minimal/commit/34587677b75c2f3b3e41374a7a770f20862269f8))

## [2.1.0](https://github.com/extra2000/yocto-ros2-minimal/compare/v2.0.0...v2.1.0) (2023-06-06)


### Features

* **yocto:** add netplan networking ([063f212](https://github.com/extra2000/yocto-ros2-minimal/commit/063f2122aa29b758693f9e295f58a76d64d643d6))
* **yocto:** add qemuarm and qemuarm64 machines ([9749a8f](https://github.com/extra2000/yocto-ros2-minimal/commit/9749a8f78725245fb0d9dd800f58efcb87094718))


### Documentations

* **rock64:** fix typo ([c1efbcf](https://github.com/extra2000/yocto-ros2-minimal/commit/c1efbcf1c4606bdf8d15c843408555937c1d39ca))

## [2.0.0](https://github.com/extra2000/yocto-ros2-minimal/compare/v1.1.2...v2.0.0) (2023-05-25)


### ⚠ BREAKING CHANGES

* **yocto:** project files have been restructured for multiconfig build
* **yocto/submodules:** submodules for Yocto have been restructured

### Features

* **yocto:** add multiconfig build ([7c4d33a](https://github.com/extra2000/yocto-ros2-minimal/commit/7c4d33aa819571579964f92335a554869f428d33))
* **yocto:** add Rock64 machine ([6a57e69](https://github.com/extra2000/yocto-ros2-minimal/commit/6a57e69eaccd78f3e79c927203c230740dd3c542))


### Code Refactoring

* **yocto/submodules:** move all submodules in `project/yocto/*/layers/*` to `project/yocto/layers/*` ([5e8c36f](https://github.com/extra2000/yocto-ros2-minimal/commit/5e8c36febd5aedfe6e8282cd1e15420ced1ce246))
* **yocto:** remove unused bitbake and conf files ([55a46e8](https://github.com/extra2000/yocto-ros2-minimal/commit/55a46e89cfde6178825198f1d5fd483135aa32b9))


### Documentations

* **yocto:** update instructions for multiconfig build ([dc6731f](https://github.com/extra2000/yocto-ros2-minimal/commit/dc6731f3ac09752eb177d04ba2030a486fd7b2b1))

## [1.1.2](https://github.com/extra2000/yocto-ros2-minimal/compare/v1.1.1...v1.1.2) (2023-05-24)


### Documentations

* **petalinux,yocto:** remove SELinux labeling when creating containers ([c4a8e9f](https://github.com/extra2000/yocto-ros2-minimal/commit/c4a8e9ffbeb73d00d6fc9fcc9aea153b72869bb2))

## [1.1.1](https://github.com/extra2000/yocto-ros2-minimal/compare/v1.1.0...v1.1.1) (2023-05-18)


### Fixes

* **gitmodules:** fix missing path ([c7b4364](https://github.com/extra2000/yocto-ros2-minimal/commit/c7b4364de3cc0f1a1d3786585e0eadd43bae62b1))

## [1.1.0](https://github.com/extra2000/yocto-ros2-minimal/compare/v1.0.0...v1.1.0) (2023-05-17)


### Features

* **petalinux:** add support for KR260 ([97e7a16](https://github.com/extra2000/yocto-ros2-minimal/commit/97e7a16e325e571c4ec93719e8427824ba8f3db5))
* **yocto:** add support for RPi 3B + ([1ac4491](https://github.com/extra2000/yocto-ros2-minimal/commit/1ac44918437d780bd62d1e21d4dc079a815be2b3))
* **yocto:** add support for RPi 4B ([d1527c3](https://github.com/extra2000/yocto-ros2-minimal/commit/d1527c3c5ec86ebfa8739ef2edfd2e050d1e45d3))
* **yocto:** add support for RPi Zero 2 W ([3e5df99](https://github.com/extra2000/yocto-ros2-minimal/commit/3e5df99de469a42707daa8938d2dfe0b304d435a))


### Maintenance

* **gitignore:** ignore hardware, hw-description, and BSP ([e802122](https://github.com/extra2000/yocto-ros2-minimal/commit/e80212252d326cdcc909c0f0d2e6be1feb3ed519))


### Documentations

* **arty-z7-20:** add `xilinx-tools-v2022-2` volume as required by `xilinx-toolkit` v3.x image ([962a321](https://github.com/extra2000/yocto-ros2-minimal/commit/962a3210cd55f7d3ae074dd66d3831bf6502a7d1))
* **arty-z7-20:** add a list of requirements ([b6cc435](https://github.com/extra2000/yocto-ros2-minimal/commit/b6cc4358fd1f45320ef94bd6c3d0ef376f31ef70))
* **README:** fix git clone URL ([8dbd2b7](https://github.com/extra2000/yocto-ros2-minimal/commit/8dbd2b707bac2c12d8808b45d95b25f9f75d6475))
* **README:** remove Prerequisites ([79b7728](https://github.com/extra2000/yocto-ros2-minimal/commit/79b7728c68b0f9bc8f6731cd2c70e9b838418ada))
* **README:** update Table of Contents ([5e8497a](https://github.com/extra2000/yocto-ros2-minimal/commit/5e8497a0afbfa6a43cad1faaa430dbe71b18fe4b))
* **rpizero-w:** add `xilinx-toolkit` v3.x as requirement ([5387326](https://github.com/extra2000/yocto-ros2-minimal/commit/5387326e1c8e4a04bfcc740941f53041eadc5274))

## 1.0.0 (2023-05-14)


### Features

* initial implementations ([c6a0fcb](https://github.com/extra2000/yocto-ros2-minimal/commit/c6a0fcb42a847c2a933017732aa646db2b7b096f))


### Documentations

* **README:** update docs ([c3f0ec8](https://github.com/extra2000/yocto-ros2-minimal/commit/c3f0ec8cca08ac7001b76f8d66036aa7c25d3784))


### Continuous Integrations

* add GitHub Action with semantic-release ([be86617](https://github.com/extra2000/yocto-ros2-minimal/commit/be86617fa8c0a09ab14b502b66124f5746642979))
