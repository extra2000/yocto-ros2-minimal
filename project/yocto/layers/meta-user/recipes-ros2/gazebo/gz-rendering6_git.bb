SUMMARY = "Gazebo Rendering"
DESCRIPTION = "${SUMMARY}"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-rendering;branch=ign-rendering6;protocol=https"
SRCREV = "6ea5ede531133c4686d352c5af52cf000af6e21a"
S = "${WORKDIR}/git"

DEPENDS = " \
    freeimage \
    ogre \
    gz-cmake2 \
    gz-math6 \
    gz-common4 \
    gz-plugin1 \
    gz-msgs8 \
    gz-utils1 \
"

inherit cmake pkgconfig

EXTRA_OECMAKE = " \
    -DUSE_UNOFFICIAL_OGRE_VERSIONS=ON \
    -DFREEIMAGE_RUNS=FAILED_TO_RUN \
    -DFREEIMAGE_RUNS__TRYRUN_OUTPUT='' \
    -DCMAKE_C_FLAGS=-DGLX_GLXEXT_LEGACY \
    -DCMAKE_CXX_FLAGS='-DGLX_GLXEXT_LEGACY -DCMAKE_NO_SYSTEM_FROM_IMPORTED=1' \
    -DCMAKE_SYSROOT='${WORKDIR}/recipe-sysroot' \
"

FILES:${PN}:append = " \
    /usr/lib/ign-rendering-6/* \
    /usr/share/ignition/* \
"

INSANE_SKIP:${PN}:append = " buildpaths dev-so"
INSANE_SKIP:${PN}-dbg:append = " buildpaths"

BBCLASSEXTEND = "native nativesdk"
