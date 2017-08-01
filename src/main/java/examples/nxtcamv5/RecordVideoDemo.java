package examples.nxtcamv5;

import lejos.hardware.device.NXTCam;
import lejos.hardware.device.NXTCamV5;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

/**
 * Created by jabrena on 30/7/17.
 */
public class RecordVideoDemo {

    public static void main(String[] args){

        System.out.println("NXTCamV5 create Video Demo");

        final NXTCamV5 camera = new NXTCamV5(SensorPort.S1);

        System.out.println("Creating video");
        camera.createVideo();

        Delay.msDelay(20000);
        System.out.println("End process");

        camera.close();
        System.exit(0);
    }
}
