package com.example.colour.services.ChineseColourPrinter;

import com.example.colour.services.BluePrinter;
import org.springframework.stereotype.Component;

@Component

public class BlueCN implements BluePrinter {
    @Override
    public String print() {
        return "蓝色";
    }
}
