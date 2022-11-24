package com.example.iotcontroller.domain.assetconnection;

import com.example.iotcontroller.domain.assetconnection.AssetConnection;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link AssetConnection} entity
 */
@Data
@NoArgsConstructor
public class AssetConnectionDto implements Serializable {
    private Integer id;
    private Integer sourceAssetId;
    private String sourceAssetName;
    private String sourceAssetRole;
    private Integer targetAssetId;
    private String targetAssetName;
    private String targetAssetRole;
    private Instant createdAt;
    private Integer intervalMs;
}