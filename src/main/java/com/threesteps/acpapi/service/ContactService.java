package com.threesteps.acpapi.service;

import com.threesteps.acpapi.dto.CreateContactRequest;
import com.threesteps.acpapi.service.helper.LanguageService;
import com.threesteps.acpapi.service.helper.MailService;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private final LanguageService languageService;
    private final MailService mailService;

    public ContactService(LanguageService languageService,
                          MailService mailService) {
        this.languageService = languageService;
        this.mailService = mailService;
    }

    public String sendMail(CreateContactRequest request) {
        Thread thread = new Thread(() -> {
            var willSendText = "Müştəri: " + request.getCustomerFullName() + "\n" +
                    "Telefon: " + request.getPhone() + "\n" +
                    "Mail: " + request.getMail() + "\n" +
                    "Mesaj: " + request.getDescription() + "\n";
            mailService.sendMail("Əlaqə üçün mesaj!", willSendText);
        });
        thread.start();

        var language = this.languageService.getLanguage();

        return switch (language) {
            case "az" -> "Uğurla göndərildi!";
            case "ru" -> "Успешно отправлено!";
            default -> "Sent successfully!";
        };

    }
}
