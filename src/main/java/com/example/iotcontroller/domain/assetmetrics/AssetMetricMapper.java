package com.example.iotcontroller.domain.assetmetrics;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AssetMetricMapper {
    @Mapping(source = "assetConnectionIntervalMs", target = "assetConnection.intervalMs")
    @Mapping(target = "id", ignore = true)
    AssetMetric toEntity(AssetMetricDto assetMetricDto);

    @InheritInverseConfiguration(name = "toEntity")
    AssetMetricDto toDto(AssetMetric assetMetric);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AssetMetric updateEntity(AssetMetricDto assetMetricDto, @MappingTarget AssetMetric assetMetric);
}
