package eap.abstractfactory;

import java.awt.*;

public class SmartPhone extends Phone{
    private final int batterySize;
    private final Dimension screenSize;
    private final String phoneNumber;
    private final String manufacturer;
    private final int storage;
    private final String operatingSystem;
    private final int camera;
            
    
    
    public SmartPhone(int batterySize, Dimension screenSize, String phoneNumber, String manufacturer, int storage, int camera, String operatingSystem) { //camera as int
        this.batterySize = batterySize;
        this.screenSize = screenSize;
        this.phoneNumber = phoneNumber;
        this.manufacturer = manufacturer;
        this.storage = storage;
        this.operatingSystem = operatingSystem;
        this.camera = camera;
    }

    @Override
    public int getBatterySize() {
        return batterySize;
    }

    @Override
    public Dimension getScreenSize() {
        return screenSize;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public int getStorage() {
        return storage;
    }
    
    
    public String getOperatingSystem(){
        return operatingSystem;
     }
    
    
    public int getCamera(){
        return camera;
    }
   

    
    
     @Override
    public String toString() {
        return "Battery(mAh): "
                + getBatterySize() + "\n"
                + "Screen: "
                + getScreenSize() + "\n"
                + "Number: "
                + getPhoneNumber() + "\n"
                + "Manufacturer: "
                + getManufacturer() + "\n"
                + "Storage(GB): "
                + getStorage() + "\n"
                + "Camera: "
                + getCamera() + " MP" + "\n"
                + "Operation System: "
                + getOperatingSystem();

    }
    
    
    
    
    
    
    
 }
/*

This class extends the Phone class. It contains additional camera characteristics, as well as the operatingSystem string.
 It overrides the tostring method that has been inherited from the Phone class.
The code used the inherited method, filling the fields from the information inputted in the SmartPhone class. 
- essentially the same as Feauture Phone, with the only difference the extra declarations for camera and OS.
*/


