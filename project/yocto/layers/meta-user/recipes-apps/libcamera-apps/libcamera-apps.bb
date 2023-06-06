SUMMARY = "Libcamera Apps"
DESCRIPTION = "${SUMMARY}"
AUTHOR = "Nick Aizuddin <nick@extra2000.io>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://license.txt;md5=a0013d1b383d72ba4bdc5b750e7d1d77"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

SRC_URI = "git://github.com/raspberrypi/libcamera-apps;name=libcamera_apps;protocol=https;nobranch=1"
SRCREV_libcamera_apps = "a6267d51949d0602eedf60f3ddf8c6685f652812"

DEPENDS:append = " \
    libcamera \
    boost \
    libexif \
    jpeg \
    tiff \
    libpng \
    libdrm \
"

RDEPENDS:append:${PN} = " \
    python3-core \
"

inherit pkgconfig cmake

EXTRA_OECMAKE = "-DENABLE_DRM=1 -DENABLE_X11=0 -DENABLE_QT=0 -DENABLE_OPENCV=0 -DENABLE_TFLITE=0"
