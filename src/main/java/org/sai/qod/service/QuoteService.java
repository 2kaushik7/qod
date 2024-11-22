package org.sai.qod.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

@Service
public class QuoteService {

    @Value("${quotes.filePath}")
    String quotesFilePath;


    public String readQuotesAndReturnQuote() throws IOException {
        List<String> quotes = Files.readAllLines(Paths.get(quotesFilePath));
        Random random = new Random();
        int index = random.nextInt(quotes.size());
        return quotes.get(index);
    }
}
