package com.djeffing.biblio_app.services.interfaces;

import com.djeffing.biblio_app.dtos.LoanDto;

import java.util.List;
import java.util.Optional;

public interface LoanService {
    LoanDto create(LoanDto loanDto);
    List<LoanDto> findAll();
    Optional<LoanDto> findById(long laonId);
    LoanDto update(long laonId, LoanDto loanDto);

    String deleteById(long laonId);

    String deleteAll();
}
