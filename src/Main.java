public class Main {
    public static void main(String[] args) {
        HotelService service = new HotelService();

        EconomyRoom eco = new EconomyRoom(101, 2, 3000);
        StandardRoom std = new StandardRoom(202, 3, 5000);
        LuxRoom lux = new LuxRoom(303, 4, 8000);
        UltraLuxRoom ultra = new UltraLuxRoom(404, 5, 12000);

        EconomyRoom ecoRandom = new EconomyRoom(105, 2500);
        System.out.println("Конструктор со случайным maxPeople:\n" + ecoRandom);
        System.out.println("Сгенерировано человек: " + ecoRandom.getMaxPeople() + "\n");

        // Room room = new Room(1, 2, 1000);
        // ProRoom pro = new ProRoom(2, 3, 2000);
        // Проверка, что нельзя создать (т.к. Room и ProRoom абстрактны)

        System.out.println("Проверка EconomyRoom");
        System.out.println(eco);
        service.clean(eco);
        service.reserve(eco);
        System.out.println("После брони: " + eco.isBooked());
        service.free(eco);
        System.out.println("После освобождения: " + eco.isBooked());

        System.out.println("\nПроверка LuxRoom");
        System.out.println(lux);
        service.reserve(lux);
        System.out.println("После брони: " + lux.isBooked());
        service.free(lux);
        System.out.println("После освобождения: " + lux.isBooked());

        System.out.println("\nПроверка UltraLuxRoom");
        System.out.println(ultra);
        service.clean(ultra);
        service.reserve(ultra);
        System.out.println("После брони: " + ultra.isBooked());
        service.free(ultra);
        System.out.println("После освобождения: " + ultra.isBooked());

        System.out.println("\nПроверка StandardRoom и исключения");
        System.out.println(std);
        service.reserve(std);
        System.out.println("После брони: " + std.isBooked());

        try {
            service.reserve(std); // повторная бронь
        } catch (RoomAlreadyBookedException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        service.free(std);
        System.out.println("После освобождения: " + std.isBooked());
    }
}