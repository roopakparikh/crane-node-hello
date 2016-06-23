TARGETS = hostname.sh mountkernfs.sh udev urandom mountall.sh mountall-bootclean.sh hwclock.sh mountdevsubfs.sh checkroot.sh mountnfs.sh mountnfs-bootclean.sh procps checkroot-bootclean.sh bootmisc.sh checkfs.sh udev-finish x11-common
INTERACTIVE = udev checkroot.sh checkfs.sh
udev: mountkernfs.sh
urandom: mountall.sh mountall-bootclean.sh hwclock.sh
mountall.sh: checkfs.sh checkroot-bootclean.sh
mountall-bootclean.sh: mountall.sh
hwclock.sh: mountdevsubfs.sh
mountdevsubfs.sh: mountkernfs.sh udev
checkroot.sh: hwclock.sh mountdevsubfs.sh hostname.sh
mountnfs.sh: mountall.sh mountall-bootclean.sh
mountnfs-bootclean.sh: mountall.sh mountall-bootclean.sh mountnfs.sh
procps: mountkernfs.sh mountall.sh mountall-bootclean.sh udev
checkroot-bootclean.sh: checkroot.sh
bootmisc.sh: checkroot-bootclean.sh mountall.sh mountall-bootclean.sh mountnfs.sh mountnfs-bootclean.sh udev
checkfs.sh: checkroot.sh
udev-finish: udev mountall.sh mountall-bootclean.sh
x11-common: mountall.sh mountall-bootclean.sh mountnfs.sh mountnfs-bootclean.sh
