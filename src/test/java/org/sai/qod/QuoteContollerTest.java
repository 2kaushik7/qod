package org.sai.qod;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sai.qod.controller.QodController;
import org.sai.qod.model.Quote;
import org.sai.qod.service.QuoteService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class QuoteContollerTest {

    @Mock
    private QuoteService quoteService;

    @InjectMocks
    private QodController qodController;

    @Test
    public void testGetAllQuotes(){
        List<Quote> mockQuotes = Arrays.asList(new Quote(1L,"Test quote1","saibaba1@gmail.com"), new Quote(2L,"Test quote2","saibaba2@gmail.com"));
        Mockito.when(quoteService.getAllQuotes()).thenReturn(mockQuotes);
        //Act
        List<Quote> result = qodController.getAllQuotes();
        assertEquals(mockQuotes.size(),2);
        assertEquals(mockQuotes.get(0).getId(),result.get(0).getId());
        assertEquals(mockQuotes.get(1).getId(),result.get(1).getId());
        assertEquals(mockQuotes.get(0).getQuote(),result.get(0).getQuote());
        assertEquals(mockQuotes.get(1).getQuote(),result.get(1).getQuote());
    }

}
