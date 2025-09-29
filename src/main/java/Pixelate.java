public class Pixelate implements Transform {
    public static int newPixelSize = 10;

    public void applyTo(GrayImage image) {
        int moyenne = 0;
        for (int i = 0; i < image.getWidth(); i = i + newPixelSize) {
            for (int j = 0; j < image.getHeight(); j = j + newPixelSize) {
                /* i = i-ème carré horizontalement,
                   j = j-ième carré verticalement */

                //// Pixelisation d'UN carré ////
                // ETAPE 1 : moyenne du carré actuel
                moyenne = 0;
                for (int x = 0; x < newPixelSize; x++) {
                    for (int y = 0; y < newPixelSize; y++) {
                        moyenne = moyenne + (int) image.getPixelGrayColor(x + i, y + j).getLuminosity() * 255; // sum of everything
                    }
                }
                // ETAPE 2 : mettre tous pixel du carré à Moyenne
                moyenne = moyenne / newPixelSize * newPixelSize; // vraie moyenne du carré
                for (int x = 0; x < newPixelSize; x++) {
                    for (int y = 0; y < newPixelSize; y++) {
                        image.setPixel(moyenne, x + i, y + j); // sum of everything
                    }
                }

            }
        }

    }


}
