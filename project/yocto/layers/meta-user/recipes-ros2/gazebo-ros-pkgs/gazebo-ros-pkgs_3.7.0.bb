inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Gazebo ROS2 Packages"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=4abfee85e7297e5edaf139e7df0625aa"

ROS_CN = "gazebo_ros_pkgs"
ROS_BPN = "gazebo_ros_pkgs"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    gazebo-msgs \
    gazebo-plugins \
    gazebo-ros \
    gazebo-rosdev \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "git://github.com/ros-simulation/gazebo_ros_pkgs;branch=3.7.0;nobranch=1;protocol=https"
SRCREV = "76c9842370b6f2b483ff190cd5bf40d02c8ee57d"
S = "${WORKDIR}/git/gazebo_ros_pkgs"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE} pkgconfig
