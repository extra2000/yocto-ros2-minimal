FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

DRIVER_PATCH_FILE = ""
DRIVER_PATCH_FILE:raspberrypi0-wifi = "file://0001-networkd-prioritize-wext-driver.patch"
DRIVER_PATCH_FILE:raspberrypi0-2w-64 = "file://0001-networkd-prioritize-wext-driver.patch"
DRIVER_PATCH_FILE:raspberrypi3-64 = "file://0001-networkd-prioritize-wext-driver.patch"
DRIVER_PATCH_FILE:raspberrypi4-64 = "file://0001-networkd-prioritize-wext-driver.patch"

SRC_URI:append = " \
    ${DRIVER_PATCH_FILE} \
"
