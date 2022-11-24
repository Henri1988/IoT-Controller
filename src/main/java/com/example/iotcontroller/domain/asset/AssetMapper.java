package com.example.iotcontroller.domain.asset;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AssetMapper {
    @Mapping(target = "id", ignore = true)
    Asset toEntity(AssetDto assetDto);

    AssetDto toDto(Asset asset);

    List<AssetDto>toDtos(List<Asset>assets);

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(AssetDto assetDto, @MappingTarget Asset asset);
}
