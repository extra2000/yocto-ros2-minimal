FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
    ${@bb.utils.contains("MACHINE", "raspberrypi0-2w-64", "file://0001-networkd-prioritize-wext-driver.patch", "", d)} \
"
