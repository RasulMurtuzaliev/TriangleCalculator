package Spar.TriangleCalculator.service;

import Spar.TriangleCalculator.dto.TriangleCalculateDto;
import Spar.TriangleCalculator.dto.TriangleDto;
import Spar.TriangleCalculator.dto.TriangleTypeBySides;
import Spar.TriangleCalculator.dto.TriangleTypeByAngles;
import Spar.TriangleCalculator.mapper.TriangleMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TriangleCalculateServiceTest {

    @InjectMocks
    private TriangleCalculateService triangleCalculateService;

    @Mock
    private TriangleDataService triangleDataService;

    @Spy
    private TriangleMapper triangleMapper = Mappers.getMapper(TriangleMapper.class);

    @Test
    void testCalculate() {
        TriangleDto triangleDto = TriangleDto.builder()
                .sideAB(5.0)
                .sideBC(10.0)
                .sideCA(7.0)
                .angleA(112.0)
                .angleB(41.0)
                .angleC(28.0)
                .build();
        TriangleCalculateDto triangleCalculateDto = triangleMapper.toCalculateDto(triangleDto);

        when(triangleDataService.completeTriangleData(triangleDto)).thenReturn(triangleDto);
        when(triangleMapper.toCalculateDto(triangleDto)).thenReturn(triangleCalculateDto);

        TriangleCalculateDto result = triangleCalculateService.calculate(triangleDto);

        assertEquals(5.0, result.getSideAB());
        assertEquals(22.0, result.getPerimeter());
        assertEquals(16.0, (double) Math.round(result.getArea()));
        assertEquals(TriangleTypeBySides.SCALENE, result.getTypeBySides());
        assertEquals(TriangleTypeByAngles.OBTUSE, result.getTypeByAngles());
        assertEquals(3.0, (double) Math.round(result.getHeightA()));
    }
}
