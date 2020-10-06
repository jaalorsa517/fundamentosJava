package fund_java.ejercicio1.models.bd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import fund_java.ejercicio1.models.Atleta;

public class Datos {

    // CONSTRUCTOR: Si el archivo no existe, lo crea
    public Datos() {
        try {
            File db = new File("atletas.txt");
            db.createNewFile();
        } catch (IOException error) {
            System.out.println("Error al abrir-crear db");
        }
    }

    static public String newAthlete(Atleta atleta) {
        File db;
        try {
            db = new File("atletas.txt");
            FileWriter saveAthlete = new FileWriter(db, true);
            saveAthlete.write(String.join(",", atleta.getName(), atleta.getNacionality(),
                    String.valueOf(atleta.getTime()) + "\n"));
            saveAthlete.close();
            return "Atleta guardado\n";
        } catch (IOException error) {
            return "Hubo un error al guardar el atleta\n";
        }
    }

    static public Atleta[] getAthletes() {
        File db = new File("atletas.txt");
        if (db.exists()) {
            ArrayList<Atleta> atletas = new ArrayList<Atleta>();
            try {
                Scanner input = new Scanner(db);
                input.useDelimiter("\n");
                while (input.hasNext()) {
                    String[] atletaOfDb = input.next().split(",");
                    Atleta atletaObject = new Atleta(atletaOfDb[0], atletaOfDb[1], Float.parseFloat(atletaOfDb[2]));
                    atletas.add(atletaObject);
                }
                input.close();
            } catch (FileNotFoundException error) {
                System.out.println("Db not found");
            }
            return convertToList(atletas);
        }
        return null;
    }

    static public Atleta[] getAthletesByCountry(String nacionality) {
        Atleta[] athletes = getAthletes();
        if (athletes != null) {
            ArrayList<Atleta> athletesCountry = new ArrayList<Atleta>();
            for (int i = 0; i < athletes.length; i++) {
                if (athletes[i].getNacionality().equals(nacionality)) {
                    athletesCountry.add(athletes[i]);
                }
            }
            return convertToList(athletesCountry);
        } else {
            return null;
        }
    }

    static private Atleta[] convertToList(ArrayList<Atleta> list) {
        if (list.isEmpty()) {
            return null;
        }
        Atleta[] atletasList = new Atleta[list.size()];
        for (int i = 0; i < atletasList.length; i++) {
            atletasList[i] = list.get(i);
        }
        return atletasList;
    }
}
