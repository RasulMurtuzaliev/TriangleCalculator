package Spar.TriangleCalculator.mapper;

import Spar.TriangleCalculator.dto.TriangleCalculateDto;
import Spar.TriangleCalculator.dto.TriangleDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TriangleMapper {

    TriangleCalculateDto toCalculateDto(TriangleDto triangleDto);
}
