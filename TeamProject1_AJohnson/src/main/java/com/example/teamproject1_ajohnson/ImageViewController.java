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

    // ImageViewController.java

    @FXML
    protected void onSepiaButtonClick() {
        Image image = originalImage.getImage();
        PixelReader pixelReader = image.getPixelReader();
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();

        WritableImage sepiaImage = new WritableImage(width, height);
        PixelWriter pixelWriter = sepiaImage.getPixelWriter();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                int color = pixelReader.getArgb(x, y);
                int alpha = (color >> 24) & 0xff;
                int red = (color >> 16) & 0xff;
                int green = (color >> 8) & 0xff;
                int blue = color & 0xff;

                int newRed = (int) (0.393 * red + 0.769 * green + 0.189 * blue);
                int newGreen = (int) (0.349 * red + 0.686 * green + 0.168 * blue);
                int newBlue = (int) (0.272 * red + 0.534 * green + 0.131 * blue);

                newRed = Math.min(newRed, 255);
                newGreen = Math.min(newGreen, 255);
                newBlue = Math.min(newBlue, 255);

                int sepia = (alpha << 24) | (newRed << 16) | (newGreen << 8) | newBlue;
                pixelWriter.setArgb(x, y, sepia);
            }
        }
        transformedImage.setImage(sepiaImage);
    }

    // image-view.fxml


    public void RedButtonClick(ActionEvent actionEvent) {
        Image image = originalImage.getImage();
        PixelReader pixelReader = image.getPixelReader();
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();

        WritableImage redscaleImage = new WritableImage(width, height);
        PixelWriter pixelWriter = redscaleImage.getPixelWriter();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                int color = pixelReader.getArgb(x, y);
                int red = (color >> 16) & 0xff;
                int green = (color >> 8) & 0xff;
                int blue = color & 0xff;
                int RED = 0;
                int newGreen = green;
                int newBlue = blue;
                int newColor = (RED << 16) | (newGreen << 8) | newBlue;
                pixelWriter.setArgb(x, y, -newColor);
            }
        }
        transformedImage.setImage(redscaleImage);
    }


}