SUMMARY = "Gazebo Sensors"
DESCRIPTION = "${SUMMARY}"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-sensors;branch=ign-sensors6;protocol=https"
SRCREV = "4f73c0a240b52b8f0eb99afa1f760cf2c491126e"
S = "${WORKDIR}/git"

DEPENDS:class-target = " \
    ogre \
    protobuf \
    protobuf-native \
    gz-cmake2 \
    gz-math6 \
    gz-common4 \
    gz-msgs8 \
    gz-transport11 \
    gz-rendering6 \
    sdformat12 \
"

inherit cmake pkgconfig

EXTRA_OECMAKE:class-target = " \
    -DPROTOBUF_PROTOC_EXECUTABLE=${WORKDIR}/recipe-sysroot-native/usr/bin/protoc \
"

BBCLASSEXTEND = "native nativesdk"
