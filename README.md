# phonedesignpattern
An early foray in the use of design patterns through multiple packages. (Namely the 'Observer' and 'Abstract Factory' patterns)
The program (starting from the "main" method of the "Simulation" class, package "eap.simulate") initially asks the user to specify the number of mobile phones that will be subsequently produced on the assembly line, as well as the number of customers who will be created and will wait for the possible production of the phones they are interested in. Customers, randomly, are interested in either a Featurephone or a Smartphone (one of each). Subsequently, an object of the "PhoneShop" class is created, which is essentially responsible for generating the specifications, which must be random, of the mobile phones we want to produce. These phone specifications are transferred to the "PhoneOrderHandler" class, which is responsible for executing their construction and informing interested customers (using the "buildPhones" method). Each customer who has finally received a mobile phone uses it, making a call to a number in the case of a Featurephone or taking a photo in the case of a Smartphone. The program completes by stating how many customers possibly did not receive a mobile phone, according to the requested characteristics, or if there were more customers than phones ordered.

Following is the class diagram of the "eap.simulate" package, for the sake of completeness. The contents of the "Simulate" class are not shown in the image because they are requirements.

Subsequently, there are a number of requirements and assumptions regarding this specific project:

1. The "Simulation" class contains the "main" method, from which the program starts execution and simulates the project:
   a. It has an array ("names") of user names (as many as needed) that will be used (you can leave the array as is).
   b. It asks the user to enter the number of phones that will be ordered to be produced.
   c. It asks the user to enter the number of customers who will wait to receive a mobile phone (maximum 10).
   d. Then, it simulates the PhoneShop store and the customers, choosing a random name for each customer. Furthermore, as mentioned earlier, each customer must be assigned a type of phone (Featurephone or Smartphone) randomly. Each customer (i.e., each name) can receive one phone.
   e. Finally, it prints a report on how many customers did not receive a phone (according to the requested characteristics or if there were more customers than phones ordered).

2. The mobile phone production line supports Featurephones (older type mobile phones without an operating system and camera) and Smartphones (modern mobile phones with an operating system and camera). Specifically, Smartphones have all the features of Featurephones, but additionally have an operating system and camera.

3. The class/interface files related to the Abstract Factory pattern are located in the "eap.abstractfactory" package, the files related to the Observer pattern are located in the "eap.observer" package, while the remaining files related to simulations are in the "eap.simulate" package.

4. Private fields in combination with getters/setters (where needed) are used for better and safer data handling in the project whenever possible.

5. The "DelaySimulator" class has a static method "sleep(int timeInSeconds)" that simulates a time delay for the given time in seconds without using threads.

6. The "PhoneCreationListener" interface is used both in the "PhoneOrderHandler" class and in any other class that wants to declare an interest in monitoring/observing specific objects. Therefore, clients interested in mobile phones implement this interface so that they can be notified, through the "PhoneOrderHandler" class, whenever it happens.

7. The "PhoneOrderHandler" class is responsible for handling orders in terms of their implementation and for informing interested customers. Within the class, creating a new phone is done by calling the "PhoneFactory.getPhone" method. Additionally, it has the "printCreatedPhoneSpecsToTextFile" method, which saves the basic specifications of the phones produced in a text file.

8. The "PhoneShop" class is responsible for generating the specifications of mobile phones (for the fields they have) in a random manner. Additionally, it maintains a list that records the phones for which specifications have been generated (and are to be produced).

9. The "Client" class, which pertains to the customer, is responsible, among other things, for the following when notified of the production of a new mobile phone:
   a. Checking if the received phone is of the type that interests the customer (Featurephone or Smartphone). Having the phone of interest, in the case of a Featurephone, it makes a call to a phone (it doesn't need to be random), while in the case of having a Smartphone, it takes a photo with a chosen resolution and flash usage (it doesn't need to be random) using the "usePhone" method.
   b. Once the customer finds the phone of interest, they should remove the phone from the set of available phones (so that no one else takes it), unregister from the list of interested customers (so as not to be notified again), and remove themselves from the set of customers waiting for a phone (using the "update" method).
   c. Checking and printing whether the phone number received is valid (information is in the "checkNumberValidity" method).
   d. Checking and printing the name of the mobile carrier for the received phone number (information is in the "carriers" array and the "getCarrierName" method, respectively).
