FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
    ${@bb.utils.contains("DISTRO_FEATURES", "selinux", "file://enable-selinux.cfg", "", d)} \
"
