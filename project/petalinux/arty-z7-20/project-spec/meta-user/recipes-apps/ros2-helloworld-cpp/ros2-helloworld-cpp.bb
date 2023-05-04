inherit ros_distro_humble
inherit ros_superflore_generated

SUMMARY = "ROS2 Humble C++ helloworld"
DESCRIPTION = "${SUMMARY}"
AUTHOR = "Nick Aizuddin <nick@extra2000.io>"
ROS_AUTHOR = "Nick Aizuddin"
SECTION = "PETALINUX/apps"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=14549528096b9b60194cbada83109dcd"
PV = "1.0.0"
PR = "r0"

#ROS_CN = "myexamples"
#ROS_BPN = "ros2-helloworld-cpp"

S = "${WORKDIR}/ros2-helloworld-cpp"

SRC_URI = "\
    file://ros2-helloworld-cpp/LICENSE \
    file://ros2-helloworld-cpp/VERSION \
    file://ros2-helloworld-cpp/package.xml \
    file://ros2-helloworld-cpp/CMakeLists.txt \
    file://ros2-helloworld-cpp/src/main.cpp \
    file://ros2-helloworld-cpp/include/engine.hpp \
    file://ros2-helloworld-cpp/src/lib/engine.cpp \
"

ROS_BUILD_TYPE = "ament_cmake"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

# Package "python3-numpy-native" is required by ament.
# See https://github.com/Xilinx/meta-ros/blob/rel-v2022.2/meta-ros2-humble/recipes-bbappends/examples/examples-rclcpp-minimal-publisher_%25.bbappend
ROS_BUILD_DEPENDS = " \
    rclcpp \
    std-msgs \
    python3-numpy-native \
"

ROS_EXEC_DEPENDS = "\
    rclcpp \
    std-msgs \
"

ROS_EXPORT_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"
RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

inherit ros_${ROS_BUILD_TYPE}
