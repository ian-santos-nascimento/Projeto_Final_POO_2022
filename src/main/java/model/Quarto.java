package model;

public class Quarto {

    private Integer numeroQuarto;

    private boolean ocupado;

    private Integer andar;

    private Integer numeroPessoas;

    public Quarto(Integer numeroQuarto, Integer andar, Integer numeroPessoas) {
        this.numeroQuarto = numeroQuarto;
        this.ocupado = false;
        this.andar = andar;
        this.numeroPessoas = numeroPessoas;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Integer getAndar() {
        return andar;
    }

    public void setAndar(Integer andar) {
        this.andar = andar;
    }

    public Integer getNumeroPessoas() {
        return numeroPessoas;
    }

    public void setNumeroPessoas(Integer numeroPessoas) {
        this.numeroPessoas = numeroPessoas;
    }


    @Override
    public String toString() {
        return "Quarto{" +
                "numeroQuarto=" + numeroQuarto +
                ", ocupado=" + ocupado +
                ", andar=" + andar +
                ", numeroPessoas=" + numeroPessoas +
                '}';
    }
}
