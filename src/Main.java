import java.util.*;
import java.util.stream.Collectors;

public class Main{
    public static void main(String[] args) {
        // Задание 1
        Random random = new Random();
        int[] carYears = new int[50];
        for (int i = 0; i < carYears.length; i++) {
            carYears[i] = random.nextInt(26) + 2000;
        }

        System.out.println("Машины, выпущенные после 2015 года:");
        int sum = 0;
        for (int carYear : carYears) {
            if (carYear > 2015) {
                System.out.println(carYear);
            }
            sum += carYear;
        }

        double averageAge = 2025 - (double) sum / carYears.length;
        System.out.println("\nСредний возраст авто: " + averageAge);

        // Задание 2
        List<String> carModels = new ArrayList<>(Arrays.asList(
                "Skoda Rapid", "Subaru Outback", "Mazda CX-30", "Skoda Rapid",
                "Suzuki Vitara", "Citroën C4", "Subaru Outback", "Kia Stinger",
                "Nissan Juke", "Mazda CX-30", "Renault Arkana", "Skoda Rapid",
                "Mitsubishi Eclipse Cross", "Subaru Outback", "Citroën C4",
                "Suzuki Vitara", "Mazda CX-30", "Kia Stinger", "Subaru Outback",
                "Tesla Model 3", "Tesla Model S", "Audi A4", "Tesla Model X"
        ));

        Set<String> uniqueSet = new LinkedHashSet<>(carModels);
        List<String> uniqueList = new ArrayList<>(uniqueSet);
        uniqueList.sort(Comparator.reverseOrder());
        System.out.println("Отсортированные уникальные модели:");
        for (String model : uniqueList) {
            System.out.println(model);
        }
        Set<String> resultSet = new LinkedHashSet<>();

        for (String model : uniqueList) {
            if (model.contains("Tesla")) {
                resultSet.add("ELECTRO_CAR");
            } else {
                resultSet.add(model);
            }
        }
        System.out.println("\nРезультат в Set:\n" + resultSet);

        // Задание 3
        Set<Car> cars = new HashSet<>();
        cars.add(new Car("VIN01", "Camry", "Toyota", 2022, 30000, 25000));
        cars.add(new Car("VIN02", "X5", "BMW", 2023, 10000, 65000));
        cars.add(new Car("VIN03", "A5", "Audi", 2021, 51000, 28000));
        cars.add(new Car("VIN04", "Model 3", "Tesla", 2024, 20000, 52000));
        cars.add(new Car("VIN05", "Q5", "Audi", 2020, 65000, 40000));
        cars.add(new Car("VIN01", "Corolla", "Toyota", 2024, 5000, 30000)); // дубликат
        System.out.println("\nКоличество машин в HashSet: " + cars.size());

        List<Car> sortedCars = new ArrayList<>(cars);
        Collections.sort(sortedCars);
        System.out.println("\nРезультат сортировки по году выпуска (от новых к старым):");
        sortedCars.forEach(System.out::println);

        // Задание 4
        List<Car> carsList = new ArrayList<>(cars);
        System.out.println("\nМашины с пробегом < 50 000:");
        carsList.stream()
                .filter(c -> c.getMileage() < 50000)
                .forEach(System.out::println);

        System.out.println("\nТоп-3 самые дорогие машины (по убыванию):");
        carsList.stream()
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .limit(3)
                .forEach(System.out::println);

        double avgMileage = carsList.stream()
                .mapToInt(Car::getMileage)
                .average()
                .orElse(0);
        System.out.println("\nСредний пробег: " + avgMileage);

        Map<String, List<Car>> byManufacturer = carsList.stream()
                .collect(Collectors.groupingBy(Car::getManufacturer));
        System.out.println("\nГруппировка по производителю:");
        byManufacturer.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(System.out::println);
        });
    }
}
