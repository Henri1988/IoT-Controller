package com.example.iotcontroller.domain.asset;

import com.example.iotcontroller.domain.asset.Asset;
import com.example.iotcontroller.domain.asset.AssetDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AssetMapper {
    Asset assetDtoToAsset(AssetDto assetDto);

    AssetDto assetToAssetDto(Asset asset);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Asset updateAssetFromAssetDto(AssetDto assetDto, @MappingTarget Asset asset);
}
