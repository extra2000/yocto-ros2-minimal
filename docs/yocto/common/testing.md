# Testing

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


## Known Issues

Python examples are broken at the moment due to Yocto Langdale uses `Python3 Setuptools v65.0.2`. See [entry_points install path is now 'bin' instead of 'lib' for setup.py installs](https://github.com/colcon/colcon-core/issues/518) issue. The examples only work with Yocto Honister which uses `Python3 Setuptools v57.4.0`.
