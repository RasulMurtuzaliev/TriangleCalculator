package Spar.TriangleCalculator.controller;

import Spar.TriangleCalculator.dto.TriangleCalculateDto;
import Spar.TriangleCalculator.dto.TriangleDto;
import Spar.TriangleCalculator.service.TriangleCalculateService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/triangles")
@Tag(name = "Triangle Calculator Controller")
public class TriangleController {

    private final TriangleCalculateService triangleService;

    @PostMapping("/calculate")
    public TriangleCalculateDto calculate(@RequestBody @Validated TriangleDto triangleDto) {
        return triangleService.calculate(triangleDto);
    }
}
