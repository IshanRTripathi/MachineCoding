package parkingLot.service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import parkingLot.entities.Car;
import parkingLot.entities.ParkedCar;

public class ParkingLotService {
    List<ParkedCar> parkingHistory;
    PriorityQueue<Integer> availableParkingSlots;
    Integer maximumParkingSpace;
    List<ParkedCar> parkedCars;

    public void createParkingLot(Integer maximumParkingSpace) {
        this.parkingHistory = new ArrayList<>();
        this.maximumParkingSpace = maximumParkingSpace;
        availableParkingSlots = new PriorityQueue<>();
        for(int i=1; i<= maximumParkingSpace; i++){
            availableParkingSlots.add(i);
        }
        parkedCars = new ArrayList<>();
        System.out.println("Created a parking lot with "+maximumParkingSpace+" slots");
    }

    public void releaseVehicle(Integer id) {
        AtomicReference<ParkedCar> carToRelease = new AtomicReference<>();
        Optional.ofNullable(parkedCars.stream().filter(parkedCar -> parkedCar.getId() == id).collect(Collectors.toList()).get(0))
            .ifPresentOrElse((parkedCar) ->{
                parkedCar.setReleasedAt(OffsetDateTime.now().toString());
                carToRelease.set(parkedCar);
            }, () -> {
                System.out.println("No car present at the given parking slot");
                return;
            });
        availableParkingSlots.add(id);
        parkedCars.remove(carToRelease.get());
        parkingHistory.add(carToRelease.get());
        System.out.println("Slot number "+id+" is free");
    }

    public void parkVehicle(Car car) {
        if(availableParkingSlots.isEmpty()){
            System.out.println("Sorry, parking lot is full");
            return;
        }
        Integer slot = availableParkingSlots.remove();
        System.out.println("Allocated slot number: " + slot);
        parkedCars.add(new ParkedCar(slot, car, OffsetDateTime.now().toString(), null));
    }

    public void findRegistrationNumberByColor(String color) {
        List<String> registrationNumbers= parkedCars.stream().filter(parkedCar -> {
            return parkedCar.getCar().getVehicleColour().equals(color);
        }).map(parkedCar -> parkedCar.getCar().getVehicleNumber()).collect(Collectors.toList());
        System.out.println(registrationNumbers);
    }

    public void findSlotByRegistrationNumber(String registrationNumber) {
        parkedCars.stream().filter(parkedCar -> parkedCar.getCar().getVehicleNumber().equals(registrationNumber)).findFirst().ifPresentOrElse(parkedCar -> {
            System.out.println(parkedCar.getId());
        }, () -> {
            System.out.println("Not found");
        });
    }

    public void findSlotByVehicleColor(String color) {
        List<Integer> slots = parkedCars.stream().filter(parkedCar -> {
            return parkedCar.getCar().getVehicleColour().equals(color);
        }).map(parkedCar -> parkedCar.getId()).collect(Collectors.toList());
        System.out.println(slots);
    }

    public void findAllParkedVehicles() {
        System.out.println(parkedCars);
    }
}
