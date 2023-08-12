SUMMARY = "Gazebo Tools"
DESCRIPTION = "${SUMMARY}"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/sdformat;branch=sdf9;protocol=https"
SRCREV = "9d9693b38a806a43f066bc6329e81eed6ceba33e"
S = "${WORKDIR}/git"

DEPENDS = " \
    libtinyxml \
    gz-cmake2 \
    gz-tools1 \
    gz-math6 \
    ruby-native \
"

DEPENDS:append:class-target = " \
    urdfdom \
"

inherit cmake pkgconfig

EXTRA_OECMAKE = ""

do_install:append:class-target() {
    sed -i "s,${WORKDIR}/recipe-sysroot/usr/include/ignition/math6,\x24{_IMPORT_PREFIX}/include/ignition/math6,g" ${D}/usr/lib/cmake/sdformat9/sdformat9-targets.cmake
}

FILES:${PN}:append = " \
    /usr/lib/ruby \
    /usr/lib/ruby/ignition \
    /usr/lib/ruby/ignition/cmdsdformat9.rb \
    /usr/share/gz \
    /usr/share/ignition \
    /usr/share/gz/gz1.completion.d \
    /usr/share/gz/gz1.completion.d/sdf.bash_completion.sh \
    /usr/share/ignition/sdformat9.yaml \
"

BBCLASSEXTEND = "native nativesdk"
