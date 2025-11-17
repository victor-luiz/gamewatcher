package br.com.victor.gamewatcher.entity

import jakarta.persistence.*
import org.springframework.data.jpa.domain.AbstractPersistable_.id

@Entity
@Table(name = "teams")
class Team(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "name", nullable = false, unique = true)
    var name: String,

    @Column(name = "acronym", nullable = false, length = 3)
    var acronym: String,

    @OneToMany(mappedBy = "homeTeam", fetch = FetchType.LAZY)
    private val _homeGames: MutableList<Game> = mutableListOf(),

    @OneToMany(mappedBy = "awayTeam", fetch = FetchType.LAZY)
    private val _awayGames: MutableList<Game> = mutableListOf()
) {
    val games: List<Game>
        get() = _homeGames + _awayGames

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Team) return false
        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()
}