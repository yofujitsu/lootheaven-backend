package com.example.lootheaven.dao.models.DTO;

public record AuthDTO(Long id, String email, String username, String role, String avatarImg, Boolean active) {
}
