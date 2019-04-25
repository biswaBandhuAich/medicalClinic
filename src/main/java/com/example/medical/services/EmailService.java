package com.example.medical.services;

import com.example.medical.Bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Locale;

@Service
public class EmailService {
    private static TemplateEngine templateEngine;
    private static Context context;
    private JavaMailSender mailSender;
    @Autowired
    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    private Logger LOG = LoggerFactory.getLogger(EmailService.class);

    public static void initializeTemplateEngine() {
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setTemplateMode("HTML5");
        resolver.setSuffix(".html");
        resolver.setCharacterEncoding("UTF-8");
        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);
        context = new Context(Locale.US);

    }



    public void readyAndSendWelcomeEmail(User user) throws MessagingException {
        String template = "templates/WelcomeEmailTemplate";
        String mailTo=user.getEmail();
        initializeTemplateEngine();
        context.setVariable("sender", "Repose Clinic");
        context.setVariable("sentTo",mailTo );
        String htmlBody = templateEngine.process(template, context);
        sendEmail(mailTo, "Test Email", htmlBody);
    }

    private void sendEmail(String mailTo, String subject, String body) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
        messageHelper.setTo(mailTo);
        messageHelper.setSubject(subject);
        messageHelper.setText(body, true);
        mailSender.send(message);
        LOG.info("Mail Sent To:" + mailTo);

    }
}
