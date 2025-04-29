package Part1;
public class Horse {
    private String name;
    private char symbol;
    private int distanceTravelled;
    private boolean hasFallen;
    private double confidence;

    public Horse(char horseSymbol, String horseName, double horseConfidence) {
        this.symbol = horseSymbol;
        this.name = horseName;

        if (horseConfidence < 0) {
            this.confidence = 0;
        } else if (horseConfidence > 1) {
            this.confidence = 1;
        } else {
            this.confidence = horseConfidence;
        }

        this.distanceTravelled = 0;
        this.hasFallen = false;
    }

    public void fall() {
        this.hasFallen = true;
    }

    public double getConfidence() {
        return this.confidence;
    }

    public int getDistanceTravelled() {
        return this.distanceTravelled;
    }

    public String getName() {
        return this.name;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public void goBackToStart() {
        this.distanceTravelled = 0;
        this.hasFallen = false;
    }

    public boolean hasFallen() {
        return this.hasFallen;
    }

    public void moveForward() {
        this.distanceTravelled += 1;
    }

    public void setConfidence(double newConfidence) {
        if (newConfidence < 0) {
            this.confidence = 0;
        } else if (newConfidence > 1) {
            this.confidence = 1;
        } else {
            this.confidence = newConfidence;
        }
    }

    public void setSymbol(char newSymbol) {
        this.symbol = newSymbol;
    }
}
