package com.example.iotcontroller.domain.assetconnection;

import com.example.iotcontroller.domain.asset.Asset;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
@Entity
@Table(name = "asset_connection")
public class AssetConnection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "source_asset_id", nullable = false)
    private Asset sourceAsset;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "target_asset_id", nullable = false)
    private Asset targetAsset;


    @Column(name = "created_at", nullable = false)
    private Instant createdAt;


    @Column(name = "interval_ms", nullable = false)
    private Integer intervalMs;


}