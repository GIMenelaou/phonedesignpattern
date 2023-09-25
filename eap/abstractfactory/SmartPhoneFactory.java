package eap.abstractfactory;

import java.awt.*;



public class SmartPhoneFactory implements PhoneAbstractFactory{
    private final int batterySize;
    private final Dimension screenSize;
    private final String phoneNumber;
    private final String manufacturer;
    private final int storage;
    private final String operatingSystem;
    private final int camera; //int camera

  public SmartPhoneFactory(int batterySize, Dimension screenSize, String phoneNumber, String manufacturer, int storage, int camera, String operatingSystem) {
        this.batterySize = batterySize;
        this.screenSize = screenSize;
        this.phoneNumber = phoneNumber;
        this.manufacturer = manufacturer;
        this.storage = storage;
        this.operatingSystem = operatingSystem;
        this.camera = camera;
    }
  
    @Override
    public Phone createPhone() {
        return new SmartPhone(batterySize,screenSize,phoneNumber,manufacturer,storage,camera,operatingSystem);
    }
}
// Similar to SmartPhone and FeaturePhone implementation