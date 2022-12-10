package model;

import java.time.LocalTime;
import java.util.Date;

public class Funcionario extends Pessoa{


    private Float salario;

    private LocalTime inicioTurno;

    private LocalTime fimTurno;


    public Funcionario() {
    }

    public Funcionario(String nome, String ocupacao, String cpf, Date dataNascimento) {
        super(nome, ocupacao, cpf, dataNascimento);
    }

    public Funcionario(String nome, String ocupacao, String cpf, Date dataNascimento, Float salario, LocalTime inicioTurno, LocalTime fimTurno) {
        super(nome, ocupacao, cpf, dataNascimento);
        this.salario = salario;
        this.inicioTurno = inicioTurno;
        this.fimTurno = fimTurno;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public LocalTime getInicioTurno() {
        return inicioTurno;
    }

    public void setInicioTurno(LocalTime inicioTurno) {
        this.inicioTurno = inicioTurno;
    }

    public LocalTime getFimTurno() {
        return fimTurno;
    }

    public void setFimTurno(LocalTime fimTurno) {
        this.fimTurno = fimTurno;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "salario=" + salario +
                ", inicioTurno=" + inicioTurno +
                ", fimTurno=" + fimTurno +
                '}';
    }
}
