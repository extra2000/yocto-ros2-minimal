SUMMARY = "Gazebo CMake"
DESCRIPTION = "${SUMMARY}"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-cmake;branch=ign-cmake2;protocol=https"
SRCREV = "940e2b795eaa69df651031ceb430b5a025177c12"
S = "${WORKDIR}/git"

inherit cmake pkgconfig

EXTRA_OECMAKE = ""

FILES:${PN}:append = " \
    /usr/share/ignition/* \
"

BBCLASSEXTEND = "native nativesdk"
