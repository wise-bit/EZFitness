/**
 * @author Daniel
 * @sub-author Satrajit
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

public class InfoScreen2 extends JFrame implements ActionListener, MouseListener {

    public static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    private JPanel panel = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel buttons = new JPanel();

    private JLabel body = new JLabel();

    private JLabel armTitle = new JLabel("Biceps");
    private JLabel arm2Title = new JLabel("Triceps");
    private JLabel chestTitle = new JLabel("Chest");
    private JLabel chest2Title = new JLabel("Shoulders");
    private JLabel legTitle = new JLabel("Legs");
    private JLabel backTitle = new JLabel("Back");

    private JPanel arm = new JPanel();
    private JPanel chest = new JPanel();
    private JPanel chest2 = new JPanel();
    private JPanel back = new JPanel();
    private JPanel arm2 = new JPanel();
    private JPanel leg = new JPanel();
    private JPanel credits = new JPanel();

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

    // \/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\\
    private JList<String> allText = new JList<String>();

    private JButton showHistory = new JButton("Show History");
    private JButton exit = new JButton("EXIT");
    private JButton modify = new JButton("Modify Entry");
    private JButton addExercise = new JButton("Add Exericse");
    private JButton missedDate = new JButton("Add Missed Date Log");
    private JButton showInfo = new JButton("Initial Profile");
    private JButton tableStuff = new JButton("See What The Numbers Say");

    public static int width = (int) dim.getWidth();

    public static int height = (int) dim.getHeight();

    public static int width1 = (int) dim.getWidth();

    private int x = 0;

    private int y = 100;

    boolean inside = false;

    Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
    Border borderchoose= BorderFactory.createLineBorder(Color.RED, 5);

    public InfoScreen2() {

        for (Exercise e : Main.allExercises) {

            if (Integer.parseInt(e.getIntensity()) <= Integer.parseInt(Main.currentUser.getLevel())) {

                if (e.getBodyPart().equals("legs")) {
                    legsList.add(e.getName());
                    System.out.println("legs added " + e.getName());
                }
                if (e.getBodyPart().equals("back")) {
                    backList.add(e.getName());
                    System.out.println("back added " + e.getName());
                }
                if (e.getBodyPart().equals("shoulders")) {
                    shouldersList.add(e.getName());
                    System.out.println("shoulders added " + e.getName());
                }
                if (e.getBodyPart().equals("chest")) {
                    chestList.add(e.getName());
                    System.out.println("chest added " + e.getName());
                }
                if (e.getBodyPart().equals("biceps")) {
                    bicepsList.add(e.getName());
                    System.out.println("bisceps added " + e.getName());
                }
                if (e.getBodyPart().equals("triceps")) {
                    tricepsList.add(e.getName());
                    System.out.println("triceps added " + e.getName());
                }

            }

        }

        setBackground(new Color(57, 173, 189));
        setSize(width1, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        panel.setBounds(0, 0, width - (width - height) + (height / 5), height - (height / 18));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setBorder(border);
        add(panel);

        panel2.setBounds(width - (width - height) + (height / 5), 0, width - height - (height / 5),
                height - (height / 18));
        panel2.setBackground(Color.WHITE);
        panel2.setLayout(new BorderLayout());
        panel2.setBorder(border);
        add(panel2);

        body.setIcon(new ImageIcon(new ImageIcon("res/FitBody.jpg").getImage().getScaledInstance(height, height, 0)));
        body.setBounds(5 + (height / 5), 5, height, height);
        panel.add(body);

        // change location to match image

        arm.setBounds(height / 12, height / 6, (height / 10), height / 5);
        chest.setBounds((height / 12) + (height / 10), height / 6, height / 7, height / 5);
        chest2.setBounds(height - (height / 3) - (height / 14), height / 6, height / 5, height / 10);
        back.setBounds(height - (height / 3) - (height / 14), height / 4, height / 5, height / 5);
        arm2.setBounds((height / 12) + (height / 10) + (height / 7), height / 6, 100, height / 5);
        leg.setBounds(height / 7, height / 2 - (height / 12), height / 5, height / 5);
        credits.setBounds((height / 12) + (height / 9), height / 20, height / 10, height / 10);

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
        credits.addMouseListener(this);

        arm.setOpaque(false);
        chest.setOpaque(false);
        chest2.setOpaque(false);
        back.setOpaque(false);
        arm2.setOpaque(false);
        leg.setOpaque(false);
        credits.setOpaque(false);

        body.add(arm);
        body.add(chest);
        body.add(chest2);
        body.add(back);
        body.add(arm2);
        body.add(leg);
        body.add(credits);

        armBox.setBorder(border);
        chestBox.setBorder(border);
        backBox.setBorder(border);
        arm2Box.setBorder(border);
        legBox.setBorder(border);

        buttons.setBackground(Color.WHITE);
        buttons.setLayout(new GridLayout(7,1));

        showInfo.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 26));
        showInfo.setPreferredSize(new Dimension(220, 40));
        showInfo.setMinimumSize(new Dimension(220, 40));
        showInfo.setMaximumSize(new Dimension(220, 40));
        showInfo.setBackground(Color.RED);
        showInfo.setForeground(Color.WHITE);
        showInfo.setBorderPainted(false);
        showInfo.addActionListener(this);
        buttons.add(showInfo);
        
        tableStuff.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 26));
        tableStuff.setPreferredSize(new Dimension(220, 40));
        tableStuff.setMinimumSize(new Dimension(220, 40));
        tableStuff.setMaximumSize(new Dimension(220, 40));
        tableStuff.setBackground(Color.RED);
        tableStuff.setForeground(Color.WHITE);
        tableStuff.setBorderPainted(false);
        tableStuff.addActionListener(this);
        buttons.add(tableStuff);

        addExercise.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 26));
        addExercise.setPreferredSize(new Dimension(220, 40));
        addExercise.setMinimumSize(new Dimension(220, 40));
        addExercise.setMaximumSize(new Dimension(220, 40));
        addExercise.setBackground(Color.RED);
        addExercise.setForeground(Color.WHITE);
        addExercise.setBorderPainted(false);
        addExercise.addActionListener(this);
        buttons.add(addExercise);

        modify.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 26));
        modify.setPreferredSize(new Dimension(220, 40));
        modify.setMinimumSize(new Dimension(220, 40));
        modify.setMaximumSize(new Dimension(220, 40));
        modify.setBackground(Color.RED);
        modify.setForeground(Color.WHITE);
        modify.setBorderPainted(false);
        modify.addActionListener(this);
        buttons.add(modify);

        showHistory.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 26));
        showHistory.setPreferredSize(new Dimension(220, 40));
        showHistory.setMinimumSize(new Dimension(220, 40));
        showHistory.setMaximumSize(new Dimension(220, 40));
        showHistory.setBackground(Color.RED);
        showHistory.setForeground(Color.WHITE);
        showHistory.setBorderPainted(false);
        showHistory.addActionListener(this);
        buttons.add(showHistory);

        missedDate.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 26));
        missedDate.setPreferredSize(new Dimension(220, 40));
        missedDate.setMinimumSize(new Dimension(220, 40));
        missedDate.setMaximumSize(new Dimension(220, 40));
        missedDate.setBackground(Color.RED);
        missedDate.setForeground(Color.WHITE);
        missedDate.setBorderPainted(false);
        missedDate.addActionListener(this);
        buttons.add(missedDate);

        exit.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 26));
        exit.setPreferredSize(new Dimension(220, 40));
        exit.setMinimumSize(new Dimension(220, 40));
        exit.setMaximumSize(new Dimension(220, 40));
        exit.setBackground(Color.RED);
        exit.setForeground(Color.WHITE);
        exit.setBorderPainted(false);
        exit.addActionListener(this);
        buttons.add(exit);

        panel2.add(buttons, BorderLayout.SOUTH);

        allText.addMouseListener(this);

        setVisible(true);

        System.out.println("screen built");

        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        repaint();

    }

    public void actionPerformed(ActionEvent e) {

		if (e.getSource() == showHistory) {

			try {
				// this.setVisible(false);
                this.dispose();
				new Statistics();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		if (e.getSource() == exit) {

			try {
				// this.setVisible(false);
                this.dispose();
				Main.x = new Login();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}

		if (e.getSource() == addExercise) {
            try {
                new addExercise(legsList, chestList, backList, shouldersList, bicepsList, tricepsList);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        if (e.getSource() == modify) {
            try {
                new modifyData();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        if (e.getSource() == missedDate) {
                new addMissedDate();
        }

        if (e.getSource() == showInfo) {
            new startInfo();
        }

        if (e.getSource() == tableStuff) {
            try {
                new tableData();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == arm) {

            allText = new JList<String>(toNormalArray(bicepsList));

            panel2.removeAll();

            allText.setFont(new Font("Arial", Font.PLAIN, 20));
            allText.addMouseListener(this);
            allText.setVisible(true);

            armTitle.setFont(new Font("Arial", Font.BOLD, 20));
            armTitle.setVisible(true);

            panel2.add(armTitle, BorderLayout.NORTH);
            panel2.add(allText, BorderLayout.CENTER);

            panel2.revalidate();
            panel2.repaint();

            System.out.println("in arm");

            arm.setBorder(borderchoose);
            chest.setBorder(border);
            chest2.setBorder(border);
            back.setBorder(border);
            arm2.setBorder(border);
            leg.setBorder(border);


        }
        if (e.getSource() == chest) {

            allText = new JList<String>(toNormalArray(chestList));

            panel2.removeAll();

            allText.setFont(new Font("Arial", Font.PLAIN, 20));
            allText.addMouseListener(this);
            allText.setVisible(true);

            chestTitle.setFont(new Font("Arial", Font.BOLD, 20));
            chestTitle.setVisible(true);

            panel2.add(chestTitle, BorderLayout.NORTH);
            panel2.add(allText, BorderLayout.CENTER);

            panel2.revalidate();
            panel2.repaint();

            System.out.println("in chest");

            arm.setBorder(border);
            chest.setBorder(borderchoose);
            chest2.setBorder(border);
            back.setBorder(border);
            arm2.setBorder(border);
            leg.setBorder(border);


        }
        if (e.getSource() == chest2) {

            allText = new JList<String>(toNormalArray(shouldersList));

            panel2.removeAll();

            allText.setFont(new Font("Arial", Font.PLAIN, 20));
            allText.addMouseListener(this);
            allText.setVisible(true);

            chest2Title.setFont(new Font("Arial", Font.BOLD, 20));
            chest2Title.setVisible(true);

            panel2.add(chest2Title, BorderLayout.NORTH);
            panel2.add(allText, BorderLayout.CENTER);

            panel2.revalidate();
            panel2.repaint();

            System.out.println("in chest2");

            arm.setBorder(border);
            chest.setBorder(border);
            chest2.setBorder(borderchoose);
            back.setBorder(border);
            arm2.setBorder(border);
            leg.setBorder(border);


        }
        if (e.getSource() == back) {

            allText = new JList<String>(toNormalArray(backList));

            panel2.removeAll();

            allText.setFont(new Font("Arial", Font.PLAIN, 20));
            allText.addMouseListener(this);
            allText.setVisible(true);

            backTitle.setFont(new Font("Arial", Font.BOLD, 20));
            backTitle.setVisible(true);

            panel2.add(backTitle, BorderLayout.NORTH);
            panel2.add(allText, BorderLayout.CENTER);

            panel2.revalidate();
            panel2.repaint();

            System.out.println("in back");

            arm.setBorder(border);
            chest.setBorder(border);
            chest2.setBorder(border);
            back.setBorder(borderchoose);
            arm2.setBorder(border);
            leg.setBorder(border);

        }
        if (e.getSource() == arm2) {

            allText = new JList<String>(toNormalArray(tricepsList));

            panel2.removeAll();

            allText.setFont(new Font("Arial", Font.PLAIN, 20));
            allText.addMouseListener(this);
            allText.setVisible(true);

            arm2Title.setFont(new Font("Arial", Font.BOLD, 20));
            arm2Title.setVisible(true);

            panel2.add(arm2Title, BorderLayout.NORTH);
            panel2.add(allText, BorderLayout.CENTER);

            panel2.revalidate();
            panel2.repaint();

            System.out.println("in arm2");

            arm.setBorder(border);
            chest.setBorder(border);
            chest2.setBorder(border);
            back.setBorder(border);
            arm2.setBorder(borderchoose);
            leg.setBorder(border);


        }
        if (e.getSource() == leg) {

            allText = new JList<String>(toNormalArray(legsList));

            panel2.removeAll();

            allText.setFont(new Font("Arial", Font.PLAIN, 20));
            allText.addMouseListener(this);
            allText.setVisible(true);

            legTitle.setFont(new Font("Arial", Font.BOLD, 20));
            legTitle.setVisible(true);

            panel2.add(legTitle, BorderLayout.NORTH);
            panel2.add(allText, BorderLayout.CENTER);

            panel2.revalidate();
            panel2.repaint();

            System.out.println("in leg");

            arm.setBorder(border);
            chest.setBorder(border);
            chest2.setBorder(border);
            back.setBorder(border);
            arm2.setBorder(border);
            leg.setBorder(borderchoose);

        }
        if (e.getSource() == allText) {

            Main.currentExercise = allText.getSelectedValue().toString();
            try {
                new Activity(allText.getSelectedValue().toString());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            this.dispose();

            System.out.println("open > " + allText.getSelectedValue().toString());

        }

        if (e.getSource() == credits) {

            // #EasterEggs
            new Credits();
            System.out.println("open credits");


        }

        panel2.add(buttons, BorderLayout.PAGE_END);

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
