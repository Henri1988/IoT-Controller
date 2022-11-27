package com.example.iotcontroller.domain.assetmetrics;

import com.example.iotcontroller.domain.assetconnection.AssetConnection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "asset_metrics")
public class AssetMetric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "value", nullable = false)
    private Integer value;

    @NotNull
    @Column(name = "metrics_time", nullable = false)
    private Instant metricsTime;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "asset_connection_id", nullable = false)
    private AssetConnection assetConnection;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Instant getMetricsTime() {
        return metricsTime;
    }

    public void setMetricsTime(Instant metricsTime) {
        this.metricsTime = metricsTime;
    }

    public AssetConnection getAssetConnection() {
        return assetConnection;
    }

    public void setAssetConnection(AssetConnection assetConnection) {
        this.assetConnection = assetConnection;
    }

}