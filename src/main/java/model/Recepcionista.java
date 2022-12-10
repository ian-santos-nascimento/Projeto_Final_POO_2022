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
        System.out.println(String.format("Olá %s, seja bem vindo ao nosso hotel!", nomeHospede));
    }

    @Override
    public Float cobrarHospedagem(Float valorHospedagem, Float valorDado) {
        Float troco = valorHospedagem - valorDado;
        System.out.println(String.format("O valor da hospedagem é de R$%f então seu troco será %f", valorHospedagem, troco));
        return troco;
    }


}
