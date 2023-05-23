package com.rainer.pawel.project.adapters.inbound;

import com.rainer.pawel.project.application.AnimalRepository;
import com.rainer.pawel.project.application.AnimalService;
import com.rainer.pawel.project.domain.Animal;
import com.rainer.pawel.project.domain.AnimalType;
import com.rainer.pawel.project.domain.Name;
import com.rainer.pawel.project.domain.Price;
import com.rainer.pawel.project.domain.PriceRange;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;


import static com.rainer.pawel.project.adapters.inbound.utils.ConsoleUtils.error;
import static com.rainer.pawel.project.adapters.inbound.utils.ConsoleUtils.print;
import static com.rainer.pawel.project.adapters.inbound.utils.ConsoleUtils.println;
import static com.rainer.pawel.project.adapters.inbound.utils.ConsoleUtils.readLine;
import static com.rainer.pawel.project.adapters.inbound.utils.ConsoleUtils.readNumber;
import static com.rainer.pawel.project.adapters.inbound.utils.ConsoleUtils.readUUID;

public class ConsoleLineInterface {

    private final AnimalRepository animalRepository;

    private final AnimalService animalService;

    private final Supplier<UUID> animalIdSupplier;

    public ConsoleLineInterface(AnimalRepository animalRepository, AnimalService animalService,
                                Supplier<UUID> animalIdSupplier) {
        this.animalRepository = animalRepository;
        this.animalService = animalService;
        this.animalIdSupplier = animalIdSupplier;
    }

    public void run() {
        printWelcome();

        while (true) {
            try {
                showMenu();
            } catch (Exception e) {
                error("Command returned an error:");
                error(e.getMessage());
                println();
            }
        }
    }

    private void showMenu() {
        println("Type command to execute:");

        String line = readLine();

        while (line.isBlank()) {
            line = readLine();
        }

        switch (line) {
            case "help" -> printHelp();
            case "add" -> addAnimal();
            case "modify" -> modifyAnimal();
            case "delete" -> deleteAnimal();
            case "find by id" -> findById();
            case "find all" -> findAllWithFilter();
            case "exit" -> System.exit(0);
            default -> println("Unknown command");
        }
    }

    private void printWelcome() {
        println("Welcome to animal catalog");
        println("You can add, modify, delete and view animals here");
        println();
        println("Type `help` to see all commands");
        println();
    }

    private void addAnimal() {
        print("name: ");
        String name = readLine();
        print(String.format("type %s: ", Arrays.toString(AnimalType.values())));
        String type = readLine();
        print("price: ");
        int price = readNumber();

        Animal animal = new Animal(
                animalIdSupplier.get(),
                Name.of(name),
                AnimalType.getAnimalType(type),
                Price.of(price)
        );

        animalRepository.save(animal);

        println("Animal successfully added");
        println();
    }

    private void modifyAnimal() {
        print("id: ");
        UUID id = readUUID();
        print("name: ");
        String name = readLine();
        print(String.format("type %s: ", Arrays.toString(AnimalType.values())));
        String type = readLine();
        print("price: ");
        int price = readNumber();

        Animal animal = new Animal(
                id,
                Name.of(name),
                AnimalType.getAnimalType(type),
                Price.of(price)
        );

        animalRepository.save(animal);

        println("Animal successfully modified");
        println();
    }

    private void deleteAnimal() {
        print("id: ");
        UUID id = readUUID();

        animalRepository.delete(id);

        println("Animal successfully deleted");
        println();
    }

    private void findById() {
        print("id: ");

        UUID id = readUUID();

        println();
        println(animalRepository.findById(id));
        println();
    }

    private void findAllWithFilter() {
        println("Which filter do you want to apply: [none, price range, type]");
        print("filter: ");

        String filter = readLine();

        List<Animal> animals = switch (filter) {
            case "none" -> animalRepository.findAll();
            case "price range" -> findInPriceRange();
            case "type" -> findWithType();
            default -> animalRepository.findAll();
        };

        println();

        for (Animal animal : animals) {
            println(animal);
        }

        println();
        println(String.format("Found %s animals", animals.size()));
        println();
    }

    private List<Animal> findInPriceRange() {
        print("min price: ");
        int minPrice = readNumber();
        print("max price: ");
        int maxPrice = readNumber();

        PriceRange priceRange = PriceRange.of(minPrice, maxPrice);

        return animalService.findAllInPriceRange(priceRange);
    }

    private List<Animal> findWithType() {
        print(String.format("type %s: ", Arrays.toString(AnimalType.values())));
        String rawType = readLine();

        AnimalType type = AnimalType.valueOf(rawType.toUpperCase());

        return animalService.findAllWithType(type);
    }

    private void printHelp() {
        println("-----------  Help  -----------");
        println("");
        println("Type `add` to add animal");
        println("Type `modify` to modify animal");
        println("Type `delete` to delete animal");
        println("Type `find by id` to view animal");
        println("Type `find all` to view all animals");
        println("Type `exit` to exit");
        println();
    }
}
