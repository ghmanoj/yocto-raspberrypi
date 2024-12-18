SUMMARY = "Yocto OE Image for Speedy Box"
DESCRIPTION = "Custom OE Linux Image for Speedy Box (based on Raspberry Pi3)"

LICENSE = "CLOSED"


inherit core-image extrausers

IMAGE_FSTYPES = "wic wic.gz ext4.gz"

IMAGE_FEATURES:append = "\
    allow-root-login \
    debug-tweaks \
    tools-debug \
    package-management \
"

IMAGE_INSTALL:append = "\
    networkmanager \
    networkmanager-nmcli \
    networkmanager-config \
    swupdate \
    speedy-swupdate-hwcompat \
    parted \
    json-c \
    ntp \
    ntp-utils \
    rpi-gpio \
    i2c-tools \
    util-linux \
    libxml2 \
    strace \
    openssh \
    zeromq \
    htop \
    tmux \
    curl \
    bash \
"

SKIP_RECIPE[rust-native]      = "Removed"
SKIP_RECIPE[libstd-rs-dev]    = "Removed"
SKIP_RECIPE[libstd-rs]        = "Removed"
SKIP_RECIPE[uutils-coreutils] = "Removed"



# User: root
# Pass: Apex1234
PASSWD = "\$5\$NfxEOCi67egy8GEB\$3UBtpedMHBUWkHPH.3AEgvbgO9JiNS5ZJSA6L15DPm1"
EXTRA_USERS_PARAMS = "\
    usermod -p '${PASSWD}' root; \
"