module com.example.teamproject1_ajohnson {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.teamproject1_ajohnson to javafx.fxml;
    exports com.example.teamproject1_ajohnson;
}