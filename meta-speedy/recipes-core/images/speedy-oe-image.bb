COMPATIBLE_MACHINE = "^speedy-box$"

SUMMARY = "Yocto OE Image for Speedy Box"
DESCRIPTION = "Custom OE Linux Image for Speedy Box (based on Raspberry Pi3)"
RECIPE_MAINTAINER = "Manoj"

LICENSE = "MIT"

WKS_FILE = "speedy-sdcard.wks"

IMAGE_FSTYPES = "wic wic.bmap ext4.gz"

IMAGE_FEATURES:append = "\
    allow-root-login \
    allow-empty-password \
    empty-root-password \
    post-install-logging \
    ssh-server-openssh \
"

IMAGE_INSTALL:append = "\
    networkmanager \
    networkmanager-nmcli \
    networkmanager-config \
    lua \
    swupdate \
    swupdate-www \
    swupdate-progress \
    swupdate-client \
    swupdate-tools-ipc \
    u-boot-fw-utils \
    json-c \
    ntp \
    ntp-utils \
    rpi-gpio \
    i2c-tools \
    util-linux \
    libxml2 \
    strace \
    openssh \
    openssh-sshd \
    zeromq \
    htop \
    tmux \
    curl \
    bash \
    rt-tests \
    stress-ng \
    jsoncpp \
    brotli \
"

SKIP_RECIPE[rust-native]      = "Removed"
SKIP_RECIPE[libstd-rs-dev]    = "Removed"
SKIP_RECIPE[libstd-rs]        = "Removed"
SKIP_RECIPE[uutils-coreutils] = "Removed"


inherit core-image extrausers

# User: root
# Pass: Apex1234
PASSWD = "\$5\$NfxEOCi67egy8GEB\$3UBtpedMHBUWkHPH.3AEgvbgO9JiNS5ZJSA6L15DPm1"
EXTRA_USERS_PARAMS = "\
    usermod -p '${PASSWD}' root; \
"