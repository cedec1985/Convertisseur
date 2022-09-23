import java.util.*;
public class Cercle {
public int x,y,r;
public static int nombre;

public void créer(){
Scanner lectureclavier=new Scanner(System.in);
System.out.println("position en x:");
x=lectureclavier.nextInt();
System.out.println("position en y:");
y=lectureclavier.nextInt();
System.out.println("rayon:");
r=lectureclavier.nextInt();
nombre++;

}

public void afficher(){
    System.out.println("cercle centre en"+x+","+y);
    System.out.println("de rayon:"+r);
}
public double perimetre(){
    return 2*Math.PI*r;

}
public void deplacer(int nx,int ny){
    x=nx;
    y=ny;
}
public void agrandir(int nr){
    r=r+nr;
}

public void compterdescercles (){
        Cercle A=new Cercle();
        System.out.println("nombre de cercles:" + Cercle.nombre);
        Cercle B=new Cercle ();
        System.out.println("nombre de cercles:" + Cercle.nombre);

}

public void echanger(Cercle autre){
int temp;
temp=x;
x=autre.x;
autre.x=temp;
temp=y;
y=autre.y;
autre.y=temp;

}

public static void main(String[] args){
Cercle A = new Cercle();   
A.afficher();
Scanner lectureclavier=new Scanner(System.in);
System.out.println("entrez la position en x:");
A.x = lectureclavier.nextInt();
System.out.println("entrez la position en y:");
A.y=lectureclavier.nextInt();
System.out.println("entrez le rayon:");
A.r =lectureclavier.nextInt();
A.afficher();
double p =A.perimetre();
System.out.println("votre cercle a pour périmètre:"+p);
A.deplacer(5,2);
System.out.println("après déplacement:");
A.afficher();
A.agrandir(10);
System.out.println("après agrandissement:");
A.afficher();

Cercle A1=new Cercle();
A1.créer();
System.out.println("le cercle B:");
A1.afficher();
double p1=A1.perimetre();
System.out.println("votre cercle a pour périmètre:"+p1);
Cercle B=new Cercle();
B.créer();
System.out.println("le cercle C:");
B.afficher();
B.echanger(A1);
System.out.println("après échange:");
System.out.println("le cercle C:");
B.afficher();
System.out.println("le cercle B:");
B.afficher();

A.créer();
System.out.println("nombre de cercles:" + Cercle.nombre);

B.créer();
System.out.println("nombre de cercles:" + Cercle.nombre);
} 
}

                


