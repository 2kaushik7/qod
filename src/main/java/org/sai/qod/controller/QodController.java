package org.sai.qod.controller;

import jakarta.websocket.server.PathParam;
import org.sai.qod.model.Quote;
import org.sai.qod.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quotes")
public class QodController {

    @Autowired
    private QuoteService quoteService;

    @GetMapping ("/all")
    public List<Quote> getAllQuotes() {
        return quoteService.getAllQuotes();
    }
    @GetMapping ("/{id}")
    public Optional<Quote> getQuote(@PathVariable Long id){
        return quoteService.getQuoteById(id);
    }
    @PostMapping
    public Quote insertQuote(@RequestBody Quote quote){
        return quoteService.saveQuote(quote);
    }
    @PutMapping("/quote")
    public void updateQuote(){
        System.out.println("OM Sainathaya Namaha update");
    }
    @DeleteMapping ("/quote")
    public void deleteQuote(){
        System.out.println("OM Sainathaya Namaha delete");
    }
}
