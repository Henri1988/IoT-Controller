package com.example.iotcontroller.domain.asset;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AssetRepository extends JpaRepository<Asset, Integer> {
    @Query("select a from Asset a where a.id = ?1")
    Asset findAssetById(Integer id);

}