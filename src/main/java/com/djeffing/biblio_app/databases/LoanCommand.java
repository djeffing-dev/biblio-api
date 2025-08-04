package com.djeffing.biblio_app.databases;

import com.djeffing.biblio_app.services.interfaces.LoanService;
import org.springframework.stereotype.Component;

@Component
public class LoanCommand {
    final  private LoanService loanService;

    public LoanCommand(LoanService loanService){
        this.loanService = loanService;
    }

    public  void save(){
        loanService.deleteAll();
    }
}
