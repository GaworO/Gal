package pl.gal.gal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import pl.gal.gal.entity.Formular;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Component
public class MailComponent {


    @Autowired
    MailSender mailSender;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    TemplateEngine templateEngine;


    public boolean sendSimpleEmail(Formular formular) {
        String myMessage = "Imię:    " + formular.getName() + "\n" +
                "Nazwisko:    " + formular.getSurname() + "\n" +
                "Numer Telefonu: " + formular.getNumber() + "\n" +
                "Email:   " + formular.getEmail() + "\n" +
                "Wiadomość:   " + formular.getMessage();
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(formular.getEmail());
        simpleMailMessage.setTo("gal.gaworjozef@gmail.com");
        simpleMailMessage.setSubject(formular.getSubject());
        simpleMailMessage.setText(myMessage);


        try {
            mailSender.send(simpleMailMessage);
            return true;
        } catch (MailException e) {
            System.err.println(e.getMessage());
            return false;

        }

    }

//
//    public boolean sentHtmlEmail(@ModelAttribute Formular formular) {
//
//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        Context context = new Context();
//        context.setVariable("form", formular);
//        final String content = templateEngine.process("email/contact", context);
//        String myMessage1 = "Imię " + formular.getName() + "/n" +
//                "Nazwisko " + formular.getSurname() + "/n" +
//                "Numer Telefonu" + formular.getNumber() + "/n" +
//                "Email" + formular.getEmail() + "/n" +
//                "Wiadomość" + formular.getMessage();
//
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        MimeMessageHelper mailMessage = new MimeMessageHelper(mimeMessage);
//
//
//        try {
//            mailMessage.setFrom(formular.getEmail());
//            mailMessage.setTo("gal.gaworjozef@gmail.com");
//            mailMessage.setSubject("Nowa Wiadomość");
//            mailMessage.setText(myMessage1, true);
//            javaMailSender.send(mimeMessage);
//            return true;
//
//        } catch (MessagingException e) {
//            e.printStackTrace();
//            System.err.println(e.getMessage());
//            return false;
//        }
//
//    }
}

