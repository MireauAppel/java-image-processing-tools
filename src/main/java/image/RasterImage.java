package image;

import javafx.scene.paint.Color;
import util.Matrices;

public abstract class RasterImage implements Image {
    public int width;
    public int height;

    public RasterImage(Color color, int width , int height){
        this.width = width;
        this.height = height;
        createRepresentation();
        setPixelsColor(color);
    }
    public RasterImage(Color[][] colors){
        Matrices.requiresNonNull(colors);
        Matrices.requiresNonZeroDimensions(colors);
        setWidth(Matrices.getRowCount(colors));
        setHeight(Matrices.getColumnCount(colors));
        createRepresentation();
        setPixelsColor(colors);
    }

    public abstract void createRepresentation();

    public abstract void setPixelColor(Color color, int x, int y);
    private void setPixelsColor(Color[][] pixels){
        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                setPixelColor(pixels[x][y], x, y);
            }
        }
    }

    public abstract Color getPixelColor(int x, int y);

    private void setPixelsColor(Color color){
        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                setPixelColor(color, x, y);
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
