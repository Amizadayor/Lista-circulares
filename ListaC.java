import java.util.Scanner;
import javax.swing.JOptionPane;

public class ListaC{ // Creamos la clase ListaC //
    Nodo primero;
    Nodo ultimo;
    Scanner t = new Scanner(System.in);

    public class Nodo{
        int dato;
        Nodo siguiente;
    }
    private void mensaje(String cad){
        System.out.println (cad);
    }
    public ListaC(){
        primero = null;
        ultimo = null;
    }
    public void Insertar(int a){ // Esta clase Insertara el nodo en la lista
        Nodo nuevo = new Nodo();
        nuevo.dato = a;
        int v;
        do{
            try {
                v=0;
                if(primero == null){
                    primero = nuevo;
                    ultimo = primero;
                    primero.siguiente = ultimo;
                }else{
                    ultimo.siguiente = nuevo;
                    nuevo.siguiente = primero;
                    ultimo = nuevo;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog (null, " INGRESE SOLO NUMEROS ENTEROS ", " ERROR ", JOptionPane.ERROR_MESSAGE);
                t.nextLine();
                v=1;
            }
        }while(v!=0);
    }
    public void Buscar(int a){ // Esta clase buscara el nodo entre la lista//
        Nodo actual = new Nodo();
        actual = primero;
        boolean encontrado= false;
        int v;
        do{
            try {
                v=0;
                do{
                    if(actual.dato == a){
                        encontrado = true;
                    }
                    actual = actual.siguiente;
                }while(actual != primero);
                if(encontrado == true){
                    JOptionPane.showMessageDialog (null, " DATO ENCONTRADO  ");
                }else{
                    JOptionPane.showMessageDialog (null, " DATO NO ENCONTRADO ", " ERROR ", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog (null, " INGRESE SOLO NUMEROS ENTEROS ", " ERROR ", JOptionPane.ERROR_MESSAGE);
                t.nextLine();
                v=1;
            }
        }while(v!=0);
    }
    public void Editar(int a){ // Esta clase modificara el nodo de la  lista//
        Nodo actual = new Nodo();
        actual = primero;
        int v;
        do{
            try {
                v=0;
                do{//creamos un ciclo.
                    if(actual.dato == a){
                        actual.dato = t.nextInt();
                    }
                    actual = actual.siguiente;
                }while(actual != primero);
            } catch (Exception e) {
                JOptionPane.showMessageDialog (null, " INGRESE SOLO NUMEROS ENTEROS ", " ERROR ", JOptionPane.ERROR_MESSAGE);
                t.nextLine();
                v=1;
            }
        }while(v!=0);
    }
    public void Eliminar(int a){ // esta clase eliminara un Nodo de la lista
        Nodo actual = new Nodo();
        Nodo anterior = new Nodo();
        actual= primero;
        anterior=ultimo;
        int v;
        do{
            try {
                v=0;
                do{
                    if(actual.dato == a){
                        if(actual == primero){
                            primero = primero.siguiente;
                            ultimo.siguiente = primero;
                        }else if(actual == ultimo){
                            anterior.siguiente = ultimo.siguiente;
                            ultimo = anterior;
                        }else{
                            anterior.siguiente = actual.siguiente;
                        }
                        JOptionPane.showMessageDialog (null, " DATO ELIMINADO  ");
                    }
                    anterior = actual;
                    actual = actual.siguiente;
                }while(actual!=primero);
            } catch (Exception e) {
                JOptionPane.showMessageDialog (null, " INGRESE SOLO NUMEROS ENTEROS ", " ERROR ", JOptionPane.ERROR_MESSAGE);
                v=1;
                t.nextLine();
            }
        }while(v!=0);
    }
    public void Listar(){ // Esta clase Listara todos los nodos disponibles en la lista //
        int c =1;
        Nodo actual = new Nodo();
        actual = primero;
            do{
                mensaje ("POSICION = [" + c + "] VALOR = " + actual.dato);
                actual = actual.siguiente;
                c++;
            }while(actual != primero);
    }
    public static void main(String [] args){
        ListaC l = new ListaC();
        Scanner t = new Scanner(System.in);
        int op = 0;
        int v;
        do{
            try {
                v=0; //  Este es el menu de opciones que se mostrara al usuario , en la cual podra realizar varias funciones. //
                do{
                    System.out.println (" _________________________________ ");
                    System.out.println ("|                                 |");
                    System.out.println ("|        MENU DE OPCIONES         |");
                    System.out.println ("|                                 |");
                    System.out.println ("|       1. - INSERTAR NODO        |");
                    System.out.println ("|       2. - BUSCAR NODO          |");
                    System.out.println ("|       3. - EDITAR NODO          |");
                    System.out.println ("|       4. - ELIMINAR NODO        |");
                    System.out.println ("|       5. - LISTAR NODOS         |");
                    System.out.println ("|       6. - SALIR                |");
                    System.out.println ("|_________________________________|");
                    System.out.println ("|                                 |");
                    System.out.println ("|       ELIJA SU OPCION           |");
                    System.out.println ("|_________________________________|");
                    op = t.nextInt();
                    switch(op){
                        case 1:
                        System.out.println(" INGRESE EL VALOR DEL NODO A INSERTAR : ");
                        int dato = t.nextInt();
                        l.Insertar(dato);
                        break;
                        case 2:
                        System.out.print(" INGRESE EL VALOR DEL NODO A BUSCAR : ");
                        dato = t.nextInt();
                        l.Buscar(dato);
                        break;
                        case 3:
                        System.out.print(" INGRESE EL VALOR DEL DATO A EDITAR : ");
                        dato = t.nextInt();
                        l.Editar(dato);
                        break;
                        case 4:
                        System.out.print(" INGRESE EL VALOR DEL DATO A ELIMINAR : ");
                        dato = t.nextInt();
                        l.Eliminar(dato);
                        break;
                        case 5:
                        System.out.println("***** LISTADO GENERAL *****");
                        l.Listar();
                        break;
                        case 6:
                        break;
                        default:
                    }
                }while(op!=6);
            } catch (Exception e) {
                JOptionPane.showMessageDialog (null, " INGRESE SOLO NUMEROS ENTEROS ", " ERROR ", JOptionPane.ERROR_MESSAGE);
                v=1;
                t.nextLine();
            }
        }while(v!=0);
    }
}
