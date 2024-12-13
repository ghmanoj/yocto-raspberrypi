SUMMARY = "Custom NetworkManager configuration"
DESCRIPTION = "Installs a predefined NetworkManager Wi-Fi connection configuration."
LICENSE = "CLOSED"

SRC_URI = "file://localwifi.nmconnection"

do_install() {
    install -d ${D}${sysconfdir}/NetworkManager/system-connections
    WIFI_CFG=${D}${sysconfdir}/NetworkManager/system-connections/localwifi.nmconnection

    install -m 0600 ${WORKDIR}/localwifi.nmconnection ${WIFI_CFG}

    if [ -n "${SPEEDY_WIFI_SSID}" ]; then
        sed -i 's/SPEEDY_WIFI_SSID/${SPEEDY_WIFI_SSID}/' ${WIFI_CFG}
    fi

    if [ -n "${SPEEDY_WIFI_PASS}" ]; then
        sed -i 's/SPEEDY_WIFI_PASS/${SPEEDY_WIFI_PASS}/' ${WIFI_CFG}
    fi
}


FILES:${PN}:append = "${sysconfdir}/NetworkManager/system-connections/"
