package com.threesteps.acpapi.startup;

import com.threesteps.acpapi.model.Constant;
import com.threesteps.acpapi.service.ConstantService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConstantStartup implements CommandLineRunner {

    private final ConstantService constantService;

    public ConstantStartup(ConstantService constantService) {
        this.constantService = constantService;
    }

    @Override
    public void run(String... args) {
        String[] constantList = {
                "our-experiences",
                "who-are-we",
                "our-values",
                "our-missions",
                "our-vision",
                "slogan",
                "core-values",
                "footer-value"
        };
        for (var constantId : constantList) {
            var constantEntity = constantService.findByIdOptional(constantId);
            if (constantEntity.isPresent()) continue;

            var constant = new Constant(
                    constantId,
                    "titleEN",
                    "titleAZ",
                    "titleRU",
                    "descriptionEN",
                    "descriptionAZ",
                    "descriptionRU");

            constantService.add(constant);
        }
    }
}
