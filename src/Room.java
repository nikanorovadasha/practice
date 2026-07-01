import java.util.Random;

public abstract class Room {
    private int roomNumber;
    private int maxPeople;
    private int pricePerNight;
    private boolean isBooked;

    public Room(int roomNumber, int maxPeople, int pricePerNight) {
        this.roomNumber = roomNumber;
        this.maxPeople = maxPeople;
        this.pricePerNight = pricePerNight;
        this.isBooked = false;
    }

    public Room(int roomNumber, int pricePerNight) {
        this.roomNumber = roomNumber;
        this.maxPeople = new Random().nextInt(4) + 1;
        this.pricePerNight = pricePerNight;
        this.isBooked = false;
    }

    public int getRoomNumber() { return roomNumber; }
    public int getMaxPeople() { return maxPeople; }
    public int getPricePerNight() { return pricePerNight; }
    public boolean isBooked() { return isBooked; }
    public void setBooked(boolean booked) { isBooked = booked; }

    @Override
    public String toString() {
        return "Комната №" + roomNumber +
                "\nмаксимальное количество человек=" + maxPeople +
                "\nцена за ночь=" + pricePerNight +
                "\nзабронирована=" + isBooked;
    }
}