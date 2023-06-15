do_install:append () {
    # Allow members of group wheel to execute any command
    echo "%wheel ALL=(ALL:ALL) ALL" > ${D}${sysconfdir}/sudoers.d/wheel
}

FILES_${PN} += " ${sysconfdir}/sudoers.d/wheel"
