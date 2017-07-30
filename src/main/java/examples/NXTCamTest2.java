package examples;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.device.NXTCam;
import lejos.hardware.port.SensorPort;

/**
 * Created by jabrena on 30/7/17.
 */
public class NXTCamTest2 {

    public static void main(String[] args){

        System.out.println("NXTCamV5 V5 Demo");

        final NXTCam camera = new NXTCam(SensorPort.S1);

        camera.setTrackingMode(NXTCam.OBJECT_TRACKING);
        camera.sortBy(NXTCam.SIZE);
        camera.enableTracking(true);

        while (Button.waitForAnyPress() == Button.ID_ESCAPE) {
            int trackedObject = camera.getNumberOfObjects();
            System.out.println(trackedObject);
            if(trackedObject > 0) {
                Sound.beep();
            }
        }

    }
}
