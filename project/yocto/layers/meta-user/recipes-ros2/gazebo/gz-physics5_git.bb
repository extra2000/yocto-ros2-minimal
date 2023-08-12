SUMMARY = "Gazebo Physics"
DESCRIPTION = "${SUMMARY}"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-physics;branch=ign-physics5;protocol=https"
SRCREV = "8127d83af5242d48efe9f4d862acb7d7b910375b"
S = "${WORKDIR}/git"

DEPENDS = " \
    libeigen \
    dart-physics \
    bullet \
    gz-cmake2 \
    gz-common4 \
    gz-math6 \
    gz-plugin1 \
    gz-utils1 \
    sdformat12 \
"

inherit cmake pkgconfig

EXTRA_OECMAKE = " \
    -DBUILD_TESTING=OFF \
"

do_install:append:class-target() {
    sed -E -i "s,(${WORKDIR}/git/dartsim/include;|${WORKDIR}/build/dartsim/include;|${WORKDIR}/recipe-sysroot),,g" ${D}/usr/lib/cmake/ignition-physics5-dartsim/ignition-physics5-dartsim-targets.cmake
}

FILES:${PN}:append = " \
    /usr/lib/ign-physics-5/engine-plugins/libignition-physics5-dartsim-plugin.so.5.3.1 \
    /usr/lib/ign-physics-5/engine-plugins/libignition-physics5-dartsim-plugin.so.5 \
    /usr/lib/ign-physics-5/engine-plugins/libignition-physics5-dartsim-plugin.so \
    /usr/lib/ign-physics-5/engine-plugins/libignition-physics-dartsim-plugin.so \
    /usr/lib/ign-physics-5/engine-plugins/libignition-physics5-tpe-plugin.so.5.3.1 \
    /usr/lib/ign-physics-5/engine-plugins/libignition-physics5-tpe-plugin.so.5 \
    /usr/lib/ign-physics-5/engine-plugins/libignition-physics5-tpe-plugin.so \
    /usr/lib/ign-physics-5/engine-plugins/libignition-physics-tpe-plugin.so \
    /usr/lib/ign-physics-5/engine-plugins/libignition-physics5-bullet-plugin.so.5.3.1 \
    /usr/lib/ign-physics-5/engine-plugins/libignition-physics5-bullet-plugin.so.5 \
    /usr/lib/ign-physics-5/engine-plugins/libignition-physics5-bullet-plugin.so \
    /usr/lib/ign-physics-5/engine-plugins/libignition-physics-bullet-plugin.so \
"

INSANE_SKIP:${PN}:append = " dev-so"

BBCLASSEXTEND = "native nativesdk"
