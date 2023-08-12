SUMMARY = "Gazebo Common"
DESCRIPTION = "${SUMMARY}"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-common;branch=ign-common3;protocol=https"
SRCREV = "11e94807ab35119716e336e14f7a1f2c70aed835"

SRC_URI:append:class-native = " file://0000-cmake.patch"

S = "${WORKDIR}/git"

DEPENDS = " \
    freeimage \
    util-linux \
    libtinyxml2 \
    gts \
    ffmpeg \
    gz-cmake2 \
    gz-math6 \
"

inherit cmake pkgconfig

EXTRA_OECMAKE = " \
    -DBUILD_TESTING=OFF \
    -DFREEIMAGE_RUNS=FAILED_TO_RUN \
    -DFREEIMAGE_RUNS__TRYRUN_OUTPUT='' \
"

FILES:${PN}:append = " \
    /usr/share \
    /usr/share/ignition \
    /usr/share/ignition/ignition-common3 \
    /usr/share/ignition/ignition-common3/profiler_vis \
    /usr/share/ignition/ignition-common3/profiler_vis/index.html \
    /usr/share/ignition/ignition-common3/profiler_vis/Code \
    /usr/share/ignition/ignition-common3/profiler_vis/Styles \
    /usr/share/ignition/ignition-common3/profiler_vis/extern \
    /usr/share/ignition/ignition-common3/profiler_vis/Code/Console.js \
    /usr/share/ignition/ignition-common3/profiler_vis/Code/DataViewReader.js \
    /usr/share/ignition/ignition-common3/profiler_vis/Code/PixelTimeRange.js \
    /usr/share/ignition/ignition-common3/profiler_vis/Code/Remotery.js \
    /usr/share/ignition/ignition-common3/profiler_vis/Code/SampleWindow.js \
    /usr/share/ignition/ignition-common3/profiler_vis/Code/ThreadFrame.js \
    /usr/share/ignition/ignition-common3/profiler_vis/Code/TimelineRow.js \
    /usr/share/ignition/ignition-common3/profiler_vis/Code/TimelineWindow.js \
    /usr/share/ignition/ignition-common3/profiler_vis/Code/TitleWindow.js \
    /usr/share/ignition/ignition-common3/profiler_vis/Code/WebSocketConnection.js \
    /usr/share/ignition/ignition-common3/profiler_vis/Styles/Remotery.css \
    /usr/share/ignition/ignition-common3/profiler_vis/extern/BrowserLib \
    /usr/share/ignition/ignition-common3/profiler_vis/extern/BrowserLib/Core \
    /usr/share/ignition/ignition-common3/profiler_vis/extern/BrowserLib/WindowManager \
    /usr/share/ignition/ignition-common3/profiler_vis/extern/BrowserLib/Core/Code \
    /usr/share/ignition/ignition-common3/profiler_vis/extern/BrowserLib/Core/Code/Animation.js \
    /usr/share/ignition/ignition-common3/profiler_vis/extern/BrowserLib/Core/Code/Bind.js \
    /usr/share/ignition/ignition-common3/profiler_vis/extern/BrowserLib/Core/Code/Convert.js \
    /usr/share/ignition/ignition-common3/profiler_vis/extern/BrowserLib/Core/Code/Core.js \
    /usr/share/ignition/ignition-common3/profiler_vis/extern/BrowserLib/Core/Code/DOM.js \
    /usr/share/ignition/ignition-common3/profiler_vis/extern/BrowserLib/Core/Code/Keyboard.js \
    /usr/share/ignition/ignition-common3/profiler_vis/extern/BrowserLib/Core/Code/LocalStore.js \
    /usr/share/ignition/ignition-common3/profiler_vis/extern/BrowserLib/Core/Code/Mouse.js \
    /usr/share/ignition/ignition-common3/profiler_vis/extern/BrowserLib/Core/Code/MurmurHash3.js \
    /usr/share/ignition/ignition-common3/profiler_vis/extern/BrowserLib/WindowManager/Code \
    /usr/share/ignition/ignition-common3/profiler_vis/extern/BrowserLib/WindowManager/Styles \
    /usr/share/ignition/ignition-common3/profiler_vis/extern/BrowserLib/WindowManager/Code/Button.js \
    /usr/share/ignition/ignition-common3/profiler_vis/extern/BrowserLib/WindowManager/Code/ComboBox.js \
    /usr/share/ignition/ignition-common3/profiler_vis/extern/BrowserLib/WindowManager/Code/Container.js \
    /usr/share/ignition/ignition-common3/profiler_vis/extern/BrowserLib/WindowManager/Code/EditBox.js \
    /usr/share/ignition/ignition-common3/profiler_vis/extern/BrowserLib/WindowManager/Code/Grid.js \
    /usr/share/ignition/ignition-common3/profiler_vis/extern/BrowserLib/WindowManager/Code/Label.js \
    /usr/share/ignition/ignition-common3/profiler_vis/extern/BrowserLib/WindowManager/Code/Treeview.js \
    /usr/share/ignition/ignition-common3/profiler_vis/extern/BrowserLib/WindowManager/Code/TreeviewItem.js \
    /usr/share/ignition/ignition-common3/profiler_vis/extern/BrowserLib/WindowManager/Code/Window.js \
    /usr/share/ignition/ignition-common3/profiler_vis/extern/BrowserLib/WindowManager/Code/WindowManager.js \
    /usr/share/ignition/ignition-common3/profiler_vis/extern/BrowserLib/WindowManager/Styles/WindowManager.css \
"

BBCLASSEXTEND = "native nativesdk"
