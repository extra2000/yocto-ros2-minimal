SUMMARY = "Gazebo Utils"
DESCRIPTION = "${SUMMARY}"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-utils;branch=ign-utils1;protocol=https"
SRCREV = "0f3aa90afe449af80b275301d218db9632a8df44"
S = "${WORKDIR}/git"

DEPENDS = " \
    gz-cmake2 \
"

inherit cmake pkgconfig

EXTRA_OECMAKE = ""

BBCLASSEXTEND = "native nativesdk"
