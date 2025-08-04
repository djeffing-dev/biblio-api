package com.djeffing.biblio_app.mappers;

import com.djeffing.biblio_app.Models.Loan;
import com.djeffing.biblio_app.dtos.LoanDto;
import org.mapstruct.Mapper;

import java.time.LocalDate;

@Mapper(componentModel = "spring")
public interface LoanMapper {
    LoanDto toLoanDto(Loan loan);
    Loan toLoan(LoanDto loanDto);

}
