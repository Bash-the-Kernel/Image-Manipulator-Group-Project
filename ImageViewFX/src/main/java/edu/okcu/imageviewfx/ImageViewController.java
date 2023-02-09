package edu.okcu.imageviewfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;

public class ImageViewController {
    @FXML
    private ImageView picture;
    @FXML
    private ImageView picture1;

    @FXML
    protected void onLoadImageButtonClick() {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);

        Image image = new Image(selectedFile.toURI().toString());
        picture.setImage(image);
    }
    @FXML
    protected void onDuplicateButtonClick() {
        picture1.setImage(picture.getImage());
    }
}