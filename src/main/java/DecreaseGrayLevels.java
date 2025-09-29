public class DecreaseGrayLevels implements Transform {
    public static int nbGrayLevels = 5;

    public void applyTo(GrayImage image) {
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                image.setPixel(image.getPixelGrayColor(x, y).splitLuminosity(), x, y);
            }
        }
    }
}