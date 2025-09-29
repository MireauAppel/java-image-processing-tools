public class CompositeTransform implements Transform{
    @Override
    public void applyTo(GrayImage image) {
        DecreaseGrayLevels decreasedImage = new DecreaseGrayLevels();
        decreasedImage.applyTo(image);
        Outline outlinedImage = new Outline();
        outlinedImage.applyTo(image);
        Invert invertedImage = new Invert();
        invertedImage.applyTo(image);
    }
}
