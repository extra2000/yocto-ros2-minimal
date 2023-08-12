SUMMARY = "Gazebo Fuel Tools"
DESCRIPTION = "${SUMMARY}"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-fuel-tools;branch=ign-fuel-tools7;protocol=https"
SRCREV = "50a619642b0ce89f9fe78e49a65d6ded6059e047"
S = "${WORKDIR}/git"

DEPENDS = " \
    libtinyxml2 \
    jsoncpp \
    libzip \
    libyaml \
    curl \
    gz-cmake2 \
    gz-common4 \
    gz-math6 \
    gz-msgs8 \
"

inherit cmake

EXTRA_OECMAKE = "-DPROTOBUF_PROTOC_EXECUTABLE=${WORKDIR}/recipe-sysroot-native/usr/bin/protoc"

FILES:${PN}:append = " \
    /usr/share \
    /usr/lib/ruby \
    /usr/lib/ruby/ignition \
    /usr/lib/ruby/ignition/cmdfuel7.rb \
    /usr/share/gz \
    /usr/share/ignition \
    /usr/share/gz/gz1.completion.d \
    /usr/share/gz/gz1.completion.d/fuel7.bash_completion.sh \
    /usr/share/ignition/fuel7.yaml \
    /usr/share/ignition/fuel_tools7 \
    /usr/share/ignition/fuel_tools7/config.yaml \
"

BBCLASSEXTEND = "native nativesdk"
