package examples.nxtcamv5;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.device.NXTCam;
import lejos.hardware.device.NXTCamV5;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

/**
 * Created by jabrena on 30/7/17.
 */
public class TrackObjectsDemo {

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
                Sound.beep();
            }

            Delay.msDelay(1000);
        }

    }
}
