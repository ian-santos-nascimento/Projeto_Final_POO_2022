import model.Hospede;
import model.Quarto;
import model.Recepcionista;
import model.Reserva;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        System.out.println("Eu sou o seu primeiro programa.");

        //Criação do Recepcionista
        Recepcionista recepcionista = new Recepcionista("Joao", "218.939.070-23", new Date(1990, Calendar.SEPTEMBER, 22),
                LocalTime.of(6, 30), LocalTime.of(18, 30));


        //Criação dos Quartos
        Quarto quarto1 = new Quarto(101, 1, 1);
        Quarto quarto2 = new Quarto(102, 1, 2);
        Quarto quarto3 = new Quarto(103, 1, 2);
        Quarto quarto4 = new Quarto(104, 1, 3);
        Quarto quarto5 = new Quarto(201, 2, 1);
        Quarto quarto6 = new Quarto(202, 2, 2);
        Quarto quarto7 = new Quarto(203, 2, 2);
        Quarto quarto8 = new Quarto(204, 2, 3);
        Quarto quarto9 = new Quarto(301, 3, 1);
        Quarto quarto10 = new Quarto(302, 3, 2);
        Quarto quarto11 = new Quarto(303, 3, 2);
        Quarto quarto12 = new Quarto(304, 3, 3);
        List<Quarto> quartos = List.of(quarto1, quarto2, quarto3, quarto4, quarto5, quarto6, quarto7, quarto8, quarto9, quarto10, quarto11, quarto12);


        //Criacao de Hospede
        Hospede hospede1 = new Hospede("Kleber", "Desenvolvedor", "604.858.780-54",transformarData("29/03/2003") , "Rua alguma coisa");
        Hospede hospede2 = new Hospede("Ricardo", "Analista de Sistemas", "841.536.580-22",transformarData("20/05/2000") , "Rua alguma coisa");
        Hospede hospede3 = new Hospede("Jerson", "Desempregado", "082.908.340-55",transformarData("20/10/1980") , "Rua alguma coisa");


        //Criação de Reservas
        Quarto quartoEscolhido1 = procurarQuartoDisponivel(quartos, 1);
        if(quartoEscolhido1 != null){
            Reserva reserva1 = new Reserva(quartoEscolhido1, hospede1, new Date(), transformarData(LocalDate.now().plusDays(5).toString()));
            System.out.println("Reserva Realizada! Quarto numero:" + quartoEscolhido1.getNumeroQuarto());
            quartoEscolhido1.setOcupado(true);
        } else{
            System.out.println("Não existem quartos disponíveis para a quantidade de pessoas escolhida");
        }


        Quarto quartoEscolhido2 = procurarQuartoDisponivel(quartos, 2);
        if(quartoEscolhido2 != null){
            Reserva reserva2 = new Reserva(quartoEscolhido2, hospede2, new Date(), transformarData(LocalDate.now().plusDays(5).toString()));
            System.out.println("Reserva Realizada! Quarto numero:" + quartoEscolhido2.getNumeroQuarto());
            quartoEscolhido2.setOcupado(true);
        } else{
            System.out.println("Não existem quartos disponíveis para a quantidade de pessoas escolhida");
        }

        Quarto quartoEscolhido3 = procurarQuartoDisponivel(quartos, 3);
        if(quartoEscolhido3 != null){
            Reserva reserva3 = new Reserva(quartoEscolhido3, hospede3, new Date(), transformarData(LocalDate.now().plusDays(5).toString()));
            System.out.println("Reserva Realizada! Quarto numero:" + quartoEscolhido3.getNumeroQuarto());
            quartoEscolhido3.setOcupado(true);
        } else{
            System.out.println("Não existem quartos disponíveis para a quantidade de pessoas escolhida");
        }




    }












    public static Date transformarData(String data) {
        try {
            System.out.println("[transformarData]"+df.parse(data));
            return df.parse(data);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Quarto procurarQuartoDisponivel(List<Quarto> quartos, Integer qtdPessoasProQuarto){
        List<Quarto> quartosDisponivel =  quartos.stream().filter(quarto -> quarto.getNumeroPessoas().equals(qtdPessoasProQuarto) && !quarto.isOcupado())
                .collect(Collectors.toList());
        if(quartosDisponivel.isEmpty())
            return null;
        else
            return quartosDisponivel.get(0);
    }
}
