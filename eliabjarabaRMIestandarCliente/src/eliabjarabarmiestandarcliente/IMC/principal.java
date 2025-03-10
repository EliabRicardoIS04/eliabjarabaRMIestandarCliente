package eliabjarabarmiestandarcliente.IMC;

import java.awt.BorderLayout;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import lib.interfaceRClassDatosIMC;
import lib.ClassDatosIMC;

public class principal {

    public static void main(String[] args) {
        ClassDatosIMC datos = new ClassDatosIMC();
        ClassDatosIMC res= new ClassDatosIMC();
        Scanner sc = new Scanner(System.in);
        try {
            Registry registry = LocateRegistry.getRegistry();
            interfaceRClassDatosIMC stub = (interfaceRClassDatosIMC) registry.lookup("interfaceRClassDatosIMC");
            System.out.println("ingrese el peso:  ");
            datos.setPeso(sc.nextFloat());
            System.out.println("ingrese la altura:  ");
            datos.setAltura(sc.nextFloat());
            
            res = stub.CalcularIMC(datos);
            
            System.out.println("Resultado: " + res.getResultado());
            System.out.println("Mensaje: " + res.getInterpretacion());
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

}
