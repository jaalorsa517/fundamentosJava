package fund_java.ejercicio1.views;

import java.util.Scanner;

import fund_java.ejercicio1.controllers.Competencia;
import fund_java.utils.util;

public class Principal {

    private Competencia competencia;

    // CONSTRUCTOR
    public Principal() {
        this.competencia = new Competencia();
    }

    public void interact() {
        int option = 0;
        while (option != 5) {
            option = util.validatorInt(menu());
            optionSelected(option);
        }
    }

    private String menu() {
        return "        COMPETENCIA \n" + "1. Registrar atleta. \n" + "2. Datos del campeon.\n"
                + "3. Atleta por pais. \n" + "4. Tiempo promedio de todos los atletas. \n" + "5. Salir \n";
    }

    private void optionSelected(int option) {
        switch (option) {
            case 1:
                System.out.println(this.competencia.registerAthlete(registrar()));
                break;
            case 2:
                String[] champion = competencia.getCampeon();
                if (champion == null) {
                    System.out.println("No existe atletas!\n");
                } else {
                    System.out.println("El campeon actual es: \nNombre:" + champion[0] + "\nNacionalidad: "
                            + champion[1] + "\nTiempo: " + champion[2] + "\n");
                }
                break;
            case 3:
                System.out.println(competencia.athleteByCountry(country()));
                break;
            case 4:
                System.out.println("El tiempo promedio de los atletas registrados es: " + competencia.mediaTime()+"\n");
                break;
            case 5:
                System.out.println("Fin ejercicio 1\n");
                break;
            default:
                System.out.println("Opción incorrecta, intenta nuevamente\n");
                break;
        }
    }

    private String country() {
        Scanner country = new Scanner(System.in);
        System.out.println("Ingrese el país que quieres filtrar");
        return util.capitalize(country.nextLine());
    }

    private String[] registrar() {
        String[] atleta = new String[3];
        atleta[0] = util.capitalize(util.validatorEmpty("Nombre del atleta"));
        atleta[1] = util.capitalize(util.validatorEmpty("Nacionalidad del atleta"));
        atleta[2] = util.validatorEmpty("Tiempo en segundos del atleta");
        return atleta;
    }
}