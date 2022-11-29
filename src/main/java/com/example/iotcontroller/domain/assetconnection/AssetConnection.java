package com.example.iotcontroller.domain.assetconnection;

import com.example.iotcontroller.domain.asset.Asset;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

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


    @Column(name = "interval_ms", nullable = false)
    private Integer intervalMs;


    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Asset getSourceAsset() {
        return sourceAsset;
    }

    public void setSourceAsset(Asset sourceAsset) {
        this.sourceAsset = sourceAsset;
    }

    public Asset getTargetAsset() {
        return targetAsset;
    }

    public void setTargetAsset(Asset targetAsset) {
        this.targetAsset = targetAsset;
    }

    public Integer getIntervalMs() {
        return intervalMs;
    }

    public void setIntervalMs(Integer intervalMs) {
        this.intervalMs = intervalMs;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

}