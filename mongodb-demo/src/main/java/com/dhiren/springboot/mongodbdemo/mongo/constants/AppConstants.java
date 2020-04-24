package com.dhiren.springboot.mongodbdemo.mongo.constants;

public enum AppConstants {

    DELIMITER(" of "),
    USERNAME("dhiren"),
    PASSWORD("zxcvbnm"),
    DATABASE_NAME("mongodemo"),
    TTL_COLUMN("expiryTime");

    private String type;

    AppConstants(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
