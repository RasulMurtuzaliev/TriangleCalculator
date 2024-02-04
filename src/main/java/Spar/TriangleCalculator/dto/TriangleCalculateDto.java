package Spar.TriangleCalculator.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TriangleCalculateDto {

    private double sideAB;
    private double sideBC;
    private double sideCA;
    private double angleA;
    private double angleB;
    private double angleC;

    private double perimeter;
    private double area;


    private TriangleTypeBySides typeBySides;
    private TriangleTypeByAngles typeByAngles;

    private double medianA;
    private double medianB;
    private double medianC;

    private double bisectorA;
    private double bisectorB;
    private double bisectorC;

    private double heightA;
    private double heightB;
    private double heightC;

    private double inscribedCircleArea;
    private double circumscribedCircleArea;

    private double sinA;
    private double sinB;
    private double sinC;
    private double cosA;
    private double cosB;
    private double cosC;
    private double tanA;
    private double tanB;
    private double tanC;
}
