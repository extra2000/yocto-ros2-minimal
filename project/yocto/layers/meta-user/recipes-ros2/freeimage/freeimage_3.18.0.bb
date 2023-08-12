SUMMARY = "FreeImage"
DESCRIPTION = "${SUMMARY}"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://license-gplv2.txt;md5=1fbed70be9d970d3da399f33dae9cc51"

SRC_URI = " \
    ${SOURCEFORGE_MIRROR}/freeimage/FreeImage3154.zip \
    file://0000-fix-memset-not-declared.patch \
"

SRC_URI[sha256sum] = "eb6361519d33131690a0e726b085a05825e5adf9fb72c752d8d39100e48dc829"
S = "${WORKDIR}/FreeImage"

TARGET_CC_ARCH:append = " ${LDFLAGS}"

do_configure() {
    sed -i -e /^CC/d \
           -e /^CXX\ /d \
           -e /^AR/d \
           -e /^INCDIR\ /d \
           -e /^INSTALLDIR\ /d \
           -e s:'-o root -g root'::g \
           -e /ldconfig/d \
    ${S}/Makefile.gnu
}

do_compile() {
    oe_runmake CXXFLAGS="-O3 -fPIC -fexceptions -fvisibility=hidden -Wno-ctor-dtor-privacy -std=c++03 -I. -ISource -ISource/Metadata -ISource/FreeImageToolkit -ISource/LibJPEG -ISource/LibPNG -ISource/LibTIFF4 -ISource/ZLib -ISource/LibOpenJPEG -ISource/OpenEXR -ISource/OpenEXR/Half -ISource/OpenEXR/Iex -ISource/OpenEXR/IlmImf -ISource/OpenEXR/IlmThread -ISource/OpenEXR/Imath -ISource/LibRawLite -ISource/LibRawLite/dcraw -ISource/LibRawLite/internal -ISource/LibRawLite/libraw -ISource/LibRawLite/src" -f ${S}/Makefile
}

do_install() {
    install -d ${D}/${libdir}
    install -d ${D}/${includedir}
    oe_runmake INSTALLDIR="${D}/${libdir}" INCDIR="${D}/${includedir}" -f ${S}/Makefile install
}

do_stage() {
    install -d ${STAGING_LIBDIR}
    install -d ${STAGING_INCDIR}
    oe_runmake  INSTALLDIR="${STAGING_LIBDIR}" INCDIR="${STAGING_INCDIR}" install
}

FILES:${PN} = " \
    ${includedir} \
    ${libdir}/libfreeimage* \
"

FILES:${PN}-dev = ""

INSANE_SKIP:${PN}:append = " already-stripped dev-so"

BBCLASSEXTEND = "native nativesdk"
