package com.djeffing.biblio_app.databases;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRuner implements CommandLineRunner {
    final private BookCommand bookCommand;
    final private  CustomerCommand customerCommand;

    public CommandLineRuner(BookCommand bookCommand, CustomerCommand customerCommand) {
        this.bookCommand = bookCommand;
        this.customerCommand = customerCommand;
    }



    @Override
    public void run(String... args) throws Exception {
        //bookCommand.save();
        //customerCommand.save();
    }
}
