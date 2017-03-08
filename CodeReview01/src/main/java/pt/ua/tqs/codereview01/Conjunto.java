package pt.ua.tqs.codereview01;

import java.util.Arrays;

/**
 * @author Pedro
 * @param <T>
 *
 */
public class Conjunto<T> {

    private T[] elements;
    private int counter;

    public Conjunto() {
        elements = (T[]) new Object[10];
        counter = 0;
    }

    public void insert(T n) {
        if (!contains(n)) {
            if (counter == elements.length) {
                T[] newElements = elements;
                elements = (T[]) new Object[newElements.length + 10];
                System.arraycopy(newElements, 0, elements, 0, newElements.length);
            }
            elements[counter] = n;
            counter++;
        }

    }

    public void empty() {
        elements = (T[]) new Object[10];
        counter = 0;
    }

    public boolean contains(T n) {
        for (int i = 0; i < counter; i++) {
            if (elements[i] == n) {
                return true;
            }
        }
        return false;
    }

    public void remove(T n) {
        int pos = -1;
        if (contains(n)) {
            for (int i = 0; i < counter; i++) {
                if (n == elements[i]) {
                    pos = i;
                    break;
                }
            }
        }
        if (pos != -1) {
            for (int k = pos; k < counter - 1; k++) {
                elements[k] = elements[k + 1];
            }
        }
        counter--;
    }

    @Override
    public String toString() {
        StringBuilder strB = new StringBuilder();
        for (int i = 0; i < counter; i++) {
            strB.append(elements[i]);
            strB.append(" ");
        }
        return strB.toString();
    }

    public int size() {
        return counter;
    }

    public Conjunto<T> unir(Conjunto<T> add) {
        Conjunto<T> uniao = new Conjunto<>();

        for (int i = 0; i < counter; i++) {
            uniao.insert(elements[i]);
        }
        for (int k = 0; k < add.size(); k++) {
            uniao.insert(add.elements[k]);
        }
        return uniao;
    }

    public Conjunto<T> subtrair(Conjunto<T> dif) {
        Conjunto<T> diferenca = new Conjunto<>();
        for (int i = 0; i < counter; i++) {
            int count = 0;
            for (int k = 0; k < dif.size(); k++) {
                if (elements[i] == dif.elements[k]) {
                    count++;
                }
            }
            if (count == 0) {
                diferenca.insert(elements[i]);
            }
        }
        return diferenca;
    }

    public Conjunto<T> interset(Conjunto<T> inter) {
        Conjunto<T> intersecao = new Conjunto<>();
        for (int i = 0; i < counter; i++) {
            for (int k = 0; k < inter.size(); k++) {
                if (elements[i] == inter.elements[k]) {
                    intersecao.insert(elements[i]);
                }
            }
        }
        return intersecao;
    }    
}
