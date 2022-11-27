package com.example.iotcontroller.controller;
import com.example.iotcontroller.domain.assetconnection.AssetConnectionDto;
import com.example.iotcontroller.domain.assetmetrics.AssetMetricDto;
import com.example.iotcontroller.service.AssetConnectionService;
import com.example.iotcontroller.service.AssetMetricsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Slf4j
@RestController
@RequestMapping("/connection")
public class AssetConnectionController {

    @Resource
    private AssetConnectionService assetConnectionService;

    @Resource
    private AssetMetricsService assetMetricsService;


    @PostMapping(value = "/create/{sourceAssetId}/{targetAssetId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AssetConnectionDto> createConnection(@PathVariable int sourceAssetId, @PathVariable int targetAssetId) throws Exception {
        log.info("Session between assets started!");
        return ResponseEntity.ok(assetConnectionService.createConnection(sourceAssetId, targetAssetId));
    }

    @PostMapping("/{connectionId}/metrics")
    public ResponseEntity<?> saveAssetMetrics (@PathVariable Integer connectionId,  @RequestBody AssetMetricDto assetMetricDto ) throws Exception {
        assetMetricsService.save(connectionId, assetMetricDto);
        return ResponseEntity.noContent().build();
    }

}
