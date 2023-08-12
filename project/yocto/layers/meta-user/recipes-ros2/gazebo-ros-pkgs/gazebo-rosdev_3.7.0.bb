inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Gazebo ROS2 Dev"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "gazebo_ros_pkgs"
ROS_BPN = "gazebo_dev"

#DEPENDS:remove = "${ROS_UNRESOLVED_DEP-uncrustify}"
#ROS_EXEC_DEPENDS:remove = "${ROS_UNRESOLVED_DEP-uncrustify}"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    gazebo11 \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    gazebo11 \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS:append = "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN}:append = "${ROS_EXEC_DEPENDS}"

SRC_URI = "git://github.com/ros-simulation/gazebo_ros_pkgs;branch=3.7.0;nobranch=1;protocol=https"
SRCREV = "76c9842370b6f2b483ff190cd5bf40d02c8ee57d"
S = "${WORKDIR}/git/gazebo_dev"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE} pkgconfig
