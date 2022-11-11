package parkingLot.entities;

public class Car {
    String vehicleNumber;
    String vehicleColour;

    public Car(String vehicleNumber, String vehicleColour) {
        this.vehicleColour =vehicleColour;
        this.vehicleNumber =vehicleNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
            "vehicleNumber='" + vehicleNumber + '\'' +
            ", vehicleColour='" + vehicleColour + '\'' +
            '}';
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleColour() {
        return vehicleColour;
    }

    public void setVehicleColour(String vehicleColour) {
        this.vehicleColour = vehicleColour;
    }
}
