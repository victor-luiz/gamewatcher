package br.com.victor.gamewatcher.service

import br.com.victor.gamewatcher.dto.CreateTeamDto
import br.com.victor.gamewatcher.dto.TeamResponseDto
import br.com.victor.gamewatcher.entity.Team

interface TeamService {
    fun create(dto: CreateTeamDto): TeamResponseDto
    fun getAll(): List<TeamResponseDto>
    fun getById(id: Long): TeamResponseDto
    fun update(id: Long, dto: CreateTeamDto): TeamResponseDto
    fun delete(id: Long)
    fun getEntityById(id: Long): Team
}