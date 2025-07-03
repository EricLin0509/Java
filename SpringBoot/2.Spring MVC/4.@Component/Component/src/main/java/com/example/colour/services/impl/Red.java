package com.example.colour.services.impl;

import com.example.colour.services.RedPrinter;
import org.springframework.stereotype.Component;

public class Red implements RedPrinter {
    @Override
    public String print() {
        return "red";
    }
}
