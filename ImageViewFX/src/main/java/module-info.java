module edu.okcu.imageviewfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.okcu.imageviewfx to javafx.fxml;
    exports edu.okcu.imageviewfx;
}