package model;

import interfaces.Recepcionar;

import java.time.LocalTime;
import java.util.Date;

public class Recepcionista extends Funcionario implements Recepcionar {


    public Recepcionista(String nome, String cpf, Date dataNascimento, LocalTime inicioTurno, LocalTime fimTurno) {
        super(nome, "Recepcionista", cpf, dataNascimento, 2000.0F, inicioTurno, fimTurno);

    }

    @Override
    public void darBoasVindas(String nomeHospede) {
        System.out.println(String.format("Ola %s, seja bem vindo ao nosso hotel!", nomeHospede));
    }

    @Override
    public Integer cobrarHospedagem(Integer valorHospedagem, Integer valorDado) {
        Integer troco = valorDado - valorHospedagem;
        System.out.println(String.format("O valor da hospedagem e de R$%d e voce deu %d entao seu troco sera %d", valorHospedagem,valorDado, troco));
        return troco;
    }


}
