SUMMARY = "Dart Physics Engine"
DESCRIPTION = "${SUMMARY}"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dded0ba36ab35cc5e5c2389f23e60084"

SRC_URI = "git://github.com/dartsim/dart;branch=v6.12.2;nobranch=1;protocol=https"
SRCREV = "1fe8fa2c53976d57003edb293b62eac747247d19"
S = "${WORKDIR}/git"

DEPENDS = " \
    libtool \
    libeigen \
    libccd \
    fcl \
    assimp \
    boost \
    octomap \
    bullet \
    libtinyxml2 \
    urdfdom \
    ode \
"

inherit cmake pkgconfig

TARGET_CC_ARCH:append = " ${LDFLAGS}"

EXTRA_OECMAKE = "-DDART_VERBOSE=TRUE"

do_compile:append() {
    sed -E -i "s,(-fmacro-prefix-map|-fdebug-prefix-map|--sysroot)=[^ ]*[[:space:]]+,,g" ${WORKDIR}/build/cmake/dart.pc
    sed -E -i "s,${WORKDIR}/git,/usr/src/debug/dart-physics/6.12.2-r0,g" ${WORKDIR}/build/dart/config.hpp
}

FILES:${PN}:append = " \
    /usr/share/dart \
    /usr/share/dart/package.xml \
    /usr/share/dart/cmake \
    /usr/share/dart/cmake/dart_external-lodepngComponent.cmake \
    /usr/share/dart/cmake/dart_external-odelcpsolverComponent.cmake \
    /usr/share/dart/cmake/DARTFindEigen3.cmake \
    /usr/share/dart/cmake/Findccd.cmake \
    /usr/share/dart/cmake/DARTFindccd.cmake \
    /usr/share/dart/cmake/Findfcl.cmake \
    /usr/share/dart/cmake/DARTFindfcl.cmake \
    /usr/share/dart/cmake/Findassimp.cmake \
    /usr/share/dart/cmake/DARTFindassimp.cmake \
    /usr/share/dart/cmake/DARTFindBoost.cmake \
    /usr/share/dart/cmake/DARTFindoctomap.cmake \
    /usr/share/dart/cmake/dart_dartComponent.cmake \
    /usr/share/dart/cmake/DARTConfig.cmake \
    /usr/share/dart/cmake/DARTConfigVersion.cmake \
    /usr/share/dart/cmake/dart_dartTargets.cmake \
    /usr/share/dart/cmake/dart_dartTargets-release.cmake \
    /usr/share/dart/cmake/dart_external-lodepngTargets.cmake \
    /usr/share/dart/cmake/dart_external-lodepngTargets-release.cmake \
    /usr/share/dart/cmake/dart_external-odelcpsolverTargets.cmake \
    /usr/share/dart/cmake/dart_external-odelcpsolverTargets-release.cmake \
"

BBCLASSEXTEND = "native nativesdk"
