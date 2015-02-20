require recipes-core/images/core-image-minimal.bb

IMAGE_FEATURES += "ssh-server-openssh package-management"

NO_RECOMMENDATIONS = "1"

IMAGE_INSTALL += "qtbase-plugins qtdeclarative-qmlplugins qtgraphicaleffects-qmlplugins qtbase-fonts qtserialport"
IMAGE_INSTALL += "packagegroup-qt5-qtcreator-debug"
IMAGE_INSTALL += "dosfstools e2fsprogs-mke2fs"
IMAGE_INSTALL += "memtester"

OPKG_BUILD_MACHINE ?= "${MACHINE}"
OPKG_DOWNLOAD_SERVER ?= "yocto.autorock.com"
OPKG_BUILD_FEATURE ?= "dev"

PACKAGE_FEED_URIS += "http://${OPKG_DOWNLOAD_SERVER}/${DISTRO}/${DISTRO_VERSION}/${OPKG_BUILD_MACHINE}/${OPKG_BUILD_FEATURE}"
