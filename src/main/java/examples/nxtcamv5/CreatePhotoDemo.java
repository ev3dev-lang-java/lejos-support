package examples.nxtcamv5;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.device.NXTCamV5;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

/**
 * Created by jabrena on 30/7/17.
 */
public class CreatePhotoDemo {

    public static void main(String[] args){

        System.out.println("NXTCamV5 create Photo Demo");

        final NXTCamV5 camera = new NXTCamV5(SensorPort.S1);

        while (Button.ESCAPE.isUp()) {

            Button.waitForAnyPress();
            System.out.println("Creating photo");
            camera.createPhoto();
            Sound.buzz();
            Delay.msDelay(500);

        }

        camera.close();
        System.exit(0);
    }
}
