package examples.nxtcamv5;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.device.NXTCamV5;
import lejos.hardware.port.SensorPort;
import lejos.robotics.geometry.Rectangle;
import lejos.robotics.geometry.Rectangle2D;
import lejos.utility.Delay;

/**
 * Created by jabrena on 30/7/17.
 */
public class RectanglesDemo {

    public static void main(String[] args){

        System.out.println("NXTCamV5 Track Object Demo");

        final NXTCamV5 camera = new NXTCamV5(SensorPort.S1);

        int counter = 0;
        while (Button.ESCAPE.isUp()) {
            counter++;
            System.out.println("Iteration: " + counter);

            int trackedObject = camera.getNumberOfObjects();
            System.out.println(trackedObject);

            if(trackedObject > 0) {
                for(int x = 0; x < trackedObject; x++){
                    Rectangle2D rectangle = camera.getRectangle(x);
                    System.out.print("W: " + rectangle.getWidth() + " ");
                    System.out.print("H: " + rectangle.getHeight() + " ");
                    System.out.print("X: " + rectangle.getX() + " ");
                    System.out.print("Y: " + rectangle.getY() + "\n");
                }

                Sound.beep();
            }

            Delay.msDelay(1000);
        }

    }
}
