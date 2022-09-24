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
public int rayon=3;
public void rayonprotege(){
    Cercle A = new Cercle();
    A.afficher();
    Scanner lectureclavier=new Scanner(System.in);
    System.out.println("position en x:");
    x=lectureclavier.nextInt();
    System.out.println("position en y:");
    y=lectureclavier.nextInt();

    do{
        System.out.println("rayon:");
        r=lectureclavier.nextInt(); }
    while (r<0 || r>TailleEcran);}

public void supplanter(int nr){
if (r+nr>r) r=0;
else if(r+nr>TailleEcran) r=TailleEcran;
else r =r+nr;
}

public int getRayon(){
    return rayon;
}
public void setRayon(int r){
    rayon=r;
    setRayon(15);
    System.out.println("après modification"+getRayon());

}
public int TailleEcran=600;
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
A.agrandir(2);
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

Cercle A2= new Cercle();
A2.créer();
A2.afficher();
System.out.println("entrez une valeur d'agrandissement:");
int r = lectureclavier.nextInt();
A2.rayonprotege();
A2.supplanter(2);
System.out.println("après agrandissement:");
A2.afficher();
}}



                



