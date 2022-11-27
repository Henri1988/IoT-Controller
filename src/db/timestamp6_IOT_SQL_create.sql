-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-11-27 16:32:46.597

-- tables
-- Table: asset
CREATE TABLE asset (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    role varchar(255)  NOT NULL,
    CONSTRAINT asset_pk PRIMARY KEY (id)
);

-- Table: asset_connection
CREATE TABLE asset_connection (
    id serial  NOT NULL,
    source_asset_id int  NOT NULL,
    target_asset_id int  NOT NULL,
    created_at time  NOT NULL,
    interval_ms int  NOT NULL,
    CONSTRAINT asset_connection_pk PRIMARY KEY (id)
);

-- Table: asset_metrics
CREATE TABLE asset_metrics (
    id serial  NOT NULL,
    value int  NOT NULL,
    metrics_time timestamp(6)  NOT NULL,
    asset_connection_id int  NOT NULL,
    CONSTRAINT asset_metrics_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: asset_metrics_asset_connection (table: asset_metrics)
ALTER TABLE asset_metrics ADD CONSTRAINT asset_metrics_asset_connection
    FOREIGN KEY (asset_connection_id)
    REFERENCES asset_connection (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: source_asset_id_fk (table: asset_connection)
ALTER TABLE asset_connection ADD CONSTRAINT source_asset_id_fk
    FOREIGN KEY (source_asset_id)
    REFERENCES asset (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: target_asset_id_fk (table: asset_connection)
ALTER TABLE asset_connection ADD CONSTRAINT target_asset_id_fk
    FOREIGN KEY (target_asset_id)
    REFERENCES asset (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

