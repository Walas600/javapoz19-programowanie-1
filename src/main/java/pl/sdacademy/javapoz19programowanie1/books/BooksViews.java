package pl.sdacademy.javapoz19programowanie1.books;

import java.util.List;
import java.util.Scanner;

public class BooksViews {
    private Scanner scanner;

    public BooksViews(Scanner scanner) {
        this.scanner = scanner;
    }

    public int startMenu() {
        System.out.println("1. Authors");
        System.out.println("2. Books");
        System.out.println("0. Koniec");
        return getDecisionAfterEnter();
    }


    public int getDecision() {
        return scanner.nextInt();
    }

    public Nation getNation() {
        String nationAsString = scanner.nextLine().trim();
        return Nation.valueOf(nationAsString);
    }

    public int authorsMenu(List<Author> authors) {
        authors.forEach(author -> System.out.println(author));
        System.out.println();
        System.out.println("1. find by nation (PL, ENG, USA)");
        System.out.println("2. find by after birthYear");
        System.out.println("0. Wroc");
        return getDecision();
    }

    public int booksMenu(List<Book> books) {
        books.forEach(book -> System.out.println(book));
        System.out.println();
        System.out.println("1 Find by after release Year");
        System.out.println("2 Search");
        System.out.println("3 Search by author");
        System.out.println("0 Back");
        return getDecision();
    }

    public int getBirthYear() {
       return readIntAndClearLine();
    }

    public int getDecisionAfterEnter() {
       return readIntAndClearLine();
    }

    public int getReleaseYear() {
       return readIntAndClearLine();
    }

    private int readIntAndClearLine() {
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    public String getPhrase() {
        return scanner.nextLine().trim();
    }
}
