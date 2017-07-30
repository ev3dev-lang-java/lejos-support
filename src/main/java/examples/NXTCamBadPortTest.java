package examples;

import lejos.hardware.device.NXTCam;
import lejos.hardware.port.SensorPort;

/**
 * Created by jabrena on 30/7/17.
 */
public class NXTCamBadPortTest {

    public static void main(String[] args){

        System.out.println("NXTCamV5 V5 Demo");

        final NXTCam camera = new NXTCam(SensorPort.S2);

        /*
        camera.setTrackingMode(NXTCamV5.OBJECT_TRACKING);
        camera.sortBy(NXTCamV5.SIZE);
        camera.enableTracking(true);

        while (Button.waitForAnyPress() == Button.ID_ESCAPE) {
            int trackedObject = camera.getNumberOfObjects();
            System.out.println(trackedObject);
            if(trackedObject > 0) {
                Sound.beep();
            }
        }
        */

    }
}
