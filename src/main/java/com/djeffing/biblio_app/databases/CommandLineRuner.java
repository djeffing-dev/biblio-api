package com.djeffing.biblio_app.databases;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRuner implements CommandLineRunner {
    final private BookCommand bookCommand;
    final private  CustomerCommand customerCommand;
    final  private  LoanCommand loanCommand;

    public CommandLineRuner(BookCommand bookCommand, CustomerCommand customerCommand, LoanCommand loanCommand) {
        this.bookCommand = bookCommand;
        this.customerCommand = customerCommand;
        this.loanCommand = loanCommand;
    }




    @Override
    public void run(String... args) throws Exception {
        loanCommand.save();
        bookCommand.save();
        customerCommand.save();
    }
}
