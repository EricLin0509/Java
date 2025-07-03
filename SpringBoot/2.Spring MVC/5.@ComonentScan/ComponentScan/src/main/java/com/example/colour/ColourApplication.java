package com.example.colour;

import com.example.colour.services.ColourPrinter;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@Log
@ComponentScan("com.example.colour.services.ChineseColourPrinter")
public class ColourApplication implements CommandLineRunner {
    private ColourPrinter colourPrinter;

    public ColourApplication(final ColourPrinter colourPrinter) { // 构造函数注入
        this.colourPrinter = colourPrinter;
    }

    public static void main(String[] args) {
        SpringApplication.run(ColourApplication.class, args);
    }

    @Override
    public void run(final String... args) {
        log.info(colourPrinter.print());
    }
}
