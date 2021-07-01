package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTestManyValue {

    ProductManager manager = new ProductManager();

    private Book firstBook = new Book(1, "Гарри Поттер и узник Азкабана", 500, "Джоан Роулинг");
    private Book secondBook = new Book(2, "Зеленая миля", 600, "Стивен Кинг");
    private Book thirdBook = new Book(3, "Унесенные ветром", 700, "Маргарет Митчелл");
    private Book fourthBook = new Book(4, "Гарри Поттер и философский камень", 99, "Джоан Роулинг");

    private Smartphone firstModel = new Smartphone(5, "Iphone XS", 1000, "USA");
    private Smartphone secondModel = new Smartphone(6, "Iphone 12 PRO MAX", 1200, "USA");
    private Smartphone thirdModel = new Smartphone(7, "Sony Ericsson", 1400, "China");


    @BeforeEach
    public void saveProducts() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
        manager.add(fourthBook);
        manager.add(firstModel);
        manager.add(secondModel);
        manager.add(thirdModel);
    }

    @Test
    public void checkingSearchFromManyBooks() {
        Product[] actual = manager.searchBy("Гарри Поттер");
        Product[] expected = new Product[]{firstBook, fourthBook};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void checkingSearchFromBooks() {
        Product[] actual = manager.searchBy("Зеленая миля");
        Product[] expected = new Product[]{secondBook};
        assertArrayEquals(actual, expected);
    }


    @Test
    public void checkingSearchFromManySmartphones() {
        Product[] actual = manager.searchBy("Iphone");
        Product[] expected = new Product[]{firstModel, secondModel};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchChosenProductNameAndDeveloper() {

        Product[] actual = manager.searchBy("USA");
        Product[] expected = new Product[]{firstModel, secondModel};
        assertArrayEquals(actual,expected);
    }
    @Test
    public void checkingSearchFromManyAuthors() {
        Product[] actual = manager.searchBy("Джоан Роулинг");
        Product[] expected = new Product[]{firstBook, fourthBook};
        assertArrayEquals(actual, expected);
    }
    @Test
    public void checkingSearchFromAuthors() {
        Product[] actual = manager.searchBy("Кинг");
        Product[] expected = new Product[]{secondBook};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void checkingSearchFromSmartphones() {
        Product[] actual = manager.searchBy("Sony");
        Product[] expected = new Product[]{thirdModel};
        assertArrayEquals(actual, expected);
    }


}


