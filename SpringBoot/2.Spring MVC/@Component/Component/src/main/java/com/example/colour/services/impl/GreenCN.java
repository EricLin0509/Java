package com.example.colour.services.impl;

import com.example.colour.services.GreenPrinter;
import org.springframework.stereotype.Component;

@Component

public class GreenCN implements GreenPrinter {
    @Override
    public String print() {
        return "绿色";
    }
}
