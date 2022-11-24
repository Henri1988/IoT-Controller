package com.example.iotcontroller.domain.asset;

import com.example.iotcontroller.domain.asset.Asset;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link Asset} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AssetDto implements Serializable {
    private  Integer id;
    private  String name;
    private  String role;
}