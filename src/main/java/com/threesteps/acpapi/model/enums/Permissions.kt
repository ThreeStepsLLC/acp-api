package com.threesteps.acpapi.model.enums

enum class Permissions(
    var id: String? = "",
    var title: String? = ""
) {
    OUR_EXPERIENCES("our-experiences", "Təcrübələrimiz"),
    WHO_ARE_WE("who-are-we", "Haqqımızda"),
    OUR_VALUES("our-values", "Dəyərlərimiz"),
    OUR_MISSIONS("our-missions", "Missiyalarımız"),
    OUR_VISION("our-vision", "Viziyonlarımız"),
    SLOGAN("slogan", "Sloqan"),
    CORE_VALUES("core-values", "Əsas dəyərlərimiz"),
    FOOTER_VALUE("footer-value", "Footer dəyəri"),
    PROJECTS("projects", "Layihələr"),
    PARTNERS("partners", "Partnyorlar"),
    POSITIONS("positions", "Vəzifələr"),
    SLIDER_IMAGES("slider-images", "Slider şəkilləri"),
    LICENSES("licenses", "Lisenziyalar"),
    VACANCIES("vacancies", "Vakansiyalar"),
    USERS("users", "İstifadəçilər"),
    SETTINGS("settings", "Ayarlar")
}