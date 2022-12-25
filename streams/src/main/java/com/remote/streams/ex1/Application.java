package com.remote.streams.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Jan Nowak", "To nie jest książka", 2010));
        books.add(new Book("Eliza Orzeszkowa", "Nad Niemnem", 1960));
        books.add(new Book("Joanna Dvorovic", "Thats not a bug its a feature", 2020));
        books.add(new Book("Julius Verne", "Wyprawa do wnętrza Ziemi", 1880));
        books.add(new Book("John Smith", "Breaking Good", 2015));

        List<Book> result = books.stream()
                .filter(b -> b.getYear() > 2010)
                .map(b -> new Book(b.getAuthor().toUpperCase(), b.getTitle(), b.getYear()))
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
