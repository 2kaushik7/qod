package org.sai.qod.repository;

import org.sai.qod.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

    @Query(value = "SELECT q.id FROM quote q WHERE q.id = (SELECT c.id FROM current_quote c)", nativeQuery = true)
    public Long getCurrentQuote();

    @Modifying
    @Transactional
    @Query(value = "UPDATE current_quote set id = ?1, quote = ?2, email = ?3",nativeQuery = true)
    public void insertQuoteIntoCurrentQuote(Long id, String quote, String email);
}
