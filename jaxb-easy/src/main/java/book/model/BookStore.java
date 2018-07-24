package book.model;

import book.api.Book;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlRootElement(name = "books")
public class BookStore {
    @XmlElements({
        @XmlElement(name="book", type = BookImpl.class),
        @XmlElement(name="damagedbook", type = DamagedBookImpl.class)
    })
    private Collection<Book> books;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        books.forEach(book -> sb.append(book).append("\n"));
        return sb.toString();
    }
}
