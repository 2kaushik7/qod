package org.sai.qod.controller;

import org.sai.qod.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/quotes")
@CrossOrigin(origins = "https://quoteoftheday.ryu3dsst.co.uk")
public class QodController {

    @Autowired
    private QuoteService quoteService;

    @GetMapping("/refreshQuote")
    public ResponseEntity<String> getQuoteAtMidnight() throws IOException {
        String quote =  quoteService.readQuotesAndReturnQuote();
        return ResponseEntity.ok(quote);
    }
}
