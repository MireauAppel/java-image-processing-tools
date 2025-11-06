package image;

import javafx.scene.paint.Color;

public class Rectangle implements Shape{
    private Color color;
    private int width;
    private int height;
    private Point coordinate;

    public Rectangle(int x, int y, int width, int height, Color color){
        this.coordinate = new Point(x, y);
        this.width = width;
        this.height = height;
        this.color = color;
    }
    public boolean contains (Point point){
        for (int i = 0; i < this.width; i++){
            for (int j = 0; j < this.height; j++){
                if (point.equals(new Point(i, j))) return true;
            }
        }
        return false;
    }
    public Color getColor(){
        return color;
    }

}
