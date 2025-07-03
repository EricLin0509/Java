package com.example.colour.services.impl;

import com.example.colour.services.BluePrinter;
import org.springframework.stereotype.Component;

public class Blue implements BluePrinter {

    @Override
    public String print() {
        return "blue";
    }
}
