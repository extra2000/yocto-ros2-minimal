inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Gazebo ROS2 Messages"
LICENSE = "BSD-1-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "gazebo_ros_pkgs"
ROS_BPN = "gazebo_msgs"

ROS_BUILD_DEPENDS = " \
    builtin-interfaces \
    geometry-msgs \
    std-msgs \
    trajectory-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    rosidl-default-generators-native \
"

ROS_EXPORT_DEPENDS = " \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    builtin-interfaces \
    geometry-msgs \
    rosidl-default-runtime \
    std-msgs \
    trajectory-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS:append = "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN}:append = "${ROS_EXEC_DEPENDS}"

SRC_URI = "git://github.com/ros-simulation/gazebo_ros_pkgs;branch=3.7.0;nobranch=1;protocol=https"
SRCREV = "76c9842370b6f2b483ff190cd5bf40d02c8ee57d"
S = "${WORKDIR}/git/gazebo_msgs"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE} pkgconfig

do_install:append() {
    sed -E -i "s,(${WORKDIR}/recipe-sysroot-native/usr|${WORKDIR}/recipe-sysroot/usr),\x24{_IMPORT_PREFIX},g" ${D}/usr/share/gazebo_msgs/cmake/export_gazebo_msgs__rosidl_generator_pyExport.cmake
}
