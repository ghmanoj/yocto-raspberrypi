
LICENSE = "CLOSED"

do_compile() {
    echo -n "${MACHINE} ${HW_REV}" > ${WORKDIR}/speedy-swupdate-hwcompat
}


do_install() {
    install -d ${D}${sysconfdir}
    install -m 0444 ${WORKDIR}/speedy-swupdate-hwcompat ${D}${sysconfdir}/speedy-swupdate-hwcompat
}


FILES:${PN}:append = " ${sysconfdir}/speedy-swupdate-hwcompat"

inherit allarch