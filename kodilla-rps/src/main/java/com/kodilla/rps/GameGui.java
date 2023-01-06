package com.kodilla.rps;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Hashtable;
import java.util.Random;

public class GameGui {
    String playerDecision;
    int difficulty = 1;
    int roundLimit = 3;
    int round = 1;
    int scoreComputer = 0;
    int scorePlayer = 0;
    boolean endOfGame = false;
    String roundWinner;
    String playerName;
    String roundInfo;
    JButton[] buttons = new JButton[7];
    JRadioButton[] rounds = new JRadioButton[4];
    JTable scoreTable = new JTable();
    DefaultTableModel dtm = new DefaultTableModel(0,0);
    JFrame frame = new JFrame();

    public static String fightOption(int i){
        return switch (i) {
            case 1 -> "rock";
            case 2 -> "paper";
            case 3 -> "scissors";
            case 4 -> "lizard";
            case 5 -> "Spock";
            default -> null;
        };
    }



//FINISHING ROUND OPERATIONS ===========================================================================================
    public void finishRound(){
        dtm.addRow(new Object[] {"Round " + round + ": " + roundWinner +" won"});
        round++;
        if(round>roundLimit){
            endOfGame();
        }
    }

//ROUND ================================================================================================

    public void round(){
        if (playerDecision.equals("1") || playerDecision.equals("2") || playerDecision.equals("3")
                || playerDecision.equals("4") || playerDecision.equals("5")) {
            int option = Integer.parseInt(playerDecision);
            int computerDecision;

            Random rand = new Random();
            switch (difficulty) {
                case 0 -> //difficulty Sheldon
                        computerDecision = 5;
                case 2 -> { //difficulty hard
                    int probabilityCheck = rand.nextInt(0, 4);
                    if (probabilityCheck == 4) { //draw
                        computerDecision = option;
                    } else if (probabilityCheck == 3) { //player wins
                        int randomization = rand.nextInt(0, 2);
                        computerDecision = switch (option) {
                            case 1 -> (randomization == 0) ? 3 : 4;
                            case 2 -> (randomization == 0) ? 1 : 5;
                            case 3 -> (randomization == 0) ? 2 : 4;
                            case 4 -> (randomization == 0) ? 2 : 5;
                            default -> (randomization == 0) ? 1 : 3;
                        };
                    } else { //computer wins
                        int randomization = rand.nextInt(0, 2);
                        computerDecision = switch (option) {
                            case 1 -> (randomization == 0) ? 2 : 5;
                            case 2 -> (randomization == 0) ? 3 : 4;
                            case 3 -> (randomization == 0) ? 1 : 5;
                            case 4 -> (randomization == 0) ? 1 : 3;
                            default -> (randomization == 0) ? 2 : 4;
                        };
                    }
                }
                default -> //difficulty medium
                        computerDecision = rand.nextInt(1, 6);
            }

            roundInfo = "<html>round " + round + " of " + roundLimit + ": "
                    + playerName+ " chose " + fightOption(option) + " and computer chose "
                    + fightOption(computerDecision) + " - ";

            if(option == computerDecision)
            {
                roundInfo += "it's a draw";
            } else if (
                    (option==1 && computerDecision == 2) ||
                    (option==1 && computerDecision == 5) ||
                    (option==2 && computerDecision == 3) ||
                    (option==2 && computerDecision == 4) ||
                    (option==3 && computerDecision == 1) ||
                    (option==3 && computerDecision == 5) ||
                    (option==4 && computerDecision == 1) ||
                    (option==4 && computerDecision == 3) ||
                    (option==5 && computerDecision == 2) ||
                    (option==5 && computerDecision == 4))
            {
                scoreComputer++;
                roundInfo += "computer wins";
                roundWinner = "computer";
                finishRound();
            } else {
                scorePlayer++;
                roundInfo += playerName + " wins";
                roundWinner = playerName;
                finishRound();
            }
            roundInfo += "<br>CHOOSE WHAT YOU WANT TO DO</html>";
        } else if (playerDecision.equals("x")) {
            int input = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "EXIT", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if(input == 0){
                System.exit(0);
            }
        } else if (playerDecision.equals("n")) {
            int input = JOptionPane.showConfirmDialog(null, "Do you want to restart?", "RESTART", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(input == 0) {
                new GameGui();
                frame.dispose();
            }
        }
    }

//FRAME OPERATIONS =====================================================================================================
    public GameGui() {

//MAIN FRAME SETTINGS ==================================================================================================
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

//GAME NAME ============================================================================================================
        JLabel title = new JLabel("ROCK - PAPER - SCISSORS - LIZARD - SPOCK");
        title.setFont(new Font("Dialog", Font.BOLD, 20));

//GAME DIRECTIONS LABEL ================================================================================================
        JLabel directions = new JLabel("<html>Select username, number of rounds, <br> difficulty level and " +
                "press confirm.</html>");
        directions.setForeground(Color.BLUE);

//SCORE TABLE ==========================================================================================================
        scoreTable.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        String[] header = new String[]{"round score"};
        dtm.setColumnIdentifiers(header);
        scoreTable.setModel(dtm);

//USERNAME BOX =========================================================================================================
        JTextField inputNameBox = new JTextField("Please enter your name");
        inputNameBox.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(inputNameBox.getText().trim().equals("Please enter your name"))
                    inputNameBox.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(inputNameBox.getText().trim().equals(""))
                    inputNameBox.setText("Please enter your name");
            }
        });

        JLabel playerLabel = new JLabel("PLAYER:");
        JLabel playerNameLabel = new JLabel("PLAYER ONE");
        playerLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        playerNameLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        playerNameLabel.setForeground(Color.BLUE);

