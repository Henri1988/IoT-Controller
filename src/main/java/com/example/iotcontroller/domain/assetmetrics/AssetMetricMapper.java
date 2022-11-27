package com.example.iotcontroller.domain.assetmetrics;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AssetMetricMapper {
    @Mapping(source = "assetConnectionId", target = "assetConnection.id")
    AssetMetric toEntity(AssetMetricDto assetMetricDto);

    @Mapping(source = "assetConnection.id", target = "assetConnectionId")
    AssetMetricDto toDto(AssetMetric assetMetric);

    @Mapping(source = "assetConnectionId", target = "assetConnection.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AssetMetric updateEntity(AssetMetricDto assetMetricDto, @MappingTarget AssetMetric assetMetric);
}
