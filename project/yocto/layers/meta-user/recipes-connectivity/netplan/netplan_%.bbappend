FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

DRIVER_PATCH_FILE = ""
DRIVER_PATCH_FILE:raspberrypi0-2w-64 = "file://0001-networkd-prioritize-wext-driver.patch"

SRC_URI:append = " \
    ${DRIVER_PATCH_FILE} \
"
