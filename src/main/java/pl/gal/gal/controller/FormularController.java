package pl.gal.gal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.TemplateEngine;
import pl.gal.gal.email.EmailService;
import pl.gal.gal.entity.Formular;
import pl.gal.gal.repository.FormularRepository;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/form")
public class FormularController  implements ErrorController {


    private ErrorAttributes errorAttributes;

    private final static String ERROR_PATH = "/error";

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @Autowired
    FormularRepository formularRepository;



    private EmailService emailService ;

    @GetMapping("")
    public String getMapping(Model model , Formular formular) {
        model.addAttribute("form", new Formular());
        return "form";
    }

    @PostMapping("")
    public String postMapping(@ModelAttribute Formular formular) {
         formularRepository.save(formular);
        List<Formular> allData = (List<Formular>) formularRepository.findAll() ;
        StringBuilder sb = new StringBuilder() ;
        for (Formular s : allData)
        {
            sb.append(s);
        }

//        emailService.sendEmail("gal.gaworjozef@gmail.com" , "Nowa wiadomosc" , sb.toString());
    return"index";


}
    @RequestMapping(value = ERROR_PATH, produces = "text/html")
    public ModelAndView errorHtml(HttpServletRequest request) {
        return new ModelAndView("/errors/error", getErrorAttributes(request, false));
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request,
                                                   boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return this.errorAttributes.getErrorAttributes(requestAttributes,
                includeStackTrace);
    }






}
