import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class RaceTrackGUI extends JFrame {
    private int trackLength;
    private ArrayList<String> horseNames;
    private ArrayList<String> horseSymbols;
    private Timer timer;
    private int[] horsePositions;
    private boolean[] horseFallen;
    private boolean raceOver = false;
    private int[] horseSpeeds;
    private int elapsedTime = 0;

    public RaceTrackGUI(int trackLength, ArrayList<String> horseNames, ArrayList<String> horseSymbols, String weather, String trackType) {
        this.trackLength = trackLength;
        this.horseNames = horseNames;
        this.horseSymbols = horseSymbols;

        horsePositions = new int[horseNames.size()];
        horseFallen = new boolean[horseNames.size()];
        horseSpeeds = new int[horseNames.size()];

        Random random = new Random();
        for (int i = 0; i < horseSpeeds.length; i++) {
            horseSpeeds[i] = random.nextInt(6) + 5; // 5-10 arasında hızlar (Daha hızlı ve farklı)
        }

        setTitle("Race Track - " + trackType);
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        timer = new Timer(150, new ActionListener() {  // 150ms'de bir güncelliyoruz (çok daha hızlı)
            @Override
            public void actionPerformed(ActionEvent e) {
                moveHorses();
                repaint();
            }
        });
        timer.start();

        setVisible(true);
    }

    private void moveHorses() {
        if (raceOver) return;

        Random random = new Random();
        boolean anyHorseRunning = false;

        elapsedTime += 150;

        for (int i = 0; i < horsePositions.length; i++) {
            if (!horseFallen[i]) {
                horsePositions[i] += horseSpeeds[i];

                if (elapsedTime >= 5000) { // 5 saniyede bir düşme kontrolü
                    if (random.nextDouble() < 0.1) { // %10 düşme şansı
                        horseFallen[i] = true;
                    }
                }

                if (horsePositions[i] >= getWidth() - 250) {
                    timer.stop();
                    JOptionPane.showMessageDialog(this, horseNames.get(i) + " has won the race!");
                    raceOver = true;
                }
                anyHorseRunning = true;
            }
        }

        if (elapsedTime >= 5000) {
            elapsedTime = 0;
        }

        if (!anyHorseRunning && !raceOver) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "All horses have fallen. No winner!");
            raceOver = true;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (horseNames == null || horseNames.size() == 0) {
            return;
        }

        Graphics2D g2d = (Graphics2D) g;

        int startX = 100;
        int startY = 100;
        int trackWidth = getWidth() - 200;
        int trackHeight = horseNames.size() * 60;

        g2d.setColor(Color.WHITE);
        g2d.fillRect(startX, startY, trackWidth, trackHeight);

        g2d.setColor(Color.BLACK);
        g2d.drawRect(startX, startY, trackWidth, trackHeight);

        for (int i = 0; i <= horseNames.size(); i++) {
            g2d.drawLine(startX, startY + i * 60, startX + trackWidth, startY + i * 60);
        }

        // FONTU BÜYÜTÜYORUZ (At sembolleri büyük çıksın diye)
        g2d.setFont(new Font("Serif", Font.BOLD, 24)); // Font büyüklüğü: 24

        for (int i = 0; i < horseNames.size(); i++) {
            int x = startX + horsePositions[i];
            int y = startY + (i * 60) + 40;

            if (horseFallen[i]) {
                g2d.setColor(Color.RED);
                g2d.drawString("X", x, y);
            } else {
                g2d.setColor(Color.BLACK);
                g2d.drawString(horseSymbols.get(i), x, y);
            }
        }
    }
}
