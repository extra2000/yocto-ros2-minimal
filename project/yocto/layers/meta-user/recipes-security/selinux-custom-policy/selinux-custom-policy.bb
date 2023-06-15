SUMMARY = "Custom SELinux Policies"
DESCRIPTION = "${SUMMARY}"
AUTHOR = "Nick Aizuddin <nick@extra2000.io>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=14549528096b9b60194cbada83109dcd"

S = "${WORKDIR}"

SRC_URI = " \
    file://LICENSE \
    file://mypolicy.te \
    file://selinux-custom-policy.service \
"

inherit systemd

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "selinux-custom-policy.service"

DEPENDS = " \
    checkpolicy-native \
    policycoreutils-native \
    semodule-utils-native \
"

do_compile:append () {
    checkmodule -M -m -o ${S}/mypolicy.mod ${S}/mypolicy.te
    semodule_package -o ${S}/mypolicy.pp -m ${S}/mypolicy.mod
}

do_install:append () {
    install -d ${D}/etc/selinux-custom-policy
    install -m 0644 ${S}/mypolicy.pp ${D}/etc/selinux-custom-policy/mypolicy.pp

    install -d ${D}/${systemd_unitdir}/system
    install -m 0644 ${S}/selinux-custom-policy.service ${D}/${systemd_unitdir}/system/
}

FILES:${PN} += " \
    /etc/selinux-custom-policy \
    ${systemd_unitdir}/system/selinux-custom-policy.service \
"
