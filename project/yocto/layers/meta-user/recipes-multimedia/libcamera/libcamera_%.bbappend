# Meson by default will use "debug" build type which disables optimization. However, libcamera
# source uses "_FORTIFY_SOURCE=2" by default and will not work because it requires at least "-O1".
# By using "release" build type, meson will use "-O3" optimization.
MESON_BUILDTYPE = "release"
