# yocto-ros2-minimal

| License | Versioning |
| ------- | ---------- |
| [![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT) | [![semantic-release: angular](https://img.shields.io/badge/semantic--release-angular-e10079?logo=semantic-release)](https://github.com/semantic-release/semantic-release) |

A minimal ROS2 with Yocto workspace for learning purpose.


## Prerequisites

* [extra2000/yocto-toolkit v4.x image](https://github.com/extra2000/yocto-toolkit)
* Available disk space: at least 350GB
* SDCard with at least 4GB.
* Digilent Analog Discovery 2 for accessing serial console through UART pins.


## Getting Started

Clone this repository:
```
git clone --recursive https://github.com/extra2000/yocto-ros2-minimal.git
```


## Instructions

* Raspberry Pi:
    * [Raspberry Pi Zero W](docs/yocto/specifics/rpizero-w.md)
    * [Raspberry Pi Zero 2 W](docs/yocto/specifics/rpizero2-w.md)
    * [Raspberry Pi 3 B+](docs/yocto/specifics/rpi3bp.md)
    * [Raspberry Pi 4 B](docs/yocto/specifics/rpi4b.md)
* Pine64:
    * [Rock64](docs/yocto/specifics/rock64.md)
* QEMU:
    * [ARM 32-bit](docs/yocto/specifics/qemuarm.md)
    * [ARM 64-bit](docs/yocto/specifics/qemuarm64.md)
* All Yocto targets: [Yocto Building for All Targets](docs/yocto/all-targets.md)
