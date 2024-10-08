package org.sai.qod.controller;

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
    @PutMapping
    public Quote updateQuote(@RequestBody Quote quote){
        return quoteService.updateQuote(quote.getId(),quote);
    }
    @DeleteMapping
    public void deleteQuote(@RequestBody Quote quote){
        quoteService.deleteQuote(quote.getId());
    }
}
