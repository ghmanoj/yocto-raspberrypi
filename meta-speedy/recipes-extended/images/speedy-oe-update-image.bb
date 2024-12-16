DESCRIPTION = "Speedy Box SWUpdate Image"
SECTION = ""
LICENSE = "CLOSED"

DEPENDS:append = " \
    swupdate \
    speedy-oe-image \
"

SRC_URI = "\
    file://sw-description \
"

# images to build before building swupdate image
IMAGE_DEPENDS = "speedy-oe-image"

# images and files that will be included in the .swu image
SWUPDATE_IMAGES = "speedy-oe-image"

SWUPDATE_IMAGES_FSTYPES[speedy-oe-image] = ".ext4.gz"

inherit swupdate