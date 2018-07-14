package book.controller;

import book.api.Book;
import book.model.BookImpl;
import book.model.BookStore;
import book.model.DamagedBookImpl;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.util.Arrays;

public class BookController {

    public static void main(String[] args) {
        Book book1 = new BookImpl("BookA", "isbn1", "publisher1", "name1", true);
        Book book2 = new DamagedBookImpl(book1, 0);
        BookStore bookStore = new BookStore(Arrays.asList(book1,book2));
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(BookStore.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(bookStore, System.out);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            bookStore = (BookStore) unmarshaller.unmarshal(
                    BookController.class.getClassLoader().getResourceAsStream("books.xml")
            );
            System.out.println(bookStore);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}