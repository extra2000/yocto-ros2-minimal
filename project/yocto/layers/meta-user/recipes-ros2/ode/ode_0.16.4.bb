SUMMARY = "Open Dynamics Engine (ODE)"
DESCRIPTION = "${SUMMARY}"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=771782cb6245c7fbbe74bc0ec059beff"

SRC_URI = " \
    git://bitbucket.org/odedevs/ode;branch=0.16.4;nobranch=1;protocol=https \
    file://0000-fix-cmake-typo.patch \
"
SRCREV = "40a3874690979eb33bed579c0c7408f3c7b3f086"

S = "${WORKDIR}/git"

DEPENDS = " \
    libtool \
    libccd \
"

inherit cmake pkgconfig

EXTRA_OECMAKE = " \
    -DODE_WITH_TESTS:BOOL=FALSE \
    -DODE_WITH_DEMOS:BOOL=FALSE \
    -DODE_WITH_LIBCCD:BOOL=TRUE \
    -DODE_WITH_LIBCCD_SYSTEM:BOOL=FALSE \
    -DODE_DOUBLE_PRECISION:BOOL=TRUE \
"

BBCLASSEXTEND = "native nativesdk"
