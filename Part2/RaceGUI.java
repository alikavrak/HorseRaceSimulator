// RaceGUI.java

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class RaceGUI extends JFrame {

    private JButton startRaceButton;
    private JTextField trackLengthField;
    private JComboBox<Integer> laneCountComboBox;
    private JComboBox<String> weatherComboBox;
    private JComboBox<String> trackTypeComboBox;
    private JPanel horseSelectionPanel;
    private JTextField[] horseNameFields;
    private JComboBox<String>[] horseSymbolBoxes;

    public RaceGUI() {
        setTitle("Horse Race Simulator");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel settingsPanel = new JPanel(new GridLayout(5, 2, 10, 10));

        settingsPanel.add(new JLabel("Track Length:"));
        trackLengthField = new JTextField(10);
        settingsPanel.add(trackLengthField);

        settingsPanel.add(new JLabel("Number of Lanes:"));
        Integer[] laneOptions = {2, 3, 4, 5, 6, 7, 8, 9, 10};
        laneCountComboBox = new JComboBox<>(laneOptions);
        settingsPanel.add(laneCountComboBox);

        settingsPanel.add(new JLabel("Weather Conditions:"));
        String[] weatherOptions = {"Dry", "Muddy", "Wet"};
        weatherComboBox = new JComboBox<>(weatherOptions);
        settingsPanel.add(weatherComboBox);

        settingsPanel.add(new JLabel("Track Type:"));
        String[] trackTypes = {"Dirt", "Grass", "Asphalt"};
        trackTypeComboBox = new JComboBox<>(trackTypes);
        settingsPanel.add(trackTypeComboBox);

        startRaceButton = new JButton("Start Race");
        settingsPanel.add(startRaceButton);

        add(settingsPanel, BorderLayout.NORTH);

        horseSelectionPanel = new JPanel();
        horseSelectionPanel.setLayout(new BoxLayout(horseSelectionPanel, BoxLayout.Y_AXIS));
        add(new JScrollPane(horseSelectionPanel), BorderLayout.CENTER);

        laneCountComboBox.addActionListener(e -> generateHorseInputs());
        startRaceButton.addActionListener(e -> startRace());

        setVisible(true);
    }

    private void generateHorseInputs() {
        horseSelectionPanel.removeAll();
        int numberOfLanes = (Integer) laneCountComboBox.getSelectedItem();
        horseNameFields = new JTextField[numberOfLanes];
        horseSymbolBoxes = new JComboBox[numberOfLanes];
        String[] horseSymbols = {"♞", "♘", "⚔", "🐎", "🦄", "🐴", "🏇", "🛡️"};

        for (int i = 0; i < numberOfLanes; i++) {
            JPanel row = new JPanel(new FlowLayout());
            horseNameFields[i] = new JTextField(10);
            horseSymbolBoxes[i] = new JComboBox<>(horseSymbols);
            row.add(new JLabel("Horse " + (i + 1) + " Name:"));
            row.add(horseNameFields[i]);
            row.add(new JLabel("Symbol:"));
            row.add(horseSymbolBoxes[i]);
            horseSelectionPanel.add(row);
        }

        horseSelectionPanel.revalidate();
        horseSelectionPanel.repaint();
    }

    private void startRace() {
        try {
            int trackLength = Integer.parseInt(trackLengthField.getText());
            int numberOfLanes = (Integer) laneCountComboBox.getSelectedItem();
            String weather = (String) weatherComboBox.getSelectedItem();
            String trackType = (String) trackTypeComboBox.getSelectedItem();

            ArrayList<String> horseNames = new ArrayList<>();
            ArrayList<String> horseSymbols = new ArrayList<>();

            String[] randomHorseNames = {
                    "Thunderbolt", "Silver Arrow", "Night Fury", "Desert King",
                    "Stormchaser", "Midnight Sun", "Golden Hoof", "Shadow Runner",
                    "Wind Spirit", "Crimson Blaze", "Mystic Rider", "Dark Comet"
            };
            Random random = new Random();

            for (int i = 0; i < numberOfLanes; i++) {
                String name = horseNameFields[i].getText();
                if (name.trim().isEmpty()) {
                    name = randomHorseNames[random.nextInt(randomHorseNames.length)];
                }

                String symbol = (String) horseSymbolBoxes[i].getSelectedItem();
                if (symbol == null) {
                    symbol = "♞";
                }

                horseNames.add(name);
                horseSymbols.add(symbol);
            }

            new RaceTrackGUI(trackLength, horseNames, horseSymbols, weather, trackType);
            dispose();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for Track Length!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new RaceGUI();
    }
}
