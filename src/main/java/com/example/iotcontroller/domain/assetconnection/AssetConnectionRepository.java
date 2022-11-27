package com.example.iotcontroller.domain.assetconnection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AssetConnectionRepository extends JpaRepository<AssetConnection, Integer> {
    @Query("select a from AssetConnection a where a.id = ?1")
    AssetConnection findAssetConnectionById(Integer id);

}