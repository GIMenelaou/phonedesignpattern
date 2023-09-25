package eap.simulate;


import eap.observer.PhoneOrderHandler;
import eap.abstractfactory.FeaturePhone;
import eap.abstractfactory.Phone;
import eap.abstractfactory.SmartPhone;

import java.util.*;
import java.util.List;
import java.util.Scanner;

public class Simulation {
    //Fixed array of Greek names
    static final String[] names = {"George","Maria","Dimitris","John","Katerina",
                            "Panagiotis","Konstantinos","Christina","Eleni","Petros"};

    static final Class[] availablePhoneTypes = new Class[] {FeaturePhone.class, SmartPhone.class};
    
    static final List<Client> clients = new ArrayList<>();
    
    static Random random = new Random();
   
    
    static int number_of_phones ;
    static int number_of_clients ; 
    
    // Στη μέθοδο main το πρόγραμμα αρχικά ζητά από τον χρήστη να δηλώσει τον αριθμό
    // των κινητών τηλεφώνων που πρόκειται να δοθούν στη συνέχεια στη γραμμή παραγωγής,
    // καθώς και τον αριθμό των πελατών που θα δημιουργηθούν
    // και θα αναμείνουν για την ενδεχόμενη παραγωγή των τηλεφώνων που τους ενδιαφέρουν
    
     static ArrayList<String> waitingClients = new ArrayList<>(); //Λίστα πελατών που αναμένουν τηλέφωνο
    
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in); //Δημιουργία scanner για input χρήστη

       System.out.println("Please enter number of phones to be ordered:");
        number_of_phones = scanner.nextInt();
        
        System.out.println( "Please enter number of clients waiting for new phones (MAX:10) :");
            number_of_clients = scanner.nextInt(); 
            
                 int i = number_of_clients;
        
    while (i >10 || i == 0 ) {
        
        System.out.println( "More than 0, MAX:10 ");
        number_of_clients = scanner.nextInt();  
        i= number_of_clients;
        }
    
    
    
        System.out.println( number_of_phones + " phone orders have been placed by the PhoneShop!");
  
        System.out.println(number_of_clients + " clients are waiting to buy a new phone!");
   

        
        ArrayList<Client> clients = new ArrayList<>();
        Class[] phonetype = {FeaturePhone.class, SmartPhone.class};
        Random random = new Random();
    
         
        int aname,aphone;
        for (int j = 0; j < number_of_clients ; j++) {

            aname = random.nextInt(10);
            aphone = random.nextInt(2);
            waitingClients.add(names[aname]);
            clients.add(new Client(names[aname], phonetype[aphone])); // Random selection of person and phone assignment
        }
     
        
        PhoneShop pshop = new PhoneShop();
        
        
        
        
        
           Phone testpohne;    
        for (int k = 0; k < number_of_phones; k++) {
            testpohne = pshop.createPhoneSpec(); 
            PhoneOrderHandler.addPhone(testpohne);
           
        }
        
         //phone creation
        
        
        
        
        
        
        PhoneOrderHandler.buildPhones();
     
        
                System.out.println("%%%%%----Report----%%%%%");
                System.out.println(waitingClients.size() + " clients did not get a phone...");
                System.out.println("%%%%%--------------%%%%%");
        
        
                //Check waiting list, i.e people without a phone.
        
        
        
        
        
        
        
        
        
     /*Client Abc = new Client("Cde",FeaturePhone.class);
     Abc.checkNumberValidity("+306985692894"); Keep just in case for troubleshooting*/
     
     
     
     
     }
     
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    