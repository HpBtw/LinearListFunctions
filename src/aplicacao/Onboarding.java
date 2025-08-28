package aplicacao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import listas.ListaEvolucao;
import modelo.Colaborador;

public class Onboarding {
    public static Scanner kb = new Scanner(System.in);
    public static ListaEvolucao listaEvo = new ListaEvolucao();

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        //listaEvo.add(new Colaborador(4000, 30, "Buddy Teste", "ADM", "Nome Teste"));
        geraLista();

        int opcao;
        do {
            System.out.println("==============================================================");
            System.out.println("0 - Encerrar atendimento");
            System.out.println("1 - Obter colaboradores com piores notas presentes na lista");
            System.out.println("2 - Atualizar nota de um colaborador");
            System.out.println("3 - Inserir novo colaborador");
            System.out.println("Opcao: ");
            opcao = kb.nextInt();
            switch (opcao) {
                case 0:
                    listaEvo.show();
                    break;
                case 1:
                    pioresNotas();
                    break;
                case 2:
                    atualizarNota();
                    break;
                case 3:
                    inserir();
                    break;
                default:
                    System.out.println("Opcao Invalida");
            }

        } while (opcao != 0);

        kb.close();

    }

    private static void atualizarNota() {
        System.out.println("Insira o ID do colaborador à ser atualizado: ");
        int id = kb.nextInt();
        if (!listaEvo.validar((id))) {
            Colaborador colabRetirado = listaEvo.retirar(id);
            System.out.println(colabRetirado);
            reinserir(colabRetirado);
        } else {
            System.out.println("ID não encontrado, tente novamente.");
            atualizarNota(); //
        }
    }

    private static void reinserir(Colaborador colabRetirado) {
        System.out.println("Informe a nova nota do(a) colaborador(a) " + colabRetirado.getNome() + ": ");
        int nota = kb.nextInt();
        listaEvo.add(new Colaborador(colabRetirado.getId(), nota, colabRetirado.getBuddy(), colabRetirado.getSetor(), colabRetirado.getNome()));
        System.out.println("Colaborador reinserido!");
    }

    private static void inserir() {
        System.out.print("Informe o ID do colaborador à ser registrado: ");
        int id = kb.nextInt();
        kb.nextLine();
        if (!listaEvo.validar(id)) {
            System.out.println("Esse ID já pertence à algum colaborador, tente novamente.");
            inserir();
        }
        System.out.print("Informe o nome e sobrenome do colaborador à ser registrado: ");
        String nome = kb.nextLine();
        System.out.print("Informe o setor do colaborador à ser registrado: ");
        String setor = kb.nextLine();
        System.out.print("Informe o Buddy do colaborador à ser registrado: ");
        String buddy = kb.nextLine();
        try {
            listaEvo.add(new Colaborador(id, -1, buddy, setor, nome));
            System.out.println("Colaborador adicionado!");
            return;
        } catch (Exception e) {
            System.out.println("Erro ao adicionar o colaborador: " + e);
        }
    }

    private static void pioresNotas() {
        System.out.println("Deseja ler quantas notas? ");
        int size = kb.nextInt();
        if (size < 0) {
            System.out.println("Informe um número válido.");
            pioresNotas();
        }
        int max = listaEvo.contaColabs();
        if (size > max) {
            System.out.println("Insira um número menor. Não foram registrados " + size + " colaboradores.");
            pioresNotas();
        }
        listaEvo.printPioresNotas(size);
    }

    public static void geraLista() {
        String caminhoDoArquivo = "src/arquivos/Colaboradores.txt";

        try {
            File arquivo = new File(caminhoDoArquivo);
            Scanner leArq = new Scanner(arquivo);

            while (leArq.hasNextLine()) {
                String linha = leArq.nextLine();
                System.out.println(linha);
                String[] partes = linha.split(";");
                int id = Integer.parseInt(partes[0]);
                String nome = partes[1];
                String setor = partes[2];
                String buddy = partes[3];
                int nota = Integer.parseInt(partes[4]);

                Colaborador novoColab = new Colaborador(id, nota, buddy, setor, nome);
                listaEvo.add(novoColab);
            }
            leArq.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo n�o encontrado: " + e.getMessage());
        }
    }
}
