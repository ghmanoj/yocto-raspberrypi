FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

COMPATIBLE_MACHINE =. "speedy-box|"

SRC_URI += " \
    file://defconfig \
"