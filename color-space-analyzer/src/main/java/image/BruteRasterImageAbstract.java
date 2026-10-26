package image;

import javafx.scene.paint.Color;

public class BruteRasterImageAbstract extends RasterImage {
    private Color[][] pixels;

    public BruteRasterImageAbstract(Color color, int width , int height){
        super(color, width, height);
    }
    public BruteRasterImageAbstract(Color[][] colors){
        super(colors);
    }
    public void createRepresentation(){
        this.pixels = new Color[width][height];
    }

    public void setPixelColor(Color color, int x, int y){
        this.pixels[x][y] = color;
    }
    public Color getPixelColor(int x, int y){
        return this.pixels[x][y];
    }
}
