package com.example.colour.config;

import com.example.colour.services.BluePrinter;
import com.example.colour.services.ColourPrinter;
import com.example.colour.services.GreenPrinter;
import com.example.colour.services.RedPrinter;
import com.example.colour.services.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public BluePrinter bluePrinter() {
        return new BlueCN();
    }
    @Bean
    public GreenPrinter greenPrinter() {
        return new Green();
    }
    @Bean
    public RedPrinter redPrinter() {
        return new Red();
    }
    @Bean
    public ColourPrinter colourPrinter(RedPrinter redPrinter, BluePrinter bluePrinter, GreenPrinter greenPrinter) {
        return new ColourPrinterImpl(redPrinter, bluePrinter, greenPrinter);
    }
}
