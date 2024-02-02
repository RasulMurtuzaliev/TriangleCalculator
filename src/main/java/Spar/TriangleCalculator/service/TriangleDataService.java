package Spar.TriangleCalculator.service;

import Spar.TriangleCalculator.dto.TriangleDto;
import Spar.TriangleCalculator.validation.TriangleDataValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TriangleDataService {

    private final TriangleDataValidator triangleDataValidator;

    public TriangleDto completeTriangleData(TriangleDto triangleDto) {
        triangleDataValidator.validate(triangleDto);

        if (triangleDataValidator.isSSSCase(triangleDto)) {
            completeForSSS(triangleDto);
        } else if (triangleDataValidator.isSASCase(triangleDto)) {
            completeForSAS(triangleDto);
        } else if (triangleDataValidator.isASACase(triangleDto)) {
            completeForASA(triangleDto);
        }
        return triangleDto;
    }

    private void completeForSSS(TriangleDto triangleDto) {
        double ab = triangleDto.getSideAB();
        double bc = triangleDto.getSideBC();
        double ca = triangleDto.getSideCA();

        double angleA = Math.toDegrees(Math.acos((ab * ab + ca * ca - bc * bc) / (2 * ab * ca)));
        double angleB = Math.toDegrees(Math.acos((ab * ab + bc * bc - ca * ca) / (2 * ab * bc)));
        double angleC = Math.toDegrees(Math.acos((bc * bc + ca * ca - ab * ab) / (2 * bc * ca)));

        triangleDto.setAngleA(angleA);
        triangleDto.setAngleB(angleB);
        triangleDto.setAngleC(angleC);
    }

    private void completeForSAS(TriangleDto triangleDto) {
        if (triangleDto.getSideAB() != null && triangleDto.getSideBC() != null && triangleDto.getAngleB() != null) {
            calculateThirdSide(triangleDto, triangleDto.getSideAB(), triangleDto.getSideBC(), triangleDto.getAngleB(), "CA");
        } else if (triangleDto.getSideAB() != null && triangleDto.getSideCA() != null && triangleDto.getAngleA() != null) {
            calculateThirdSide(triangleDto, triangleDto.getSideAB(), triangleDto.getSideCA(), triangleDto.getAngleA(), "BC");
        } else if (triangleDto.getSideBC() != null && triangleDto.getSideCA() != null && triangleDto.getAngleC() != null) {
            calculateThirdSide(triangleDto, triangleDto.getSideBC(), triangleDto.getSideCA(), triangleDto.getAngleC(), "AB");
        }
    }

    private void calculateThirdSide(TriangleDto triangleDto, double side1, double side2, double angle, String sideToUpdate) {
        double angleRadians = Math.toRadians(angle);
        double thirdSide = Math.sqrt(side1 * side1 + side2 * side2 - 2 * side1 * side2 * Math.cos(angleRadians));

        switch (sideToUpdate) {
            case "CA" -> triangleDto.setSideCA(thirdSide);
            case "BC" -> triangleDto.setSideBC(thirdSide);
            case "AB" -> triangleDto.setSideAB(thirdSide);
        }

        completeForSSS(triangleDto);
    }

    private void completeForASA(TriangleDto triangleDto) {
        if (triangleDto.getAngleA() == null) {
            triangleDto.setAngleA(180 - triangleDto.getAngleB() - triangleDto.getAngleC());
        } else if (triangleDto.getAngleB() == null) {
            triangleDto.setAngleB(180 - triangleDto.getAngleA() - triangleDto.getAngleC());
        } else if (triangleDto.getAngleC() == null) {
            triangleDto.setAngleC(180 - triangleDto.getAngleA() - triangleDto.getAngleB());
        }

        double angleARad = Math.toRadians(triangleDto.getAngleA());
        double angleBRad = Math.toRadians(triangleDto.getAngleB());
        double angleCRad = Math.toRadians(triangleDto.getAngleC());

        if (triangleDto.getSideAB() != null) {
            triangleDto.setSideBC(triangleDto.getSideAB() * (Math.sin(angleARad) / Math.sin(angleCRad)));
            triangleDto.setSideCA(triangleDto.getSideAB() * (Math.sin(angleBRad) / Math.sin(angleCRad)));
        } else if (triangleDto.getSideBC() != null) {
            triangleDto.setSideAB(triangleDto.getSideBC() * (Math.sin(angleCRad) / Math.sin(angleARad)));
            triangleDto.setSideCA(triangleDto.getSideBC() * (Math.sin(angleBRad) / Math.sin(angleARad)));
        } else if (triangleDto.getSideCA() != null) {
            triangleDto.setSideAB(triangleDto.getSideCA() * (Math.sin(angleCRad) / Math.sin(angleBRad)));
            triangleDto.setSideBC(triangleDto.getSideCA() * (Math.sin(angleARad) / Math.sin(angleBRad)));
        }
    }
}
