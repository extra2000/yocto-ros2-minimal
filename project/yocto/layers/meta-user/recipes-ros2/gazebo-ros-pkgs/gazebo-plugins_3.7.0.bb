inherit ros_distro_humble
inherit ros_superflore_generated

DESCRIPTION = "Robot-independent Gazebo plugins for sensors, motors and dynamic reconfigurable components."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=f7d4e3a22e6490b133f4eb99348a8124"

ROS_CN = "gazebo_ros_pkgs"
ROS_BPN = "gazebo_plugins"

ROS_BUILD_DEPENDS = " \
    camera-info-manager \
    cv-bridge \
    gazebo-msgs \
    gazebo-ros \
    gazebo-rosdev \
    geometry-msgs \
    image-transport \
    nav-msgs \
    rclcpp \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf2-geometry-msgs \
    tf2-ros \
    trajectory-msgs \
    python3-numpy \
    python3-numpy-native \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    camera-info-manager \
    cv-bridge \
    geometry-msgs \
    image-transport \
    nav-msgs \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf2-geometry-msgs \
    tf2-ros \
    trajectory-msgs \
    python3-numpy \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    camera-info-manager \
    cv-bridge \
    gazebo-msgs \
    gazebo-ros \
    gazebo-rosdev \
    geometry-msgs \
    image-transport \
    nav-msgs \
    rclcpp \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf2-geometry-msgs \
    tf2-ros \
    trajectory-msgs \
    python3-numpy \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    ament-lint-auto \
    ament-lint-common \
    cv-bridge \
    python3-numpy \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "git://github.com/ros-simulation/gazebo_ros_pkgs;branch=3.7.0;nobranch=1;protocol=https"
SRCREV = "76c9842370b6f2b483ff190cd5bf40d02c8ee57d"
S = "${WORKDIR}/git/gazebo_plugins"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE} pkgconfig

EXTRA_OECMAKE:append = " -DCMAKE_MODULE_PATH=${WORKDIR}/recipe-sysroot/usr/lib/OGRE/cmake"

do_install:append() {
    sed -E -i "s,${WORKDIR}/recipe-sysroot,,g" ${D}/usr/share/gazebo_plugins/environment/gazebo_plugins.sh
    sed -E -i "s,${WORKDIR}/recipe-sysroot,,g" ${D}/usr/share/gazebo_plugins/environment/gazebo_plugins.dsv
}
