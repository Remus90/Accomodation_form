package ro.fasttrackit.project.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.fasttrackit.project.service.RegistrationService;


@Controller
@RequestMapping("registrations")
public class RegistrationsUiController {
    private final RegistrationService service;

    public RegistrationsUiController(RegistrationService service) {
        this.service = service;
    }

    @GetMapping
    String registrationsPage(Model model) {
        model.addAttribute("registrations", service.getAll());
        return "registrations";
    }

    @GetMapping("{registrationId}")
    String singleRegistrationPage(@PathVariable int registrationId, Model pageModel) {
        pageModel.addAttribute("registration", service.getRegistration(registrationId).orElse(null));
        return "single-registration";
    }
}

