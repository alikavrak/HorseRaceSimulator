Horse Race Simulator
This Java project simulates a horse race using both textual and graphical interfaces.
It is developed in three parts as described in the coursework brief:

Part I: Core Racing Simulation (Text-based logic)

Part II: GUI Module Development (Graphical simulation with Swing)

Part III: Git Integration (Version control with Git & GitHub)

How to Run the Project
You can run both versions from the terminal using the following steps.

Part I - Textual Simulation
Navigate to the Part1 folder:
cd Part1

Compile the Java files:
javac *.java

Run the simulation:
java Part1.Main

This version runs in the console and shows textual progress of the race.

Part II - GUI Simulation
Navigate to the Part2 folder:
cd ../Part2

Compile the Java files:
javac *.java

Run the simulation:
java RaceGUI

This version launches a graphical user interface where you can:

Select number of horses and their symbols

Choose weather and track type

Observe a real-time race simulation

Technologies Used
Java SE 8+

Swing (for GUI)

Git & GitHub (version control)

Testing
The project includes a test file (HorseTest.java) under Part1 which verifies key functionality of the Horse class, such as:

Movement

Falling logic

Confidence adjustments

Project Structure
HorseRaceSimulator/
│
├── Part1/
│ ├── Horse.java
│ ├── Race.java
│ ├── HorseTest.java
│ └── Main.java
│
├── Part2/
│ ├── RaceGUI.java
│ └── RaceTrackGUI.java
│
├── README.md
├── Report.pdf
└── .git/

Notes
All files have been uploaded to a Git repository.

A separate development branch (gui-development) was used for GUI enhancements and merged back to main.

The project is also available on GitHub:
https://github.com/alikavrak/HorseRaceSimulator