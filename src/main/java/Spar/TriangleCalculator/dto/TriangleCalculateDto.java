package Spar.TriangleCalculator.dto;

import lombok.Data;

@Data
public class TriangleCalculateDto {

    private double sideAB;
    private double sideBC;
    private double sideCA;
    private double angleA;
    private double angleB;
    private double angleC;

    private double area;
    private double perimeter;

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
