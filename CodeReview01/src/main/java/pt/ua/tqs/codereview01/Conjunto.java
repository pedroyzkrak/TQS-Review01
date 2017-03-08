package pt.ua.tqs.codereview01;


/**
 * @author Pedro
 *
 */

public class Conjunto<T> {
	private T[] numeros;
	private int cont;

	@SuppressWarnings("unchecked")
	public Conjunto() {
		numeros = (T[]) new Object[10];
		cont = 0;
	}

	@SuppressWarnings("unchecked")
	public void insert(T n) {
		if (!contains(n)) {
			if (cont == numeros.length) {
				T[] numeroz = numeros;
				numeros = (T[]) new Object[numeroz.length + 10];
				for (int i = 0; i < numeroz.length; i++)
					numeros[i] = numeroz[i];
			}
			numeros[cont] = n;
			cont++;
		}

	}

	@SuppressWarnings("unchecked")
	public void empty() {
		numeros = (T[]) new Object[10];
		cont = 0;
	}

	public boolean contains(T n) {
		for (int i = 0; i < cont; i++)
			if (numeros[i] == n)
				return true;
		return false;
	}

	public void remove(T n) {
		int pos = -1;
		if (contains(n)) {
			for (int i = 0; i < cont; i++) {
				if (n == numeros[i]) {
					pos = i;
					break;
				}
			}
		}
		if (pos != -1) {
			for (int k = pos; k < cont - 1; k++) {
				numeros[k] = numeros[k + 1];
			}
		}
		cont--; 
	}

        @Override
	public String toString() {
		String el = "";
		for (int i = 0; i < cont; i++) {
			el += numeros[i] + " ";
		}
		return el;
	}

	public int size() {
		return cont;
	}

	public Conjunto<T> unir(Conjunto<T> add) {
		Conjunto<T> uniao = new Conjunto<>();

		for (int i = 0; i < cont; i++) {
			uniao.insert(numeros[i]);
		}
		for (int k = 0; k < add.size(); k++) {
			uniao.insert(add.numeros[k]);
		}
		return uniao;
	}

	public Conjunto<T> subtrair(Conjunto<T> dif) {
		Conjunto<T> diferenca = new Conjunto<>();
		for (int i = 0; i < cont; i++) {
			int count = 0;
			for (int k = 0; k < dif.size(); k++) {
				if (numeros[i] == dif.numeros[k]) {
					count++;
				}
			}
			if (count == 0) {
				diferenca.insert(numeros[i]);
			}
		}
		return diferenca;
	}

	public Conjunto<T> interset(Conjunto<T> inter) {
		Conjunto<T> intersecao = new Conjunto<>();
		for (int i = 0; i < cont; i++) {
			for (int k = 0; k < inter.size(); k++) {
				if (numeros[i] == inter.numeros[k]) {
					intersecao.insert(numeros[i]);
				}
			}
		}
		return intersecao;
	}

}
