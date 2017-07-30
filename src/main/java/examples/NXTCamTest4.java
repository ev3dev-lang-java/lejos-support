package examples;

import lejos.hardware.device.NXTCam;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

/**
 * Created by jabrena on 30/7/17.
 */
public class NXTCamTest4 {

    public static void main(String[] args){

        System.out.println("NXTCamV5 V5 Demo");

        final NXTCam camera = new NXTCam(SensorPort.S1);
        camera.sendCommand('M');

        Delay.msDelay(5000);

        camera.sendCommand('P');

        Delay.msDelay(1000);

        camera.close();
        System.exit(0);

    }
}
