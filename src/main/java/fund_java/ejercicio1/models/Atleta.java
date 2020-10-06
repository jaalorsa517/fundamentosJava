package fund_java.ejercicio1.models;

public class Atleta {
    private String name;
    private String nacionality;
    private float time;

    public Atleta(String name, String nacionality, float time) {
        this.name = name;
        this.nacionality = nacionality;
        this.time = time;
    }

    public String getName() {
        return this.name;
    }

    public String getNacionality() {
        return this.nacionality;
    }

    public float getTime() {
        return this.time;
    }

}