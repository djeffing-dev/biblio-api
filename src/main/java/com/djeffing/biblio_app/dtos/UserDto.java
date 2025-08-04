package com.djeffing.biblio_app.dtos;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private Long id;
    private String nom;
    private String email;
    private String phoneNumber;
}
