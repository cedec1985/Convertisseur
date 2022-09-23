import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ResourceBundle;

/**
 * <p>Title: Convertisseur Euro</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2001</p>
 * <p>Company: </p>
 * @author Julien Saligot
 * @version 1.0
 */

public class Convert {
  static ResourceBundle res = ResourceBundle.getBundle("Res");
  static Fenetre fen;

  public static void main(String[] argv) {
    fen = new Fenetre(res.getString("Convertisseur_Franc"));
  }
}

class Fenetre
    extends JFrame {
  static ResourceBundle res = ResourceBundle.getBundle("Res");

  Fenetre(String titre) {
    super(titre);
    getContentPane().setLayout(new GridLayout(3, 1));
    setBounds(100, 100, 400, 300);
    PanH PH = new PanH(res.getString("Convertisseur_Franc"));
    PanC PC = new PanC(res.getString("Montant_convertir_"), res.getString("Ce_montant_s_exprime"));
    PanB PB = new PanB(res.getString("Rsultat_"));
    getContentPane().add(PH);
    getContentPane().add(PC);
    getContentPane().add(PB);

    /*Pour centrer la fenêtre dans l'environnement*/
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension frameSize = this.getSize();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    this.setLocation( (screenSize.width - frameSize.width) / 2,
                     (screenSize.height - frameSize.height) / 2);

    setVisible(true);
    addWindowListener(
        new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
        System.exit(0);
      }
    });
  }

}

class PanH
    extends JPanel {

  PanH(String s) {
    add(new JLabel(s, JLabel.CENTER));
  }

}

class PanB
    extends JPanel {

  PanB(String s) {
    setLayout(new GridLayout(1, 3));
    add(new JLabel(s, JLabel.LEFT));
    add(PanC.resultat);
    add(PanC.monnaie);
  }

}

class PanC
    extends JPanel {
  static ResourceBundle res = ResourceBundle.getBundle("Res");

  JButton convertir, effacer;
  Choice liste = new Choice();
  JTextField texte = new JTextField(res.getString("Entrer_un_nombre"));
  float tauxEuro = 6.55957f;
  static JLabel monnaie = new JLabel(res.getString("FRANC_EURO_"), JLabel.RIGHT);
  static JLabel resultat = new JLabel(res.getString("Conversion_faite"), JLabel.CENTER);
  String chaine;
  int choixListe;

  PanC(String s1, String s2) {
    setLayout(new GridLayout(3, 3));
    convertir = new JButton(res.getString("Convertir"));
    liste.addItem(res.getString("Monnaie_choisir"));
    liste.addItem(res.getString("Francs_Fran_ais"));
    liste.addItem(res.getString("Euro"));
    effacer = new JButton(res.getString("Effacer"));
    convertir.addMouseListener(
        new MouseAdapter() {
      public void mousePressed(MouseEvent me) {
        choixListe = liste.getSelectedIndex();
        chaine = texte.getText();
        if (choixListe == 0) {
          /*Si aucun choix dans la liste des monnaies*/
          resultat.setText(res.getString("Monnaie_"));
        }
        else if (choixListe == 1) {
          /*Si on choisit de convertir en €*/
          monnaie.setText(res.getString("Euro"));
          try {
            /*On convertit le chiffre saisie*/
            Float intermediaire = java.lang.Float.valueOf(chaine);
            float resultatConvert = intermediaire.floatValue();
            /*On divise le chiffre par le taux de l'euro. Cela donne des euros*/
            resultatConvert /= tauxEuro;
            /*On affiche le resultat*/
            resultat.setText(java.lang.String.valueOf(resultatConvert));
          }
          catch (Exception e) {
            resultat.setText(res.getString("Erreur_de_saisie"));
          }
        }
        else if (choixListe == 2) {
          /*Si on choisit de convertir en franc*/
          monnaie.setText(res.getString("Francs_Fran_ais"));
          try {
            /*On convertit le chiffre saisie*/
            Float intermediaire = java.lang.Float.valueOf(chaine);
            float resultatConvert = intermediaire.floatValue();
            /*On multiplie le chiffre par le taux de l'euro. Cela donne des francs*/
            resultatConvert *= tauxEuro;
            /*On affiche le resultat*/
            resultat.setText(java.lang.String.valueOf(resultatConvert));
          }
          catch (Exception e) {
            resultat.setText(res.getString("Erreurde_saisie"));
          }
        }
        else {
          resultat.setText(res.getString("Erreur_"));
        }
      }
    });
    effacer.addMouseListener(
        new MouseAdapter() {
      public void mousePressed(MouseEvent me) {
        texte.setText("");
        monnaie.setText(res.getString("FRANC_EURO_"));
        resultat.setText(res.getString("Conversion_faite"));
        liste.select(0);
      }
    });
    add(new JLabel(s1, JLabel.RIGHT));
    add(texte);
    add(new JLabel(s2, JLabel.RIGHT));
    add(liste);
    add(convertir);
    add(effacer);
  }

}
