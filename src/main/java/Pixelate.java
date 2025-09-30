public class Pixelate implements Transform {
    public static int newPixelSize = 10;
    // taille de luminy.jpg : 1333x1000 px (width*height) //

    public void applyTo(GrayImage image) {
        /* Variables :
            (int i, int j) : i-ème carré (horizontalement) et (j-ième carré horizontalement);
            (int x, int y) : coordonées (allant de 0 à newPixelSize-1) à l'INTERIEUR d'un carré;
            double somme : somme de tous pixels (grayLevel) d'un carré;
            int iteration : compte le nombre d'itération et donc le nombre de pixel dans un carré
                        (différent de newPixelSize*newPixelSize car cela ne gèrerait pas les bordures);
            double moyenne : somme/itération, moyenne d'UN carré
         */

        double somme;
        int iteration;

        for (int i = 0; i < image.getWidth(); i = i + newPixelSize) {
            for (int j = 0; j < image.getHeight(); j = j + newPixelSize) {

                //// Pixelisation d'UN carré ////
                // ETAPE 1 : moyenne du carré actuel
                somme = 0;
                iteration = 0;
                for (int x = 0; (x < newPixelSize) && (x+i < image.getWidth()); x++) { // 0 à 9 compris
                    for (int y = 0; (y < newPixelSize) && (y+j < image.getHeight()); y++) { // 0 à 9 compris
                        somme += image.getPixelGrayColor(x + i, y + j).getLuminosity() * 255; // sum of everything
                        iteration++;
                    }
                }
                // ETAPE 2 : mettre tous pixel du carré à Moyenne
                GrayColor moyenne = new ByteGrayColor((somme/iteration)/255) ; // vraie moyenne du carré
                for (int x = 0; (x < newPixelSize) && (x+i < image.getWidth()); x++) { // 0 à 9 compris
                    for (int y = 0; (y < newPixelSize) && (y+j < image.getHeight()); y++) { // 0 à 9 compris
                        image.setPixel(moyenne, x + i, y + j);
                    }
                }

            }
        }

    }


}
