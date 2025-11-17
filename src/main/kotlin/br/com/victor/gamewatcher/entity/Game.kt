package br.com.victor.gamewatcher.entity

import br.com.victor.gamewatcher.enums.EnumBroadcastChannel
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "games")
class Game(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "game_time", nullable = false)
    var gameTime: LocalDateTime,

    @Column(name = "broadcast_channel", nullable = false)
    @Enumerated(EnumType.STRING)
    var broadcastChannel: EnumBroadcastChannel,

    @Column(name = "championship", nullable = false)
    var championship: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_team_id", nullable = false)
    var homeTeam: Team,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "away_team_id", nullable = false)
    var awayTeam: Team
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Game) return false
        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()
}