import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.Timer;
import javax.swing.border.Border;

public class InfoScreen2 extends JFrame implements ActionListener, MouseListener {

    public static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    private JPanel panel = new JPanel();
    private JPanel panel2 = new JPanel();

    private JLabel body = new JLabel();

    private JLabel armTitle = new JLabel("Biceps");
    private JLabel arm2Title = new JLabel("Triceps");
    private JLabel chestTitle = new JLabel("Chest");
    private JLabel chest2Title = new JLabel("Shoulders");
    private JLabel legTitle = new JLabel("Legs");
    private JLabel backTitle = new JLabel("Back");

    // private Timer timer = new Timer(100, this);

    private JPanel arm = new JPanel();
    private JPanel chest = new JPanel();
    private JPanel chest2 = new JPanel();
    private JPanel back = new JPanel();
    private JPanel arm2 = new JPanel();
    private JPanel leg = new JPanel();

    // Box is unused - not used
    private JPanel armBox = new JPanel();
    private JPanel chestBox = new JPanel();
    private JPanel backBox = new JPanel();
    private JPanel arm2Box = new JPanel();
    private JPanel legBox = new JPanel();

    // stores exercises details - not used
    private String armInfo = "";
    private String chestInfo = "";
    private String backInfo = "";
    private String arm2Info = "";
    private String legInfo = "";

    private ArrayList<String> legsList = new ArrayList<String>();
    private ArrayList<String> chestList = new ArrayList<String>();
    private ArrayList<String> backList = new ArrayList<String>();
    private ArrayList<String> shouldersList = new ArrayList<String>();
    private ArrayList<String> bicepsList = new ArrayList<String>();
    private ArrayList<String> tricepsList = new ArrayList<String>();

    // shows exercises
    // private JList<String> armText = new JList<String>();
    // private JList<String> chestText = new JList<String>();
    // private JList<String> backText = new JList<String>();
    // private JList<String> arm2Text = new JList<String>();
    // private JList<String> shouldersText = new JList<String>();
    // private JList<String> legText = new JList<String>();

    // \/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\\
    private JList<String> allText = new JList<String>();

    private JButton showHistory = new JButton("Show History");

    public static int width = (int) dim.getWidth();

    public static int height = (int) dim.getHeight();

    public static int width1 = (int) dim.getWidth();

    private int x = 0;

    private int y = 100;

    boolean inside = false;

    Border border = BorderFactory.createLineBorder(Color.BLACK, 5);

    public InfoScreen2() {

        try {
            Scanner input = new Scanner(new File("res/database/exercises.csv"));
            // input.useDelimiter(",");

            while (input.hasNextLine()) {

                String[] temp = input.nextLine().split(",");

                if (temp[1].equals("legs")) {
                    legsList.add(temp[0]);
                    System.out.println("legs added " + temp[0]);
                }
                if (temp[1].equals("back")) {
                    backList.add(temp[0]);
                    System.out.println("back added " + temp[0]);
                }
                if (temp[1].equals("shoulders")) {
                    shouldersList.add(temp[0]);
                    System.out.println("shoulders added " + temp[0]);
                }
                if (temp[1].equals("chest")) {
                    chestList.add(temp[0]);
                    System.out.println("chest added " + temp[0]);
                }
                if (temp[1].equals("biceps")) {
                    bicepsList.add(temp[0]);
                    System.out.println("bisceps added " + temp[0]);
                }
                if (temp[1].equals("triceps")) {
                    tricepsList.add(temp[0]);
                    System.out.println("triceps added " + temp[0]);
                }

            }
            input.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found.");
        }

        // timer.start();

        setBackground(new Color(57, 173, 189));
        setSize(width1, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        panel.setBounds(0, 0, width - (width - height) + (height / 5), height);
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setBorder(border);
        add(panel);

        panel2.setBounds(width - (width - height) + (height / 5), 0, width - height - (height / 5), height);
        panel2.setBackground(Color.WHITE);
        panel2.setLayout(new BorderLayout());
        panel2.setBorder(border);
        add(panel2);

        body.setIcon(new ImageIcon(new ImageIcon("res/FitBody.jpg").getImage().getScaledInstance(height, height, 0)));
        // body.setLayout(new BorderLayout());
        // body.setVisible(true);
        body.setBounds(5 + (height / 5), 5, height, height);
        panel.add(body);
        // panel.add(body, BorderLayout.CENTER);
        // panel.revalidate();
        // panel.repaint();

        // change location to match image

        arm.setBounds(height / 12, height / 6, 100, 225);
        chest.setBounds(height / 8, height / 6, 225, 180);
        chest2.setBounds(height - (height / 3) - 75, height / 6, 225, 80);
        back.setBounds(height - (height / 3) - 75, height / 4, 225, 200);
        arm2.setBounds(height / 3, height / 6, 100, 225);
        leg.setBounds(height / 8, height / 2, 225, 300);

        // chest.setLayout(new BorderLayout());
        // JPanel chestRight = new JPanel();
        // JPanel chestLeft = new JPanel();
        // chestRight.setBorder(border);
        // chestLeft.setBorder(border);
        // chest.add(chestLeft, BorderLayout.WEST);
        // chest.add(chestRight, BorderLayout.EAST);

        // arm.setForeground(Color.RED);
        // chest.setForeground(Color.RED);
        // back.setForeground(Color.RED);
        // arm2.setForeground(Color.RED);
        // leg.setForeground(Color.RED);

        arm.setBorder(border);
        chest.setBorder(border);
        chest2.setBorder(border);
        back.setBorder(border);
        arm2.setBorder(border);
        leg.setBorder(border);

        arm.addMouseListener(this);
        chest.addMouseListener(this);
        chest2.addMouseListener(this);
        back.addMouseListener(this);
        arm2.addMouseListener(this);
        leg.addMouseListener(this);

        body.add(arm);
        body.add(chest);
        body.add(chest2);
        body.add(back);
        body.add(arm2);
        body.add(leg);

        /*
         * armBox.setBounds(((width / 2) - 270) + 60, ((height / 2) - 200) + 180, 120,
         * 225); chestBox.setBounds(((width / 2) - 270) + 180, ((height / 2) - 200) +
         * 130, 180, 100); backBox.setBounds(((width / 2) - 270) + 180, ((height / 2) -
         * 200) + 250, 180, 100); arm2Box.setBounds(((width / 2) - 270) + 180, ((height
         * / 2) - 200) + 380, 190, 185); legBox.setBounds(((width / 2) - 270) + 180,
         * ((height / 2) - 200) + 580, 190, 165);
         */

        armBox.setBorder(border);
        chestBox.setBorder(border);
        backBox.setBorder(border);
        arm2Box.setBorder(border);
        legBox.setBorder(border);

        showHistory.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 26));
        showHistory.setBounds((width / 10) * 1, (height / 10) * 8, width / 5, height / 11);
        showHistory.addActionListener(this);
        add(showHistory);

