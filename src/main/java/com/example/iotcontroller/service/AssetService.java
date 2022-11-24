package com.example.iotcontroller.service;


import com.example.iotcontroller.domain.asset.Asset;
import com.example.iotcontroller.domain.asset.AssetDto;
import com.example.iotcontroller.domain.asset.AssetMapper;
import com.example.iotcontroller.domain.asset.AssetRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AssetService {

    @Resource
    private AssetMapper assetMapper;
    @Resource
    private AssetRepository assetRepository;

    public AssetDto createAsset(AssetDto assetDto) {
        Asset asset =assetMapper.toEntity(assetDto);
        assetRepository.save(asset);
        return assetMapper.toDto(asset);
    }

    public List<AssetDto> getAllAssets() {
        List<Asset> assets = assetRepository.findAll();
        return assetMapper.toDtos(assets);
    }

    public AssetDto getAssetById(Integer id) {
        Asset asset =assetRepository.findAssetById(id);
        return assetMapper.toDto(asset);
    }

    public void updateAssetById(Integer id, AssetDto assetDto) {
        Asset asset = assetRepository.findAssetById(id);
        assetMapper.updateEntity(assetDto, asset);
        assetRepository.save(asset);
    }

    public void deleteAssetById(Integer id) {
        Asset asset = assetRepository.findAssetById(id);
        assetRepository.delete(asset);

    }
}
