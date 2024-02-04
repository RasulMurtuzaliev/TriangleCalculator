package Spar.TriangleCalculator.service;

import Spar.TriangleCalculator.dto.TriangleCalculateDto;
import Spar.TriangleCalculator.dto.TriangleDto;
import Spar.TriangleCalculator.dto.TriangleTypeByAngles;
import Spar.TriangleCalculator.dto.TriangleTypeBySides;
import Spar.TriangleCalculator.mapper.TriangleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TriangleCalculateService {

    private final TriangleDataService triangleDataService;
    private final TriangleMapper triangleMapper;

    public TriangleCalculateDto calculate(TriangleDto triangleDto) {
        TriangleDto triangleDataComplete = triangleDataService.completeTriangleData(triangleDto);
        TriangleCalculateDto triangleCalculateDto = triangleMapper.toCalculateDto(triangleDataComplete);

        calculatePerimeter(triangleCalculateDto);
        calculateArea(triangleCalculateDto);
        calculateTypeBySides(triangleCalculateDto);
        calculateTypeByAngles(triangleCalculateDto);
        calculateMedians(triangleCalculateDto);
        calculateBisectors(triangleCalculateDto);
        calculateHeights(triangleCalculateDto);
        calculateInscribedCircleArea(triangleCalculateDto);
        calculateCircumscribedCircleArea(triangleCalculateDto);
        calculateTrigonometricFunctions(triangleCalculateDto);

        return triangleCalculateDto;
    }

    private void calculatePerimeter(TriangleCalculateDto dto) {
        double perimeter = dto.getSideAB() + dto.getSideBC() + dto.getSideCA();
        dto.setPerimeter(perimeter);
    }

    private void calculateArea(TriangleCalculateDto dto) {
        double s = dto.getPerimeter() / 2;
        double area = Math.sqrt(s * (s - dto.getSideAB()) * (s - dto.getSideBC()) * (s - dto.getSideCA()));
        dto.setArea(area);
    }

    private void calculateTypeBySides(TriangleCalculateDto dto) {
        if (dto.getSideAB() == dto.getSideBC() && dto.getSideBC() == dto.getSideCA()) {
            dto.setTypeBySides(TriangleTypeBySides.EQUILATERAL);
        } else if (dto.getSideAB() == dto.getSideBC() || dto.getSideBC() == dto.getSideCA() || dto.getSideCA() == dto.getSideAB()) {
            dto.setTypeBySides(TriangleTypeBySides.ISOSCELES);
        } else {
            dto.setTypeBySides(TriangleTypeBySides.SCALENE);
        }
    }

    private void calculateTypeByAngles(TriangleCalculateDto dto) {
        if (dto.getAngleA() == 90 || dto.getAngleB() == 90 || dto.getAngleC() == 90) {
            dto.setTypeByAngles(TriangleTypeByAngles.RIGHT);
        } else if (dto.getAngleA() > 90 || dto.getAngleB() > 90 || dto.getAngleC() > 90) {
            dto.setTypeByAngles(TriangleTypeByAngles.OBTUSE);
        } else {
            dto.setTypeByAngles(TriangleTypeByAngles.ACUTE);
        }
    }

    private void calculateMedians(TriangleCalculateDto dto) {
        double medianA = 0.5 * Math.sqrt(2 * (squaring(dto.getSideAB()) + squaring(dto.getSideCA())) - squaring(dto.getSideBC()));
        double medianB = 0.5 * Math.sqrt(2 * (squaring(dto.getSideBC()) + squaring(dto.getSideAB())) - squaring(dto.getSideCA()));
        double medianC = 0.5 * Math.sqrt(2 * (squaring(dto.getSideCA()) + squaring(dto.getSideBC())) - squaring(dto.getSideAB()));

        dto.setMedianA(medianA);
        dto.setMedianB(medianB);
        dto.setMedianC(medianC);
    }

    private void calculateBisectors(TriangleCalculateDto dto) {
        double ab = dto.getSideAB();
        double bc = dto.getSideBC();
        double ca = dto.getSideCA();

        double bisectorA = Math.sqrt(ab * ca * (ab + ca + bc) * (ab + ca - bc)) / (ab + ca);
        double bisectorB = Math.sqrt(bc * ab * (bc + ab + ca) * (bc + ab - ca)) / (bc + ab);
        double bisectorC = Math.sqrt(ca * bc * (ca + bc + ab) * (ca + bc - ab)) / (ca + bc);

        dto.setBisectorA(bisectorA);
        dto.setBisectorB(bisectorB);
        dto.setBisectorC(bisectorC);
    }

    private void calculateHeights(TriangleCalculateDto dto) {
        double heightA = (2 * dto.getArea()) / dto.getSideBC();
        double heightB = (2 * dto.getArea()) / dto.getSideCA();
        double heightC = (2 * dto.getArea()) / dto.getSideAB();

        dto.setHeightA(heightA);
        dto.setHeightB(heightB);
        dto.setHeightC(heightC);
    }

    private void calculateInscribedCircleArea(TriangleCalculateDto dto) {
        double s = dto.getPerimeter() / 2;
        double r = dto.getArea() / s;
        double inscribedCircleArea = Math.PI * r * r;
        dto.setInscribedCircleArea(inscribedCircleArea);
    }

    private void calculateCircumscribedCircleArea(TriangleCalculateDto dto) {
        double R = (dto.getSideAB() * dto.getSideBC() * dto.getSideCA()) / (4 * dto.getArea());
        double circumscribedCircleArea = Math.PI * R * R;
        dto.setCircumscribedCircleArea(circumscribedCircleArea);
    }

    private void calculateTrigonometricFunctions(TriangleCalculateDto dto) {
        dto.setSinA(Math.sin(Math.toRadians(dto.getAngleA())));
        dto.setSinB(Math.sin(Math.toRadians(dto.getAngleB())));
        dto.setSinC(Math.sin(Math.toRadians(dto.getAngleC())));
        dto.setCosA(Math.cos(Math.toRadians(dto.getAngleA())));
        dto.setCosB(Math.cos(Math.toRadians(dto.getAngleB())));
        dto.setCosC(Math.cos(Math.toRadians(dto.getAngleC())));
        dto.setTanA(Math.tan(Math.toRadians(dto.getAngleA())));
        dto.setTanB(Math.tan(Math.toRadians(dto.getAngleB())));
        dto.setTanC(Math.tan(Math.toRadians(dto.getAngleC())));
    }

    private double squaring(double a) {
        return a * a;
    }
}
