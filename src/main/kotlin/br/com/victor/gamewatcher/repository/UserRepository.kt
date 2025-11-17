package br.com.victor.gamewatcher.repository

import br.com.victor.gamewatcher.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
}