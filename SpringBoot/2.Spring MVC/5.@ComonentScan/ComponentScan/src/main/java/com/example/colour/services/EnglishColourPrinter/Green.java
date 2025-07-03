package com.example.colour.services.EnglishColourPrinter;

import com.example.colour.services.GreenPrinter;
import org.springframework.stereotype.Component;

@Component

public class Green implements GreenPrinter {
    @Override
    public String print() {
        return "green";
    }
}
