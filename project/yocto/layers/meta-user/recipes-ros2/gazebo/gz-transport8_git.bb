SUMMARY = "Gazebo Transport"
DESCRIPTION = "${SUMMARY}"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-transport;branch=ign-transport8;protocol=https"
SRCREV = "b3a81827e463f9f0b5150a9c7d08e991f0c9f50c"
S = "${WORKDIR}/git"

DEPENDS = " \
    util-linux \
    zeromq \
    cppzmq \
    sqlite3 \
    gz-cmake2 \
    gz-msgs5 \
"

inherit cmake pkgconfig

EXTRA_OECMAKE = "-DPROTOBUF_PROTOC_EXECUTABLE=${WORKDIR}/recipe-sysroot-native/usr/bin/protoc"

FILES:${PN}:append = " \
    /usr/share \
    /usr/lib/ruby \
    /usr/lib/ruby/ignition \
    /usr/lib/ruby/ignition/cmdtransport8.rb \
    /usr/lib/ruby/ignition/cmdlog8.rb \
    /usr/share/gz \
    /usr/share/ignition \
    /usr/share/gz/gz1.completion.d \
    /usr/share/gz/gz1.completion.d/transport8.bash_completion.sh \
    /usr/share/ignition/transportlog8.yaml \
    /usr/share/ignition/transport8.yaml \
    /usr/share/ignition/ignition-transport8 \
    /usr/share/ignition/ignition-transport8/sql \
    /usr/share/ignition/ignition-transport8/sql/0.1.0.sql \
"

BBCLASSEXTEND = "native nativesdk"
