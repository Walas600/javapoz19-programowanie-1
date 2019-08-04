package pl.sdacademy.javapoz11programowanie1;

import java.util.Arrays;
import java.util.List;

public class ApplicationBook {
    public static void main(String[] args) {
      List<Book> books = Arrays.asList(
                new Book("W pustyni i w puszczy", 1910, 300),
                new Book("Krzyżacy", 1900, 1000),
                new Book("Dziady III", 1832, 250),
                new Book("Dziady I", 1860, 350),
                new Book("Zielona mila", 1996, 290),
                new Book("Balladyna", 1839, 400),
                new Book("Harry Potter i Czara ognia", 2005, 650),
                new Book("Harry Potter i Ksiaze Polkrwi", 2009, 650),
                new Book("Romeo i Julia", 1595, 340)
        );

        books.stream()
                .filter(book -> book.getReleaseYear() < 2000)
                .filter(book -> book.getPages() > 300)
                .map(book -> book.getName())
                .forEach(bookName -> System.out.println(bookName));

    }
}
