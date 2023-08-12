inherit pkgconfig

do_configure[network] = "1"

DEPENDS:append = " freeimage"

do_install:append:class-target() {
    sed -i "s,${WORKDIR}/recipe-sysroot,,g" ${D}/usr/lib/OGRE/cmake/OgreTargets.cmake
}

BBCLASSEXTEND:append = " native nativesdk"
