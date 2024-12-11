COMPATIBLE_MACHINE = "^speedy-box$"

SUMMARY = "Yocto OE Image for Speedy Box"
DESCRIPTION = "Custom OE Linux Image for Speedy Box (based on Raspberry Pi3)"
RECIPE_MAINTAINER = "Manoj"

LICENSE = "MIT"

IMAGE_FSTYPES = "wic wic.bmap ext4.gz"
IMAGE_OVERHEAD_FACTOR = "1.1"


IMAGE_FEATURES:append = "\
    allow-root-login \
    allow-empty-password \
    empty-root-password \
    post-install-logging \
    ssh-server-openssh \
"

IMAGE_INSTALL:append = "\
    bcm2835-tests \
    libubootenv \
    swupdate \
    swupdate-www \
    os-release \
    raspi-gpio \
    ntp \
    ntp-utils \
    rpio \
    rpi-gpio \
    pi-blaster \
    i2c-tools \
    setserial \
    util-linux \
    libxml2 \
    strace \
    tzdata \
    openssh \
    openssh-sshd \
    zeromq \
    cppzmq-dev \
    htop \
    tmux \
    curl \
    bash \
    rt-tests \
    stress-ng \
    devmem2 \
    ifupdown \
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