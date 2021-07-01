package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor

public class Book extends Product {
    private String author;

    public Book(int id, String productName, int productCount, String author) {
        super(id, productName, productCount);
        this.author = author;
    }

    public Book(){

    }

    public boolean matches(String search) {
        return super.matches(search) || author.contains(search);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author);
    }

    @Override
    public String
    toString() {
        return "Book{" +
                "author='" + author + '\'' +
                '}';
    }
}

