package org.sai.qod.model;


/*import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;*/
import lombok.Data;
import lombok.NoArgsConstructor;

/*@Entity
@Data*/
@NoArgsConstructor
public class Quote {

    public Quote(Long id, String quote, String email) {
        this.id = id;
        this.quote = quote;
        this.email = email;
    }

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)*/
    private Long id;
    private String quote;
    private String email;

}


