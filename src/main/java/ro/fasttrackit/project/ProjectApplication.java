package ro.fasttrackit.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.project.model.entity.Registration;
import ro.fasttrackit.project.repository.RegistrationRepository;

import java.util.List;


@SpringBootApplication
public class ProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

    @Bean
    CommandLineRunner atStartup(RegistrationRepository repository) {
        return args -> {
            repository.saveAll(List.of(
                    new Registration("Marian", "Popescu", "Camera de nefumatori", "0754634567"),
                    new Registration("Adrian", "Nicoara", "camera cu balcon", "0743654321"),
                    new Registration("Florin", "Popovici", "prefera etajul 2 sau 3", "05467382123"),
                    new Registration("Marius", "Vuscan", "are acces gratuit", "0723445678")
            ));
        };
    }
}
