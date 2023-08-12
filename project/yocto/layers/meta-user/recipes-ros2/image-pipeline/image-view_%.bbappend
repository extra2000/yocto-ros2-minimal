ROS_BUILD_DEPENDS:append = " \
    python3-numpy \
    python3-numpy-native \
"

ROS_EXEC_DEPENDS:append = " \
    python3-numpy \
"

# Fixes "src/video_recorder_node.cpp:114:95: error: no matching function for call to 'rclcpp::Duration::Duration(double)'"
SRCREV = "784f025d8504106d0d84e584b73b00fb436d2897"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=d566ef916e9dedc494f5f793a6690ba5"
