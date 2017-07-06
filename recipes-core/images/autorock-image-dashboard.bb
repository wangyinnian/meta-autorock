SUMMARY = "dashboard image"
DESCRIPTION = "Autorock dashboard image"
SECTION = "autorock"

inherit image

NO_RECOMMENDATIONS = "1"

IMAGE_INSTALL = ""

IMAGE_FEATURES += "read-only-rootfs"

pre_process_image() {
	install -d ${IMAGE_ROOTFS}/dev
	install -d ${IMAGE_ROOTFS}/tmp
	rm -rf ${IMAGE_ROOTFS}/etc
	rm -rf ${IMAGE_ROOTFS}/usr/lib/locale
	rm -rf ${IMAGE_ROOTFS}/usr/share
	rm -rf ${IMAGE_ROOTFS}/var
	rm -rf ${IMAGE_ROOTFS}/sbin
	rm -rf ${IMAGE_ROOTFS}/lib/modules
	rm -rf ${IMAGE_ROOTFS}/lib/libanl*
	rm -rf ${IMAGE_ROOTFS}/lib/libBrokenLocale*
	rm -rf ${IMAGE_ROOTFS}/lib/libcrypt*
	rm -rf ${IMAGE_ROOTFS}/lib/libnsl*
	rm -rf ${IMAGE_ROOTFS}/lib/libnss*
	rm -rf ${IMAGE_ROOTFS}/lib/libresolv*
	rm -rf ${IMAGE_ROOTFS}/lib/libutil*
}

IMAGE_PREPROCESS_COMMAND += "pre_process_image;"
