package ro.fasttrackit.project.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.project.model.entity.Registration;
import ro.fasttrackit.project.repository.RegistrationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
    private final RegistrationRepository repository;

    public RegistrationService(RegistrationRepository repository) {
        this.repository = repository;
    }

    public List<Registration> getAll() {
        return repository.findAll();

    }

    public Registration create(Registration newRegistration) {
        newRegistration.setId(null);
        return repository.save(newRegistration);
    }

    public Registration deleteRegistration(int registrationId) {
        Optional<Registration> registration = repository.findById(registrationId);
        registration.ifPresent(repository::delete);
        return registration.orElse(null);
    }

    public Optional<Registration> replaceRegistration(int registrationId, Registration registration) {
        return repository.findById(registrationId)
                .map(dbRegistration -> patchRegistration(dbRegistration, registration))
                .map(repository::save);
    }

    private Registration patchRegistration(Registration dbRegistration, Registration registration) {
        dbRegistration.setFirstname(registration.getFirstname());
        dbRegistration.setLastname(registration.getLastname());
        dbRegistration.setNotes(registration.getNotes());
        dbRegistration.setPhone(registration.getPhone());
        return dbRegistration;
    }

    public Optional<Registration> getRegistration(int registrationId) {
        return repository.findById(registrationId);
    }
}

