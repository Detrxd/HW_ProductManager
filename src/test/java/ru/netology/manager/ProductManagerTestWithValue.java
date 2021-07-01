package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTestWithValue {

    ProductManager manager = new ProductManager();


    private Book firstBook = new Book(1, "Гарри Поттер и узник Азкабана", 500, "Джоан Роулинг");
    private Book secondBook = new Book(2, "Зеленая миля", 600, "Стивен Кинг");
    private Book thirdBook = new Book(3, "Унесенные ветром", 700, "Маргарет Митчелл");
    private Book fourthBook = new Book(3,"Гарри Поттер и философский камень", 99, "NoName");

    private Smartphone firstModel = new Smartphone(4, "Nokia", 1000, "Nokia.inc");
    private Smartphone secondModel = new Smartphone(5, "Sony", 1200, "Panasonic");
    private Smartphone thirdModel = new Smartphone(6, "Sony Ericsson", 1400, "Nokia.inc");

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
    public void shouldSearchChosenAuthor() {

        Product[] actual = manager.searchBy("Джоан Роулинг");
        Product[] expected = new Product[]{firstBook};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchChosenDeveloperName(){

        Product[] actual = manager.searchBy("Panasonic");
        Product[] expected = new Product[]{secondModel};
        assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldSearchChosenNameSmartphone() {

        Product[] actual = manager.searchBy("Nokia");
        Product[] expected = new Product[]{firstModel};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchChosenBookName(){

        Product[] actual = manager.searchBy("Гарри Поттер и узник Азкабана");
        Product[] expected = new Product[]{firstBook};
        assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldReceiveZero(){
        Product[] actual = manager.searchBy("Android");
        Product[] expected = new Product[]{};
        assertArrayEquals(actual, expected);
    }
}


