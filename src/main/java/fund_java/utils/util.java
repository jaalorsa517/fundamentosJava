package fund_java.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class util {

    /***
     * Clase que capitaliza un string separados por espacios
     * 
     * @param str String a capitalizar
     * @return String capitalizado
     */
    static public String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        String[] words = str.split(" ");
        String result = "";
        for (int i = 0; i < words.length; i++) {
            result += words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase() + " ";
        }
        return result;
    }

    /**
     * Valida una entrada hasta que contenga un caracter
     * 
     * @param message Mensaje informativo
     * @return String con el valor ingresado por el usuario
     */
    static public String validatorEmpty(String message) {
        Scanner input = new Scanner(System.in);
        String str = "";
        do {
            System.out.println(message);
            str = input.nextLine();
            if (str.isEmpty()) {
                System.out.println("El campo no puedo ser vacío, intente nuevamente");
            }
        } while (str.isEmpty());
        return str;
    }

    /**
     * Valida una entrada hasta que se ingrese un número
     * @param message Mensaje informativo
     * @return Entero con la opcion seleccionada
     */
    public static int validatorInt(String message) {
        Scanner input = new Scanner(System.in);
        int num = 0;
        do {
            try {
                System.out.println(message);
                num = input.nextInt();
                break;
            } catch (InputMismatchException error) {
                System.out.println("Recuerde solo ingresar números\n");
                input.nextLine();
            }
        } while (true);
        return num;
    }
}
