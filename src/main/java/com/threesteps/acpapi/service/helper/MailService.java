package com.threesteps.acpapi.service.helper;

import com.threesteps.acpapi.service.SettingService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private final JavaMailSender javaMailSender;
    private final SettingService settingService;

    public MailService(JavaMailSender javaMailSender,
                       SettingService settingService) {
        this.javaMailSender = javaMailSender;
        this.settingService = settingService;
    }

    public void sendMail(String subject, String text) {
        var willSentMail = settingService.get().getMailAdressForContact();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(willSentMail);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }

}
