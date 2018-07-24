package book.api;

public interface Book {
    String getAuthor();
    String getPublisher();
    String getIsbn();
    String getName();
    boolean isAvailable();
}
