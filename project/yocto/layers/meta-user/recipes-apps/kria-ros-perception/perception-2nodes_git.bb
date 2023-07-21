inherit ros_distro_humble
inherit ros_superflore_generated

SUMMARY = "ROS2 Perception Nodes"
DESCRIPTION = "${SUMMARY}"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://../../LICENSE;md5=aaa7729bf8823a5d00dc80db2da0f9db"

S = "${WORKDIR}/kria_ros_perception/src/perception_2nodes"

SRC_URI = "\
    file://kria_ros_perception/ \
"

ROS_BUILD_TYPE = "ament_python"

ROS_BUILDTOOL_DEPENDS = ""

ROS_BUILD_DEPENDS = " \
    image-proc \
    python3-numpy \
    python3-numpy-native \
"

ROS_EXEC_DEPENDS = "\
    rclpy \
    std-msgs \
    python3-numpy \
    gazebo-ros-pkgs \
    image-pipeline \
    ros2trace \
    tracetools \
    tracetools-launch \
    tracetools-trace \
    lttng-modules \
    lttng-tools \
    lttng-ust \
"

ROS_EXPORT_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-copyright \
    ament-flake8 \
    ament-pep257 \
    python3-pytest \
    python3-numpy \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"
RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

inherit ros_${ROS_BUILD_TYPE}

FILES:${PN}:append = " \
    /usr/share/perception_2nodes \
    /usr/share/perception_2nodes/package.xml \
    /usr/share/perception_2nodes/launch \
    /usr/share/perception_2nodes/models \
    /usr/share/perception_2nodes/worlds \
    /usr/share/perception_2nodes/launch/simulation.launch.py \
    /usr/share/perception_2nodes/launch/trace_rectify_resize.launch.py \
    /usr/share/perception_2nodes/launch/trace_rectify_resize_fpga_streamlined.launch.py \
    /usr/share/perception_2nodes/models/camera-plugin \
    /usr/share/perception_2nodes/models/camera-plugin/model.config \
    /usr/share/perception_2nodes/models/camera-plugin/model_distorted.sdf \
    /usr/share/perception_2nodes/models/camera-plugin/model_undistorted.sdf \
    /usr/share/perception_2nodes/worlds/camera.world \
    /usr/share/perception_2nodes/worlds/camera_dynamic.world \
    /usr/share/perception_2nodes/worlds/camera_dynamic_hd.world \
    /usr/share/perception_2nodes/worlds/camera_dynamic_undistorted.world \
    /usr/share/perception_2nodes/worlds/camera_simple.world \
"
