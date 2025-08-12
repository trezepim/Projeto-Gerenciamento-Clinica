package classes;

public class Paciente {
    private String nome;
    private String cpf;
    private String dtNasc;

    public Paciente() {
    }

    public Paciente(String nome, String cpf, String dtNasc) {
        this.nome = nome;
        this.cpf = cpf;
        this.dtNasc = dtNasc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDtNasc() {
        return dtNasc;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | CPF: " + nome + " | Data de nascimento: " + dtNasc + ".";
    }
}
