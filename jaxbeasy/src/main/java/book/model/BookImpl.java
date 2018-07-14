package book.model;

import book.api.Book;
import lombok.*;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement(name="book")
@XmlType(propOrder =  {"name","author", "publisher", "isbn"})
@XmlAccessorType(XmlAccessType.FIELD)
public class BookImpl implements Book {

    private String author;
    private String isbn;
    private String publisher;
    private String name;
    @XmlAttribute
    private boolean available;

    public BookImpl(Book book) {
        this.author = book.getAuthor();
        this.isbn = book.getIsbn();
        this.publisher = book.getPublisher();
        this.name = book.getName();
        this.available = book.isAvailable();
    }
}
