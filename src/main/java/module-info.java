module kirgaard.addressparsing {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens kirgaard.addressparsing to javafx.fxml;
    exports kirgaard.addressparsing;

    opens kirgaard.addressparsing.Controller to javafx.fxml;
    exports kirgaard.addressparsing.Controller;
}