package com.example.iotcontroller.service;

import com.example.iotcontroller.domain.assetconnection.AssetConnection;
import com.example.iotcontroller.domain.assetmetrics.AssetMetric;
import com.example.iotcontroller.domain.assetmetrics.AssetMetricDto;
import com.example.iotcontroller.domain.assetmetrics.AssetMetricMapper;
import com.example.iotcontroller.domain.assetmetrics.AssetMetricRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;

@Service
public class AssetMetricsService {

    @Resource
    private AssetMetricMapper assetMetricMapper;

    @Resource
    private AssetConnectionService assetConnectionService;

    @Resource
    private AssetMetricRepository assetMetricRepository;
    public AssetMetricDto save(Integer connectionId, AssetMetricDto assetMetricDto) {
        AssetMetric assetMetric =assetMetricMapper.toEntity(assetMetricDto);
        AssetConnection assetConnection =assetConnectionService.findConnectionById(connectionId);
        assetMetric.setMetricsTime(Instant.now());
        assetMetric.setAssetConnection(assetConnection);
        assetMetricRepository.save(assetMetric);
        return assetMetricMapper.toDto(assetMetric);
    }
}
