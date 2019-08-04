package pl.sdacademy.javapoz11programowanie1.books;

import java.util.List;

public interface AuthorsRepository {
    List<Author> findAll();

    List<Author> findByNAtion (Nation nation);
}
