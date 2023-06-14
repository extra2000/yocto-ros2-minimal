# CMake will git clone https://github.com/uncrustify/uncrustify.git during compile step.
# Thus, network access during compile step is required.
do_compile[network] = "1"
