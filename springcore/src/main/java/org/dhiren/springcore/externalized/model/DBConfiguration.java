package org.dhiren.springcore.externalized.model;

public class DBConfiguration {
    private String dbServer;
    private String dbPort;
    private String dbUser;
    private String dbPass;

    public DBConfiguration(String dbServer, String dbPort, String dbUser, String dbPass) {
        this.dbServer = dbServer;
        this.dbPort = dbPort;
        this.dbUser = dbUser;
        this.dbPass = dbPass;
    }

    @Override
    public String toString() {
        return "DBConfiguration{" +
                "dbServer='" + dbServer + '\'' +
                ", dbPort='" + dbPort + '\'' +
                ", dbUser='" + dbUser + '\'' +
                ", dbPass='" + dbPass + '\'' +
                '}';
    }
}
