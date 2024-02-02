package Spar.TriangleCalculator.controller;

import Spar.TriangleCalculator.dto.TriangleDto;
import Spar.TriangleCalculator.service.TriangleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/triangles")
public class TriangleController {

    private final TriangleService triangleService;

    @PostMapping("/calculate")
    public TriangleDto calculate(@RequestBody TriangleDto triangleDto) {
        return triangleService.calculate(triangleDto);
    }
}
