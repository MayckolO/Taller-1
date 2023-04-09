import com.sun.source.doctree.SerialDataTree;
import edu.princeton.cs.stdlib.StdDraw;

import java.awt.*;

/**
 * Programa screensaver
 *
 * @author Mayckol Olivares Donoso
 */
public class Main {

    /**
     * The Main
     */
    public static void main(String[] args) {
        panel();
    }

    /**
     * Subprograma para crear un panel
     */
    public static void panel(){

        //Rango de dibujo
        double min = -1.0;
        double max = 1.0;

        //Definición de la escala del panel
        StdDraw.setXscale(min,max);
        StdDraw.setYscale(min,max);

        //Evitar el parpadeo de la pantalla
        StdDraw.enableDoubleBuffering();

        //Subprograma para generar las líneas en el panel
        lineas();
    }

    /**
     * Subprograma para crear líneas
     */
    public static void lineas(){

        //Rango de dibujo
        double min = -1.0;
        double max = 1.0;

        //Definición de la escala del panel
        StdDraw.setXscale(min,max);
        StdDraw.setYscale(min,max);

        //Evitar el parpadeo de la pantalla
        StdDraw.enableDoubleBuffering();

        Color[] colores = {Color.BLACK,Color.BLUE,Color.CYAN,Color.RED,Color.DARK_GRAY,Color.GREEN,Color.MAGENTA,Color.ORANGE,Color.PINK,Color.YELLOW};

        //Generación por un par ordenado (x,y)
        double x0 = min + (max - min) * Math.random();
        double y0 = min + (max- min) * Math.random();

        double x1 = min + (max- min) * Math.random();
        double y1 = min + (max- min) * Math.random();

        //Velocidad inicial
        double velocidadX0 = 0.09;
        double velocidadY0 = 0.03;
        double velocidadX1 = 0.09;
        double velocidadY1 = 0.03;

        //Ciclo infinito
        while (true){

            //Colisión
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

            //Selecciona el color de la linea al azar
            int random = (int) (Math.random() * colores.length);
            Color color = colores[random];
            StdDraw.setPenColor(color);

            int contador = 0;

            //Ciclo para generar 6 líneas
            while (contador < 6){

                //Actualización de posición
                x0 += velocidadX0;
                y0 += velocidadY0;
                x1 += velocidadX1;
                y1 += velocidadY1;

                //Dibujar la linea
                StdDraw.line(x0,y0,x1,y1);
                StdDraw.show();
                StdDraw.pause(100);

                contador++;
            }
            //Limpiar el panel
            StdDraw.clear();
        }
    }
}