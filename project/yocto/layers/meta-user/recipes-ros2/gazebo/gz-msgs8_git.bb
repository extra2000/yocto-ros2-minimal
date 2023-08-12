SUMMARY = "Gazebo Messages"
DESCRIPTION = "${SUMMARY}"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-msgs;branch=ign-msgs8;protocol=https"
SRCREV = "0387c129d63af1597e550d6b16ce9beaed51d7eb"
S = "${WORKDIR}/git"

DEPENDS:class-target = " \
    libtinyxml2 \
    protobuf \
    gz-msgs8-native \
    gz-cmake2 \
    gz-math6 \
"

DEPENDS:class-native = " \
    gz-cmake2-native \
    gz-math6-native \
    libtinyxml2-native \
    protobuf-native \
"

RDEPENDS:${PN}:class-native = " \
    protobuf-compiler \
"

inherit cmake

EXTRA_OECMAKE:class-target = "-DIGN_MSGS_GEN_EXECUTABLE=${WORKDIR}/recipe-sysroot-native/usr/bin/ign_msgs_gen -DPROTOBUF_PROTOC_EXECUTABLE=${WORKDIR}/recipe-sysroot-native/usr/bin/protoc"
EXTRA_OECMAKE:class-native = "-DINSTALL_IGN_MSGS_GEN_EXECUTABLE:BOOL=ON"

FILES:${PN}:append:class-target = " \
    /usr/share \
    /usr/lib/ruby \
    /usr/lib/ruby/ignition \
    /usr/lib/ruby/ignition/cmdmsgs8.rb \
    /usr/lib/ruby/ignition/msgs8 \
    /usr/lib/ruby/ignition/msgs8/actor_pb.rb \
    /usr/lib/ruby/ignition/msgs8/actuators_pb.rb \
    /usr/lib/ruby/ignition/msgs8/air_pressure_sensor_pb.rb \
    /usr/lib/ruby/ignition/msgs8/altimeter_pb.rb \
    /usr/lib/ruby/ignition/msgs8/altimeter_sensor_pb.rb \
    /usr/lib/ruby/ignition/msgs8/annotated_axis_aligned_2d_box_pb.rb \
    /usr/lib/ruby/ignition/msgs8/annotated_axis_aligned_2d_box_v_pb.rb \
    /usr/lib/ruby/ignition/msgs8/annotated_oriented_3d_box_pb.rb \
    /usr/lib/ruby/ignition/msgs8/annotated_oriented_3d_box_v_pb.rb \
    /usr/lib/ruby/ignition/msgs8/any_pb.rb \
    /usr/lib/ruby/ignition/msgs8/atmosphere_pb.rb \
    /usr/lib/ruby/ignition/msgs8/axis_pb.rb \
    /usr/lib/ruby/ignition/msgs8/axis_aligned_2d_box_pb.rb \
    /usr/lib/ruby/ignition/msgs8/axis_aligned_box_pb.rb \
    /usr/lib/ruby/ignition/msgs8/battery_pb.rb \
    /usr/lib/ruby/ignition/msgs8/battery_state_pb.rb \
    /usr/lib/ruby/ignition/msgs8/boolean_pb.rb \
    /usr/lib/ruby/ignition/msgs8/boxgeom_pb.rb \
    /usr/lib/ruby/ignition/msgs8/bytes_pb.rb \
    /usr/lib/ruby/ignition/msgs8/camera_cmd_pb.rb \
    /usr/lib/ruby/ignition/msgs8/camera_info_pb.rb \
    /usr/lib/ruby/ignition/msgs8/camera_lens_pb.rb \
    /usr/lib/ruby/ignition/msgs8/camerasensor_pb.rb \
    /usr/lib/ruby/ignition/msgs8/capsulegeom_pb.rb \
    /usr/lib/ruby/ignition/msgs8/cessna_pb.rb \
    /usr/lib/ruby/ignition/msgs8/clock_pb.rb \
    /usr/lib/ruby/ignition/msgs8/cmd_vel2d_pb.rb \
    /usr/lib/ruby/ignition/msgs8/collision_pb.rb \
    /usr/lib/ruby/ignition/msgs8/color_pb.rb \
    /usr/lib/ruby/ignition/msgs8/conegeom_pb.rb \
    /usr/lib/ruby/ignition/msgs8/contact_pb.rb \
    /usr/lib/ruby/ignition/msgs8/contacts_pb.rb \
    /usr/lib/ruby/ignition/msgs8/contactsensor_pb.rb \
    /usr/lib/ruby/ignition/msgs8/cylindergeom_pb.rb \
"

BBCLASSEXTEND = "native nativesdk"
