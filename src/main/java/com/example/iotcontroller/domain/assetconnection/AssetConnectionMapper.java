package com.example.iotcontroller.domain.assetconnection;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AssetConnectionMapper {
    @Mapping(source = "sourceAssetId", target = "sourceAsset.id")
    @Mapping(source = "sourceAssetName", target = "sourceAsset.name")
    @Mapping(source = "sourceAssetRole", target = "sourceAsset.role")
    @Mapping(source = "targetAssetId", target = "targetAsset.id")
    @Mapping(source = "targetAssetName", target = "targetAsset.name")
    @Mapping(source = "targetAssetRole", target = "targetAsset.role")
    @Mapping(target = "id", ignore = true)
    AssetConnection toEntity(AssetConnectionDto assetConnectionDto);

    @InheritInverseConfiguration(name = "toEntity")
    AssetConnectionDto toDto(AssetConnection assetConnection);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AssetConnection updateEntity(AssetConnectionDto assetConnectionDto, @MappingTarget AssetConnection assetConnection);
}
