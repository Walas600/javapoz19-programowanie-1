package pl.sdacademy.javapoz11programowanie1;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Author sienkiewicz = new Author();
        sienkiewicz.setFirstName("Henryk");
        sienkiewicz.setLastname("Sienkiewicz");
        sienkiewicz.setBirthYear(1846);
        sienkiewicz.setNation(Nation.PL);

        Author King = new Author("Stephen", "King", 1947, Nation.USA);
        Author mickiewicz = new Author("Adam", "Mickiewicz", 1798, Nation.PL);

        List<Author> authors = Arrays.asList(sienkiewicz, King, mickiewicz,
                new Author("Juliusz", "Słowacki", 1849, Nation.PL),
                new Author("Joanne Murray", "Rowling", 1965, Nation.ENG),
                new Author("William", "Shakespeare", 1564, Nation.ENG));

        showByNation(authors, Nation.PL);
        showModernAuthors(authors);
        showByNationAndAfterBirthYear(authors, Nation.PL , 1846);
        System.out.println(groupByNation(authors));

    }

    private static void showByNation(List<Author> authors, Nation nation) {
        for (Author author : authors) {
            if (author.getNation().equals(nation)) {
                System.out.println(author);
            }
        }

    }

    private static void showModernAuthors(List<Author> authors) {
        for (Author author : authors) {
            if (author.getBirthYear() > 1900) {
                System.out.println(author);
            }
        }
    }

    private static void showByNationAndAfterBirthYear(List<Author> authors, Nation nation, int birthYear) {
        for (Author author : authors) {
            if (author.getNation().equals(nation) && author.getBirthYear() >= birthYear) {
                System.out.println(author);
            }
        }

    }
    private static Map<Nation,List<Author>> groupByNation(List<Author> authors){
       Map<Nation,List<Author>> map = new HashMap<>();
       for (Author author : authors){
           map.putIfAbsent(author.getNation(), new ArrayList<>());
           map.get(author.getNation()).add(author);
       }


        return map;
    }
}

