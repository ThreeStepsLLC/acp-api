package com.threesteps.acpapi.mapper;

import com.threesteps.acpapi.dto.ConstantDto;
import com.threesteps.acpapi.dto.ConstantLangedDto;
import com.threesteps.acpapi.model.Constant;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ConstantMapper {

    public ConstantDto toDTO(Constant from) {
        if (from == null) return null;

        return new ConstantDto(from.getId(),
                from.getTitleEN(),
                from.getTitleAZ(),
                from.getTitleRU(),
                from.getDescriptionEN1(),
                from.getDescriptionEN2(),
                from.getDescriptionAZ1(),
                from.getDescriptionAZ2(),
                from.getDescriptionRU1(),
                from.getDescriptionRU2(),
                from.getImageUrl(),
                from.getMediaContentUrl1(),
                from.getMediaContentUrl2(),
                from.getYouTubeLink1(),
                from.getYouTubeLink2());
    }

    public Constant toDBO(ConstantDto from) {
        if (from == null) return null;

        return new Constant(from.getId(),
                from.getTitleEN(),
                from.getTitleAZ(),
                from.getTitleRU(),
                from.getDescriptionEN1(),
                from.getDescriptionEN2(),
                from.getDescriptionAZ1(),
                from.getDescriptionAZ2(),
                from.getDescriptionRU1(),
                from.getDescriptionRU2(),
                from.getImageUrl(),
                from.getMediaContentUrl1(),
                from.getMediaContentUrl2(),
                from.getYouTubeLink1(),
                from.getYouTubeLink2());
    }

    public ConstantLangedDto toConstantLangedDto(Constant from, String language) {
        if (from == null) return null;

        if (Objects.equals(language, "az")) {
            return new ConstantLangedDto(
                    from.getId(),
                    from.getTitleAZ(),
                    from.getDescriptionAZ1(),
                    from.getDescriptionAZ2(),
                    from.getImageUrl(),
                    from.getMediaContentUrl1(),
                    from.getMediaContentUrl2(),
                    from.getYouTubeLink1(),
                    from.getYouTubeLink2()
            );
        }

        if (Objects.equals(language, "ru")) {
            return new ConstantLangedDto(
                    from.getId(),
                    from.getTitleRU(),
                    from.getDescriptionRU1(),
                    from.getDescriptionRU2(),
                    from.getImageUrl(),
                    from.getMediaContentUrl1(),
                    from.getMediaContentUrl2(),
                    from.getYouTubeLink1(),
                    from.getYouTubeLink2()
            );
        }

        return new ConstantLangedDto(
                from.getId(),
                from.getTitleEN(),
                from.getDescriptionEN1(),
                from.getDescriptionEN2(),
                from.getImageUrl(),
                from.getMediaContentUrl1(),
                from.getMediaContentUrl2(),
                from.getYouTubeLink1(),
                from.getYouTubeLink2()
        );
    }

}