package model;

import interfaces.ReservarQuarto;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class Reserva implements ReservarQuarto {
    private static final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    private Quarto quarto;

    private Hospede hospedeResponsavel;

    private Date inicioOcupacao;

    private Date fimOcupacao;

    public Reserva(Quarto quarto, Hospede hospedeResponsavel, Date inicioOcupacao, Date fimOcupacao) {
        this.quarto = quarto;
        this.hospedeResponsavel = hospedeResponsavel;
        this.inicioOcupacao = inicioOcupacao;
        this.fimOcupacao = fimOcupacao;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Hospede getHospedeResponsavel() {
        return hospedeResponsavel;
    }

    public void setHospedeResponsavel(Hospede hospedeResponsavel) {
        this.hospedeResponsavel = hospedeResponsavel;
    }

    public Date getInicioOcupacao() {
        return inicioOcupacao;
    }

    public void setInicioOcupacao(Date inicioOcupacao) {
        this.inicioOcupacao = inicioOcupacao;
    }

    public Date getFimOcupacao() {
        return fimOcupacao;
    }

    public void setFimOcupacao(Date fimOcupacao) {
        this.fimOcupacao = fimOcupacao;
    }

    @Override
    public boolean verificarDocumentos(Date dataNascimento) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy");
        String anoAtual = df.format(new Date());
        String anoNascimento = df.format(dataNascimento);
        if (Integer.parseInt(anoAtual) - Integer.parseInt(anoNascimento) < 18) {
            System.out.println("Menores de Idade são impedidos de reservar um quarto de acordo com a Lei Federal 8.069/1990 (Estatuto da Criança e do adolescente-ECA), em seu artigo 82");
            return false;
        }
        return true;
    }

    @Override
    public Integer calcuarTotalHospeadgem(Quarto quarto, Date inicioOcupacao, Date fimOcupacao) {
        //Diaria:R$100,00 FIXO * qtdPessoasQuarto * diasTotais
        Calendar inicio = Calendar.getInstance();
        Calendar fim = Calendar.getInstance();
        inicio.setTime(inicioOcupacao);
        fim.setTime(fimOcupacao);
        Integer diasHospedados = fim.get(Calendar.DAY_OF_YEAR) - inicio.get(Calendar.DAY_OF_YEAR); //MUDAR ISSO QUE TA DANDO ERRADO
        Integer diaria = 100;
        Integer qtdPessoasQuarto = quarto.getNumeroPessoas();
        return diasHospedados * diaria * qtdPessoasQuarto;
    }

    @Override
    public boolean verificarDisponibilidade(Quarto quarto, Date inicioOcupacao, Date fimOcupacao, List<Quarto> quartosList) {
        //Faço stream na lista de quartos disponíveis e verifico se o quarto que quero está disponível
        return quartosList.stream().anyMatch(quartoAtual ->
                !quartoAtual.isOcupado() && quartoAtual.getNumeroQuarto().equals(quarto.getNumeroQuarto()));
    }
}
