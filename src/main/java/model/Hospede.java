package model;

import java.util.Date;

public class Hospede extends Pessoa{

    private String enderecoMoradia;

    public Hospede(String nome, String ocupacao, String cpf, Date dataNascimento, String enderecoMoradia) {
        super(nome, ocupacao, cpf, dataNascimento);
        this.enderecoMoradia = enderecoMoradia;
    }

    public String getEnderecoMoradia() {
        return enderecoMoradia;
    }

    public void setEnderecoMoradia(String enderecoMoradia) {
        this.enderecoMoradia = enderecoMoradia;
    }

    @Override
    public String toString() {
        return "Hospede{" +
                "enderecoMoradia='" + enderecoMoradia + '\'' +
                '}';
    }
}
