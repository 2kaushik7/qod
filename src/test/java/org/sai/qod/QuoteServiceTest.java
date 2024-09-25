package org.sai.qod;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sai.qod.model.Quote;
import org.sai.qod.repository.QuoteRepository;
import org.sai.qod.service.QuoteService;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class QuoteServiceTest {
    @Mock
    private QuoteRepository quoteRepository;

    @InjectMocks
    private QuoteService quoteService;

    @Test
    void testGetQuoteById() {
        Quote quote = null;
        Quote mockQuote = new Quote(1L, "John", "Doe");
        Mockito.when(quoteRepository.findById(1L)).thenReturn(Optional.of(mockQuote));

        Optional<Quote> quoteOptional = quoteService.getQuoteById(1L);
        if (quoteOptional.isPresent()) {quote = quoteOptional.get();}
        assertNotNull(quote);
        assertEquals("John", quote.getQuote());
        assertEquals("Doe", quote.getEmail());
    }

    @Test
    void testGetQuoteById_QuoteNotFound() {
        Mockito.when(quoteRepository.findById(1L)).thenThrow(NullPointerException.class);
        assertThrows(NullPointerException.class,() -> quoteService.getQuoteById(1L));
    }

    @Test
    void testGetAllQuotes(){
        List<Quote> mockQuotes = Arrays.asList(new Quote(1L, "John", "Doe"), new Quote(2L, "Jane", "Doe"));
        Mockito.when(quoteRepository.findAll()).thenReturn(mockQuotes);
        List<Quote> quotes = quoteService.getAllQuotes();
        assertEquals(mockQuotes.size(), quotes.size());
    }

    @Test
    void testSaveQuote(){
        Quote quote = new Quote(1L, "John", "Doe");
        Mockito.when(quoteRepository.save(quote)).thenReturn(quote);
        Quote savedQuote = quoteService.saveQuote(quote);
        assertNotNull(savedQuote);
        assertEquals("John", savedQuote.getQuote());
    }

    @Test
    void testUpdateQuote(){
        Long id = 1L;
        Quote quote = new Quote(1L, "John", "Doe");
        Mockito.when(quoteRepository.findById(id)).thenReturn(Optional.of(quote));
        Mockito.when(quoteRepository.save(quote)).thenReturn(quote);
        //Act
        Quote savedQuote = quoteService.updateQuote(1L,quote);
        assertEquals(quote.getQuote(), savedQuote.getQuote());
        assertEquals(quote.getEmail(), savedQuote.getEmail());
    }

    @Test
    void testUpdateQuote_QuoteNotFound(){
        Long id = 1L;
        Quote quote = new Quote(1L, "John", "Doe");
        Mockito.when(quoteRepository.findById(id)).thenReturn(Optional.empty()).thenThrow(NullPointerException.class);
        assertThrows(NullPointerException.class,() -> quoteService.updateQuote(1L,quote));
    }

    @Test
    void testDeleteQuote(){
        Long id = 1L;
        Quote quote = new Quote(1L, "John", "Doe");
        Mockito.when(quoteRepository.findById(id)).thenReturn(Optional.of(quote));
        //Act
        quoteService.deleteQuote(1L);
        Mockito.verify(quoteRepository, Mockito.times(1)).findById(id);
        Mockito.verify(quoteRepository, Mockito.times(1)).deleteById(id);

    }

    @Test
    void testDeleteQuote_QuoteNotFound(){
        Long id = 1L;
        Quote quote = new Quote(1L, "John", "Doe");
        Mockito.when(quoteRepository.findById(id)).thenReturn(Optional.empty());
        //Act and assert
        NullPointerException exception = assertThrows(NullPointerException.class,() ->  quoteService.deleteQuote(1L));
        assertEquals("Quote not found with id: " + id, exception.getMessage());
        Mockito.verify(quoteRepository, Mockito.times(1)).findById(id);
        Mockito.verify(quoteRepository, Mockito.times(0)).delete(quote);
    }
}
