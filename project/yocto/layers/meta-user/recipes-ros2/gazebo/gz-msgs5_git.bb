SUMMARY = "Gazebo Messages"
DESCRIPTION = "${SUMMARY}"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-msgs;branch=ign-msgs5;protocol=https"
SRCREV = "0c0926c37042ac8f5aeb49ac36101acd3e084c6b"
S = "${WORKDIR}/git"

DEPENDS:class-target = " \
    libtinyxml2 \
    protobuf \
    gz-msgs5-native \
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
    /usr/lib/ruby/ignition/cmdmsgs5.rb \
    /usr/lib/ruby/ignition/msgs5 \
    /usr/lib/ruby/ignition/msgs5/actor_pb.rb \
    /usr/lib/ruby/ignition/msgs5/actuators_pb.rb \
    /usr/lib/ruby/ignition/msgs5/air_pressure_sensor_pb.rb \
    /usr/lib/ruby/ignition/msgs5/altimeter_pb.rb \
    /usr/lib/ruby/ignition/msgs5/altimeter_sensor_pb.rb \
    /usr/lib/ruby/ignition/msgs5/any_pb.rb \
    /usr/lib/ruby/ignition/msgs5/atmosphere_pb.rb \
    /usr/lib/ruby/ignition/msgs5/axis_pb.rb \
    /usr/lib/ruby/ignition/msgs5/axis_aligned_box_pb.rb \
    /usr/lib/ruby/ignition/msgs5/battery_pb.rb \
    /usr/lib/ruby/ignition/msgs5/battery_state_pb.rb \
    /usr/lib/ruby/ignition/msgs5/boolean_pb.rb \
    /usr/lib/ruby/ignition/msgs5/boxgeom_pb.rb \
    /usr/lib/ruby/ignition/msgs5/bytes_pb.rb \
    /usr/lib/ruby/ignition/msgs5/camera_cmd_pb.rb \
    /usr/lib/ruby/ignition/msgs5/camera_info_pb.rb \
    /usr/lib/ruby/ignition/msgs5/camera_lens_pb.rb \
    /usr/lib/ruby/ignition/msgs5/camerasensor_pb.rb \
    /usr/lib/ruby/ignition/msgs5/cessna_pb.rb \
    /usr/lib/ruby/ignition/msgs5/clock_pb.rb \
    /usr/lib/ruby/ignition/msgs5/cmd_vel2d_pb.rb \
    /usr/lib/ruby/ignition/msgs5/collision_pb.rb \
    /usr/lib/ruby/ignition/msgs5/color_pb.rb \
    /usr/lib/ruby/ignition/msgs5/contact_pb.rb \
    /usr/lib/ruby/ignition/msgs5/contacts_pb.rb \
    /usr/lib/ruby/ignition/msgs5/contactsensor_pb.rb \
    /usr/lib/ruby/ignition/msgs5/cylindergeom_pb.rb \
    /usr/lib/ruby/ignition/msgs5/density_pb.rb \
    /usr/lib/ruby/ignition/msgs5/diagnostics_pb.rb \
    /usr/lib/ruby/ignition/msgs5/discovery_pb.rb \
    /usr/lib/ruby/ignition/msgs5/distortion_pb.rb \
    /usr/lib/ruby/ignition/msgs5/double_pb.rb \
    /usr/lib/ruby/ignition/msgs5/double_v_pb.rb \
    /usr/lib/ruby/ignition/msgs5/duration_pb.rb \
    /usr/lib/ruby/ignition/msgs5/empty_pb.rb \
    /usr/lib/ruby/ignition/msgs5/entity_pb.rb \
    /usr/lib/ruby/ignition/msgs5/entity_factory_pb.rb \
    /usr/lib/ruby/ignition/msgs5/entity_factory_v_pb.rb \
    /usr/lib/ruby/ignition/msgs5/entity_wrench_pb.rb \
    /usr/lib/ruby/ignition/msgs5/float_pb.rb \
    /usr/lib/ruby/ignition/msgs5/float_v_pb.rb \
    /usr/lib/ruby/ignition/msgs5/fluid_pb.rb \
    /usr/lib/ruby/ignition/msgs5/fluid_pressure_pb.rb \
    /usr/lib/ruby/ignition/msgs5/fog_pb.rb \
    /usr/lib/ruby/ignition/msgs5/friction_pb.rb \
    /usr/lib/ruby/ignition/msgs5/fuel_metadata_pb.rb \
    /usr/lib/ruby/ignition/msgs5/geometry_pb.rb \
    /usr/lib/ruby/ignition/msgs5/gps_pb.rb \
    /usr/lib/ruby/ignition/msgs5/gps_sensor_pb.rb \
    /usr/lib/ruby/ignition/msgs5/gui_pb.rb \
    /usr/lib/ruby/ignition/msgs5/gui_camera_pb.rb \
    /usr/lib/ruby/ignition/msgs5/header_pb.rb \
    /usr/lib/ruby/ignition/msgs5/heightmapgeom_pb.rb \
    /usr/lib/ruby/ignition/msgs5/hydra_pb.rb \
    /usr/lib/ruby/ignition/msgs5/image_pb.rb \
    /usr/lib/ruby/ignition/msgs5/imagegeom_pb.rb \
    /usr/lib/ruby/ignition/msgs5/imu_pb.rb \
    /usr/lib/ruby/ignition/msgs5/imu_sensor_pb.rb \
    /usr/lib/ruby/ignition/msgs5/inertial_pb.rb \
    /usr/lib/ruby/ignition/msgs5/int32_pb.rb \
    /usr/lib/ruby/ignition/msgs5/int32_v_pb.rb \
    /usr/lib/ruby/ignition/msgs5/int64_pb.rb \
    /usr/lib/ruby/ignition/msgs5/int64_v_pb.rb \
    /usr/lib/ruby/ignition/msgs5/joint_pb.rb \
    /usr/lib/ruby/ignition/msgs5/joint_animation_pb.rb \
    /usr/lib/ruby/ignition/msgs5/joint_cmd_pb.rb \
    /usr/lib/ruby/ignition/msgs5/joint_trajectory_pb.rb \
    /usr/lib/ruby/ignition/msgs5/joint_trajectory_point_pb.rb \
    /usr/lib/ruby/ignition/msgs5/joint_wrench_pb.rb \
    /usr/lib/ruby/ignition/msgs5/joy_pb.rb \
    /usr/lib/ruby/ignition/msgs5/joystick_pb.rb \
    /usr/lib/ruby/ignition/msgs5/laserscan_pb.rb \
    /usr/lib/ruby/ignition/msgs5/lidar_sensor_pb.rb \
    /usr/lib/ruby/ignition/msgs5/light_pb.rb \
    /usr/lib/ruby/ignition/msgs5/link_pb.rb \
    /usr/lib/ruby/ignition/msgs5/link_data_pb.rb \
    /usr/lib/ruby/ignition/msgs5/log_control_pb.rb \
    /usr/lib/ruby/ignition/msgs5/log_playback_control_pb.rb \
    /usr/lib/ruby/ignition/msgs5/log_playback_stats_pb.rb \
    /usr/lib/ruby/ignition/msgs5/log_status_pb.rb \
    /usr/lib/ruby/ignition/msgs5/logical_camera_image_pb.rb \
    /usr/lib/ruby/ignition/msgs5/logical_camera_sensor_pb.rb \
    /usr/lib/ruby/ignition/msgs5/magnetometer_pb.rb \
    /usr/lib/ruby/ignition/msgs5/magnetometer_sensor_pb.rb \
    /usr/lib/ruby/ignition/msgs5/marker_pb.rb \
    /usr/lib/ruby/ignition/msgs5/marker_v_pb.rb \
    /usr/lib/ruby/ignition/msgs5/material_pb.rb \
    /usr/lib/ruby/ignition/msgs5/meshgeom_pb.rb \
    /usr/lib/ruby/ignition/msgs5/model_pb.rb \
    /usr/lib/ruby/ignition/msgs5/model_configuration_pb.rb \
    /usr/lib/ruby/ignition/msgs5/model_v_pb.rb \
    /usr/lib/ruby/ignition/msgs5/navsat_pb.rb \
    /usr/lib/ruby/ignition/msgs5/occupancy_grid_pb.rb \
    /usr/lib/ruby/ignition/msgs5/odometry_pb.rb \
    /usr/lib/ruby/ignition/msgs5/packet_pb.rb \
    /usr/lib/ruby/ignition/msgs5/param_pb.rb \
    /usr/lib/ruby/ignition/msgs5/param_v_pb.rb \
    /usr/lib/ruby/ignition/msgs5/performance_sensor_metrics_pb.rb \
    /usr/lib/ruby/ignition/msgs5/physics_pb.rb \
    /usr/lib/ruby/ignition/msgs5/pid_pb.rb \
    /usr/lib/ruby/ignition/msgs5/planegeom_pb.rb \
    /usr/lib/ruby/ignition/msgs5/plugin_pb.rb \
    /usr/lib/ruby/ignition/msgs5/plugin_v_pb.rb \
    /usr/lib/ruby/ignition/msgs5/pointcloud_pb.rb \
    /usr/lib/ruby/ignition/msgs5/pointcloud_packed_pb.rb \
    /usr/lib/ruby/ignition/msgs5/polylinegeom_pb.rb \
    /usr/lib/ruby/ignition/msgs5/pose_pb.rb \
    /usr/lib/ruby/ignition/msgs5/pose_animation_pb.rb \
    /usr/lib/ruby/ignition/msgs5/pose_trajectory_pb.rb \
    /usr/lib/ruby/ignition/msgs5/pose_v_pb.rb \
    /usr/lib/ruby/ignition/msgs5/projector_pb.rb \
    /usr/lib/ruby/ignition/msgs5/propagation_grid_pb.rb \
    /usr/lib/ruby/ignition/msgs5/propagation_particle_pb.rb \
    /usr/lib/ruby/ignition/msgs5/publish_pb.rb \
    /usr/lib/ruby/ignition/msgs5/publishers_pb.rb \
    /usr/lib/ruby/ignition/msgs5/quaternion_pb.rb \
    /usr/lib/ruby/ignition/msgs5/raysensor_pb.rb \
    /usr/lib/ruby/ignition/msgs5/request_pb.rb \
    /usr/lib/ruby/ignition/msgs5/response_pb.rb \
    /usr/lib/ruby/ignition/msgs5/rest_login_pb.rb \
    /usr/lib/ruby/ignition/msgs5/rest_logout_pb.rb \
    /usr/lib/ruby/ignition/msgs5/rest_post_pb.rb \
    /usr/lib/ruby/ignition/msgs5/rest_response_pb.rb \
    /usr/lib/ruby/ignition/msgs5/road_pb.rb \
    /usr/lib/ruby/ignition/msgs5/scene_pb.rb \
    /usr/lib/ruby/ignition/msgs5/sdf_generator_config_pb.rb \
    /usr/lib/ruby/ignition/msgs5/selection_pb.rb \
    /usr/lib/ruby/ignition/msgs5/sensor_pb.rb \
    /usr/lib/ruby/ignition/msgs5/sensor_noise_pb.rb \
    /usr/lib/ruby/ignition/msgs5/sensor_v_pb.rb \
    /usr/lib/ruby/ignition/msgs5/serialized_pb.rb \
    /usr/lib/ruby/ignition/msgs5/serialized_map_pb.rb \
    /usr/lib/ruby/ignition/msgs5/server_control_pb.rb \
    /usr/lib/ruby/ignition/msgs5/shadows_pb.rb \
    /usr/lib/ruby/ignition/msgs5/sim_event_pb.rb \
    /usr/lib/ruby/ignition/msgs5/sky_pb.rb \
    /usr/lib/ruby/ignition/msgs5/sonar_pb.rb \
    /usr/lib/ruby/ignition/msgs5/spheregeom_pb.rb \
    /usr/lib/ruby/ignition/msgs5/spherical_coordinates_pb.rb \
    /usr/lib/ruby/ignition/msgs5/statistic_pb.rb \
    /usr/lib/ruby/ignition/msgs5/stringmsg_pb.rb \
    /usr/lib/ruby/ignition/msgs5/stringmsg_v_pb.rb \
    /usr/lib/ruby/ignition/msgs5/subscribe_pb.rb \
    /usr/lib/ruby/ignition/msgs5/surface_pb.rb \
    /usr/lib/ruby/ignition/msgs5/tactile_pb.rb \
    /usr/lib/ruby/ignition/msgs5/test_pb.rb \
    /usr/lib/ruby/ignition/msgs5/time_pb.rb \
    /usr/lib/ruby/ignition/msgs5/topic_info_pb.rb \
    /usr/lib/ruby/ignition/msgs5/track_visual_pb.rb \
    /usr/lib/ruby/ignition/msgs5/twist_pb.rb \
    /usr/lib/ruby/ignition/msgs5/uint32_pb.rb \
    /usr/lib/ruby/ignition/msgs5/uint32_v_pb.rb \
    /usr/lib/ruby/ignition/msgs5/uint64_pb.rb \
    /usr/lib/ruby/ignition/msgs5/uint64_v_pb.rb \
    /usr/lib/ruby/ignition/msgs5/undo_redo_pb.rb \
    /usr/lib/ruby/ignition/msgs5/user_cmd_pb.rb \
    /usr/lib/ruby/ignition/msgs5/user_cmd_stats_pb.rb \
    /usr/lib/ruby/ignition/msgs5/vector2d_pb.rb \
    /usr/lib/ruby/ignition/msgs5/vector3d_pb.rb \
    /usr/lib/ruby/ignition/msgs5/version_pb.rb \
    /usr/lib/ruby/ignition/msgs5/version_range_pb.rb \
    /usr/lib/ruby/ignition/msgs5/versioned_name_pb.rb \
    /usr/lib/ruby/ignition/msgs5/video_record_pb.rb \
    /usr/lib/ruby/ignition/msgs5/visual_pb.rb \
    /usr/lib/ruby/ignition/msgs5/visual_v_pb.rb \
    /usr/lib/ruby/ignition/msgs5/web_request_pb.rb \
    /usr/lib/ruby/ignition/msgs5/wind_pb.rb \
    /usr/lib/ruby/ignition/msgs5/wireless_node_pb.rb \
    /usr/lib/ruby/ignition/msgs5/wireless_nodes_pb.rb \
    /usr/lib/ruby/ignition/msgs5/world_control_pb.rb \
    /usr/lib/ruby/ignition/msgs5/world_modify_pb.rb \
    /usr/lib/ruby/ignition/msgs5/world_reset_pb.rb \
    /usr/lib/ruby/ignition/msgs5/world_stats_pb.rb \
    /usr/lib/ruby/ignition/msgs5/wrench_pb.rb \
    /usr/share/gz \
    /usr/share/ignition \
    /usr/share/gz/gz1.completion.d \
    /usr/share/gz/gz1.completion.d/msgs5.bash_completion.sh \
    /usr/share/ignition/msgs5.yaml \
"

BBCLASSEXTEND = "native nativesdk"
