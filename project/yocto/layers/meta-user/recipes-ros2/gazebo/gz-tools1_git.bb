SUMMARY = "Gazebo Tools"
DESCRIPTION = "${SUMMARY}"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-tools;branch=ign-tools1;protocol=https"
SRCREV = "c6932dbdc9df42ec19d46c52baa648e90a9eb3e3"
S = "${WORKDIR}/git"

DEPENDS = " \
    elfutils \
    binutils \
"

inherit cmake pkgconfig

EXTRA_OECMAKE = "-DUSE_SYSTEM_BACKWARDCPP=TRUE -DBackward_DIR='${S}/src/Backward'"

FILES:${PN}:append = " \
    /usr/share \
    /usr/share/gz \
    /usr/share/bash-completion \
    /usr/share/gz/gz1.completion \
    /usr/share/bash-completion/completions \
    /usr/share/bash-completion/completions/ign \
"

INSANE_SKIP:${PN}-dev:append = " dev-elf"

BBCLASSEXTEND = "native nativesdk"
