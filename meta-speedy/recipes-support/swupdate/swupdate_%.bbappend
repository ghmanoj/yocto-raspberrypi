FILESEXTRAPATHS:append := "${THISDIR}/${PN}:"

PACKAGECONFIG_CONFARGS = ""


SRC_URI += " \
    file://09-swupdate-args \
    file://swupdate.cfg \
"

DEPENDS:append = " openssl"

# additional dependencies required to run swupdate on the target
RDEPENDS:${PN} += "u-boot-fw-utils"

do_install:append() {
    install -m 0644 ${WORKDIR}/09-swupdate-args ${D}${libdir}/swupdate/conf.d/
    sed -i "s#@MACHINE@#${MACHINE}#g" ${D}${libdir}/swupdate/conf.d/09-swupdate-args

    install -d ${D}${sysconfdir}
    install -m 644 ${WORKDIR}/swupdate.cfg ${D}${sysconfdir}
}