package com.example.iotcontroller.domain.asset;

import com.example.iotcontroller.domain.asset.Asset;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link Asset} entity
 */
@Data
public class AssetDto implements Serializable {
    private final Integer id;
    @Size(max = 255)
    @NotNull
    private final String name;
    @Size(max = 255)
    @NotNull
    private final String role;
}