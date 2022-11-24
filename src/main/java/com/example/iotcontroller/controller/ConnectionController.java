package com.example.iotcontroller.controller;
import com.example.iotcontroller.domain.assetconnection.AssetConnectionDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/connection")
public class ConnectionController {

    @PostMapping("/create/{sourceAssetId}/{targetAssetId}")
    public AssetConnectionDto createConnection(@PathVariable int sourceAssetId, @PathVariable int targetAssetId) {
        System.out.println(sourceAssetId);
        System.out.println(targetAssetId);
        var resp = new AssetConnectionDto();
        resp.setId(1003);
        resp.setSourceAssetId(sourceAssetId);
        resp.setTargetAssetId(targetAssetId);

        return resp;
    }
}
