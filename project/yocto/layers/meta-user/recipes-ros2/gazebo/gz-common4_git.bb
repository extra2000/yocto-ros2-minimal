SUMMARY = "Gazebo Common"
DESCRIPTION = "${SUMMARY}"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-common;branch=ign-common4;protocol=https"
SRCREV = "60b1fddf05ce020ba7cb79022fdf40be545eb789"
S = "${WORKDIR}/git"

DEPENDS = " \
    freeimage \
    util-linux \
    libtinyxml2 \
    ffmpeg \
    gts \
    gz-cmake2 \
    gz-math6 \
    gz-utils1 \
"

inherit cmake pkgconfig

EXTRA_OECMAKE = " \
    -DFREEIMAGE_RUNS=FAILED_TO_RUN \
    -DFREEIMAGE_RUNS__TRYRUN_OUTPUT='' \
"

FILES:${PN}:append = " \
    /usr/share/ignition/ignition-common4/* \
"

BBCLASSEXTEND = "native nativesdk"
