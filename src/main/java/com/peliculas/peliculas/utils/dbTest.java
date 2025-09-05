package com.peliculas.peliculas.utils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;

@Component
public class dbTest implements CommandLineRunner {

    private final DataSource dataSource;

    public dbTest(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(String... args) throws Exception {
        try (var conn = dataSource.getConnection()) {
            System.out.println("✅ Conectado a Oracle: " + conn.getMetaData().getURL());
        }
    }
}
