package eap.simulate;

import eap.abstractfactory.FeaturePhone;
import eap.abstractfactory.Phone;
import eap.abstractfactory.SmartPhone;
import eap.observer.PhoneCreationListener;
import eap.observer.PhoneOrderHandler;
import eap.simulate.Simulation;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




import eap.abstractfactory.Camera;

public class Client implements PhoneCreationListener {

    private final String name;
    private final Class interestedFor;
    private Phone phone;
    
    /*Για τους παρόχους κινητής τηλεφωνίας έχουμε τις εξής παραδοχές:
    1. Είναι οι 3 που υπάρχουν στην ακόλουθη λίστα
    2. Η Cosmote έχει κινητά που ξεκινάνε 697, 698 και 699, η Vodafone 694, 695 και 696 και η Wind 691,692 και 693.
    3. Κινητά που ξεκινάνε ως 690 θα αναφέρονται ως "Διαφημιστικά".*/
    
    private static final String[] carriers = {"Cosmote", "Vodafone", "Wind"};

    public Phone getPhone() {
        return phone;
    }

    private void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Client(String name, Class interestedFor) {
        this.name = name;
        this.interestedFor = interestedFor;
        PhoneOrderHandler.addListener(this);
    }

    public String getName() {
        return name;
    }

    public Class getInterestedFor() {
        return interestedFor;
    }

    @Override
    public void update(Phone phone) {

        String wantedphone = this.getInterestedFor().getSimpleName(); //Για να μπορεί να εμφανιστεί είδος κινητού στις εκτυπώσεις
        
        
        if (wantedphone.equals(phone.getClass().getSimpleName())) {
            
            if (PhoneOrderHandler.phoneExistsInList(phone)) {

                PhoneOrderHandler.removePhone(phone);
             Simulation.waitingClients.remove(name);
               this.setPhone(phone);
                
                PhoneOrderHandler.removeListener(this);


                System.out.println("\nHi, I am " + name + "(" + wantedphone + ") and I got my new phone!");
                System.out.println("Phone specs: ");
                System.out.println(phone.toString());
                System.out.println("Phone number valid: " + checkNumberValidity(phone.getPhoneNumber()));
                System.out.println("Phone number carrier: " + getCarrierName(phone.getPhoneNumber())); //Έλεγχος εγκυρότητας και ονόματος carrier

                usePhone(phone);
            }
        }
    }

    /*Η μέθοδος χρήσης του κινητού τηλεφώνου θα κάνει τα εξής:
    Στην περίπτωση FeaturePhone θα καλεί τον αριθμό +30123456789
    Στην περίπτωση SmartPhone Θα βγάζει μια φωτογραφία με φλας και ανάλυση 12 MP*/
    
    private void usePhone(Phone phone) {
        if (phone.getClass().getSimpleName().equals("SmartPhone")) {

           
            Camera camera = new Camera(12); //Για διευκόλυνση δημιουργώ camera εδώ διότι δεν είμαι σίγουρος πως θα καλέσω την δημιουργημένη απο το shop.
            camera.setSelectedResolution(12);
            camera.setUseFlash(true);
            camera.takePicture();
            } 
        
        else {

            phone.callNumber("+30123456789");
        }
    }


    public String getCarrierName(String phoneNumber) {     //Ανάλογα με το διακριτικό, η μέθοδος επιστρέφει είτε το όνομα του carrier, είτε Διαφημιστικά

        int tempCarriers = Integer.parseInt(phoneNumber.substring(3, 6));

        if (tempCarriers == 691 || tempCarriers == 692 || tempCarriers == 693) { ///Έλεγχος carrier μέσω συγκρίσεων των πρότων αριθμών με την χρήση του substring.
            return carriers[2];
        } 
        else if (tempCarriers == 694 || tempCarriers == 695 || tempCarriers == 696) {
            return carriers[1]; }
        else if (tempCarriers == 697 || tempCarriers == 698 || tempCarriers == 699) {
            return carriers[0];
        }
        else 
            return "Διαφημιστικό";
    }

    /*Για να είναι έγκυρο ένα κινητό τηλέφωνο πρέπει να ισχύουν ταυτόχρονα τα εξής:
    1. Να ξεκινάει από +3069 (είναι όλα από Ελλάδα και είναι όλα κινητά)
    2. Στη συνέχεια να υπάρχουν ακριβώς 10 αριθμοί
    3. Παραδοχή ότι δεν υπάρχουν κενά (white spaces μεταξύ των αριθμών)*/
    public boolean checkNumberValidity(String phoneNumber) {

        String prefix = "+3069";
    
        if (phoneNumber.substring(0, 5).equals(prefix) && phoneNumber.length() == 13)  {
    
                    return true;
                    
                } else 
            
                    return false;
                }
            
            }
        

    

