package com.example.colour.services.EnglishColourPrinter;

import com.example.colour.services.RedPrinter;
import org.springframework.stereotype.Component;

@Component

public class Red implements RedPrinter {
    @Override
    public String print() {
        return "red";
    }
}
