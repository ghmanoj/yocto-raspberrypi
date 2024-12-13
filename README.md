Yocto build for Raspberry Pi 3 B+. 
It supports the swupdate facility also. And can connect to wifi in a headless system.

Set below Wifi configs in local.conf to get wifi on first boot:
    SPEEDY_WIFI_SSID
    SPEEDY_WIFI_PASS



Project depends on 'scarthgap' branch of the following repo:
https://github.com/yoctoproject/poky.git
https://github.com/openembedded/meta-openembedded.git
https://github.com/agherzan/meta-raspberrypi.git
https://github.com/sbabic/meta-swupdate.git