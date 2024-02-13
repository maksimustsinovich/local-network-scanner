package by.ustsinovich.localnetworkscanner.model;

import javafx.beans.property.SimpleStringProperty;

public class NetworkData {
    private final SimpleStringProperty mac;
    private final SimpleStringProperty name;

    public NetworkData(String mac, String name) {
        this.mac = new SimpleStringProperty(mac);
        this.name = new SimpleStringProperty(name);
    }

    public String getMac() {
        return mac.get();
    }

    public SimpleStringProperty macProperty() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac.set(mac);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
