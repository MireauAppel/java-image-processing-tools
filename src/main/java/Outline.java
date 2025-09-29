public class Outline implements Transform {
    public static double Threshold = 0.025;

    @Override
    public void applyTo(GrayImage image) {
        double difference = Math.abs(image.getPixelGrayColor(int x, int y));
        return;
    }

}
