import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Personne extends JFrame implements ActionListener{
    private JLabel labelNom, labelPrenom, labelDateNaissance, labelResultat;
    private JTextField textFieldNom, textFieldPrenom, textFieldDateNaissance;
    private JButton buttonCalculer, buttonRemiseAZero;

    public Personne() {
        // Créer les JLabels
        labelNom = new JLabel("Nom:");
        labelPrenom = new JLabel("Prénom:");
        labelDateNaissance = new JLabel("Date de naissance:");
        labelResultat = new JLabel("");

        // Créer les JTextFields
        textFieldNom = new JTextField(20);
        textFieldPrenom = new JTextField(20);
        textFieldDateNaissance = new JTextField(20);

        // Créer le premier JPanel avec les JLabels et JTextFields
        JPanel panel1 = new JPanel(new GridLayout(3, 2));
        panel1.add(labelNom);
        panel1.add(textFieldNom);
        panel1.add(labelPrenom);
        panel1.add(textFieldPrenom);
        panel1.add(labelDateNaissance);
        panel1.add(textFieldDateNaissance);

        // Créer le deuxième JPanel avec le JLabel pour afficher le résultat
        JPanel panel2 = new JPanel(new FlowLayout());
        panel2.add(labelResultat);

        // Créer les boutons
        buttonCalculer = new JButton("Calculer");
        buttonRemiseAZero = new JButton("Remise à zéro");

        // Ajouter des écouteurs d'événements aux boutons
        buttonCalculer.addActionListener(this);
        buttonRemiseAZero.addActionListener(this);

        // Créer le troisième JPanel avec les boutons
        JPanel panel3 = new JPanel(new FlowLayout());
        panel3.add(buttonCalculer);
        panel3.add(buttonRemiseAZero);

        // Ajouter les trois JPanels à la JFrame
        add(panel1, BorderLayout.CENTER);
        add(panel2, BorderLayout.NORTH);
        add(panel3, BorderLayout.SOUTH);

        // Centrer la JFrame sur l'écran
        setLocationRelativeTo(null);

        // Rendre la JFrame visible
        setVisible(true);

        // Fermer la JFrame lorsque l'utilisateur clique sur la croix rouge
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Définir la taille de la JFrame en fonction du contenu
        pack();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonCalculer) {
            String nom = textFieldNom.getText();
            String prenom = textFieldPrenom.getText();
            String dateNaissance = textFieldDateNaissance.getText();

            labelResultat.setText("Nom: " + nom + " - Prénom: " + prenom + " - Date de naissance: " + dateNaissance);
            System.out.println("Nom: " + nom);
            System.out.println("Prénom: " + prenom);
            System.out.println("Date de naissance: " + dateNaissance);
            System.out.println();
        } else if (e.getSource() == buttonRemiseAZero) {
            textFieldNom.setText("");
            textFieldPrenom.setText("");
            textFieldDateNaissance.setText("");
            textFieldNom.requestFocus();
            labelResultat.setText("");
        }
    }

    public static void main(String[] args) {
        Personne personne = new Personne();
    }
}
