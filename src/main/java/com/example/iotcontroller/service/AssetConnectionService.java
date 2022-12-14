package com.example.iotcontroller.service;
import com.example.iotcontroller.domain.asset.Asset;
import com.example.iotcontroller.domain.asset.AssetDto;
import com.example.iotcontroller.domain.asset.AssetMapper;
import com.example.iotcontroller.domain.asset.AssetRepository;
import com.example.iotcontroller.domain.assetconnection.AssetConnection;
import com.example.iotcontroller.domain.assetconnection.AssetConnectionDto;
import com.example.iotcontroller.domain.assetconnection.AssetConnectionMapper;
import com.example.iotcontroller.domain.assetconnection.AssetConnectionRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class AssetConnectionService {

    @Resource
    private AssetService assetService;

    @Resource
    private AssetMapper assetMapper;

    @Resource
    private AssetConnectionRepository assetConnectionRepository;

    @Resource
    private AssetConnectionMapper assetConnectionMapper;

    @Resource
    private AssetRepository assetRepository;

    public AssetConnectionDto createConnection(int sourceAssetId, int targetAssetId) {
        AssetConnection assetConnection = new AssetConnection();

        Asset machine = assetRepository.findAssetById(sourceAssetId);
        assetConnection.setSourceAsset(machine);

        Asset device = assetRepository.findAssetById(targetAssetId);
        assetConnection.setTargetAsset(device);
        assetConnection.setCreatedAt(Instant.now());
        assetConnection.setIntervalMs(5000);

        assetConnectionRepository.save(assetConnection);

        return assetConnectionMapper.toDto(assetConnection);

    }

    public AssetConnection findConnectionById(Integer id){
        return assetConnectionRepository.findAssetConnectionById(id);
    }

}
