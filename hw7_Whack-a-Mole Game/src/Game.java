import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;


/**
 * Whack A Mole game.
 * @author Xi Chen
 *
 */
public class Game {
    /**
     * Hit string constant.
     */
    private static final String HIT = ":-(";
    /**
     * On string constant.
     */
    private static final String UP = ":-)";
    /**
     * Down string constant.
     */
    private static final String DOWN = " ";
    /**
     * On color constant.
     */
    private static final Color UP_COLOR = Color.GREEN;
    /**
     * Hit color constant.
     */
    private static final Color HIT_COLOR = Color.RED;
    /**
     * Down color constant.
     */
    private static final Color DOWN_COLOR = Color.LIGHT_GRAY;
    /**
     * Array of buttons to show on and off.
     */
    private JButton[] buttons;
    /**
     * Random object to pick a button from the array.
     */
    private Random random = new Random();
    /**
     * Start button.
     */
    private JButton startButton;
    /**
     * time textarea.
     */
    private JTextArea timeArea;
    /**
     * score textarea.
     */
    private JTextArea scoreArea;
    /**
     * time integer.
     */
    private int time;
    /**
     * score time.
     */
    private int score;
    /**
     * Construtor. GUI for the game.
     */
    public Game() {
        Font font = new Font(Font.MONOSPACED, Font.BOLD, 14);

        // create a window
        JFrame window = new JFrame("Whack-a-mole Game");
        window.setSize(760, 470);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        // create a container
        JPanel pane = new JPanel();
        //pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        JPanel part1 = new JPanel();
        part1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        pane.add(part1);
        JPanel part2 = new JPanel();
        part2.setLayout(new GridLayout(8, 8, 8, 8));
        pane.add(part2);
        //
        //Instantiate an ActionLister
        //
        ActionListener listener = new MyActionListener();
        //Set Border
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        //
        //Set Font
        //
        Font font4 = new Font(Font.SERIF, Font.BOLD, 18);
        Font font2 = new Font(Font.SERIF, Font.ROMAN_BASELINE, 18);
        Font font3 = new Font(Font.SERIF, Font.ROMAN_BASELINE, 17);
        // create and add components to the container
        buttons = new JButton[64];
        for (int i = 0; i < buttons.length; i++) {
            // set every button to default state (neither walk nor stop)
            buttons[i] = new JButton(DOWN);
            buttons[i].setBackground(Color.LIGHT_GRAY);
            buttons[i].setFont(font);
            buttons[i].setOpaque(true);
            buttons[i].setPreferredSize(new Dimension(80, 30));
            buttons[i].addActionListener(listener);
            part2.add(buttons[i]);
        }
        //
        //Part1
        //
        JLabel label = new JLabel("Time Left:");
        JLabel label2 = new JLabel("Score:");
        label.setFont(font2);
        label2.setFont(font2);
        timeArea = new JTextArea(0, 8);
        timeArea.setLineWrap(true);
        timeArea.setWrapStyleWord(true);
        timeArea.setEditable(false);
        timeArea.setFont(font3);
        timeArea.setBorder(border);
        scoreArea = new JTextArea(0, 8);
        scoreArea.setLineWrap(true);
        scoreArea.setWrapStyleWord(true);
        scoreArea.setEditable(false);
        scoreArea.setFont(font3);
        scoreArea.setBorder(border);
        startButton = new JButton("Start");
        startButton.setPreferredSize(new Dimension(100, 30));
        startButton.setBorder(BorderFactory.createRaisedBevelBorder());
        startButton.setFont(font2);
        startButton.addActionListener(listener);
        part1.add(startButton);
        part1.add(label);
        part1.add(timeArea);
        part1.add(label2);
        part1.add(scoreArea);
        // set window's content pane to be the container
        window.setContentPane(pane);
        window.setVisible(true);

    }
    /**
     * Action listener which can performed the incident.
     * @author Xi Chen
     *
     */
    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            Thread[] molesThread = new Thread[buttons.length];
            startButton.setEnabled(false);
            if (event.getSource() == startButton) {
                time = 21;
                score = 0;
                //timeArea.setText(Integer.toString(time));
                scoreArea.setText(String.valueOf(score));
                Runnable timer = new MyRunnable();
                Thread timerCount = new Thread(timer);
                timerCount.start();
                int len = buttons.length;
                //System.out.println(buttons.length);
                for (int i = 0; i < len; i++) {
                    int randomLightNum = random.nextInt(len);
                    // pick a button from an array of JButtons
                    JButton b = buttons[randomLightNum];
                    molesThread[i] = new MyThread(b);
                    molesThread[i].start();
                }
                }
               for (int j = 0; j < 64; j++) {
                   if (time >= 0 && buttons[j].getText().equals(UP)
                           && event.getSource() == buttons[j]) {
                       score = score + 1;
                       scoreArea.setText(Integer.toString(score));
                       buttons[j].setText(HIT);
                       buttons[j].setBackground(HIT_COLOR);
                   }
               }
            }
        }
    /**
     * Runnable for the timer.
     * @author Xi Chen
     *
     */
    public class MyRunnable implements Runnable {
        // unique state per runnable instance
        /**
         * Constructor.
         */
        public MyRunnable() {
        }
        /**
         * Implementation of run method of Runnable Interface.
         */
        @Override
        public void run() {
            try {
                while (time >= 0) {
                    Thread.sleep(1000);
                    time = time - 1;
                    timeArea.setText(String.valueOf(time));
                }
                timeArea.setText("");
                Thread.sleep(5000);
                scoreArea.setText("");
                startButton.setEnabled(true);
        } catch (InterruptedException e) {
            throw new AssertionError(e);
        }
        }
    }
    /**
     * another way to multithread.
     * @author Xi Chen
     *
     */
    private class MyThread extends Thread {
        /**
         * button connect to thread.
         */
        private JButton aButton;
/**
 * Constructor for button.
 * @param c Buttons
 */
        MyThread(JButton c) {
            aButton = c;
        }

        /**
         * Implementation of run method of Runnable Interface.
         * Thread class implements Runnable Interface
         */
        @Override
        public void run() {
            synchronized (aButton) {
            try {
                while (time >= 0) {
                int upTime = random.nextInt(4000);
                int downTime = random.nextInt(4000);
                if (upTime <= 1500) {
                    upTime = 1500;
                }
                if (downTime <= 2000) {
                    downTime = 2000;
                }
                if (aButton.getText().equals(DOWN)) {
                    Thread.sleep(downTime);
                    aButton.setText(UP);
                    aButton.setBackground(UP_COLOR);
                } else if (aButton.getText().equals(HIT)) {
                    Thread.sleep(1500);
                    aButton.setText(DOWN);
                    aButton.setBackground(DOWN_COLOR);
                } else {
                    Thread.sleep(upTime);
                    aButton.setText(DOWN);
                    aButton.setBackground(DOWN_COLOR);
                }
                }
                } catch (InterruptedException e) {
                    throw new AssertionError(e);
                }
                aButton.setText(DOWN);
                aButton.setBackground(DOWN_COLOR);
            }
        }
    }
/** game object.
 * @param args args
 * instantiate ags args.
 */
    public static void main(String[] args) {
        new Game();
    }
}



