package com.example.iotcontroller.domain.assetconnection;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalTime;

/**
 * A DTO for the {@link AssetConnection} entity
 */
@Data
public class AssetConnectionDto implements Serializable {
    private final Integer id;
    private final Integer sourceAssetId;
    private final String sourceAssetName;
    private final String sourceAssetRole;
    private final Integer targetAssetId;
    private final String targetAssetName;
    private final String targetAssetRole;
    @NotNull
    private final LocalTime createdAt;
    @NotNull
    private final Integer intervalMs;
}