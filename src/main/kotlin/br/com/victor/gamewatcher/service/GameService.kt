package br.com.victor.gamewatcher.service

import br.com.victor.gamewatcher.dto.CreateGameDto
import br.com.victor.gamewatcher.dto.GameResponseDto

interface GameService {
    fun create(dto: CreateGameDto): GameResponseDto
    fun getAll(): List<GameResponseDto>
    fun getById(id: Long): GameResponseDto
    fun update(id: Long, dto: CreateGameDto): GameResponseDto
    fun delete(id: Long)
}