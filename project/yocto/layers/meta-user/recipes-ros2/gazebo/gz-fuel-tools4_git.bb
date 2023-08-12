SUMMARY = "Gazebo Fuel Tools"
DESCRIPTION = "${SUMMARY}"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-fuel-tools;branch=ign-fuel-tools4;protocol=https"
SRCREV = "ed4cea14c3ca5f9f2330a6b3fd4766887fc45bbc"
S = "${WORKDIR}/git"

DEPENDS = " \
    libtinyxml2 \
    jsoncpp \
    libzip \
    libyaml \
    curl \
    gz-cmake2 \
    gz-common3 \
    gz-math6 \
    gz-msgs5 \
    gz-tools1 \
"

inherit cmake

EXTRA_OECMAKE = "-DPROTOBUF_PROTOC_EXECUTABLE=${WORKDIR}/recipe-sysroot-native/usr/bin/protoc"

FILES:${PN}:append = " \
    /usr/share \
    /usr/lib/ruby \
    /usr/lib/ruby/ignition \
    /usr/lib/ruby/ignition/cmdfuel4.rb \
    /usr/share/gz \
    /usr/share/ignition \
    /usr/share/gz/gz1.completion.d \
    /usr/share/gz/gz1.completion.d/fuel4.bash_completion.sh \
    /usr/share/ignition/fuel4.yaml \
    /usr/share/ignition/fuel_tools4 \
    /usr/share/ignition/fuel_tools4/config.yaml \
"

BBCLASSEXTEND = "native nativesdk"
