package image;

import javafx.scene.paint.Color;
import util.Matrices;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage implements Image{
    private int width;
    private int height;
    private List<Color> palette;
    private int[][] indexesOfColors;

    public PaletteRasterImage(Color color, int width , int height){
        this.width = width;
        this.height = height;
        createRepresentation();
        setPixelsColor(color);
    }

    public PaletteRasterImage(Color[][] colors){
        Matrices.requiresNonNull(colors);
        Matrices.requiresNonZeroDimensions(colors);
        setWidth(Matrices.getRowCount(colors));
        setHeight(Matrices.getColumnCount(colors));
        createRepresentation();
        setPixelsColor(colors);
    }

    public void createRepresentation(){
        this.indexesOfColors = new int[width][height];
        this.palette = new ArrayList<>();
    }

    public void setPixelColor(Color color, int x, int y){
        if (!this.palette.contains(color)){
            this.palette.add(color);
        }
        int PaletteIndex = this.palette.indexOf(color);
        this.indexesOfColors[x][y] = PaletteIndex;
    }

    public Color getPixelColor(int x, int y){
        return this.palette.get(indexesOfColors[x][y]);
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
