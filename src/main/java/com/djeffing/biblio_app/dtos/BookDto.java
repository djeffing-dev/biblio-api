package com.djeffing.biblio_app.dtos;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDto {
    private Long id;
    private String title;
    private Integer nbrDiponible;
    private Integer nbrTotal;



}
