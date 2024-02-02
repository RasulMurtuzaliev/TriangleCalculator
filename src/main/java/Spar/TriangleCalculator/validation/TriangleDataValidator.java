package Spar.TriangleCalculator.validation;

import Spar.TriangleCalculator.dto.TriangleDto;
import Spar.TriangleCalculator.exception.DataValidationException;
import org.springframework.stereotype.Component;

@Component
public class TriangleDataValidator {

    public void validate(TriangleDto triangleDto) {
        if (isSSSCase(triangleDto) || isSASCase(triangleDto) || isASACase(triangleDto)) {
            return;
        }

        if (twoSidesCase(triangleDto)) {
            throw new DataValidationException("You entered two sides. " +
                    "Enter the angle between these sides for SAS calculations or the other side for SSS calculations.");
        }

        if (twoAnglesCase(triangleDto)) {
            throw new DataValidationException("You entered more than one angle. Enter one side to calculate ASA.");
        }

        if (oneSideOneAdjacentAngleCase(triangleDto)) {
            throw new DataValidationException("You entered one side and one adjacent angle. " +
                    "Enter the second side forming this angle for SAS calculation.");
        }

        if (oneSideCase(triangleDto)) {
            throw new DataValidationException("You have entered only one side. " +
                    "Enter one more side and the angle between them for SAS calculations, or the other two sides for SSS calculations.");
        }

        if (oneAngleCase(triangleDto)) {
            throw new DataValidationException("You entered only one angle. " +
                    "Enter one more angle and one side to calculate the ASA or two sides forming this angle to calculate the SAS.");
        }

        throw new DataValidationException("You have not entered enough information to calculate the triangle.");
    }


    public boolean isSSSCase(TriangleDto triangleDto) {
        if (triangleDto.getSideAB() != null && triangleDto.getSideBC() != null && triangleDto.getSideCA() != null) {
            if (!(triangleDto.getSideAB() + triangleDto.getSideBC() > triangleDto.getSideCA() &&
                    triangleDto.getSideAB() + triangleDto.getSideCA() > triangleDto.getSideBC() &&
                    triangleDto.getSideBC() + triangleDto.getSideCA() > triangleDto.getSideAB())) {
                throw new DataValidationException("The sum of any two sides must be greater than the third side.");
            }
            return true;
        }
        return false;
    }

    public boolean isSASCase(TriangleDto triangleDto) {
        return (triangleDto.getSideAB() != null && triangleDto.getSideBC() != null && triangleDto.getAngleB() != null) ||
                (triangleDto.getSideAB() != null && triangleDto.getSideCA() != null && triangleDto.getAngleA() != null) ||
                (triangleDto.getSideBC() != null && triangleDto.getSideCA() != null && triangleDto.getAngleC() != null);
    }

    public boolean isASACase(TriangleDto triangleDto) {
        int anglesCount = (triangleDto.getAngleA() != null ? 1 : 0) +
                (triangleDto.getAngleB() != null ? 1 : 0) +
                (triangleDto.getAngleC() != null ? 1 : 0);
        return anglesCount >= 2 && (triangleDto.getSideAB() != null || triangleDto.getSideBC() != null || triangleDto.getSideCA() != null);
    }

    private boolean twoSidesCase(TriangleDto triangleDto) {
        int sidesCount = (triangleDto.getSideAB() != null ? 1 : 0) +
                (triangleDto.getSideBC() != null ? 1 : 0) +
                (triangleDto.getSideCA() != null ? 1 : 0);
        return sidesCount == 2;
    }

    private boolean twoAnglesCase(TriangleDto triangleDto) {
        int anglesCount = (triangleDto.getAngleA() != null ? 1 : 0) +
                (triangleDto.getAngleB() != null ? 1 : 0) +
                (triangleDto.getAngleC() != null ? 1 : 0);
        return anglesCount >= 2;
    }

    private boolean oneSideOneAdjacentAngleCase(TriangleDto triangleDto) {
        return (triangleDto.getSideAB() != null && (triangleDto.getAngleA() != null || triangleDto.getAngleB() != null)) ||
                (triangleDto.getSideBC() != null && (triangleDto.getAngleB() != null || triangleDto.getAngleC() != null)) ||
                (triangleDto.getSideCA() != null && (triangleDto.getAngleC() != null || triangleDto.getAngleA() != null));
    }

    private boolean oneSideCase(TriangleDto triangleDto) {
        int sidesCount = (triangleDto.getSideAB() != null ? 1 : 0) +
                (triangleDto.getSideBC() != null ? 1 : 0) +
                (triangleDto.getSideCA() != null ? 1 : 0);
        return sidesCount == 1 && (triangleDto.getAngleA() == null && triangleDto.getAngleB() == null && triangleDto.getAngleC() == null);
    }

    private boolean oneAngleCase(TriangleDto triangleDto) {
        int anglesCount = (triangleDto.getAngleA() != null ? 1 : 0) +
                (triangleDto.getAngleB() != null ? 1 : 0) +
                (triangleDto.getAngleC() != null ? 1 : 0);
        return anglesCount == 1 && (triangleDto.getSideAB() == null && triangleDto.getSideBC() == null && triangleDto.getSideCA() == null);
    }
}
