package edu.itc.shop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import edu.itc.shop.domain.Product;

@Repository
public class ProductRepository {
    private final JdbcClient jdbc;

    // constructor build jdbc (injection)
    public ProductRepository(JdbcClient jdbc) { 
        this.jdbc = jdbc; 
    }

    public List<Product> findAll() {
        return jdbc.sql("SELECT id, name, price, stock FROM product ORDER BY id")
                   .query(Product.class).list();
    }

    public Optional<Product> findById(long id) {
        // TODO
        return Optional.empty();
    }

    public long insert(Product p) {
        var keys = new GeneratedKeyHolder();
        jdbc.sql("INSERT INTO product(name, price, stock) VALUES (:name, :price, :stock)")
            .paramSource(p)
            .update(keys);
        return keys.getKey().longValue();
    }

    public int updateStock(long id, int delta) {
        // TODO: UPDATE product SET stock = stock + :delta WHERE id = :id AND stock + :delta >= 0
        return 0;
    }
}