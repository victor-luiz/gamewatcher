package br.com.victor.gamewatcher.enums

enum class EnumBroadcastChannel(
    val id: String,
    val displayName: String,
    val url: String
) {
    PREMIERE(
        "PREMIERE",
        "Premiere",
        "https://premiere.globo.com"
    ),

    ESPN(
        "ESPN",
        "ESPN no Star+",
        "https://www.starplus.com/sports"
    ),

    GLOBO(
        "GLOBO",
        "TV Globo (Globoplay)",
        "https://globoplay.globo.com/agora-na-tv/"
    ),

    TNT(
        "TNT",
        "TNT Sports (Max)",
        "https://www.max.com/"
    );

    companion object {
        fun fromId(id: String): EnumBroadcastChannel? {
            return entries.find { it.id == id }
        }
    }
}