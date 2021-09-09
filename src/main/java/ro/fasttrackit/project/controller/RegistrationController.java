package ro.fasttrackit.project.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.project.model.entity.Registration;
import ro.fasttrackit.project.service.RegistrationService;


@RestController
@RequestMapping("api/registrations")
public class RegistrationController {
    private final RegistrationService service;

    public RegistrationController(RegistrationService service) {
        this.service = service;
    }

    @PostMapping
    Registration addRegistration(@RequestBody Registration newRegistration) {
        return service.create(newRegistration);
    }

    @PutMapping("{registrationId}")
    Registration replaceRegistration(@PathVariable int registrationId, @RequestBody Registration registration) {
        return service.replaceRegistration(registrationId, registration)
                .orElseThrow(() -> new RuntimeException("Could not find registration with id " + registrationId));
    }


    @DeleteMapping("{registrationId}")
    Registration deleteRegistration(@PathVariable int registrationId) {
        return service.deleteRegistration(registrationId);
    }

}
