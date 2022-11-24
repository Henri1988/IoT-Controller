package com.example.iotcontroller.domain.assetconnection;

import com.example.iotcontroller.domain.assetconnection.AssetConnection;
import com.example.iotcontroller.domain.assetconnection.AssetConnectionDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AssetConnectionMapper {
    @Mapping(source = "sourceAssetId", target = "sourceAsset.id")
    @Mapping(source = "sourceAssetName", target = "sourceAsset.name")
    @Mapping(source = "sourceAssetRole", target = "sourceAsset.role")
    @Mapping(source = "targetAssetId", target = "targetAsset.id")
    @Mapping(source = "targetAssetName", target = "targetAsset.name")
    @Mapping(source = "targetAssetRole", target = "targetAsset.role")
    AssetConnection assetConnectionDtoToAssetConnection(AssetConnectionDto assetConnectionDto);

    @InheritInverseConfiguration(name = "assetConnectionDtoToAssetConnection")
    AssetConnectionDto assetConnectionToAssetConnectionDto(AssetConnection assetConnection);

    @InheritConfiguration(name = "assetConnectionDtoToAssetConnection")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AssetConnection updateAssetConnectionFromAssetConnectionDto(AssetConnectionDto assetConnectionDto, @MappingTarget AssetConnection assetConnection);
}
