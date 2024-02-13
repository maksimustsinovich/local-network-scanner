package by.ustsinovich.localnetworkscanner.controller;

import by.ustsinovich.localnetworkscanner.model.NetworkData;
import by.ustsinovich.localnetworkscanner.utils.NetworkDataUtils;
import by.ustsinovich.localnetworkscanner.view.MainView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Collections;

public class MainController {
    @FXML
    public TableColumn<NetworkData, String> nameColumn;
    @FXML
    public TableColumn<NetworkData, String> macColumn;
    @FXML
    public TextField tfName;
    @FXML
    public TextField tfMac;
    @FXML
    public TextField tfIp;
    @FXML
    private TableView<NetworkData> tvInfo;

    @FXML
    public void onBtnRunAction(ActionEvent event) {
        MainView view = new MainView(tvInfo, tfName, tfIp, tfMac);

        view.clear();

        try {
            var networkInterfaces = Collections.list(NetworkInterface.getNetworkInterfaces());

            for (var networkInterface : networkInterfaces) {
                var hardwareAddress = networkInterface.getHardwareAddress();
                var name = networkInterface.getDisplayName();

                var mac = "00-00-00-00-00-00";
                if (hardwareAddress != null) {
                    mac = NetworkDataUtils.macToString(hardwareAddress);
                }

                var data = new NetworkData(mac, name);
                view.addData(data);
            }

            var localhost = InetAddress.getLocalHost();
            var name = localhost.getHostName();
            var ip = localhost.getHostAddress();
            var networkInterface = NetworkInterface.getByInetAddress(localhost);
            var mac = NetworkDataUtils.macToString(networkInterface.getHardwareAddress());

            view.update(ip, name, mac);
        } catch (SocketException | UnknownHostException e) {
            throw new RuntimeException(e);
        }

    }
}