package Spar.TriangleCalculator.service;

import Spar.TriangleCalculator.dto.TriangleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TriangleService {

    public TriangleDto calculate(TriangleDto triangleDto) {
        return triangleDto;
    }
}
