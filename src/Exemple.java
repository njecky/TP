import java.util.Vector;
import javax.swing.border.EmptyBorder ;
import java.awt.* ;
import javax.swing.*;

public class Exemple extends JFrame {
    /**
* Les variables pointant chaque composant sont declarees
* en variables d’instance et en type protected. Elles
* auraient tres bien pu etre des variables locales au
* constructeur mais, pour des raisons pedagogiques,
* la gestion des evenements n’est presentee que plus
* tard (section events) dans une classe heritant
* de ExInterface. Les variables sont de type protected
* afin de pouvoir y accéder dans cette sous-classe.
*/
public JRadioButton button1, button2, button3;
public JComboBox couleur ;
public JTextField text ;
public JButton ajout ;
public JList textList ;
public Vector<String> listData ;
public Dessin dessin ;

public Exemple(){
    super("Les forme géométrie");
    //le programme doit se terminer quand la fenetre est fermee
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // creation du panel gauche
    JPanel gauche = new JPanel(new GridLayout(6, 1, 0, 5));
    
    // creation des cases a cocher
    JLabel label = new JLabel("Forme:");
    button1 = new JRadioButton("Carre", true);
    button2 = new JRadioButton("Cercle", false);
    button3 = new JRadioButton("Triangle", false);
    JLabel label2 = new JLabel("Couleur:");
    couleur = new JComboBox();
    couleur.addItem("Bleu");
    couleur.addItem("Rouge");
    couleur.addItem("Vert");
    
    // le groupe de bouton permet d’interdire la selection
    // de plusieurs cases en meme temps
    ButtonGroup group = new ButtonGroup();
    group.add(button1);
    group.add(button2);
    group.add(button3);
    
    // remplissage du panel gauche
    gauche.add(label);
    gauche.add(button1);
    gauche.add(button2);
    gauche.add(button3);
    gauche.add(label2);
    gauche.add(couleur);
    // creation du panel bas
    JPanel bas = new JPanel(new BorderLayout(0, 10));
    // creation et remplissage du panel d’ajout de texte
    JPanel textPanel = new JPanel(new GridLayout(3, 1, 0, 5));
    label = new JLabel("Ajouter un texte possible:");
    textPanel.add(label);
    text = new JTextField(16);
    textPanel.add(text);
    ajout = new JButton("Ajouter");
    textPanel.add(ajout);
    
    // creation du modele de la liste
    listData = new Vector<String>();
    listData.addElement("Hello World");
    listData.addElement("Une belle figure");
    listData.addElement("Champions du monde !");
    listData.addElement("A ciao, bonsoir...");
    listData.addElement("Changez la couleur");
    listData.addElement("J’adore Java");
    listData.addElement("Allez les verts !");
    listData.addElement("Ca marche");
    listData.addElement("blablabla");
    
    // creation de la liste
    textList = new JList(listData);
    textList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    // l’inclusion de la liste dans un JScrollPane permet
    // de la faire defiler par des ascenceurs
    JScrollPane scrollPane = new JScrollPane(textList);
    scrollPane.setPreferredSize(new Dimension(200, 100));
    
    // remplissage du panel bas
    bas.add(scrollPane, BorderLayout.NORTH);
    bas.add(textPanel, BorderLayout.SOUTH);
    
    // remplissage du panel principal
    JPanel mainPanel = (JPanel) this.getContentPane();
    mainPanel.setLayout(new BorderLayout(10, 10));
    mainPanel.add(gauche, BorderLayout.WEST);
    dessin = new Dessin();
    mainPanel.add(dessin, BorderLayout.CENTER);
    mainPanel.add(bas, BorderLayout.SOUTH);
    
    // une bordure permet d’aerer l’affichage
    mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
    // calcul de la dimension de la fenetre
    this.pack();
}
public static void main(String[] args) {
    Exemple myInterface = new Exemple();
    myInterface.setVisible(true);
}

}
// Cette classe herite de canvas pour redéfinir la
// methode paint. La vue est codee dans cette classe
class Dessin extends Canvas {
    String figure ;
    Color couleur ;
    String text ;
    // le constructeur de la classe
    public Dessin() {
        figure = "Carre";
        couleur = Color.blue ;
        text = "Hello World" ;
        this.setBackground(Color.white);
    }

    public void paint(Graphics g) {
        // un rectangle noir encadre le composant
        g.setColor(Color.black);
        g.drawRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);
        // le texte est affiche
        g.drawString(text, 10, 15);
        // la couleur est choisie
        g.setColor(couleur);
        // la figure est affichee
        if (figure.equals("Carre")) {
            g.drawRect(50, 30, 100, 100);
        } else if (figure.equals("Cercle")) {
            g.drawOval(50, 30, 100, 100);
        } else {
            g.drawLine(50, 130, 100, 30);
            g.drawLine(100, 30, 150, 130);
            g.drawLine(50, 130, 150, 130);
        }
    }
    // ces methodes permettent de changer le texte,
    // la couleur ou la figure a afficher
    public void setText(String txt) {
        text = txt ;
    }
    public void setCouleur(String coul) {
        if (coul.equals("Bleu")) {
            couleur = Color.blue ;
        } else if (coul.equals("Rouge")) {
            couleur = Color.red ;
        } else {
            couleur = Color.green ;
        }
    }
    public void setFigure(String fig) {
        figure = fig ;
    }
    // La redéfinition de cette methode permet de specifier
    // la taille preferree du composant
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }
}
