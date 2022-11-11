package parkingLot.entities;

public class ParkedCar {
    int id;
    Car car;
    String parkedAt;
    String releasedAt;

    public ParkedCar(Integer id, Car car, String parkedAt, String releasedAt) {
        this.id = id;
        this.car = car;
        this.parkedAt = parkedAt;
        this.releasedAt = releasedAt;
    }

    public int getId() {
        return id;
    }

    public Car getCar() {
        return car;
    }

    public String getParkedAt() {
        return parkedAt;
    }

    public String getReleasedAt() {
        return releasedAt;
    }

    public void setReleasedAt(String time) {
        this.releasedAt = time;
    }

    @Override
    public String toString() {
        return car.toString();
    }
}
