package edu.okcu.imageviewfx;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.scene.image.*;

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
    protected void onGrayScaleButtonClick() {
        Image image = picture.getImage();
        PixelReader pixelReader = image.getPixelReader();
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();

        WritableImage grayscaleImage = new WritableImage(width, height);
        PixelWriter pixelWriter = grayscaleImage.getPixelWriter();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                int color = pixelReader.getArgb(x, y);
                int red = (color >> 16) & 0xff;
                int green = (color >> 8) & 0xff;
                int blue = color & 0xff;
                int gray = 255 - (red + green + blue) / 3;
                int newColor = (gray << 16) | (gray << 8) | gray;
                pixelWriter.setArgb(x, y, -newColor);
            }
        }
        picture1.setImage(grayscaleImage);
    }
}