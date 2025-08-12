package classes;

public class VetPaciente {
    private Paciente[] vet = new Paciente[2];
    private int quant = 0;

    public VetPaciente() {
    }

    public VetPaciente(Paciente[] vet) {
        this.vet = vet;
    }

    public Paciente getPaciente(int pos) {
        return vet[pos];
    }

    public int getQuant() {
        return quant;
    }

    public static int pesquisa(String cpf, VetPaciente vp) {
        if (vp.quant > 0) {
            for (int i = 0; i < vp.quant; i++) {
                if (vp.vet[i] != null && cpf.equals(vp.vet[i].getCpf())) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int insere(Paciente paciente, VetPaciente vp) {
        if (vp.quant == vp.vet.length) {
            return -1;
        }

        if (pesquisa(paciente.getCpf(), vp) != -1) {
            return -2;
        }

        vp.vet[vp.quant] = paciente;
        vp.quant++;
        return 0;
    }
}
