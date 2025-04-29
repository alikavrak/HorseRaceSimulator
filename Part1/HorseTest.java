package Part1;
public class HorseTest {
    public static void main(String[] args) {
        // 1. Yeni bir at oluştur
        Horse horse = new Horse('♘', "PIPPI", 0.6);

        // 2. Başlangıç değerlerini kontrol et
        System.out.println("Name: " + horse.getName());                  // PIPPI
        System.out.println("Symbol: " + horse.getSymbol());             // ♘
        System.out.println("Confidence: " + horse.getConfidence());     // 0.6
        System.out.println("Distance: " + horse.getDistanceTravelled()); // 0
        System.out.println("Has fallen: " + horse.hasFallen());         // false

        // 3. Atı ilerlet ve mesafeyi kontrol et
        horse.moveForward();
        horse.moveForward();
        System.out.println("Distance after 2 steps: " + horse.getDistanceTravelled()); // 2

        // 4. Atı düşür ve kontrol et
        horse.fall();
        System.out.println("Has fallen after fall(): " + horse.hasFallen()); // true

        // 5. Atı resetle ve tekrar kontrol et
        horse.goBackToStart();
        System.out.println("After reset - Distance: " + horse.getDistanceTravelled()); // 0
        System.out.println("After reset - Has fallen: " + horse.hasFallen()); // false

        // 6. Confidence setter testi
        horse.setConfidence(1.2); // Geçersiz değer, otomatik 1.0 yapılacak
        System.out.println("Confidence after setting 1.2: " + horse.getConfidence()); // 1.0

        // 7. Symbol değişikliği testi
        horse.setSymbol('🐎');
        System.out.println("New symbol: " + horse.getSymbol()); // 🐎
    }
}
