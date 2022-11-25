package com.example.iotcontroller.controller;
import com.example.iotcontroller.domain.assetconnection.AssetConnectionDto;
import com.example.iotcontroller.service.AssetConnectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Slf4j
@RestController
@RequestMapping("/connection")
public class AssetConnectionController {

    @Resource
    private AssetConnectionService assetConnectionService;

//    @PostMapping("/create/{sourceAssetId}/{targetAssetId}")
//    public AssetConnectionDto createConnection(@PathVariable int sourceAssetId, @PathVariable int targetAssetId) {
//        return assetConnectionService.createConnection(sourceAssetId,targetAssetId);
//    }

    @PostMapping(value = "/create/{sourceAssetId}/{targetAssetId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AssetConnectionDto> createConnection(@PathVariable int sourceAssetId, @PathVariable int targetAssetId) throws Exception {
        log.info("Session between assets started!");
        return ResponseEntity.ok(assetConnectionService.createConnection(sourceAssetId, targetAssetId));
    }

    /*
    @PostMapping("/create/{sourceAssetId}/{targetAssetId}")
    public AssetConnectionDto createConnection(@PathVariable int sourceAssetId, @PathVariable int targetAssetId) {
        System.out.println(sourceAssetId);
        System.out.println(targetAssetId);
        var resp = new AssetConnectionDto();
        resp.setId(1003);
        resp.setSourceAssetId(sourceAssetId);
        resp.setTargetAssetId(targetAssetId);

        return resp;
    }*/




}
