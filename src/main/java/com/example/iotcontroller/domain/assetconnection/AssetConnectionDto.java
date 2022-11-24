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
    @Size(max = 255)
    @NotNull
    private String sourceAssetName;
    @Size(max = 255)
    @NotNull
    private String sourceAssetRole;
    private Integer targetAssetId;
    @Size(max = 255)
    @NotNull
    private String targetAssetName;
    @Size(max = 255)
    @NotNull
    private String targetAssetRole;
    @NotNull
    private Instant createdAt;
    @NotNull
    private Integer intervalMs;
}