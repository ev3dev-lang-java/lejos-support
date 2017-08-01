package examples.nxtcamv5;

import lejos.hardware.Sound;
import lejos.hardware.device.NXTCam;
import lejos.hardware.device.NXTCamV5;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

/**
 * Created by jabrena on 30/7/17.
 */
public class FaceRecognitionDemo {

    public static void main(String[] args){

        System.out.println("NXTCamV5 Face Recognition Demo");

        final NXTCamV5 camera = new NXTCamV5(SensorPort.S1);
        camera.setTrackingMode(NXTCamV5.FACE_TRACKING);

        for(int x = 0; x <= 100; x++){
            System.out.println("Iteration: " + x);

            int trackedObject = camera.getNumberOfObjects();
            System.out.println(trackedObject);

            if(trackedObject > 0) {
                Sound.beep();
            }

            Delay.msDelay(1000);
        }

    }
}
