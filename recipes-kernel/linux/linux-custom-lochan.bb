FILESEXTRAPATHS:prepend := "${THISDIR}/linux-lochan:"
KBRANCH ?= "linux-6.15.y"
require recipes-kernel/linux/linux-yocto.inc

SRCREV_meta ?= "8368cc1f9d0a6f8681602a918746df3b3932bad6"
SRCREV_machine = "353d1690f1419fd93e4bcc5104f9f6c3b8dd60eb"
INC_PR := "r1"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;protocol=https;name=machine;branch=${KBRANCH}; \
	git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-6.5;destsuffix=yocto-kmeta"

SRC_URI += "${@bb.utils.contains('DISTRO_FEATURES', 'xen', 'file://xen.cfg', '', d)}"



LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

LINUX_VERSION ?= "6.15.8"
KMETA = "kernel-meta"
KCONF_BSP_AUDIT_LEVEL = "1"

PV = "6.15.8"
KERNEL_VERSION_SANITY_SKIP = "1"

PR := "${INC_PR}.0"

KMACHINE = "common-pc-64"
COMPATIBLE_MACHINE = "${MACHINE}"


