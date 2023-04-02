import edu.princeton.cs.stdlib.StdDraw;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Lineas();
    }

    public static void Lineas(){

        double min = -1.0;
        double max = 1.0;

        StdDraw.setXscale(min,max);
        StdDraw.setYscale(min,max);

        StdDraw.enableDoubleBuffering();

        Color[] colores = {Color.BLACK, Color.BLUE, Color.CYAN, Color.RED};

        int contadorLineas = 0;

        double x0 = min + (max- min) * Math.random();
        double y0 = min + (max- min) * Math.random();

        double x1 = min + (max- min) * Math.random();
        double y1 = min + (max- min) * Math.random();

        while (contadorLineas < 6){

            int random = (int) (Math.random() * colores.length);
            Color color = colores[random];
            StdDraw.setPenColor(color);

            StdDraw.line(x0, y0, x1, y1);
            StdDraw.show();

            contadorLineas++;

            x0 = x0 + 0.025;
            y0 = y0 + 0.025;
            x1 = x1 + 0.025;
            y1 = y1 + 0.025;
        }
    }
}