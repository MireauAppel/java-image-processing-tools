package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SparseRasterImage extends RasterImage {
    private Map<Point, Color> colorMap;

    public SparseRasterImage(Color color, int width , int height){
        super(color, width, height);
    }
    public SparseRasterImage(Color[][] colors){
        super(colors);
    }
    public void createRepresentation(){
        this.colorMap = new HashMap<Point, Color>();
    }

    public void setPixelColor(Color color, int x, int y){
        this.colorMap.put(new Point(x, y), color);
    }

    public Color getPixelColor(int x, int y){
        return this.colorMap.get(new Point(x, y));
    }

}
