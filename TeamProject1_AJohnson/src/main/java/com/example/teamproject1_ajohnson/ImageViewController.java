package com.example.teamproject1_ajohnson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.*;
import javafx.stage.FileChooser;
import java.io.File;

public class ImageViewController {
    @FXML
    // originalImage = picture
    private ImageView originalImage;

    @FXML
    // transformedImage = picture1
    private ImageView transformedImage;

    public void onLoadImageButtonClick(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);

        Image image = new Image(selectedFile.toURI().toString());
        originalImage.setImage(image);
    }

    public void onGrayScaleButtonClick(ActionEvent actionEvent) {
        Image image = originalImage.getImage();
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
        transformedImage.setImage(grayscaleImage);
    }

    public void onSepiaButtonClick(ActionEvent actionEvent) {
    }

    public void onInvertColorsButtonClick(ActionEvent actionEvent) {
        Image image = originalImage.getImage();
        PixelReader pixelReader = image.getPixelReader();
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();

        WritableImage teamChoice = new WritableImage(width, height);
        PixelWriter pixelWriter = teamChoice.getPixelWriter();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // invert colors filter
                int color = pixelReader.getArgb(x, y);
                int red = (color >> 16) & 0xff;
                int green = (color >> 8) & 0xff;
                int blue = color & 0xff;
                int inverted = (red + green + blue) / 3;
                int newColor = (inverted << 16) | (inverted << 8) | inverted;
                pixelWriter.setArgb(x, y, -newColor);
            }
        }
        transformedImage.setImage(teamChoice);
    }

    public void onTeamChoiceButtonClick(ActionEvent actionEvent) {
    }


}