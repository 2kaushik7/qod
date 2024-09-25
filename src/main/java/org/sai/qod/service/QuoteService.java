package org.sai.qod.service;

import org.sai.qod.model.Quote;
import org.sai.qod.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    // Method to get all quotes
    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }

    // Method to get a quote by ID
    public Optional<Quote> getQuoteById(Long id) {
        return quoteRepository.findById(id);
    }

    // Method to create or update a quote
    public Quote saveQuote(Quote quote) {
        return quoteRepository.save(quote);
    }

    // Method to delete a quote by ID
    public void deleteQuote(Long id) {
        Quote quoteExisting = quoteRepository.findById(id).orElseThrow(() -> new NullPointerException("Quote not found with id: " + id));
        quoteRepository.deleteById(id);
    }

    public Quote updateQuote(long l, Quote quote) {
        Quote quoteExisting = quoteRepository.findById(l).orElseThrow(() -> new NullPointerException("Quote not found with id: " + l));
        quoteExisting.setQuote(quote.getQuote());
        quoteExisting.setEmail(quote.getEmail());
        return quoteRepository.save(quoteExisting);
    }
}
