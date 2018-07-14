package book.api;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public interface Book {
    String getAuthor();
    String getPublisher();
    String getIsbn();
    String getName();
    boolean isAvailable();
}
