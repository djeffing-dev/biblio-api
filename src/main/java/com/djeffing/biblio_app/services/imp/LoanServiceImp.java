package com.djeffing.biblio_app.services.imp;

import com.djeffing.biblio_app.Models.Loan;
import com.djeffing.biblio_app.dtos.LoanDto;
import com.djeffing.biblio_app.mappers.LoanMapper;
import com.djeffing.biblio_app.repositories.LoanRepository;
import com.djeffing.biblio_app.services.interfaces.LoanService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class LoanServiceImp implements LoanService {
    final private LoanRepository loanRepository;
    final  private LoanMapper loanMapper;

    public LoanServiceImp(LoanRepository loanRepository, LoanMapper loanMapper) {
        this.loanRepository = loanRepository;
        this.loanMapper = loanMapper;
    }

    private LoanDto save(LoanDto loanDto){
        Loan loan =  loanMapper.toLoan(loanDto);
        Loan loanSaved = loanRepository.save(loan);
        return loanMapper.toLoanDto(loanSaved);
    }

    @Override
    public LoanDto create(LoanDto loanDto) {
        loanDto.setDateEmprunt(Date.valueOf(LocalDate.now()));
        return save(loanDto);
    }

    @Override
    public List<LoanDto> findAll() {
        return loanRepository.findAll().stream()
                .map(loanMapper::toLoanDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<LoanDto> findById(long laonId) {
        Optional<Loan> loanOptional = loanRepository.findById(laonId);
        return loanOptional.map(loan -> LoanDto.builder()
                .id(loan.getId())
                .dateEmprunt(loan.getDateEmprunt())
                .dateRetourEstimer(loan.getDateRetourEstimer())
                .dateRetour(loan.getDateRetour())
                .book(loan.getBook())
                .customer(loan.getCustomer())
                .build());
    }

    @Override
    public LoanDto update(long laonId, LoanDto loanDto) {
        return null;
    }

    @Override
    public String deleteById(long laonId) {
        return null;
    }

    @Override
    public String deleteAll() {
        return null;
    }
}
