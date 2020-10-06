package fund_java.ejercicio1.controllers;

import fund_java.ejercicio1.models.Atleta;
import fund_java.ejercicio1.models.bd.Datos;

public class Competencia {

    private Atleta listToAtleta(String[] atleta) {
        return new Atleta(atleta[0], atleta[1], Float.parseFloat(atleta[2]));
    }

    private Atleta getChampion(Atleta[] athletes) {
        int lessTime = 0;
        for (int i = 1; i < athletes.length; i++) {
            if (athletes[i].getTime() < athletes[lessTime].getTime()) {
                lessTime = i;
            }
        }
        return athletes[lessTime];
    }

    public String registerAthlete(String[] atleta) {
        return Datos.newAthlete(listToAtleta(atleta));
    }

    public String[] getCampeon() {
        Atleta[] athletes = Datos.getAthletes();
        if (athletes == null) {
            return null;
        }
        Atleta champion = getChampion(athletes);
        String[] championString = { champion.getName(), champion.getNacionality(), String.valueOf(champion.getTime()) };
        return championString;
    }

    public String athleteByCountry(String nacionality) {
        Atleta[] athletes = Datos.getAthletesByCountry(nacionality);
        if (athletes != null) {
            String athletesString = "NOMBRE --- TIEMPO\n";
            for (int i = 0; i < athletes.length; i++) {
                athletesString += athletes[i].getName() + " --- " + String.valueOf(athletes[i].getTime()) + "\n";
            }
            return athletesString;
        } else {
            return "No existe ningún registro!\n";
        }
    }

    public String mediaTime() {
        Atleta[] athletes = Datos.getAthletes();
        if (athletes == null) {
            return "No datos";
        }
        float media = 0;
        for (int i = 0; i < athletes.length; i++) {
            media += athletes[i].getTime();
        }
        return String.valueOf(media / athletes.length);
    }
}