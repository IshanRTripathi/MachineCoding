package parkingLot.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import parkingLot.entities.Car;
import parkingLot.service.ParkingLotService;

public class ParkingLotController {
    private static ParkingLotService parkingLotService;
    public static void main(String[] args) {
        System.out.println("Enter input file location");
        parkingLotService = new ParkingLotService();
        ParkingLotController controller = new ParkingLotController();
        try {
            File file = new File("src/main/java/parkingLot/resources/input.txt");    //creates a new file instance
            FileReader fr = new FileReader(file);   //reads the file
            BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream
            StringBuffer sb = new StringBuffer();    //constructs a string buffer with no characters
            String line;
            while ((line = br.readLine()) != null) {
                controller.processCommand(line);
                sb.append(line);      //appends line to string buffer
                sb.append("\n");     //line feed
            }
            fr.close();    //closes the stream and release the resources
//            System.out.println("Contents of File: ");
//            System.out.println(sb.toString());   //returns a string that textually represents the object
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processCommand(String command) {
        if (command.startsWith("create_parking_lot")){
            parkingLotService.createParkingLot(Integer.parseInt(command.split(" ")[1]));
        } else if (command.startsWith("park ")){
            String[] carDetails = command.split(" ");
            parkingLotService.parkVehicle(new Car(carDetails[1], carDetails[2]));
        } else if(command.startsWith("leave ")){
            parkingLotService.releaseVehicle(Integer.parseInt(command.split(" ")[1]));
        } else if (command.startsWith("status")) {
            parkingLotService.findAllParkedVehicles();
        } else if (command.startsWith("registration_numbers_for_cars_with_colour")){
            parkingLotService.findRegistrationNumberByColor(command.split(" ")[1]);
        } else if(command.startsWith("slot_numbers_for_cars_with_colour")){
            parkingLotService.findSlotByVehicleColor(command.split(" ")[1]);
        } else if(command.startsWith("slot_number_for_registration_number")) {
            parkingLotService.findSlotByRegistrationNumber(command.split(" ")[1]);
        }
    }
}
