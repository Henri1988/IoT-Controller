package com.example.iotcontroller.domain.assetmetrics;

import com.example.iotcontroller.domain.assetconnection.AssetConnection;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

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

    @Column(name = "value", nullable = false)
    private Integer value;

    @Column(name = "metrics_time")
    private LocalTime metricsTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "asset_connection_id", nullable = false)
    private AssetConnection assetConnection;


}