//BUTTONS - OPTIONS ====================================================================================================

        buttons[0] = new JButton("ROCK");
        buttons[0].addActionListener(e -> {
            playerDecision = "1";
            round();
            directions.setText(roundInfo);
        });

        buttons[1] = new JButton("PAPER");
        buttons[1].addActionListener(e -> {
            playerDecision = "2";
            round();
            directions.setText(roundInfo);
        });

        buttons[2] = new JButton("SCISSORS");
        buttons[2].addActionListener(e -> {
            playerDecision = "3";
            round();
            directions.setText(roundInfo);
        });

        buttons[3] = new JButton("LIZARD");
        buttons[3].addActionListener(e -> {
            playerDecision = "4";
            round();
            directions.setText(roundInfo);
        });

        buttons[4] = new JButton("SPOCK");
        buttons[4].addActionListener(e -> {
            playerDecision = "5";
            round();
            directions.setText(roundInfo);
        });

        buttons[5] = new JButton("FINISH");
        buttons[5].addActionListener(e -> {
            playerDecision = "x";
            round();
            directions.setText(roundInfo);
        });

        buttons[6] = new JButton("RESTART");
        buttons[6].addActionListener(e -> {
            playerDecision = "n";
            round();
            directions.setText(roundInfo);
        });

        for(JButton but : buttons){
            but.setEnabled(false);
        }

//ROUND SELECTOR =======================================================================================================
        JLabel roundLabel = new JLabel("rounds:");
        rounds[0] = new JRadioButton("1");
        rounds[1] = new JRadioButton("3");
        rounds[2] = new JRadioButton("5");
        rounds[3] = new JRadioButton("7");
        rounds[1].setSelected(true);
        ButtonGroup radioButtons = new ButtonGroup();
        for(JRadioButton but : rounds){
            radioButtons.add(but);
        }

        class RadioButtonActionListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent event) {
                JRadioButton button = (JRadioButton) event.getSource();
                if (button == rounds[0]) {
                    roundLimit = 1;
                } else if (button == rounds[1]) {
                    roundLimit = 3;
                } else if (button == rounds[2]) {
                    roundLimit = 5;
                } else if (button == rounds[3]) {
                roundLimit = 7;
                }
            }
        }

        RadioButtonActionListener actionListener = new RadioButtonActionListener();
        for(JRadioButton but : rounds){
            but.addActionListener(actionListener);
        }

