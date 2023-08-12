SUMMARY = "Gazebo GUI"
DESCRIPTION = "${SUMMARY}"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-gui;branch=ign-gui6;protocol=https"
SRCREV = "f65395f734df81b22dcd10d68d2802b61d6b72bc"
S = "${WORKDIR}/git"

DEPENDS = " \
    protobuf \
    protobuf-native \
    libtinyxml2 \
    qtquickcontrols2 \
    gz-cmake2 \
    gz-math6 \
    gz-common4 \
    gz-plugin1 \
    gz-transport11 \
    gz-msgs8 \
    gz-rendering6 \
"

inherit cmake pkgconfig cmake_qt5

EXTRA_OECMAKE:class-target = " \
    -DPROTOBUF_PROTOC_EXECUTABLE=${WORKDIR}/recipe-sysroot-native/usr/bin/protoc \
"

FILES:${PN}:append = " \
    /usr/share \
    /usr/lib/ruby \
    /usr/lib/ruby/ignition \
    /usr/lib/ruby/ignition/cmdgui6.rb \
    /usr/lib/ign-gui-6/plugins/libCameraFps.so \
    /usr/lib/ign-gui-6/plugins/libCameraTracking.so \
    /usr/lib/ign-gui-6/plugins/libGridConfig.so \
    /usr/lib/ign-gui-6/plugins/libGrid3D.so \
    /usr/lib/ign-gui-6/plugins/libImageDisplay.so \
    /usr/lib/ign-gui-6/plugins/libInteractiveViewControl.so \
    /usr/lib/ign-gui-6/plugins/libKeyPublisher.so \
    /usr/lib/ign-gui-6/plugins/libTransportPlotting.so \
    /usr/lib/ign-gui-6/plugins/libPublisher.so \
    /usr/lib/ign-gui-6/plugins/libMarkerManager.so \
    /usr/lib/ign-gui-6/plugins/libMinimalScene.so \
    /usr/lib/ign-gui-6/plugins/libNavSatMap.so \
    /usr/lib/ign-gui-6/plugins/libScene3D.so \
    /usr/lib/ign-gui-6/plugins/libScreenshot.so \
    /usr/lib/ign-gui-6/plugins/libShutdownButton.so \
    /usr/lib/ign-gui-6/plugins/libTapeMeasure.so \
    /usr/lib/ign-gui-6/plugins/libTeleop.so \
    /usr/lib/ign-gui-6/plugins/libTopicEcho.so \
    /usr/lib/ign-gui-6/plugins/libTopicViewer.so \
    /usr/lib/ign-gui-6/plugins/libTransportSceneManager.so \
    /usr/lib/ign-gui-6/plugins/libWorldControl.so \
    /usr/lib/ign-gui-6/plugins/libWorldStats.so \
    /usr/share/gz \
    /usr/share/ignition \
    /usr/share/gz/gz1.completion.d \
    /usr/share/gz/gz1.completion.d/gui6.bash_completion.sh \
    /usr/share/ignition/gui6.yaml \
"

BBCLASSEXTEND = "native nativesdk"
