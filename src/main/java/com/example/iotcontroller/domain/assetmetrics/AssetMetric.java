package com.example.iotcontroller.domain.assetmetrics;

import com.example.iotcontroller.domain.assetconnection.AssetConnection;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
@Entity
@Table(name = "asset_metrics")
public class AssetMetric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "value", nullable = false)
    private Integer value;

    @Column(name = "metrics_time", nullable = false)
    private Instant metricsTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "asset_connection_id", nullable = false)
    private AssetConnection assetConnection;

}