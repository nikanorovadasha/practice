public class StandardRoom extends ProRoom {
    public StandardRoom(int roomNumber, int maxPeople, int pricePerNight) {
        super(roomNumber, maxPeople, pricePerNight);
    }

    public StandardRoom(int roomNumber, int pricePerNight) {
        super(roomNumber, pricePerNight);
    }
}