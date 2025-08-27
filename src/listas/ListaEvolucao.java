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
        } else if (novo.colab.getNota() < lista.colab.getNota() ||
                (novo.colab.getNota() == lista.colab.getNota() && novo.colab.getId() < lista.colab.getId())) {
            novo.prox = lista;
            lista = novo;
        }  else {
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

    public Colaborador retirar(int id) {
        if (isEmpty()) {
            System.out.println("Impossível retirar, lista vazia");
            return null;
        }
        if (lista.colab.getId() == id) {
            Colaborador retirado = lista.colab;
            lista = lista.prox;
            return retirado;
        }
        NO aux = lista;
        while (aux.prox != null && aux.prox.colab.getId() != id) {
            aux = aux.prox;
        }
        if (aux.prox != null) {
            Colaborador retirado = aux.prox.colab;
            aux.prox = aux.prox.prox;
            return retirado;
        }

        System.out.println("ID não encontrado");
        return null;
    }
        public void show() {
            NO aux = lista;
            System.out.println("*********** Lista ************");
            while (aux != null) {
                Colaborador c = aux.colab;

                System.out.printf("ID: %-5d | Nome: %-20s | Setor: %-5s | Buddy: %-20s | Nota: %d\n",
                        c.getId(),
                        c.getNome(),
                        c.getSetor(),
                        c.getBuddy(),
                        c.getNota());
                aux = aux.prox;
            }
        }
    }

