package com.djeffing.biblio_app.controllers;

import com.djeffing.biblio_app.dtos.LoanDto;
import com.djeffing.biblio_app.services.interfaces.LoanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/loans")
public class LoanController {
    final private LoanService laonService;

    public LoanController(LoanService laonService) {
        this.laonService = laonService;
    }

    @PostMapping
    public LoanDto create(@RequestBody LoanDto loanDto){
        return laonService.create(loanDto);
    }

    @GetMapping
    public List<LoanDto> findAll(){
        return laonService.findAll();
    }

    @PutMapping("/update")
    public  LoanDto update(@RequestParam long id, @RequestBody LoanDto loanDto){
        return laonService.update(id, loanDto);
    }

    @GetMapping("/findById")
    public Optional<LoanDto> findById(@RequestParam  long id){
        return laonService.findById(id);
    }

    @DeleteMapping
    public String deleteById(long id){
        return laonService.deleteById(id);
    }
}
