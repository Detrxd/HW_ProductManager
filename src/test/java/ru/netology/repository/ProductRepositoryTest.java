package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    ProductRepository repository = new ProductRepository();

    private Book firstBook = new Book(1, "Сказки", 1000, "Пушкин");
    private Book secondBook = new Book(2, "Зеленая миля ", 600, "Стивен Кинг");
    private Book thirdBook = new Book(3, "Унесенные ветром", 700, "Унесенные ветром");

    @Test
    public void shouldSaveProduct() {
        repository.save(firstBook);
        Product[] expected = new Product[]{firstBook};
        Product[] actual = repository.getAllProduct();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowAllProducts() {
        repository.save(firstBook);
        repository.save(secondBook);
        repository.getAllProduct();
    Product[] expected = new Product[]{firstBook,secondBook};
    Product[] actual = repository.getAllProduct();
    }
}