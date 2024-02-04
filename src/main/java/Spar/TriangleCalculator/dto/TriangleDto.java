package Spar.TriangleCalculator.dto;

import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TriangleDto {

    @Positive(message = "Side AB must be positive")
    private Double sideAB;

    @Positive(message = "Side BC must be positive")
    private Double sideBC;

    @Positive(message = "Side CA must be positive")
    private Double sideCA;

    @Positive(message = "Angle A must be positive")
    private Double angleA;

    @Positive(message = "Angle B must be positive")
    private Double angleB;

    @Positive(message = "Angle C must be positive")
    private Double angleC;
}
