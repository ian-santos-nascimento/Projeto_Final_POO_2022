package interfaces;

import model.Quarto;

import java.util.Date;
import java.util.List;

public interface ReservarQuarto {

    public boolean verificarDocumentos(Date dataNascimento);

    public Integer calcuarTotalHospeadgem(Quarto quarto, Date inicioOcupacao, Date fimOcupacao);

    public boolean verificarDisponibilidade(Quarto quarto, Date inicioOcupacao, Date fimOcupacao, List<Quarto> quartos);

}
