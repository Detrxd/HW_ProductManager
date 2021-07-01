package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Objects;

@Data
@NoArgsConstructor


public class Product {
    private int id;
    private String productName;
    private int productCount;

    public Product(int id, String productName, int productCount) {
        this.id = id;
        this.productName = productName;
        this.productCount = productCount;
    }

    public boolean matches(String search){
       return productName.contains(search);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && productCount == product.productCount && Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, productCount);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productCount=" + productCount +
                '}';
    }
}
