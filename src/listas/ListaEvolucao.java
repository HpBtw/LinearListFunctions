package listas;

import modelo.Colaborador;

public class ListaEvolucao {
    private class NO {
        Colaborador colab;
        NO prox;
    }

    NO lista = null;

    public boolean isEmpty() {
        return (lista == null);
    }

    public void add(Colaborador novoColab) {
        NO novo = new NO();
        novo.colab = novoColab;
        if (isEmpty()) {
            lista = novo;
            novo.prox = null;
        } else if (novo.colab.getNota() < lista.colab.getNota()) {
            novo.prox = lista;
            lista = novo;
        } else if (novo.colab.getNota() == lista.colab.getNota()) {
            if (novo.colab.getId() < lista.colab.getId()) {
                novo.prox = lista;
                lista = novo;
            } else {
                NO aux = lista;
                boolean achou = false;
                while (aux.prox != null && !achou) {
                    if (aux.prox.colab.getNota() == novo.colab.getNota() &&
                            aux.prox.colab.getId() < novo.colab.getId()) {
                        aux = aux.prox;
                    } else {
                        achou = true;
                    }
                }
                novo.prox = aux.prox;
                aux.prox = novo;
            }
        } else {
            NO aux = lista;
            boolean achou = false;
            while (aux.prox != null && !achou) {
                if (aux.prox.colab.getNota() < novo.colab.getNota())
                    aux = aux.prox;
                else
                    achou = true;
            }
            novo.prox = aux.prox;
            aux.prox = novo;
        }
    }
        public void show() {
            NO aux = lista;
            System.out.println("*********** Lista ************");
            while (aux != null) {
                System.out.print(aux.colab + "\n");
                aux = aux.prox;
            }
            System.out.println();
        }
    }

