# Testing


## Simple ROS2 Helloworld Testing

Source ROS2 environment:
```
source /etc/profile.d/ros/setup.bash
```

List installed packages and executables:
```
ros2 pkg list
ros2 pkg executables
```

To run the simple Hello World examples:
```
ros2 run ros2-helloworld-cpp main
ros2 run ros2_helloworld_python helloworld
```

To exit the program, either `CTRL` + `C` or send `0x0A03` (Number) to serial console.


## ROS2 Perception Node

SSH into the target device and run simulation:
```
source /etc/profile.d/ros/setup.bash
DISPLAY=:0 GAZEBO_RESOURCE_PATH="/usr/share/gazebo-11:/usr/share/OGRE/Media/ShadowVolume" ros2 launch perception_2nodes simulation.launch.py headless:='True'
```

Open another terminal. Then, run Rectify and Resize example on the target device:
```
source /etc/profile.d/ros/setup.bash
DISPLAY=:0 GAZEBO_RESOURCE_PATH="/usr/share/gazebo-11:/usr/share/OGRE/Media/ShadowVolume" ros2 launch perception_2nodes trace_rectify_resize.launch.py
```

On host, allow X11 forwarding from local non-network connections:
```
xhost +local:
```

Then execute the following command:
```
podman run -it --rm \
    -e DISPLAY=$DISPLAY \
    --device=/dev/dri \
    --network=host \
    --userns="keep-id:uid=1000,gid=1000" \
    --security-opt label=disable \
    --name=ros2-workstation \
    localhost/extra2000/ros2-gazebo11-classic:latest \
    bash
source /opt/ros/humble/setup.bash
rqt
```

Open another terminal and execute the following command:
```
podman exec -it ros2-workstation bash
source /opt/ros/humble/setup.bash
GAZEBO_MASTER_URI=http://TARGET_MACHINE:11345 gzclient --verbose
```

*NOTE: Replace the `TARGET_MACHINE` according to your target device IP address or FQDN.*


## Known Issues

Python examples are broken at the moment due to Yocto Langdale uses `Python3 Setuptools v65.0.2`. See [entry_points install path is now 'bin' instead of 'lib' for setup.py installs](https://github.com/colcon/colcon-core/issues/518) issue. The examples only work with Yocto Honister which uses `Python3 Setuptools v57.4.0`.
