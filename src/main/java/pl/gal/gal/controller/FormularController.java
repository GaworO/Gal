package pl.gal.gal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.gal.gal.entity.Formular;
import pl.gal.gal.repository.FormularRepository;

import java.util.List;

@Controller
@RequestMapping("/form")
public class FormularController {

    @Autowired
    MailComponent mailComponent;

    @Autowired
    FormularRepository formularRepository;

    @GetMapping("")
    public String getMapping(Model model) {
        Formular formular = new Formular();
        model.addAttribute("form", formular);
        return "form";
    }

    @PostMapping("")
    public String postMapping(@ModelAttribute Formular formular, BindingResult bindingResult, RedirectAttributes model) {
        formularRepository.save(formular);

        if (bindingResult.hasErrors())
            return "index";

        if (mailComponent.sendSimpleEmail(formular)) {
            model.addFlashAttribute("classCss", "alert alert-success");
            model.addFlashAttribute("message", "Your message has been sent");
        } else {
            model.addFlashAttribute("classCss", "alert alert-warning");
            model.addFlashAttribute("message", "An unexpected error occurred thank you to repeat your request later");
        }

        return "redirect:/";
    }


}





