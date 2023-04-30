import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class PersonneFrame extends JFrame {
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
