package Spar.TriangleCalculator.service;

import Spar.TriangleCalculator.dto.TriangleDto;
import Spar.TriangleCalculator.validation.TriangleDataValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TriangleService {

    private final TriangleDataValidator triangleDataValidator;

    public TriangleDto calculate(TriangleDto triangleDto) {
        triangleDataValidator.validate(triangleDto);
        return triangleDto;
    }
}
