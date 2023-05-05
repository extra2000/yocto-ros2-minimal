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
