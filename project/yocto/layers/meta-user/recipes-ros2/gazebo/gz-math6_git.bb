SUMMARY = "Gazebo Math"
DESCRIPTION = "${SUMMARY}"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-math;branch=ign-math6;protocol=https"
SRCREV = "d0b6179607af85caad7a4d2d39690cddcd992477"
S = "${WORKDIR}/git"

DEPENDS = " \
    libeigen \
    python3-native \
    python3 \
    python3-pybind11 \
    ruby \
    ruby-native \
    swig-native \
    gz-cmake2 \
"

inherit cmake pkgconfig

EXTRA_OECMAKE = " \
    -DBUILD_TESTING=OFF \
"

EXTRA_OECMAKE:append:class-target = " \
    -DPython_LIBRARY:FILEPATH=${WORKDIR}/recipe-sysroot/usr/lib \
    -DRuby_LIBRARY:FILEPATH=${WORKDIR}/recipe-sysroot/usr/lib \
"

do_compile:append:class-target() {
    # Remove references to TMPDIR (QA Issue [buildpaths])
    sed -i "s,${WORKDIR}/recipe-sysroot-native,,g" ${WORKDIR}/build/lib/ruby/AngleRUBY_wrap.cxx
    sed -i "s,${WORKDIR}/recipe-sysroot-native,,g" ${WORKDIR}/build/lib/ruby/GaussMarkovProcessRUBY_wrap.cxx
    sed -i "s,${WORKDIR}/recipe-sysroot-native,,g" ${WORKDIR}/build/lib/ruby/RandRUBY_wrap.cxx
    sed -i "s,${WORKDIR}/recipe-sysroot-native,,g" ${WORKDIR}/build/lib/ruby/Vector2RUBY_wrap.cxx
    sed -i "s,${WORKDIR}/recipe-sysroot-native,,g" ${WORKDIR}/build/lib/ruby/Vector3RUBY_wrap.cxx
    sed -i "s,${WORKDIR}/recipe-sysroot-native,,g" ${WORKDIR}/build/lib/ruby/Vector4RUBY_wrap.cxx
    sed -i "s,${WORKDIR}/recipe-sysroot-native,,g" ${WORKDIR}/build/lib/ruby/rubyRUBY_wrap.cxx
}

FILES:${PN}:append = " \
    ${libdir}/ignition/*.so \
    ${libdir}/python/ignition/*.so \
    ${libdir}/ruby/ignition/*.so \
"

BBCLASSEXTEND = "native nativesdk"
