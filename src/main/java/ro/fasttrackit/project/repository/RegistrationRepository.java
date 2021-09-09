package ro.fasttrackit.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.project.model.entity.Registration;

public interface RegistrationRepository extends JpaRepository<Registration,Integer> {

}
