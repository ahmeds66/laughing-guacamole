module com.ares.mpjfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    requires java.sql;
    requires mysql.connector.java;


    opens com.ares.mpjfx to javafx.fxml;
    exports com.ares.mpjfx;
}