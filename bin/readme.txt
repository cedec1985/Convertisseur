Convertisseur franc-euro (et vice-versa)----------------------------------------
Url     : http://codes-sources.commentcamarche.net/source/15676-convertisseur-franc-euro-et-vice-versaAuteur  : cs_JuSDate    : 04/08/2013
Licence :
=========

Ce document intitulé « Convertisseur franc-euro (et vice-versa) » issu de CommentCaMarche
(codes-sources.commentcamarche.net) est mis à disposition sous les termes de
la licence Creative Commons. Vous pouvez copier, modifier des copies de cette
source, dans les conditions fixées par la licence, tant que cette note
apparaît clairement.

Description :
=============

Ce programme est un convertisseur FRANC-EURO.
<br />Son utilisation est tr&egra
ve;s simple. On rentre le chiffre &agrave; convertir, puis on choisit la monnaie
. Enfin on clique sur le bouton &quot;convertir&quot; qui ... convertit en la mo
nnaie choisit.
<br />
<br />Il a &eacute;t&eacute; fait lors de ma derni&egrav
e;re ann&eacute;e d'IUT (c'est pour cela que ce n'est pas tr&egrave;s pouss&eacu
te;, ni tr&egrave;s &eacute;volu&eacute;, ... ni tr&egrave;s beau).
<br /><a na
me='source-exemple'></a><h2> Source / Exemple : </h2>
<br /><pre class='code' 
data-mode='basic'>
import java.awt.*;
import java.awt.event.*;
import javax.s
wing.*;
import java.util.ResourceBundle;

/**

<ul> <li> &lt;p&gt;Title: Co
nvertisseur Euro&lt;/p&gt;
</li> <li> &lt;p&gt;Description: &lt;/p&gt;
</li> <
li> &lt;p&gt;Copyright: Copyright (c) 2001&lt;/p&gt;
</li> <li> &lt;p&gt;Compan
y: &lt;/p&gt;
</li> <li> @author JuS
</li> <li> @version 1.0
</li> <li>/</li>
</ul>

public class Convert {
  static ResourceBundle res = ResourceBundle.ge
tBundle(&quot;Res&quot;);
  static Fenetre fen;

  public static void main(St
ring[] argv) {
    fen = new Fenetre(res.getString(&quot;Convertisseur_Franc&qu
ot;));
  }
}

class Fenetre
    extends JFrame {
  static ResourceBundle r
es = ResourceBundle.getBundle(&quot;Res&quot;);

  Fenetre(String titre) {
  
  super(titre);
    getContentPane().setLayout(new GridLayout(3, 1));
    setB
ounds(100, 100, 400, 300);
    PanH PH = new PanH(res.getString(&quot;Convertis
seur_Franc&quot;));
    PanC PC = new PanC(res.getString(&quot;Montant_converti
r_&quot;), res.getString(&quot;Ce_montant_s_exprime&quot;));
    PanB PB = new 
PanB(res.getString(&quot;Rsultat_&quot;));
    getContentPane().add(PH);
    g
etContentPane().add(PC);
    getContentPane().add(PB);

    /*Pour centrer la
 fenêtre dans l'environnement*/
    Toolkit tk = Toolkit.getDefaultToolkit();

    Dimension frameSize = this.getSize();
    Dimension screenSize = Toolkit.ge
tDefaultToolkit().getScreenSize();
    this.setLocation( (screenSize.width - fr
ameSize.width) / 2,
                     (screenSize.height - frameSize.height)
 / 2);

    setVisible(true);
    addWindowListener(
        new WindowAdapt
er() {
      public void windowClosing(WindowEvent we) {
        System.exit(0
);
      }
    });
  }

}

class PanH
    extends JPanel {

  PanH(Str
ing s) {
    add(new JLabel(s, JLabel.CENTER));
  }

}

class PanB
    ex
