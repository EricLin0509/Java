package com.example.colour.services.ChineseColourPrinter;

import com.example.colour.services.RedPrinter;
import org.springframework.stereotype.Component;

@Component

public class RedCN implements RedPrinter {
    @Override
    public String print() {
        return "红色";
    }
}
