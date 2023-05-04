inherit ros_distro_humble
inherit ros_superflore_generated

SUMMARY = "ROS2 Humble Python helloworld"
DESCRIPTION = "${SUMMARY}"
AUTHOR = "Nick Aizuddin <nick@extra2000.io>"
ROS_AUTHOR = "Nick Aizuddin"
SECTION = "PETALINUX/apps"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1317490e6c0aa391d3d8096ce4479acd"
PV = "1.0.0"
PR = "r0"

S = "${WORKDIR}/ros2_helloworld_python"

SRC_URI = "\
    file://ros2_helloworld_python/LICENSE \
    file://ros2_helloworld_python/VERSION \
    file://ros2_helloworld_python/package.xml \
    file://ros2_helloworld_python/setup.py \
    file://ros2_helloworld_python/setup.cfg \
    file://ros2_helloworld_python/test/test_copyright.py \
    file://ros2_helloworld_python/test/test_flake8.py \
    file://ros2_helloworld_python/test/test_pep257.py \
    file://ros2_helloworld_python/resource/ros2_helloworld_python \
    file://ros2_helloworld_python/ros2_helloworld_python/__init__.py \
    file://ros2_helloworld_python/ros2_helloworld_python/helloworld.py \
"

ROS_BUILD_TYPE = "ament_python"

ROS_BUILDTOOL_DEPENDS = ""

ROS_BUILD_DEPENDS = ""

ROS_EXEC_DEPENDS = "\
    rclpy \
    std-msgs \
"

ROS_EXPORT_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-copyright \
    ament-flake8 \
    ament-pep257 \
    python3-pytest \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"
RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

inherit ros_${ROS_BUILD_TYPE}
