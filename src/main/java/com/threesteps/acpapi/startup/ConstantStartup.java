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
        String[] constantList = {"about-us"};
        for (var constantId : constantList) {
            var constantEntity = constantService.findByIdOptional(constantId);
            if (constantEntity.isPresent()) return;

            var constant = new Constant(
                    constantId,
                    "titleEN",
                    "titleAZ",
                    "titleRU",
                    "descriptionEN1",
                    "descriptionEN2",
                    "descriptionAZ1",
                    "descriptionAZ2",
                    "descriptionRU1",
                    "descriptionRU2",
                    "imageUrl",
                    null,
                    null,
                    null,
                    null);


            constantService.add(constant);
        }
    }
}