        allText.addMouseListener(this);

        // .addMouseListener(this);

        setVisible(true);

        // armText = new JList<String>(toNormalArray(bicepsList));
        // shouldersText = new JList<String>(toNormalArray(shouldersList));
        // chestText = new JList<String>(toNormalArray(chestList));
        // backText = new JList<String>(toNormalArray(backList));
        // arm2Text = new JList<String>(toNormalArray(tricepsList));
        // legText = new JList<String>(toNormalArray(legsList));

        System.out.println("string is " + Arrays.toString(toNormalArray(bicepsList)));

        System.out.println("screen built");

        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        repaint();

    }

    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == arm) {

            allText = new JList<String>(toNormalArray(bicepsList));

            panel2.removeAll();

            allText.setFont(new Font("Arial", Font.BOLD, 20));
            allText.addMouseListener(this);
            allText.setVisible(true);

            armTitle.setFont(new Font("Arial", Font.BOLD, 20));
            armTitle.setVisible(true);

            panel2.add(armTitle, BorderLayout.NORTH);
            panel2.add(allText, BorderLayout.CENTER);

            panel2.revalidate();
            panel2.repaint();

            System.out.println("in arm");

        }
        if (e.getSource() == chest) {

            allText = new JList<String>(toNormalArray(chestList));

            panel2.removeAll();

            allText.setFont(new Font("Arial", Font.BOLD, 20));
            allText.addMouseListener(this);
            allText.setVisible(true);

            chestTitle.setFont(new Font("Arial", Font.BOLD, 20));
            chestTitle.setVisible(true);

            panel2.add(chestTitle, BorderLayout.NORTH);
            panel2.add(allText, BorderLayout.CENTER);

            panel2.revalidate();
            panel2.repaint();

            System.out.println("in chest");

        }
        if (e.getSource() == chest2) {

            allText = new JList<String>(toNormalArray(shouldersList));

            panel2.removeAll();

            allText.setFont(new Font("Arial", Font.BOLD, 20));
            allText.addMouseListener(this);
            allText.setVisible(true);

            chest2Title.setFont(new Font("Arial", Font.BOLD, 20));
            chest2Title.setVisible(true);

            panel2.add(chest2Title, BorderLayout.NORTH);
            panel2.add(allText, BorderLayout.CENTER);

            panel2.revalidate();
            panel2.repaint();

            System.out.println("in chest2");

        }
        if (e.getSource() == back) {

            allText = new JList<String>(toNormalArray(backList));

            panel2.removeAll();

            allText.setFont(new Font("Arial", Font.BOLD, 20));
            allText.addMouseListener(this);
            allText.setVisible(true);

            backTitle.setFont(new Font("Arial", Font.BOLD, 20));
            backTitle.setVisible(true);

            panel2.add(backTitle, BorderLayout.NORTH);
            panel2.add(allText, BorderLayout.CENTER);

            panel2.revalidate();
            panel2.repaint();

            System.out.println("in back");
        }
        if (e.getSource() == arm2) {

            allText = new JList<String>(toNormalArray(tricepsList));

            panel2.removeAll();

            allText.setFont(new Font("Arial", Font.BOLD, 20));
            allText.addMouseListener(this);
            allText.setVisible(true);

            arm2Title.setFont(new Font("Arial", Font.BOLD, 20));
            arm2Title.setVisible(true);

            panel2.add(arm2Title, BorderLayout.NORTH);
            panel2.add(allText, BorderLayout.CENTER);

            panel2.revalidate();
            panel2.repaint();

            System.out.println("in arm2");

        }
        if (e.getSource() == leg) {

            allText = new JList<String>(toNormalArray(legsList));

            panel2.removeAll();

            allText.setFont(new Font("Arial", Font.BOLD, 20));
            allText.addMouseListener(this);
            allText.setVisible(true);

            legTitle.setFont(new Font("Arial", Font.BOLD, 20));
            legTitle.setVisible(true);

            panel2.add(legTitle, BorderLayout.NORTH);
            panel2.add(allText, BorderLayout.CENTER);

            panel2.revalidate();
            panel2.repaint();

            System.out.println("in leg");

        }
        if (e.getSource() == allText) {

            // new Activity(allText.getSelectedValue().toString());
            // Main.currentExercise = allText.getSelectedValue().toString();
            //this.dispose();

            System.out.println("open > " + allText.getSelectedValue().toString());

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public String[] toNormalArray(ArrayList<String> list) {
        String[] arr = new String[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

}
