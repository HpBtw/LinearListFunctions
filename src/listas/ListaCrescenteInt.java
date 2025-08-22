package listas;

public class ListaCrescenteInt {

	private class NO {
		int dadoExemplo;
		NO proxExemplo;
	}

	NO listaExemplo = null;

	public boolean isEmpty() {
		return (listaExemplo == null);
	}

	public void add(int elem) {
		NO novo = new NO();
		novo.dadoExemplo = elem;
		if (isEmpty()) {
			listaExemplo = novo;
			novo.proxExemplo = null;
		} else if (novo.dadoExemplo < listaExemplo.dadoExemplo) {
			novo.proxExemplo = listaExemplo;
			listaExemplo = novo;
		} else {
			NO aux = listaExemplo;
			boolean achou = false;
			while (aux.proxExemplo != null && !achou) {
				if (aux.proxExemplo.dadoExemplo < novo.dadoExemplo)
					aux = aux.proxExemplo;
				else
					achou = true;
			}
			novo.proxExemplo = aux.proxExemplo;
			aux.proxExemplo = novo;
		}
	}
	public void show() {
		NO aux = listaExemplo;
		System.out.println("*********** Lista ************");
		while (aux!=null) {
			System.out.print(aux.dadoExemplo + "\t");
			aux = aux.proxExemplo;
		}
		System.out.println();
	}
	public boolean remove(int valor) {
		boolean achou = false;
		if (!isEmpty()) {
			if (valor== listaExemplo.dadoExemplo) {
				achou = true;
				listaExemplo = listaExemplo.proxExemplo;
			}
			else
			{
				NO aux = listaExemplo;
				while (aux.proxExemplo !=null && !achou) {
					if (valor == aux.proxExemplo.dadoExemplo)
						achou = true;
					else
						aux = aux.proxExemplo;
				}
				if (achou)
					aux.proxExemplo = aux.proxExemplo.proxExemplo;
			}
		}
		return achou;
	}
}
