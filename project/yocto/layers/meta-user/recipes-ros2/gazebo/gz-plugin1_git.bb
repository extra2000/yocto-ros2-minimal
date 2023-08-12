SUMMARY = "Gazebo Plugin"
DESCRIPTION = "${SUMMARY}"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-plugin;branch=ign-plugin1;protocol=https"
SRCREV = "ec0bd40c2eca69db56f799f446f489b66ca51144"
S = "${WORKDIR}/git"

DEPENDS = " \
    gz-cmake2 \
"

inherit cmake

EXTRA_OECMAKE = ""

FILES:${PN}:append = " \
    /usr/share \
    /usr/lib/ruby \
    /usr/lib/ruby/ignition \
    /usr/lib/ruby/ignition/cmdplugin1.rb \
    /usr/share/ignition \
    /usr/share/gz \
    /usr/share/ignition/plugin1.yaml \
    /usr/share/gz/gz1.completion.d \
    /usr/share/gz/gz1.completion.d/plugin1.bash_completion.sh \
"

BBCLASSEXTEND = "native nativesdk"
