package Part1;
public class Main {
    public static void main(String[] args) {
        // 1. Create the Race
        Race race = new Race(20); // 20 birimlik pist

        // 2. Create and add Horses
        Horse h1 = new Horse('♘', "PIPPI LONGSTOCKING", 0.6);
        Horse h2 = new Horse('♞', "KOKOMO", 0.5);
        Horse h3 = new Horse('⚔', "EL JEFE", 0.4);

        race.addHorse(h1, 1);
        race.addHorse(h2, 2);
        race.addHorse(h3, 3);

        // 3. Start the Race
        race.startRace();
    }
}
