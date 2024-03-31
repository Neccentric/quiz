package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class guiQuiz implements ActionListener {
    Random rand = new Random();

    JFrame frame;

    JLabel scoreLabel;
    JLabel title;
    JTextArea question;
    JLabel status;
    String[] correct = {"Correct!","Alright! You got it!", "Great!", "Keep Going!","Awesome!",
            "Good Work!", "Genius!", "Amazing!"};

    JButton opt1;
    JButton opt2;
    JButton opt3;

    JLabel loseText;
    JLabel finalScore;
    JLabel thanks;

    int upper = 13;
    int lower = 2;
    int num1;
    int num2;
    int ans;
    int score = 0;
    int questionNumber = 1;

    public guiQuiz(){
        frame = new JFrame("Endless Multiplication Game!");

        loseText = new JLabel("Oops! Wrong!");
        loseText.setFont(new Font("Times New Roman", Font.PLAIN,45));
        loseText.setBounds(0,100,665,125);
        loseText.setHorizontalAlignment(JLabel.CENTER);
        loseText.setVerticalAlignment(JLabel.CENTER);
        //frame.add(loseText);

        finalScore = new JLabel("Final Score: " + score);
        finalScore.setFont(new Font("Times New Roman", Font.PLAIN,30));
        finalScore.setBounds(0,175,665,125);
        finalScore.setHorizontalAlignment(JLabel.CENTER);
        finalScore.setVerticalAlignment(JLabel.CENTER);
        //frame.add(finalScore);

        thanks = new JLabel("Thanks for Playing!!!");
        thanks.setFont(new Font("Times New Roman", Font.PLAIN,20));
        thanks.setBounds(0,255,680,125);
        thanks.setHorizontalAlignment(JLabel.CENTER);
        thanks.setVerticalAlignment(JLabel.CENTER);
        //frame.add(thanks);

        status = new JLabel("");
        status.setFont(new Font("Times New Roman", Font.PLAIN,15));
        status.setBounds(0,420,665,30);
        status.setHorizontalAlignment(JLabel.CENTER);
        status.setVerticalAlignment(JLabel.CENTER);
        frame.add(status);

        scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setFont(new Font("Times New Roman", Font.PLAIN,30));
        scoreLabel.setBounds(0,370,665,50);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setVerticalAlignment(JLabel.CENTER);
        frame.add(scoreLabel);

        title = new JLabel("Question " + questionNumber);
        title.setFont(new Font("Times New Roman", Font.PLAIN,30));
        title.setBounds(0,65,665,50);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        frame.add(title);

        question = new JTextArea();
        question.setFont(new Font("Times New Roman", Font.PLAIN,30));
        question.setBackground(frame.getBackground());

        num1 = rand.nextInt(lower,upper);
        num2 = rand.nextInt(lower, upper);
        question.setText(num1 + " " + "*" + " " + num2 + " = ?");
        ans = num1*num2;

        question.setBounds(280,150,200,50);
        frame.add(question);
        question.setEditable(false);


        opt1 = new JButton();
        opt1.setFont(new Font("Times New Roman", Font.PLAIN,20));
        opt1.setBounds(100,250,100,50);
        frame.add(opt1);
        opt1.addActionListener(this);

        opt2 = new JButton();
        opt2.setFont(new Font("Times New Roman", Font.PLAIN,20));
        opt2.setBounds(300,250,100,50);
        frame.add(opt2);
        opt2.addActionListener(this);

        opt3 = new JButton();
        opt3.setFont(new Font("Times New Roman", Font.PLAIN,20));
        opt3.setBounds(500,250,100,50);
        frame.add(opt3);
        opt3.addActionListener(this);

        int correctIndex = rand.nextInt(1,4);
        switch (correctIndex){
            case 1:
                opt1.setText(String.valueOf(ans));
                int a = rand.nextInt(lower,upper);
                int b = rand.nextInt(lower,upper);
                while(a*b == ans){
                    a = rand.nextInt(lower,upper);
                    b = rand.nextInt(lower,upper);
                }
                opt2.setText(String.valueOf(a*b));
                int c = rand.nextInt(lower,upper);
                    int d = rand.nextInt(lower,upper);
                while(c*d == ans || c*d == a*b){
                    c = rand.nextInt(lower,upper);
                    d = rand.nextInt(lower,upper);
                }
                opt3.setText(String.valueOf(c*d));
                break;
            case 2:
                opt2.setText(String.valueOf(ans));
                int e = rand.nextInt(lower,upper);
                int f = rand.nextInt(lower,upper);
                while(e*f == ans){
                    e = rand.nextInt(lower,upper);
                        f = rand.nextInt(lower,upper);
                }
                opt1.setText(String.valueOf(e*f));
                int g = rand.nextInt(lower,upper);
                int h = rand.nextInt(lower,upper);
                while(g*h == ans || g*h == e*f){
                    g = rand.nextInt(lower,upper);
                    h = rand.nextInt(lower,upper);
                }
                opt3.setText(String.valueOf(g*h));
                break;
            case 3:
                opt3.setText(String.valueOf(ans));
                int i = rand.nextInt(lower,upper);
                int j = rand.nextInt(lower,upper);
                while(i*j == ans){
                    i = rand.nextInt(lower,upper);
                    j = rand.nextInt(lower,upper);
                }
                opt2.setText(String.valueOf(i*j));
                int k = rand.nextInt(lower,upper);
                int l = rand.nextInt(lower,upper);
                while(k*l == ans || k*l == i*j){
                    k = rand.nextInt(lower,upper);
                    l = rand.nextInt(lower,upper);
                }
                opt1.setText(String.valueOf(k*l));
                break;
        }


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public static void main(String args[]){
        new guiQuiz();
    }

    @Override
    public void actionPerformed(ActionEvent E) {
        if (E.getSource() == opt1){
           if(Integer.parseInt(opt1.getText()) == ans){
               System.out.println("Correct");
               score += 10;
               scoreLabel.setText("Score: " + score);
               String newStatus = correct[rand.nextInt(correct.length)];
               while(status.getText().equals(newStatus)){
                   newStatus = correct[rand.nextInt(correct.length)];
               }
               status.setText(newStatus);
               //next question

               int n1 = rand.nextInt(lower,upper);
               while(n1 == num1){
                   n1 = rand.nextInt(lower,upper);
               }
               num1 = n1;
               num2 = rand.nextInt(lower, upper);
               question.setText(num1 + " " + "*" + " " + num2 + " = ?");
               ans = num1*num2;
               questionNumber += 1;
               title.setText("Question " + questionNumber);
               //reset options
               int correctIndex = rand.nextInt(1,4);
               switch (correctIndex){
                   case 1:
                       opt1.setText(String.valueOf(ans));
                       int a = rand.nextInt(lower,upper);
                       int b = rand.nextInt(lower,upper);
                       while(a*b == ans){
                           a = rand.nextInt(lower,upper);
                           b = rand.nextInt(lower,upper);
                       }
                       opt2.setText(String.valueOf(a*b));
                       int c = rand.nextInt(lower,upper);
                       int d = rand.nextInt(lower,upper);
                       while(c*d == ans || c*d == a*b){
                           c = rand.nextInt(lower,upper);
                           d = rand.nextInt(lower,upper);
                       }
                       opt3.setText(String.valueOf(c*d));
                       break;
                   case 2:
                       opt2.setText(String.valueOf(ans));
                       int e = rand.nextInt(lower,upper);
                       int f = rand.nextInt(lower,upper);
                       while(e*f == ans){
                           e = rand.nextInt(lower,upper);
                           f = rand.nextInt(lower,upper);
                       }
                       opt1.setText(String.valueOf(e*f));
                       int g = rand.nextInt(lower,upper);
                       int h = rand.nextInt(lower,upper);
                       while(g*h == ans || g*h == e*f){
                           g = rand.nextInt(lower,upper);
                           h = rand.nextInt(lower,upper);
                       }
                       opt3.setText(String.valueOf(g*h));
                       break;
                   case 3:
                       opt3.setText(String.valueOf(ans));
                       int i = rand.nextInt(lower,upper);
                       int j = rand.nextInt(lower,upper);
                       while(i*j == ans){
                           i = rand.nextInt(lower,upper);
                               j = rand.nextInt(lower,upper);
                       }
                       opt2.setText(String.valueOf(i*j));
                       int k = rand.nextInt(lower,upper);
                       int l = rand.nextInt(lower,upper);
                       while(k*l == ans || k*l == i*j){
                           k = rand.nextInt(lower,upper);
                           l = rand.nextInt(lower,upper);
                       }
                       opt1.setText(String.valueOf(k*l));
                       break;
               }
           }else{
               System.out.println("Wrong");
               //take everything off
               question.setVisible(false);
               title.setVisible(false);
               opt1.setVisible(false);
               opt2.setVisible(false);
               opt3.setVisible(false);
               status.setVisible(false);
               scoreLabel.setVisible(false);

               //add end page
               frame.add(loseText);
               finalScore.setText("Final Score: " + score);
               frame.add(finalScore);
               frame.add(thanks);
           }
        }else if(E.getSource() == opt2){
            if(Integer.parseInt(opt2.getText()) == ans){
                System.out.println("Correct");
                score += 10;
                scoreLabel.setText("Score: " + score);
                String newStatus = correct[rand.nextInt(correct.length)];
                while(status.getText().equals(newStatus)){
                    newStatus = correct[rand.nextInt(correct.length)];
                }
                status.setText(newStatus);
                //next question
                int n1 = rand.nextInt(lower,upper);
                while(n1 == num1){
                    n1 = rand.nextInt(lower,upper);
                }
                num1 = n1;
                num2 = rand.nextInt(lower, upper);

                question.setText(num1 + " " + "*" + " " + num2 + " = ?");
                ans = num1*num2;
                questionNumber += 1;
                title.setText("Question " + questionNumber);
                //reset options
                int correctIndex = rand.nextInt(1,4);
                switch (correctIndex){
                    case 1:
                        opt1.setText(String.valueOf(ans));
                        int a = rand.nextInt(lower,upper);
                        int b = rand.nextInt(lower,upper);
                        while(a*b == ans){
                            a = rand.nextInt(lower,upper);
                            b = rand.nextInt(lower,upper);
                        }
                        opt2.setText(String.valueOf(a*b));
                        int c = rand.nextInt(lower,upper);
                        int d = rand.nextInt(lower,upper);
                        while(c*d == ans || c*d == a*b){
                            c = rand.nextInt(lower,upper);
                            d = rand.nextInt(lower,upper);
                        }
                        opt3.setText(String.valueOf(c*d));
                        break;
                    case 2:
                        opt2.setText(String.valueOf(ans));
                        int e = rand.nextInt(lower,upper);
                        int f = rand.nextInt(lower,upper);
                        while(e*f == ans){
                            e = rand.nextInt(lower,upper);
                            f = rand.nextInt(lower,upper);
                        }
                        opt1.setText(String.valueOf(e*f));
                        int g = rand.nextInt(lower,upper);
                        int h = rand.nextInt(lower,upper);
                        while(g*h == ans || g*h == e*f){
                            g = rand.nextInt(lower,upper);
                            h = rand.nextInt(lower,upper);
                        }
                        opt3.setText(String.valueOf(g*h));
                        break;
                    case 3:
                        opt3.setText(String.valueOf(ans));
                        int i = rand.nextInt(lower,upper);
                        int j = rand.nextInt(lower,upper);
                        while(i*j == ans){
                            i = rand.nextInt(lower,upper);
                            j = rand.nextInt(lower,upper);
                        }
                        opt2.setText(String.valueOf(i*j));
                        int k = rand.nextInt(lower,upper);
                        int l = rand.nextInt(lower,upper);
                        while(k*l == ans || k*l == i*j){
                            k = rand.nextInt(lower,upper);
                            l = rand.nextInt(lower,upper);
                        }
                        opt1.setText(String.valueOf(k*l));
                        break;
                }
            }else{
                System.out.println("Wrong");
                //take everything off
                question.setVisible(false);
                title.setVisible(false);
                opt1.setVisible(false);
                opt2.setVisible(false);
                opt3.setVisible(false);
                status.setVisible(false);
                scoreLabel.setVisible(false);

                //add end page
                frame.add(loseText);
                finalScore.setText("Final Score: " + score);
                frame.add(finalScore);
                frame.add(thanks);
            }
        }else if(E.getSource() == opt3){
            if(Integer.parseInt(opt3.getText()) == ans){
                System.out.println("Correct");
                score += 10;
                scoreLabel.setText("Score: " + score);
                String newStatus = correct[rand.nextInt(correct.length)];
                while(status.getText().equals(newStatus)){
                    newStatus = correct[rand.nextInt(correct.length)];
                }
                status.setText(newStatus);
                //next question
                int n1 = rand.nextInt(lower,upper);
                while(n1 == num1){
                    n1 = rand.nextInt(lower,upper);
                }
                num1 = n1;
                num2 = rand.nextInt(lower, upper);
                question.setText(num1 + " " + "*" + " " + num2 + " = ?");
                ans = num1*num2;
                questionNumber += 1;
                title.setText("Question " + questionNumber);
                //reset options
                int correctIndex = rand.nextInt(1,4);
                switch (correctIndex){
                    case 1:
                        opt1.setText(String.valueOf(ans));
                        int a = rand.nextInt(lower,upper);
                        int b = rand.nextInt(lower,upper);
                        while(a*b == ans){
                            a = rand.nextInt(lower,upper);
                            b = rand.nextInt(lower,upper);
                        }
                        opt2.setText(String.valueOf(a*b));
                        int c = rand.nextInt(lower,upper);
                        int d = rand.nextInt(lower,upper);
                        while(c*d == ans || c*d == a*b){
                            c = rand.nextInt(lower,upper);
                            d = rand.nextInt(lower,upper);
                        }
                        opt3.setText(String.valueOf(c*d));
                        break;
                    case 2:
                        opt2.setText(String.valueOf(ans));
                        int e = rand.nextInt(lower,upper);
                        int f = rand.nextInt(lower,upper);
                        while(e*f == ans){
                            e = rand.nextInt(lower,upper);
                            f = rand.nextInt(lower,upper);
                        }
                        opt1.setText(String.valueOf(e*f));
                        int g = rand.nextInt(lower,upper);
                        int h = rand.nextInt(lower,upper);
                        while(g*h == ans || g*h == e*f){
                            g = rand.nextInt(lower,upper);
                            h = rand.nextInt(lower,upper);
                        }
                        opt3.setText(String.valueOf(g*h));
                        break;
                    case 3:
                        opt3.setText(String.valueOf(ans));
                        int i = rand.nextInt(lower,upper);
                        int j = rand.nextInt(lower,upper);
                        while(i*j == ans){
                            i = rand.nextInt(lower,upper);
                            j = rand.nextInt(lower,upper);
                        }
                        opt2.setText(String.valueOf(i*j));
                        int k = rand.nextInt(lower,upper);
                        int l = rand.nextInt(lower,upper);
                        while(k*l == ans || k*l == i*j){
                            k = rand.nextInt(lower,upper);
                            l = rand.nextInt(lower,upper);
                        }
                        opt1.setText(String.valueOf(k*l));
                        break;
                }
            }else{
                System.out.println("Wrong");
                //take everything off
                question.setVisible(false);
                title.setVisible(false);
                opt1.setVisible(false);
                opt2.setVisible(false);
                opt3.setVisible(false);
                status.setVisible(false);
                scoreLabel.setVisible(false);

                //add end page
                frame.add(loseText);
                finalScore.setText("Final Score: " + score);
                frame.add(finalScore);
                frame.add(thanks);

            }
        }

    }
}
