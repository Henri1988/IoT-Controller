package com.example.iotcontroller.domain.assetmetrics;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalTime;

/**
 * A DTO for the {@link AssetMetric} entity
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AssetMetricDto implements Serializable {

    private Integer value;
    private LocalTime metricsTime;

    @NotNull
    private Integer assetConnectionIntervalMs;
}