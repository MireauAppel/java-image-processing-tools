import javafx.scene.paint.Color;

/**
 * Created by Arnaud Labourel on 02/10/2018.
 */

public class ByteGrayColor implements GrayColor {

    private static final int MINIMUM_GRAY_LEVEL = 0;
    private static final int MAXIMUM_GRAY_LEVEL = 255;
    private static final int OPACITY = 1;
    public static final int BLACK = MINIMUM_GRAY_LEVEL;
    public static final int WHITE = MAXIMUM_GRAY_LEVEL;

    private final int grayLevel;


    public ByteGrayColor(){
       this.grayLevel = MINIMUM_GRAY_LEVEL;
    }

    public ByteGrayColor(int grayLevel) {
        this.grayLevel = grayLevel;
    }

    public ByteGrayColor(double luminosity) {
        this.grayLevel = (int)(luminosity*255) ;
    }

    @Override
    public double getLuminosity() {
        return (double)this.grayLevel/255;
    }

    @Override
    public Color getColor(){
        double component = getLuminosity();
        return new Color(component, component, component, OPACITY);
    }


    @Override
    public int compareTo(GrayColor o) {
        return Double.compare((double)this.getLuminosity(),o.getLuminosity());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        ByteGrayColor color = (ByteGrayColor) o;
        return grayLevel == color.grayLevel;
    }

    @Override
    public GrayColor invert(){
        return new ByteGrayColor(MAXIMUM_GRAY_LEVEL-grayLevel);
    }

    @Override
    public GrayColor splitLuminosity() {
        double step = (double) 1 / (DecreaseGrayLevels.nbGrayLevels - 1);

        int i = 0;
        while (i < DecreaseGrayLevels.nbGrayLevels - 1){
            if( step * (i) <= this.getLuminosity() && this.getLuminosity() < step * (i+1) ){
                return new ByteGrayColor(step * i );
            }
            i++;
    }
        return new ByteGrayColor(1.00);
    }
}
