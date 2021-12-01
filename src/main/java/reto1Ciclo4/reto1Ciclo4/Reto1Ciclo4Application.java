package reto1Ciclo4.reto1Ciclo4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"reto1Ciclo4.reto1Ciclo4.modelo"})
public class Reto1Ciclo4Application {

    public static void main(String[] args) {
        SpringApplication.run(Reto1Ciclo4Application.class, args);
    }

}
