package com.example.iotcontroller.controller;
import com.example.iotcontroller.domain.asset.AssetDto;
import com.example.iotcontroller.service.AssetService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/asset")
public class AssetController {

    @Resource
    private AssetService assetService;


    @PostMapping("/create")
    @Operation(summary = "Creates new asset")
    public AssetDto createAsset(@RequestBody AssetDto assetDto){
        return assetService.createAsset(assetDto);
    }

    @GetMapping("/getAll")
    @Operation(summary = "Gets all assets")
    public List<AssetDto>getAllAssets(){
        return assetService.getAllAssets();
    }

    @GetMapping("/get/byId")
    @Operation(summary = "Gets asset by Id")
    public AssetDto getAssetById(@RequestParam Integer id){
        return assetService.getAssetById(id);
    }

    @PutMapping("/update/byId")
    @Operation(summary = "Updates asset by id")
    public void updateAssetById(@RequestParam Integer id, @RequestBody AssetDto assetDto){
        assetService.updateAssetById(id, assetDto);
    }

    @DeleteMapping("/delete/byId")
    @Operation(summary = "Deletes asset by id")
    public void deleteAssetById(@RequestParam Integer id){
        assetService.deleteAssetById(id);
    }

}
