package by.ustsinovich.localnetworkscanner.view;

import by.ustsinovich.localnetworkscanner.model.NetworkData;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainView {
    private final TableView<NetworkData> table;
    private final TextField nameField;
    private final TextField ipField;
    private final TextField macField;

    public MainView(TableView<NetworkData> table, TextField nameField, TextField ipField, TextField macField) {
        this.table = table;
        this.nameField = nameField;
        this.ipField = ipField;
        this.macField = macField;
    }

    public void clear() {
        table.getItems().clear();
        nameField.setText("");
        ipField.setText("");
        macField.setText("");
    }

    public void addData(NetworkData data) {
        table.getItems().add(data);
    }

    public void update(String ip, String name, String mac) {
        nameField.setText(name);
        ipField.setText(ip);
        macField.setText(mac);
    }
}
