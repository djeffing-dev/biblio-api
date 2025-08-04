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
        Optional<LoanDto> loanDtoOptional = findById(laonId);
        if(loanDtoOptional.isPresent()){
            LoanDto newLoanDto = loanDtoOptional.get();

            if(loanDto.getDateEmprunt()!=null){
                newLoanDto.setDateEmprunt(loanDto.getDateEmprunt());
            }

            if(loanDto.getDateRetour()!=null){
                newLoanDto.setDateRetour(loanDto.getDateRetour());
            }

            if(loanDto.getDateRetourEstimer()!= null){
                newLoanDto.setDateRetourEstimer(loanDto.getDateRetourEstimer());
            }

            return save(newLoanDto);
        }

        return null;
    }

    @Override
    public String deleteById(long laonId) {
        loanRepository.deleteById(laonId);
        return "L'emprunt qui a été selectionner a été supprimer avec success";
    }

    @Override
    public String deleteAll() {
        //loanRepository.deleteAll();
        loanRepository.truncateTableAndResetId(); // Cette fonction effetue déjà automatiquement la suppresion
        return "La liste des emprunts a été supprimer avec success";
    }
}
