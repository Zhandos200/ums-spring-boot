package com.yourorg.ums;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UmsApplication {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

        String dbUser = dotenv.get("DB_USERNAME");
        String dbPass = dotenv.get("DB_PASSWORD");

        if (dbUser == null || dbPass == null) {
            throw new IllegalStateException("Missing DB_USERNAME or DB_PASSWORD in .env");
        }

        System.setProperty("DB_USERNAME", dbUser);
        System.setProperty("DB_PASSWORD", dbPass);

        SpringApplication.run(UmsApplication.class, args);
    }
}
