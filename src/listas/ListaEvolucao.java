package listas;

import modelo.Colaborador;

public class ListaEvolucao {


    public void printPioresNotas(int size) {
        NO aux = lista;
        int cont = 0;
        System.out.println("*********** Lista das " + size + " menores notas: ************");
        while (aux != null && cont < size) {
            Colaborador c = aux.colab;

            if (c.getNota() == -1) {
                aux = aux.prox;
            } else {
                System.out.printf("ID: %-5d | Nome: %-20s | Setor: %-5s | Buddy: %-20s | Nota: %d\n",
                        c.getId(),
                        c.getNome(),
                        c.getSetor(),
                        c.getBuddy(),
                        c.getNota());
                aux = aux.prox;
                cont++;
            }
        }
    }

    public int contaColabs() {
        int cont = 0;
        NO aux = lista;
        while (aux != null) {
            cont++;
            aux = aux.prox;
        }
        return cont;
    }

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
        }
        else if (novo.colab.getNota() < lista.colab.getNota() ||
                (novo.colab.getNota() == lista.colab.getNota() && novo.colab.getId() < lista.colab.getId())) {
            novo.prox = lista;
            lista = novo;
        }
        else {
            NO aux = lista;
            boolean achou = false;

            while (aux.prox != null && !achou) {
                if (aux.prox.colab.getNota() < novo.colab.getNota()) {
                    aux = aux.prox;
                }
                else if (aux.prox.colab.getNota() == novo.colab.getNota() &&
                        aux.prox.colab.getId() < novo.colab.getId()) {
                    aux = aux.prox;
                }
                else {
                    achou = true;
                }
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

        public boolean validar(int id) {
            boolean valido = true;
            NO aux = lista;
            while (aux != null) {
                Colaborador c = aux.colab;
                if (id == c.getId()) {
                    valido = false;
                    break;
                }
                aux = aux.prox;
            }
            return valido;
        }
    }

