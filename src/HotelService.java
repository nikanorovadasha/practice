public class HotelService implements RoomService<Room> {
    @Override
    public void clean(Room room) {
        System.out.println("Комната #" + room.getRoomNumber() + " убрана.");
    }

    @Override
    public void reserve(Room room) throws RoomAlreadyBookedException {
        if (room.isBooked()) {
            throw new RoomAlreadyBookedException("Комната #" + room.getRoomNumber() + " уже забронирована!");
        }
        room.setBooked(true);
        System.out.println("Комната #" + room.getRoomNumber() + " успешно забронирована.");
    }

    @Override
    public void free(Room room) {
        if (!room.isBooked()) {
            System.out.println("Комната #" + room.getRoomNumber() + " и так свободна.");
            return;
        }
        room.setBooked(false);
        System.out.println("Комната #" + room.getRoomNumber() + " освобождена.");
    }
}