package com.example.colour.services.impl;

import com.example.colour.services.GreenPrinter;
import org.springframework.stereotype.Component;

public class Green implements GreenPrinter {
    @Override
    public String print() {
        return "green";
    }
}
