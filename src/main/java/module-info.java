module edu.guilford {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;

    opens edu.guilford to javafx.fxml;
    exports edu.guilford;
}
