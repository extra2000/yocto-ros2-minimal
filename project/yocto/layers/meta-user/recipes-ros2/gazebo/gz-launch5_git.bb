SUMMARY = "Gazebo Launcher"
DESCRIPTION = "${SUMMARY}"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-launch;branch=ign-launch5;protocol=https"
SRCREV = "894e2e2319617fbde652960b847e13436391ec9c"
S = "${WORKDIR}/git"

DEPENDS = " \
    gz-cmake2 \
    libtinyxml2 \
    protobuf \
    protobuf-native \
    libwebsockets \
    gz-common4 \
    gz-utils1 \
    gz-plugin1 \
    gz-tools1 \
    gz-transport11 \
    gz-msgs8 \
    gz-math6 \
    gz-gui6 \
    gz-sim6 \
"

inherit cmake pkgconfig cmake_qt5

EXTRA_OECMAKE:append:class-target = " \
    -DBUILD_TESTING=OFF \
    -DPROTOBUF_PROTOC_EXECUTABLE=${WORKDIR}/recipe-sysroot-native/usr/bin/protoc \
"

FILES:${PN}:append = " \
    /usr/share \
    /usr/lib/ruby \
    /usr/lib/ign-launch-5/plugins/libignition-launch-joytotwist.so \
    /usr/lib/ign-launch-5/plugins/libignition-launch-gazebogui.so \
    /usr/lib/ign-launch-5/plugins/libignition-launch-gazebo-factory.so \
    /usr/lib/ign-launch-5/plugins/libignition-launch-gazebo.so \
    /usr/lib/ign-launch-5/plugins/libignition-launch-websocket-server.so \
    /usr/lib/ign-launch-5/plugins/libignition-launch-joystick.so \
    /usr/lib/ignition/launch5/ign-launch \
    /usr/lib/ruby/ignition \
    /usr/lib/ruby/ignition/cmdlaunch5.rb \
    /usr/share/gz \
    /usr/share/ignition \
    /usr/share/gz/gz1.completion.d \
    /usr/share/gz/gz1.completion.d/launch5.bash_completion.sh \
    /usr/share/ignition/launch5.yaml \
    /usr/share/ignition/ignition-launch5 \
    /usr/share/ignition/ignition-launch5/configs \
    /usr/share/ignition/ignition-launch5/configs/factory.ign \
    /usr/share/ignition/ignition-launch5/configs/gazebo.ign \
    /usr/share/ignition/ignition-launch5/configs/gazebo_plugins.ign \
    /usr/share/ignition/ignition-launch5/configs/ls.ign \
    /usr/share/ignition/ignition-launch5/configs/multi_factory.ign \
    /usr/share/ignition/ignition-launch5/configs/plugins.ign \
    /usr/share/ignition/ignition-launch5/configs/websocket.ign \
"

BBCLASSEXTEND = "native nativesdk"
