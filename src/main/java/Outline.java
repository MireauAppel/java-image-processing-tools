public class Outline implements Transform {
    public static double Threshold = 0.05;

    @Override
    public void applyTo(GrayImage image) {
        for (int x = 0; x < image.getWidth()-1; x++) {
            for (int y = 0; y < image.getHeight()-1; y++) {
                double differenceRight = Math.abs(image.getPixelGrayColor(x+1, y).getLuminosity()-image.getPixelGrayColor(x, y).getLuminosity());
                double differenceBelow = Math.abs(image.getPixelGrayColor(x, y+1).getLuminosity()-image.getPixelGrayColor(x, y).getLuminosity());
                if (differenceRight > Threshold || differenceBelow > Threshold) {
                    image.setPixel(image.getPixelGrayColor(x, y).outline(), x, y);
                }
                else {
                    image.setPixel(image.getPixelGrayColor(x, y).noOutline(), x, y);
                }
            }
        }
    }

}
