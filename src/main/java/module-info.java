module by.ustsinovich.localnetworkscanner {
    requires javafx.controls;
    requires javafx.fxml;


    opens by.ustsinovich.localnetworkscanner to javafx.fxml;
    exports by.ustsinovich.localnetworkscanner;
    exports by.ustsinovich.localnetworkscanner.controller;
    exports by.ustsinovich.localnetworkscanner.model;
    opens by.ustsinovich.localnetworkscanner.controller to javafx.fxml;
}