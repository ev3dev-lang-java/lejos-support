package examples;

import lejos.hardware.device.NXTCam;
import lejos.hardware.port.SensorPort;

/**
 * Created by jabrena on 30/7/17.
 */
public class NXTCamTest1 {

    public static void main(String[] args){

        System.out.println("NXTCamV5 V5 Demo");

        final NXTCam camera = new NXTCam(SensorPort.S1);

    }
}
