import com.sun.source.doctree.SerialDataTree;
import edu.princeton.cs.stdlib.StdDraw;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        lineas();
    }

    public static void lineas(){

        double min = -1.0;
        double max = 1.0;

        StdDraw.setXscale(min,max);
        StdDraw.setYscale(min,max);

        StdDraw.enableDoubleBuffering();

        Color[] colores = {Color.BLACK,Color.BLUE,Color.CYAN,Color.RED,Color.DARK_GRAY,Color.GREEN,Color.MAGENTA,Color.ORANGE,Color.PINK,Color.YELLOW};

        double x0 = min + (max - min) * Math.random();
        double y0 = min + (max- min) * Math.random();

        double x1 = min + (max- min) * Math.random();
        double y1 = min + (max- min) * Math.random();

        double velocidadX0 = 0.09;
        double velocidadY0 = 0.03;
        double velocidadX1 = 0.09;
        double velocidadY1 = 0.03;

        while (true){

            if(Math.abs(x0 + velocidadX0) > 1.0){
                velocidadX0  = -velocidadX0;
            }

            if(Math.abs(y0 + velocidadY0) > 1.0){
                velocidadY0  = -velocidadY0;
            }

            if(Math.abs(x1 + velocidadX1) > 1.0){
                velocidadX1  = -velocidadX1;
            }

            if(Math.abs(y1 + velocidadY1) > 1.0){
                velocidadY1  = -velocidadY1;
            }

            x0 += velocidadX0;
            y0 += velocidadY0;
            x1 += velocidadX1;
            y1 += velocidadY1;

            int random = (int) (Math.random() * colores.length);
            Color color = colores[random];
            StdDraw.setPenColor(color);

            StdDraw.line(x0,y0,x1,y1);
            StdDraw.show();
            StdDraw.pause(200);
        }
    }
}