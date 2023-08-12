SUMMARY = "Gazebo Transport"
DESCRIPTION = "${SUMMARY}"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-transport;branch=ign-transport11;protocol=https"
SRCREV = "0e76a2085a5eae95e216b54740ec6e169dcf76a1"
S = "${WORKDIR}/git"

DEPENDS = " \
    util-linux \
    zeromq \
    cppzmq \
    sqlite3 \
    gz-cmake2 \
    gz-msgs8 \
    gz-utils1 \
"

inherit cmake pkgconfig

EXTRA_OECMAKE = "-DPROTOBUF_PROTOC_EXECUTABLE=${WORKDIR}/recipe-sysroot-native/usr/bin/protoc"

FILES:${PN}:append = " \
    /usr/share \
    /usr/lib/ruby \
    /usr/lib/ruby/gz \
    /usr/lib/ruby/ignition \
    /usr/lib/ruby/gz/cmdtransport11.rb \
    /usr/lib/ruby/ignition/cmdparam11.rb \
    /usr/share/gz \
    /usr/share/ignition \
    /usr/share/gz/gz1.completion.d \
    /usr/share/gz/gz1.completion.d/transport11.bash_completion.sh \
    /usr/share/ignition/transportparam11.yaml \
    /usr/share/ignition/transport11.yaml \
"

BBCLASSEXTEND = "native nativesdk"