tends JPanel {

  PanB(String s) {
    setLayout(new GridLayout(1, 3));
    
add(new JLabel(s, JLabel.LEFT));
    add(PanC.resultat);
    add(PanC.monnaie)
;
  }

}

class PanC
    extends JPanel {
  static ResourceBundle res = R
esourceBundle.getBundle(&quot;Res&quot;);

  JButton convertir, effacer;
  Ch
oice liste = new Choice();
  JTextField texte = new JTextField(res.getString(&q
uot;Entrer_un_nombre&quot;));
  float tauxEuro = 6.55957f;
  static JLabel mon
naie = new JLabel(res.getString(&quot;FRANC_EURO_&quot;), JLabel.RIGHT);
  stat
ic JLabel resultat = new JLabel(res.getString(&quot;Conversion_faite&quot;), JLa
bel.CENTER);
  String chaine;
  int choixListe;

  PanC(String s1, String s2
) {
    setLayout(new GridLayout(3, 3));
    convertir = new JButton(res.getSt
ring(&quot;Convertir&quot;));
    liste.addItem(res.getString(&quot;Monnaie_cho
isir&quot;));
    liste.addItem(res.getString(&quot;Francs_Fran_ais&quot;));
 
   liste.addItem(res.getString(&quot;Euro&quot;));
    effacer = new JButton(re
s.getString(&quot;Effacer&quot;));
    convertir.addMouseListener(
        new
 MouseAdapter() {
      public void mousePressed(MouseEvent me) {
        choi
xListe = liste.getSelectedIndex();
        chaine = texte.getText();
        i
f (choixListe == 0) {
          /*Si aucun choix dans la liste des monnaies*/

          resultat.setText(res.getString(&quot;Monnaie_&quot;));
        }
   
     else if (choixListe == 1) {
          /*Si on choisit de convertir en ?*/

          monnaie.setText(res.getString(&quot;Euro&quot;));
          try {
 
           /*On convertit le chiffre saisie*/
            Float intermediaire =
 java.lang.Float.valueOf(chaine);
            float resultatConvert = intermedi
aire.floatValue();
            /*On divise le chiffre par le taux de l'euro. Ce
la donne des euros*/
            resultatConvert /= tauxEuro;
            /*On
 affiche le resultat*/
            resultat.setText(java.lang.String.valueOf(re
sultatConvert));
          }
          catch (Exception e) {
            resu
ltat.setText(res.getString(&quot;Erreur_de_saisie&quot;));
          }
       
 }
        else if (choixListe == 2) {
          /*Si on choisit de convertir 
en franc*/
          monnaie.setText(res.getString(&quot;Francs_Fran_ais&quot;)
);
          try {
            /*On convertit le chiffre saisie*/
           
 Float intermediaire = java.lang.Float.valueOf(chaine);
            float resul
tatConvert = intermediaire.floatValue();
            /*On multiplie le chiffre 
par le taux de l'euro. Cela donne des francs*/
            resultatConvert *= t
auxEuro;
            /*On affiche le resultat*/
            resultat.setText(j
ava.lang.String.valueOf(resultatConvert));
          }
          catch (Except
ion e) {
            resultat.setText(res.getString(&quot;Erreurde_saisie&quot;
));
          }
        }
        else {
          resultat.setText(res.getS
tring(&quot;Erreur_&quot;));
        }
      }
    });
    effacer.addMouseL
istener(
        new MouseAdapter() {
      public void mousePressed(MouseEven
t me) {
        texte.setText(&quot;&quot;);
        monnaie.setText(res.getSt
ring(&quot;FRANC_EURO_&quot;));
        resultat.setText(res.getString(&quot;Co
nversion_faite&quot;));
        liste.select(0);
      }
    });
    add(new
 JLabel(s1, JLabel.RIGHT));
    add(texte);
    add(new JLabel(s2, JLabel.RIGH
T));
    add(liste);
    add(convertir);
    add(effacer);
  }

}
</pre>
