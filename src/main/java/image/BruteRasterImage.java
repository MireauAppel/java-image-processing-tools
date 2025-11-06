package image;

import util.Matrices;

import javafx.scene.paint.Color;

public class BruteRasterImage implements Image {
    private int width;
    private int height;
    private Color[][] pixels;

    public BruteRasterImage(Color color, int width, int height){
        this.width = width;
        this.height = height;
        createRepresentation();
        setPixelsColor(color);
    }
    public BruteRasterImage(Color[][] colors){
        Matrices.requiresNonNull(colors);
        Matrices.requiresNonZeroDimensions(colors);
        setWidth(Matrices.getRowCount(colors));
        setHeight(Matrices.getColumnCount(colors));
        createRepresentation();
        setPixelsColor(colors);
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
    private void setPixelsColor(Color[][] pixels){
        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                setPixelColor(pixels[x][y], x, y);
            }
        }
    }
    private void setPixelsColor(Color color){
        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                this.pixels[x][y] = color;
            }
        }
    }
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }
    protected void setWidth(int width){
        this.width = width;
    }
    protected void setHeight(int height){
        this.height = height;
    }
}
