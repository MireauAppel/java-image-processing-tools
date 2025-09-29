public class HorizontalInversion implements Transform{

    public void applyTo(GrayImage image){

        for(int x = 1; x < (image.getWidth()/2)-1 ; x++){
            for(int y = 0; y < image.getHeight(); y++){
                GrayColor temp = image.getPixelGrayColor(x,y);
                image.setPixel(image.getPixelGrayColor(image.getWidth()-x,y), x, y);
                image.setPixel(temp, image.getWidth()-x, y);

            }
        }
    }

}
