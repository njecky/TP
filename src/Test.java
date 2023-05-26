import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Test extends JFrame{
    private JLabel label1, label2;
    private JTextField textField1, textField2;
    private JTextArea textArea;
    private JButton button1, button2, button3;

    public Test(){
        super("Mon TRAVAILL");
        setLayout(null);
        setSize(500,500);
        textArea = new JTextArea();
        textArea.setBounds(10, 10, 480, 200);
        add(textArea);

        button1 = new JButton("CAlCULER");
        button1.setBounds(10, 220, 150, 30);
        add(button1);

        button2 = new JButton("Enregistrer dans un fichier");
        button2.setBounds(170, 220, 150, 30);
        add(button2);
        
        button3 = new JButton("Chercher un fichier");
        button3.setBounds(330, 220, 150, 30);
        add(button3);

        label1 = new JLabel("Premier nombre:");
        label1.setBounds(10, 260, 100, 30);
        add(label1);

        textField1 = new JTextField();
        textField1.setBounds(120, 260, 100, 30);
        add(textField1);

        label2 = new JLabel("Deuxième nombre:");
        label2.setBounds(230, 260, 100, 30);
        add(label2);

        textField2 = new JTextField();
        textField2.setBounds(340, 260, 100, 30);
        add(textField2);

        
        // button1.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         textArea.setText(textField1.getText() + " + " + textField2.getText() + " = " + (Integer.parseInt(textField1.getText()) + Integer.parseInt(textField2.getText())));
        //     }
        // });

        // button1.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         textArea.setText(textField1.getText() + " + " + textField2.getText() + " = " + (Integer.parseInt(textField1.getText()) + Integer.parseInt(textField2.getText())));
        //     }
        // });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    FileWriter fw = new FileWriter("pratique.txt");
                    fw.write(textArea.getText() + "\n");
                    fw.close();
                    textArea.setText("");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(textField1.getText());
                    int num2 = Integer.parseInt(textField2.getText());
                    int sum = num1 + num2;
                    textArea.setText(num1 + " + " + num2 + " = " + sum);
                } catch (NumberFormatException ex) {
                    textArea.setText("Veuillez saisir des nombres valides dans les champs de texte.");
                }
            }
        });
        
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(selectedFile));
                        String line;
                        while ((line = br.readLine()) != null) {
                            textArea.append(line + "\n");
                        }
                        br.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

    }

    public static void main(String[] args) {
        Test monFichier = new Test();
        monFichier.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        monFichier.setVisible(true);
    }
}
