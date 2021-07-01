package ru.netology.manager;


import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    ProductManager manager = new ProductManager();
    ProductRepository repository = new ProductRepository();

    private Book firstBook = new Book(1, "Гарри Поттер и узник Азкабана", 500, "Джоан Роулинг");
    private Book secondBook = new Book(2, "Зеленая миля ", 600, "Стивен Кинг");
    private Book thirdBook = new Book(3, "Унесенные ветром", 700, "Унесенные ветром");

    private Smartphone firstModel = new Smartphone(4, "Nokia", 1000, "Nokia.inc");
    private Smartphone secondModel = new Smartphone(5, "Sony", 1200, "Sony.inc");
    private Smartphone thirdModel = new Smartphone(6, "Iphone", 1400, "Apple.inc");

    @Test
    public void shouldSearchChosenNameBook() {
        Product[] actual = manager.searchBy("Зелёная миля");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldSearchChosenNameSmartphone (){
        Product[]actual = manager.searchBy("Iphone");
        Product[]expected = new Product[]{};
        assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldSearchChosenDeveloperName (){
        Product[]actual = manager.searchBy("Nokia.inc");
        Product[]expected = new Product[]{};
        assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldReceiveNull() {
        manager.add(firstBook);
        manager.add(secondBook);
        repository.save(firstBook);
        repository.save(secondBook);
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Пословицы");
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldReceiveChosenText() {
        manager.add(secondBook);
        repository.save(secondBook);
        assertArrayEquals(new Product[]{secondBook}, manager.searchBy("Зеленая миля"));


        manager.add(firstBook);
        repository.save(firstBook);
        assertArrayEquals(new Product[]{firstBook}, manager.searchBy( "Гарри Поттер и узник Азкабана"));
    }

 }