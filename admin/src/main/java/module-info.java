module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.rmi;
    requires org.controlsfx.controls;
    requires java.desktop;
    requires pdfjet;

    opens com.example to javafx.fxml;
    exports com.example;
    opens com.example.Models to javafx.base;
}
