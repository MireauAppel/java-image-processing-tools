import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

/**
 * Created by Arnaud Labourel on 04/10/2018.
 */
public class Display implements Initializable  {
    @FXML
    private Canvas canvas;

    MatrixGrayImage image;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.image = MatrixGrayImage.createImageFromPGMFile("images/luminy.pgm");
        /// Tâche 3 : inversion couleur
        //Invert invertedImage = new Invert();
        //invertedImage.applyTo(image);

        /// Tâche 4 : baisser le niveau de gris
        //DecreaseGrayLevels decreasedImage = new DecreaseGrayLevels();
        //decreasedImage.applyTo(image);

        /// Tâche 5 : mettre des outlines
        //Outline outlinedImage = new Outline();
        //outlinedImage.applyTo(image);

        /// Tâche 6 : pixeliser les images
        //Pixelate pixelatedImage = new Pixelate();
        //pixelatedImage.applyTo(image);

        /// Tâche 7 : composite des tâches précédentes
        //CompositeTransform compositeTransform = new CompositeTransform();
        //compositeTransform.applyTo(image);

        /// Tâche supplémentaire : inversion horizontalement ou/et verticalement
        //HorizontalInversion XinvertedImage = new HorizontalInversion();
        //XinvertedImage.applyTo(image);
        //VerticalInversion YinvertedImage = new VerticalInversion();
        //YinvertedImage.applyTo(image);

        render();
    }

    public void render() {
        int pixelWidth = image.getWidth();
        int pixelHeight = image.getHeight();

        canvas.setWidth(pixelWidth);
        canvas.setHeight(pixelHeight);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        PixelWriter pixelWriter = graphicsContext.getPixelWriter();

        for (int i = 0; i < pixelWidth; i++) {
            for (int j = 0; j < pixelHeight; j++) {
                renderPixel(i,j, pixelWriter);
            }
        }
    }

    private void renderPixel(int x, int y, PixelWriter pixelWriter) {
        pixelWriter.setColor(x, y, image.getPixelColor(x, y));
    }

}
