do_install:append() {
    # Netplan expects wpa_supplicant to be in "/sbin/" instead of "/usr/sbin/"
    mkdir -p ${D}/sbin
    ln -s /usr/sbin/wpa_supplicant ${D}/sbin/wpa_supplicant
}
