package br.com.victor.gamewatcher.service

import br.com.victor.gamewatcher.dto.CreateTeamDto
import br.com.victor.gamewatcher.dto.TeamResponseDto

interface TeamService {
    fun create(dto: CreateTeamDto): TeamResponseDto
    fun getAll(): List<TeamResponseDto>
    fun getById(id: Long): TeamResponseDto
    fun update(id: Long, dto: CreateTeamDto): TeamResponseDto
    fun delete(id: Long)
}