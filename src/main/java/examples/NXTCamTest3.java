package examples;

import lejos.hardware.device.NXTCam;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

/**
 * Created by jabrena on 30/7/17.
 */
public class NXTCamTest3 {

    public static void main(String[] args){

        System.out.println("NXTCamV5 V5 Demo");

        final NXTCam camera = new NXTCam(SensorPort.S1);
        System.out.println(camera.getFirmwareVersion());
        camera.setTrackingMode('B');
        camera.setTrackingMode('R');

        for(int x = 0; x <= 100; x++){
            System.out.println(x);
            //camera.setTrackingMode('M');
            System.out.println(camera.getNumberOfObjects());
            //camera.
            Delay.msDelay(1000);
        }


    }
}
