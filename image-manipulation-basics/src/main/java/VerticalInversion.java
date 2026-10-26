public class VerticalInversion implements Transform{

    public void applyTo(GrayImage image){

        for(int x = 0; x < image.getWidth() ; x++){
            for(int y = 1; y < (image.getHeight()/2)-1; y++){
                GrayColor temp = image.getPixelGrayColor(x,y);
                image.setPixel(image.getPixelGrayColor(x,image.getHeight()-y), x, y);
                image.setPixel(temp, x, image.getHeight()-y);

            }
        }
    }

}
