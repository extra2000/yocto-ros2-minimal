ROS_BUILD_DEPENDS:append = " \
    python3-numpy \
    python3-numpy-native \
"

ROS_EXEC_DEPENDS:append = " \
    python3-numpy \
"

# Fixes "src/crop_foremost.cpp:69:26: error: no matching function for call to 'depth_image_proc::CropForemostNode::declare_parameter(const char [9])'"
SRCREV = "ac8700f961f81b6882a54a0c3332d2f5582fc025"
LIC_FILES_CHKSUM = "file://package.xml;beginline=20;endline=20;md5=d566ef916e9dedc494f5f793a6690ba5"
