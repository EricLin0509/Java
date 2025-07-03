package com.example.colour.services.EnglishColourPrinter;

import com.example.colour.services.BluePrinter;
import org.springframework.stereotype.Component;

@Component

public class Blue implements BluePrinter {

    @Override
    public String print() {
        return "blue";
    }
}
