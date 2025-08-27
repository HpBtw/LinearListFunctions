package modelo;

public class Colaborador {
    private int id;
    private String nome;
    private String setor;
    private String buddy;
    private int nota;

    public Colaborador(int id, int nota, String buddy, String setor, String nome) {
        this.id = id;
        this.nota = nota;
        this.buddy = buddy;
        this.setor = setor;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNota() {
        return this.nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getBuddy() {
        return buddy;
    }

    public void setBuddy(String buddy) {
        this.buddy = buddy;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return "Nome: " + this.nome + "\tID: " + this.id +
                "\nBuddy: " + this.buddy + "\tSetor: " + this.setor +
                "\nNota: " + this.nota;
    }
}
