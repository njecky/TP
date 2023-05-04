import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
import java.awt.*;

public class PersonneFrame {
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;

    public PersonneFrame(String nom, String prenom, LocalDate dateNaissance){
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public int getAge() {
        return Period.between(dateNaissance, LocalDate.now()).getYears();
    }

    public static void main(String[] args) {
        // JFrame frame = new JFrame("BIEVENUE NJECKY EBOUMBOU FELIX DESIRE");
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(450, 450);
        // frame.setLocationRelativeTo(null);
        // frame.setVisible(true);
        // // Définissez les deux panels
        // // Définissez les deux panels
        // JPanel panel = new JPanel();
        // JPanel panel1 = new JPanel();
        // // frame.add(panel);

        // JLabel label = new JLabel("Je suis un JLabel", JLabel.CENTER);
        // frame.add(label);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez votre nom : ");
        String nom = scanner.nextLine();
        System.out.print("Entrez votre prénom : ");
        String prenom = scanner.nextLine();
        System.out.print("Entrez votre date de naissance (yyyy-mm-dd) : ");
        LocalDate dateNaissance = LocalDate.parse(scanner.nextLine());

        PersonneFrame personne = new PersonneFrame(nom, prenom, dateNaissance);
        System.out.println("Vous êtes né(e) le " + personne.getDateNaissance() + " et vous avez " + personne.getAge() + " ans.");
    }
}
