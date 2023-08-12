DESCRIPTION = "Extensible Modelica-based platform for optimization, simulation and analysis of complex dynamic systems."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=65d1ee510d57bbd05663424f2ff8d660"

SRCREV = "852f847aa1e602942101ecfd7578b57515e447e2"
SRC_URI = " \
    git://github.com/OGRECave/ogre;branch=v1.9.1;nobranch=1;protocol=https \
    file://0000-fix-sysctl-aarch.patch \
"

S = "${WORKDIR}/git"

inherit cmake pkgconfig features_check

REQUIRED_DISTRO_FEATURES = "x11"

DEPENDS = " \
    zlib \
    libx11 \
    pugixml \
    freetype \
    freeimage \
    boost \
    poco \
    tbb \
    libxt \
    libxaw \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'virtual/libgl virtual/libgles2 virtual/egl libglu', '', d)} \
"

EXTRA_OECMAKE = " \
    -DOGRE_BUILD_RENDERSYSTEM_GL=TRUE \
    -DOGRE_BUILD_RENDERSYSTEM_GL3PLUS=TRUE \
    -DOGRE_BUILD_RENDERSYSTEM_GLES2=TRUE \
    -DOGRE_BUILD_RENDERSYSTEM_GLES=FALSE \
    -DOGRE_STATIC:BOOL=FALSE \
    -DOGRE_INSTALL_PDB:BOOL=FALSE \
    -DOGRE_BUILD_TESTS:BOOL=FALSE \
    -DOGRE_INSTALL_SAMPLES:BOOL=FALSE \
    -DOGRE_INSTALL_SAMPLES_SOURCE:BOOL=FALSE \
"

FILES:${PN}-dev += "${libdir}/OGRE/cmake ${libdir}/OGRE/*${SOLIBSDEV}"
FILES:${PN} += "${datadir}/OGRE ${libdir}/OGRE"

BBCLASSEXTEND = "native nativesdk"
