import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ResourceBundle;


    public class euroconvertisseur {
        static ResourceBundle res = ResourceBundle.getBundle("res");
        
       
     public class fenetre extends JFrame{
            ResourceBundle res=ResourceBundle.getBundle("res");
    fenetre(String titre) {
        getContentPane().setLayout(new GridLayout(3, 1));
    setBounds(100, 100, 400, 300);
    PanH PH = new PanH(res.getString("Convertisseur_euro"));
    getContentPane().add(PH);
    PanC PC = new PanC(res.getString("Montant_convertir_"), res.getString("Ce_montant_s_exprime"));
    getContentPane().add(PC);

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
class PanH
extends JPanel {

PanH(String s) {
setLayout(new GridLayout(1, 3));    
add(new JLabel(s, JLabel.CENTER));

}
}   
public class PanC
    extends JPanel {


ResourceBundle res = ResourceBundle.getBundle("Res");

  JTextField texte = new JTextField(res.getString("entrez un nombre"));

  JButton euros = new JButton("euros");
  JButton exit = new JButton("exit");
  JButton francs = new JButton("francs");

private double valeur;

   

public static class conversion {
        private conversion() {
        }

        static final double TAUX_DE_CONVERSION = 6.55957;

        public static  double convertirEnEuros(double francs) {
        return francs / TAUX_DE_CONVERSION;
    }

        public static  double convertirEnFrancs(double euros) {
        return euros * TAUX_DE_CONVERSION;
    }}

        public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit)
            System.out.println("un message");

        string monnaie= null;
        try {
            valeur = (Double.parseDouble(monnaie.getString("Monnaie ?")));
        } catch (NumberFormatException ex) {
            monnaie.getString("Valeur réelle erronnée");
            return;
        }
        
        if (e.getSource() == euros)
            monnaie.getText(Double.toString(conversion.convertirEnEuros(this.valeur)));
        else
            monnaie.getText(Double.toString(conversion.convertirEnFrancs(this.valeur)));}
    
        PanC(String s1, String s2) {
        setLayout(new GridLayout(3, 3));
        res.getString("Monnaie_choisir");
        res.getString("Francs_Fran_ais");
        res.getString("Euro");
        }}}
        private static void launch(String[] argv) {
        }public static void main(String[] argv){
          launch(argv);}}
      

   
