package com.djeffing.biblio_app.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDto {
    private Long id;
    private String name;
    private  String email;

    private  String phoneNumber;
}
