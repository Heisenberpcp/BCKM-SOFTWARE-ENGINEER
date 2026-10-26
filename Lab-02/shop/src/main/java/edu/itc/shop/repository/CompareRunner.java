package edu.itc.shop.repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CompareRunner implements CommandLineRunner {
    private final RawJdbcProductRepository raw;
    private final ProductRepository client;

    public CompareRunner(RawJdbcProductRepository raw, ProductRepository client) {
        this.raw = raw;
        this.client = client;
    }

    @Override
    public void run(String... args) {
        System.out.println("RAW JDBC:   " + raw.findAll());
        System.out.println("JdbcClient: " + client.findAll());
    }
}