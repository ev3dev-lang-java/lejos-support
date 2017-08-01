package lejos.hardware.device;

import lejos.hardware.port.I2CPort;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.I2CSensor;
import lejos.robotics.geometry.Rectangle2D;
import lejos.robotics.geometry.RectangleInt32;

/**
 * Mindsensors NXTCamV5.
 * www.mindsensors.com
 * 
 * @author Juan Antonio Breña Moral
 * 
 */
public class NXTCamV5 extends I2CSensor {

	byte[] buf = new byte[4];

	//MODES

	/**
	 * Used by setTrackingMode() to choose object tracking.
	 */
	public static final char OBJECT_TRACKING = 'B';

	/**
	 * Used by setTrackingMode() to choose face tracking.
	 */
	public static final char FACE_TRACKING = 'F';

	/**
	 * Used by setTrackingMode() to choose eye tracking.
	 */
	public static final char EYE_TRACKING = 'e';

	/**
	 * Used by setTrackingMode() to choose line tracking.
	 */
	public static final char LINE_TRACKING = 'L';

	//CAPABILITIES

	/**
	 * Used to record a short video
	 */
	public static final char TAKE_VIDEO = 'M';

	/**
	 * Used to take a snapshot
	 */
	public static final char TAKE_PHOTO = 'P';

	public NXTCamV5(I2CPort port, int address)
	{
		super(port, address);
	}

	public NXTCamV5(I2CPort port)
	{
		this(port, DEFAULT_I2C_ADDRESS);
	}

    public NXTCamV5(Port port, int address)
    {
        super(port, address, TYPE_LOWSPEED_9V);
    }
    
    public NXTCamV5(Port port)
    {
        this(port, DEFAULT_I2C_ADDRESS);
    }

	/**
	 * Get the number of objects being tracked
	 * 
	 * @return number of objects (0 - 8)
	 */
	public int getNumberOfObjects() {
		getData(0x42, buf, 1);
		return (0xFF & buf[0]);
	}
	
	/**
	 * Choose either object or line tracking mode.
	 * @param mode Use either OBJECT_TRACKING or LINE_TRACKING
	 */
	public void setTrackingMode(char mode) {
		sendCommand(mode);
	}
	
	/**
	 * Get the color number for a tracked object
	 * 
	 * @param id the object number (starting at zero)
	 * @return the color of the object (starting at zero)
	 */
	public int getObjectColor(int id) {
		getData(0x43 + (id * 5), buf, 1);
		return (0xFF & buf[0]);
	}

	/**
	 * Get the rectangle containing a tracked object
	 * 
	 * @param id the object number (starting at zero)
	 * @return the rectangle
	 */
	public Rectangle2D getRectangle(int id) {
		for(int i=0;i<4;i++) buf[i] = 0;
		getData(0x44 + (id * 5), buf, 4);
		return new RectangleInt32(buf[0] & 0xFF, buf[1] & 0xFF,
				(buf[2] & 0xFF) - (buf[0] & 0xFF),
				(buf[3] & 0xFF) - (buf[1] & 0xFF));
	}
	
	/**
	 * Send a single byte command represented by a letter
	 * @param cmd the letter that identifies the command
	 */
	public void sendCommand(char cmd) {
		sendData(0x41, (byte) cmd);
	}

	/**
	 * Create a new video
	 */
	public void createVideo(){
		sendCommand(TAKE_VIDEO);
	}

	/**
	 * Create a photo
	 */
	public void createPhoto(){
		sendCommand(TAKE_PHOTO);
	}
}
