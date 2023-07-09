SUMMARY = "C++ Data Struct Application"
DESCRIPTION = "${SUMMARY}"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a16e19e8a5232b504f7645a00425532f"

DEPENDS = "boost"

SRC_URI = "\
    file://datastruct-cpp/LICENSE \
    file://datastruct-cpp/CMakeLists.txt \
    file://datastruct-cpp/projects/logger/CMakeLists.txt \
    file://datastruct-cpp/projects/logger/src/ \
    file://datastruct-cpp/projects/datastruct_asm_inline/CMakeLists.txt \
    file://datastruct-cpp/projects/datastruct_asm_inline/src/ \
    file://datastruct-cpp/projects/datastruct_async_signal/CMakeLists.txt \
    file://datastruct-cpp/projects/datastruct_async_signal/src/ \
    file://datastruct-cpp/projects/datastruct_async_timer/CMakeLists.txt \
    file://datastruct-cpp/projects/datastruct_async_timer/src/ \
    file://datastruct-cpp/projects/datastruct_big_integer/CMakeLists.txt \
    file://datastruct-cpp/projects/datastruct_big_integer/src/ \
    file://datastruct-cpp/projects/datastruct_class/CMakeLists.txt \
    file://datastruct-cpp/projects/datastruct_class/src/ \
    file://datastruct-cpp/projects/datastruct_class_template/CMakeLists.txt \
    file://datastruct-cpp/projects/datastruct_class_template/src/ \
    file://datastruct-cpp/projects/datastruct_file_operations/CMakeLists.txt \
    file://datastruct-cpp/projects/datastruct_file_operations/src/ \
    file://datastruct-cpp/projects/datastruct_float_multiprecision/CMakeLists.txt \
    file://datastruct-cpp/projects/datastruct_float_multiprecision/src/ \
    file://datastruct-cpp/projects/datastruct_linkedlist/CMakeLists.txt \
    file://datastruct-cpp/projects/datastruct_linkedlist/src/ \
    file://datastruct-cpp/projects/datastruct_thread_timer/CMakeLists.txt \
    file://datastruct-cpp/projects/datastruct_thread_timer/src/ \
    file://datastruct-cpp/projects/datastruct_thread_timer_class/CMakeLists.txt \
    file://datastruct-cpp/projects/datastruct_thread_timer_class/src/ \
    file://datastruct-cpp/projects/datastruct_vector/CMakeLists.txt \
    file://datastruct-cpp/projects/datastruct_vector/src/ \
    file://datastruct-cpp/projects/helloworld/CMakeLists.txt \
    file://datastruct-cpp/projects/helloworld/src/ \
    "

S = "${WORKDIR}/datastruct-cpp"

inherit cmake

EXTRA_OECMAKE = ""
