SUMMARY = "BMW dashboard application"
SECTION = "autorock"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://git@git.autorock.com/dashboards/bmw.git;branch=${SRCBRANCH};protocol=ssh \
           file://init \
"

#PROVIDES = "virtual/dashboard"

SRCBRANCH = "master"
SRCREV = "${AUTOREV}"
LOCALVERSION = "-${SRCBRANCH}+git${SRCREV}"

PV = "0+git${SRCPV}"

S = "${WORKDIR}/git"

require recipes-qt/qt5/qt5.inc

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${B}/bin/bmw ${D}${bindir}

	install -d ${D}${datadir}/${PN}
	install -m 0644 ${WORKDIR}/init ${D}${datadir}/${PN}
	cp -a ${S}/3ds ${D}${datadir}/${PN}

	install -d ${D}${libdir}
	cp -a ${S}/fonts ${D}${libdir}
}

FILES_${PN}-dbg += "${datadir}/${PN}/.debug"
FILES_${PN} += "${bindir} ${datadir} ${libdir}"

DEPENDS = "qtdeclarative qtgraphicaleffects"

RDEPENDS_${PN} = "qtbase-plugins qtdeclarative-qmlplugins qtgraphicaleffects-qmlplugins"

