-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-11-23 21:00:10.742

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
    created_at timestamp  NOT NULL,
    interval_ms int  NOT NULL,
    CONSTRAINT asset_connection_pk PRIMARY KEY (id)
);

-- foreign keys
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

