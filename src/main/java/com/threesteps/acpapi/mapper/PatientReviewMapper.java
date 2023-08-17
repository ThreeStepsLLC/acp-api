package com.threesteps.acpapi.mapper;

import com.threesteps.acpapi.dto.PatientReviewDto;
import com.threesteps.acpapi.dto.PatientReviewLangedDto;
import com.threesteps.acpapi.dto.CreatePatientReviewRequest;
import com.threesteps.acpapi.model.PatientReview;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PatientReviewMapper {

    public PatientReviewDto toDTO(PatientReview from) {
        if (from == null) return null;

        return new PatientReviewDto(from.getId(),
                from.getDescriptionEN(),
                from.getDescriptionAZ(),
                from.getDescriptionRU(),
                from.getImageUrl(),
                from.getCreateDate(),
                from.getStatus());
    }

    public PatientReview toDBO(CreatePatientReviewRequest from) {
        if (from == null) return null;

        return new PatientReview(null,
                from.getDescriptionEN(),
                from.getDescriptionAZ(),
                from.getDescriptionRU(),
                from.getImageUrl(),
                from.getCreateDate(),
                from.getStatus());
    }

    public PatientReview toDBO(PatientReviewDto from) {
        if (from == null) return null;

        return new PatientReview(from.getId(),
                from.getDescriptionEN(),
                from.getDescriptionAZ(),
                from.getDescriptionRU(),
                from.getImageUrl(),
                from.getCreateDate(),
                from.getStatus());
    }

    public PatientReviewLangedDto toPatientReviewDtoLanged(PatientReview from, String language) {
        if (from == null) return null;

        if (Objects.equals(language, "az")) {
            return new PatientReviewLangedDto(
                    from.getId(),
                    from.getDescriptionAZ(),
                    from.getImageUrl(),
                    from.getCreateDate(),
                    from.getStatus()
            );
        }

        if (Objects.equals(language, "ru")) {
            return new PatientReviewLangedDto(
                    from.getId(),
                    from.getDescriptionRU(),
                    from.getImageUrl(),
                    from.getCreateDate(),
                    from.getStatus()
            );
        }

        return new PatientReviewLangedDto(
                from.getId(),
                from.getDescriptionEN(),
                from.getImageUrl(),
                from.getCreateDate(),
                from.getStatus()
        );
    }

}