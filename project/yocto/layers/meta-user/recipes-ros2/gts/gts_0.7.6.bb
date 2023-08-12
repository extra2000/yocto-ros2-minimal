SUMMARY = "GNU Triangulated Surface Library (GTS)"
DESCRIPTION = "${SUMMARY}"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=3bf50002aefd002f49e7bb854063f7e7"

SRC_URI = "${SOURCEFORGE_MIRROR}/gts/gts-0.7.6.tar.gz"
SRC_URI[sha256sum] = "059c3e13e3e3b796d775ec9f96abdce8f2b3b5144df8514eda0cc12e13e8b81e"

SRC_URI:append:class-target = " \
    file://0000-use-predicate-init-from-path.patch \
    file://0001-fix-splitter-undefined.patch \
"

S = "${WORKDIR}/gts-0.7.6"

DEPENDS = " \
    libtool \
    glib-2.0 \
"

DEPENDS:append:class-target = "gts-native"

inherit autotools-brokensep gettext pkgconfig

EXTRA_OECONF:class-target = " \
    --includedir=/TMPROOT/usr/include \
    --oldincludedir=/TMPROOT/usr/include \
"

do_install:append:class-target() {
    mkdir -pv ${D}${includedir}
    mv -v ${D}/TMPROOT/${includedir}/gts.h ${D}${includedir}/
    mv -v ${D}/TMPROOT/${includedir}/gtsconfig.h ${D}${includedir}/
    rm -rfv ${D}/TMPROOT
    sed -i "s,/TMPROOT,,g" ${D}/usr/lib/pkgconfig/gts.pc
    sed -i "s,${WORKDIR}/recipe-sysroot,,g" ${D}${bindir}/gts-config
}

do_install:append:class-native() {
    cp -v ${S}/src/predicates_init ${D}/${bindir}/
}

FILES:${PN}:append:class-native = " \
    ${bindir}/predicates_init \
"

FILES:${PN}:append:class-target = " \
    ${includedir}/gts.h \
    ${includedir}/gtsconfig.h \
"

INSANE_SKIP:${PN}:append = " patch-fuzz"

BBCLASSEXTEND = "native nativesdk"
