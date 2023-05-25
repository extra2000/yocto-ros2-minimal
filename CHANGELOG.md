# Changelog

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