//SLIDER - DIFFICULTY LEVEL ============================================================================================
        JSlider difficultySlider = new JSlider(JSlider.VERTICAL, 0, 2, 1);
        Hashtable<Integer, JLabel> lvlDescription = new Hashtable<>();
        lvlDescription.put(0, new JLabel("Sheldon"));
        lvlDescription.put(1, new JLabel("Normal"));
        lvlDescription.put(2, new JLabel("Hard"));
        difficultySlider.setPaintLabels(true);
        difficultySlider.setLabelTable(lvlDescription);
        difficultySlider.addChangeListener(e -> difficulty = difficultySlider.getValue());

//CONFIRM BUTTON =======================================================================================================
        JButton confirmButton = new JButton("CONFIRM");
        confirmButton.addActionListener(e -> {
            playerName = inputNameBox.getText();
            if(playerName.length()>8){
                playerName = playerName.substring(0,8);
            }
            playerNameLabel.setText(playerName);
            frame.remove(inputNameBox);
            frame.remove(confirmButton);
            frame.add(playerLabel);
            frame.add(playerNameLabel);

            round = 1;
            scoreComputer = 0;
            scorePlayer = 0;
            endOfGame = false;

            for(JButton but : buttons){
                but.setEnabled(true);
            }

            directions.setText("CHOOSE WHAT YOU WANT TO DO");
            frame.revalidate();
            frame.repaint();
            for (JButton but : buttons) {
                but.setEnabled(true);
            }
            for (JRadioButton rbut : rounds) {
                rbut.setEnabled(false);
            }
            difficultySlider.setEnabled(false);

        });

//SETTING BOUNDS =======================================================================================================
        frame.setSize(500, 500);

        directions.setBounds(30, 110, 420, 90);

        title.setBounds(20, 10, 490, 20);

        inputNameBox.setBounds(30, 50, 300, 25);
        confirmButton.setBounds(350, 50, 100, 55);
        playerLabel.setBounds(30, 50, 100, 25);
        playerNameLabel.setBounds(120, 50, 300, 25);

        roundLabel.setBounds(30, 83, 60, 20);
        rounds[0].setBounds(90, 83, 45, 20);
        rounds[1].setBounds(140, 83, 45, 20);
        rounds[2].setBounds(190, 83, 45, 20);
        rounds[3].setBounds(240,83,45,20);

        difficultySlider.setBounds(400, 210, 75, 230);

        buttons[0].setBounds(30, 210, 100, 25);
        buttons[1].setBounds(30, 260, 100, 25);
        buttons[2].setBounds(30, 310, 100, 25);
        buttons[3].setBounds(30, 360, 100, 25);
        buttons[4].setBounds(30, 410, 100, 25);
        buttons[5].setBounds(230, 210, 100, 25);
        buttons[6].setBounds(230, 260, 100, 25);

        scoreTable.setBounds(180, 310, 200, 125);

//ADDING ELEMENTS TO FRAME =============================================================================================
        frame.add(title);
        frame.add(directions);
        for(JButton but : buttons){
            frame.add(but);
        }
        frame.add(roundLabel);
        for(JRadioButton rbut : rounds){
            frame.add(rbut);
        }

        frame.add(scoreTable);

        frame.add(difficultySlider);
        frame.add(inputNameBox);
        frame.add(confirmButton);

//FRAME ON =============================================================================================================
        frame.setVisible(true);

    }

//END OF GAME ==============================================================================================

    public void endOfGame() {
        for(int i=0; i<5; i++){
            buttons[i].setEnabled(false);
        }

        String winner;
        if(scorePlayer>scoreComputer){
            winner = playerName;
        } else {
            winner = "COMPUTER";
        }
        roundInfo += "<html><center><u>END OF GAME</u></center>score: " + playerName + " " + scorePlayer + " VS Computer "
                + scoreComputer + "<center><u>THE WINNER IS " + winner + "</u></center></html>";
    }

}
