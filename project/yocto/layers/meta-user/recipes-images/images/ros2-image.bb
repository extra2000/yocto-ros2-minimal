require ${COREBASE}/meta/recipes-core/images/core-image-base.bb

SUMMARY = "ROS2 Image"
DESCRIPTION = "${SUMMARY}"
AUTHOR = "Nick Aizuddin <nick@extra2000.io>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=14549528096b9b60194cbada83109dcd"

inherit ros_distro_${ROS_DISTRO}
inherit ${ROS_DISTRO_TYPE}_image

SRC_URI:append = "\
    file://LICENSE \
"

ROS_SYSROOT_BUILD_DEPENDENCIES = " \
    ament-lint-auto \
    ament-cmake-auto \
    ament-cmake-core \
    ament-cmake-cppcheck \
    ament-cmake-cpplint \
    ament-cmake-export-definitions \
    ament-cmake-export-dependencies \
    ament-cmake-export-include-directories \
    ament-cmake-export-interfaces \
    ament-cmake-export-libraries \
    ament-cmake-export-link-flags \
    ament-cmake-export-targets \
    ament-cmake-gmock \
    ament-cmake-gtest \
    ament-cmake-include-directories \
    ament-cmake-libraries \
    ament-cmake \
    ament-cmake-pytest \
    ament-cmake-python \
    ament-cmake-ros \
    ament-cmake-target-dependencies \
    ament-cmake-test \
    ament-cmake-version \
    ament-cmake-uncrustify \
    ament-cmake-flake8 \
    ament-cmake-pep257 \
    ament-copyright \
    ament-cpplint \
    ament-flake8 \
    ament-index-python \
    ament-lint-cmake \
    ament-mypy \
    ament-package \
    ament-pclint \
    ament-pep257 \
    ament-pycodestyle \
    ament-pyflakes \
    ament-uncrustify \
    ament-xmllint \
    cmake \
    eigen3-cmake-module \
    fastcdr \
    fastrtps-cmake-module \
    fastrtps \
    git \
    gmock-vendor \
    gtest-vendor \
    pkgconfig \
    python-cmake-module \
    python3-catkin-pkg \
    python3-empy \
    python3 \
    python3-pytest \
    python3-rospkg \
    rcutils \
    rmw-implementation-cmake \
    rosidl-cmake \
    rosidl-default-generators \
    rosidl-generator-c \
    rosidl-generator-cpp \
    rosidl-generator-dds-idl \
    rosidl-generator-py \
    rosidl-parser \
    rosidl-runtime-c \
    rosidl-runtime-cpp \
    rosidl-typesupport-c \
    rosidl-typesupport-cpp \
    rosidl-typesupport-fastrtps-cpp \
    rosidl-typesupport-interface \
    rosidl-typesupport-introspection-c \
    rosidl-typesupport-introspection-cpp \
    foonathan-memory-vendor \
    libyaml-vendor \
"

USER_APPS = " \
    ros2-helloworld-cpp \
    ros2-helloworld-python \
    perception-2nodes \
"

NETWORKING = " \
    netplan \
    wpa-supplicant \
"

CAMERA = " \
    libcamera \
    boost \
    libexif \
    jpeg \
    tiff \
    libpng \
    libdrm \
    libcamera-apps \
"

HARDENING = " \
    packagegroup-hardening \
"

SELINUX = " \
    packagegroup-core-selinux \
    selinux-custom-policy \
"

DATASTRUCT_APPS = " \
    datastruct-cpp \
"

IMAGE_INSTALL:append = " \
    ${ROS_SYSROOT_BUILD_DEPENDENCIES} \
    ${NETWORKING} \
    ${CAMERA} \
    ${HARDENING} \
    ${SELINUX} \
    ${DATASTRUCT_APPS} \
    ros-core \
    python3-pip \
    python3-argcomplete \
    glibc-utils \
    localedef \
    rt-tests \
    cyclonedds \
    rmw-cyclonedds-cpp \
    bash \
    ${USER_APPS} \
"

TOOLCHAIN_TARGET_TASK:append = " \
    ${ROS_SYSROOT_BUILD_DEPENDENCIES} \
    ros-core \
    foonathan-memory-staticdev \
    ament-cmake-gen-version-h \
"

TOOLCHAIN_HOST_TASK:append = " \
    nativesdk-ament-package \
    nativesdk-ament-cmake \
    nativesdk-python3-numpy \
    nativesdk-python3-colcon-ros \
    nativesdk-python3-dev \
    nativesdk-ros-core \
    nativesdk-rosidl-generator-py \
    nativesdk-rosidl-default-generators \
    nativesdk-rosidl-typesupport-c \
    nativesdk-rosidl-typesupport-cpp \
    nativesdk-ament-cmake-gen-version-h \
    nativesdk-builtin-interfaces \
"

IMAGE_LINGUAS = "en-us"
GLIBC_GENERATE_LOCALES = "en_US.UTF-8"

inherit extrausers

# Use `mkpasswd -m sha-512 yocto -s "11223344"` to encrypt
# "yocto" password into an encrypted string for usermod -p argument.
# Make sure to escape the '$' sign.
ROOT_DEFAULT_PASSWORD ?= "\$6\$11223344\$10y07XMjdVLi.mnmG6SKHGpWvywjYLMeJGpywG4MXAgY6Zux1hN05RCJl9tg5n0xIcO5nomiv5XULCjZuLhgy1"
DEFAULT_ADMIN_ACCOUNT ?= "yocto"
DEFAULT_ADMIN_GROUP ?= "wheel"
DEFAULT_ADMIN_ACCOUNT_PASSWORD ?= "\$6\$11223344\$10y07XMjdVLi.mnmG6SKHGpWvywjYLMeJGpywG4MXAgY6Zux1hN05RCJl9tg5n0xIcO5nomiv5XULCjZuLhgy1"
ADMIN_ADDITIONAL_GROUPS ?= ",video"

EXTRA_USERS_PARAMS = "${@bb.utils.contains('DISABLE_ROOT', 'True', "usermod -L root;", "usermod -p '${ROOT_DEFAULT_PASSWORD}' root;", d)}"
EXTRA_USERS_PARAMS:append = " useradd  ${DEFAULT_ADMIN_ACCOUNT};"
EXTRA_USERS_PARAMS:append = " groupadd  ${DEFAULT_ADMIN_GROUP};"
EXTRA_USERS_PARAMS:append = " usermod -p '${DEFAULT_ADMIN_ACCOUNT_PASSWORD}' ${DEFAULT_ADMIN_ACCOUNT};"
EXTRA_USERS_PARAMS:append = " usermod -aG ${DEFAULT_ADMIN_GROUP}${ADMIN_ADDITIONAL_GROUPS} ${DEFAULT_ADMIN_ACCOUNT};"
