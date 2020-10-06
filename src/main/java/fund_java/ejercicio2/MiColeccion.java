package fund_java.ejercicio2;

import java.util.*;

public class MiColeccion {
    ArrayList<Integer> numeros;

    public MiColeccion() {
        this.numeros = new ArrayList<Integer>();
    }

    public void insertarAlFinal(int valor) {
        this.numeros.add(valor);
    }

    public void insertarAlPrincipio(int valor) {
        this.numeros.add(0, valor);
    }

    public void agregarAlFinal(List<Integer> l) {
        this.numeros.addAll(l);
    }

    public void eliminar(int posicion) {
        this.numeros.remove(posicion);
    }

    public void setValor(int posicion, int valor) {
        this.numeros.add(posicion, valor);
    }

    public int getValor(int posicion) {
        return this.numeros.get(posicion);
    }

    public int getSumatoria() {
        int sum = 0;
        for (int i = 0; i < this.numeros.size(); i++) {
            sum += this.numeros.get(i);
        }
        return sum;
    }

    public double getPromedio() {
        return (double) getSumatoria() / cuentaElementos();
    }

    public int cuentaElementos() {
        return this.numeros.size();
    }

    public int cuentaCeros() {
        int ceros = 0;
        for (int i = 0; i < this.numeros.size(); i++) {
            if (this.numeros.get(i).equals(0)) {
                ceros++;
            }
        }
        return ceros;
    }

    public int sumaPares() {
        int sumPares = 0;
        for (int i = 0; i < this.numeros.size(); i++) {
            if (this.numeros.get(i) % 2 == 0) {
                sumPares += this.numeros.get(i);
            }
        }
        return sumPares;
    }

    public int cuentaRepeticiones(int numero) {
        int repetido = 0;
        for (int i = 0; i < this.numeros.size(); i++) {
            if (this.numeros.get(i).equals(numero)) {
                repetido++;
            }
        }
        return repetido;
    }

    public void reemplazarValor(int antiguoValor, int nuevoValor) {
        while (true) {
            if (buscar(antiguoValor)) {
                int indice = -1;
                int i = 0;
                while (indice == -1) {
                    if (this.numeros.get(i) == antiguoValor) {
                        indice = i;
                        this.numeros.set(i, nuevoValor);
                    } else {
                        i++;
                    }
                }
            }
            else{
                break;
            }
        }
    }

    public void reemplazarTodo(List<Integer> a) {
        this.numeros.removeAll(this.numeros);
        this.numeros.addAll(a);
    }

    public ArrayList<Integer> invertir() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < this.numeros.size(); i++) {
            list.add(this.numeros.get((this.numeros.size() - 1) - i));
        }
        return list;
    }

    public int getMayor() {
        int mayor = this.numeros.get(0);
        for (int i = 1; i < this.numeros.size(); i++) {
            if (mayor < this.numeros.get(i)) {
                mayor = this.numeros.get(i);
            }
        }
        return mayor;
    }

    public int getMenor() {
        int menor = this.numeros.get(0);
        for (int i = 1; i < this.numeros.size(); i++) {
            if (menor > this.numeros.get(i)) {
                menor = this.numeros.get(i);
            }
        }
        return menor;
    }

    public ArrayList<Integer> getPrimeros(int cantidad) {
        ArrayList<Integer> primeros = new ArrayList<Integer>();
        for (int i = 0; i < cantidad; i++) {
            primeros.add(this.numeros.get(i));
        }
        return primeros;
    }

    public ArrayList<Integer> getUltimos(int cantidad) {
        ArrayList<Integer> ultimos = new ArrayList<Integer>();
        for (int i = cantidad; i > 0; i--) {
            ultimos.add(this.numeros.get((this.numeros.size()) - i));
        }
        return ultimos;
    }

    public boolean esPalindrome() {
        ArrayList<Integer> reverso = invertir();
        for (int i = 0; i < this.numeros.size(); i++) {
            if (!this.numeros.get(i).equals(reverso.get(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean buscar(int numero) {
        return this.numeros.contains(numero);
    }

    public void mostrarContenido() {
        System.out.println(this.numeros);
    }

}