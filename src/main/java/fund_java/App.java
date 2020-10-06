package fund_java;

import fund_java.ejercicio1.views.Principal;
import fund_java.ejercicio2.TestMiColeccion;
import fund_java.utils.util;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcion = 3;
        do {
            opcion = util.validatorInt("LABORATORIO: FUNDAMENTOS JAVA\n 1.Ejercicio 1\n 2.Ejercicio 2\n 3.Salir\n");
            switch (opcion) {
                case 1:
                    Principal ejercicio1 = new Principal();
                    ejercicio1.interact();
                    break;
                case 2:
                    TestMiColeccion.main(args);
                    break;
                case 3:
                    System.out.println("Fin del programa LABORATORIO");
                    input.close();
                    break;
                default:
                    System.out.println("Opción incorrecta, intenta nuevamente");
            }
        } while (opcion != 3);
    }
}
