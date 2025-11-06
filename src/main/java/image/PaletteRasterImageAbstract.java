package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImageAbstract extends RasterImage {
    private List<Color> palette;
    private int[][] indexesOfColors;

    public PaletteRasterImageAbstract(Color color, int width , int height){
        super(color, width, height);
    }
    public PaletteRasterImageAbstract(Color[][] colors){
        super(colors);
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

}
