package eap.simulate;


import eap.abstractfactory.Camera;
import eap.abstractfactory.FeaturePhone;
import eap.abstractfactory.Phone;
import eap.abstractfactory.SmartPhone;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PhoneShop {
    //Theoretical list of valid manufacturers
    private final String[] manufacturers = new String[]{"Samsung","LG","Apple","Motorola"};
    //Indicative list of operating systems
    private final String[] operatingSystems = new String[]{"Android","iOS","Tizen"};
    private final Random random = new Random();
    //arraylist that stores the informatiom of each created phone
    private final List<Phone> phoneList = new ArrayList<>();
    
    
    
    public int numberOfPhones(){
        return phoneList.size();
    }


    public Phone createPhoneSpec(){
        
       Phone phone;
   
       
       //create random specifications for smart/feauture phone
       
       
        int battery = random.nextInt(4001)+1000; // Battery creation
         
        int wdimens = random.nextInt(3001)+500; // Screen width
        
        int hdimens = random.nextInt(30001)+500; // Screen height
        
        Dimension pdimens = new Dimension(wdimens, hdimens); // Total screen
       

       int PhoneNum = random.nextInt(100000000)+10000000; // Phone number allocation
        
       String PhoneNums = "+3069" + Integer.toString(PhoneNum);
        
        int manuf = random.nextInt(3); // Allocate manufacturer
        
        int OS = random.nextInt(2); //Operating System
        
        int storage = random.nextInt(201)+2;

        int phonetype = random.nextInt(2);
       
       
        
        
       int camres = random.nextInt(101)+12;
       

       
        if (phonetype == 1) {
            phone = new FeaturePhone(battery, pdimens, PhoneNums, manufacturers[manuf], storage);
            phoneList.add(phone);
        } else {

            phone = new SmartPhone(battery, pdimens, PhoneNums, manufacturers[manuf], storage, camres, operatingSystems[OS]);

            phoneList.add(phone);
        }
        
        


    




        return phone;

    }

    
}

    