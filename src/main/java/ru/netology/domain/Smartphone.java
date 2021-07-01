package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor

public class Smartphone extends Product {
    private String developer;

    public Smartphone(int id, String productName, int productCount, String developer) {
        super(id, productName, productCount);
        this.developer = developer;
    }

    public Smartphone() {

    }

    public boolean matches(String search) {
        return super.matches(search) || developer.contains(search);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return Objects.equals(developer, that.developer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), developer);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "developer='" + developer + '\'' +
                '}';
    }
}
