package Spar.TriangleCalculator.service;

import Spar.TriangleCalculator.dto.TriangleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TriangleCalculateService {

    private final TriangleDataService triangleDataService;

    public TriangleDto calculate(TriangleDto triangleDto) {
        return triangleDataService.completeTriangleData(triangleDto);
    }
}
