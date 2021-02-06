package io.harmed;

import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Author author1 = new Author("Anton", (short) 43);
        Author author2 = new Author("Kate", (short) 29);

        Book book1= new Book("Love", 205);
        Book book2 = new Book("Pain", 14);

        author1.setBooks(new ArrayList<>(Arrays.asList(book1, book2)));
        author2.setBooks(new ArrayList<>(Arrays.asList(book2)));

        book1.setAuthors(new ArrayList<>(Arrays.asList(author1,author2)));
        book2.setAuthors(new ArrayList<>(Arrays.asList(author2)));


        Author[] authors = new Author[]{author1, author2};
        Book[] books = new Book[]{book1, book2};

        //check if some/all book(s) have more than 200 pages;
        Stream<Book> streamOfBooks = Arrays.stream(books);
        streamOfBooks.filter(book -> book.getNumberOfPages()>200)
                .peek(e -> System.out.println("Filtered value: " + e))
                .forEach(System.out::println);

        //find the books with max and min number of pages;
        Stream<Book> streamOfBooks1 = Arrays.stream(books);
        streamOfBooks1
                .filter(e -> Optional.of(e.getNumberOfPages()).isPresent())
                .findFirst();

        Stream<Book> streamOfBooks2 = Arrays.stream(books);
        Book bookWithMinPages = streamOfBooks2.min(Comparator.comparing(Book::getNumberOfPages))
                .get();
        System.out.println(bookWithMinPages);


        //filter books with only single author;
        Stream<Book> streamOfBooks3 = Arrays.stream(books);
        streamOfBooks3.parallel()
                .filter(book -> book.getAuthors().size()==1)
                .forEach(System.out::println);

        //sort the books by number of pages/title;
        Stream<Book> streamOfBooks4 = Arrays.stream(books);
        streamOfBooks4.sorted(Comparator.comparing(book -> book.getNumberOfPages()))
        .forEach(System.out::println);

        Stream<Book> streamOfBooks5 = Arrays.stream(books);
        streamOfBooks5.sorted(Comparator.comparing(book -> book.getTitle()))
                .peek(e -> System.out.println("Sorted value : " + e))
                .forEach(System.out::println);

        //get list of all titles;
        Stream<Book> streamOfBooks6 = Arrays.stream(books);
        streamOfBooks6.map(book -> book.getTitle())
                .peek(e -> System.out.println("Mapped value: " + e))
                .forEach(System.out::println);

        //print them using forEach method;
        Stream<Book> streamOfBooks7 = Arrays.stream(books);
        streamOfBooks7.forEach(System.out::println);

        //get distinct list of all authors;
        Stream<Book> streamOfBooks8 = Arrays.stream(books);
        streamOfBooks8.map(book -> book.getAuthors())
                .flatMap(a -> a.stream())
                .peek(e -> System.out.println("considering new author " + e))
                .map(x -> x.getName())
                .distinct()
                .forEach(System.out::println);

        //Use peek method for debugging intermediate streams during execution the previous task.
        //Use parallel stream with subtask #3.
        //Use the Option type for determining the title of the biggest book of some author.

    }
}
