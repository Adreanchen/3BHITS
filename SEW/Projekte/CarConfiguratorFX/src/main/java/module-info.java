module at.htlhl.carconfiguratorfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens at.htlhl.carconfiguratorfx to javafx.fxml;
    exports at.htlhl.carconfiguratorfx;
}