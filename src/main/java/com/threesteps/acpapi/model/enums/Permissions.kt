package com.threesteps.acpapi.model.enums

enum class Permissions(
    var id: String? = "",
    var title: String? = ""
) {
    ABOUT_US("about-us", "Haqqımda"),
    SURGERY("surgery", "Cərrahiyə"),
    USEFUL_INFO("useful-info", "Faydalı məlumatlar"),
    REVIEW("review", "Rəylər"),
    GALLERY("partner", "Qalereya"),
    USERS("users", "İstifadəçilər"),
    SETTINGS("settings", "Ayarlar")
}