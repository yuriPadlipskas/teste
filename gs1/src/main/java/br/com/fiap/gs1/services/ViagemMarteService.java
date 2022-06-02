package br.com.fiap.gs1.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

import br.com.fiap.gs1.models.ViagemMarte;
import br.com.fiap.gs1.repositories.ViagemMarteRepository;

public class ViagemMarteService {
	
	private static int VIAGEM_PARA_MARTE = 260;
	private static int ANO_INTEIRO = 1900;
	private static int MES_INTEIRO = 1;
	private static String FORMATO_DATADF = "dd/MM/yy";
	private static String FORMATO_DATAlD = "dd/MM/yyyy";
	
	public String calculaDataRetornoTerra(String dataInicial) {
		String dataFinal = "";
		SimpleDateFormat df = new SimpleDateFormat(FORMATO_DATADF);
		try {
			Date data = df.parse(dataInicial);
			LocalDate date = LocalDate.of((data.getYear()+ANO_INTEIRO), (data.getMonth()+MES_INTEIRO), data.getDate()); 
			LocalDate dateReturn = date.plusDays(VIAGEM_PARA_MARTE);
			dataFinal = dateReturn.format(DateTimeFormatter.ofPattern(FORMATO_DATAlD));
			return dataFinal;
			
		} catch (ParseException e) {
			return e.toString();
		}
	}
	
	public ViagemMarte alterarViagem(ViagemMarteRepository viagemMarteRepository, ViagemMarte viagemMarte) {
		  Optional<ViagemMarte> viagem = viagemMarteRepository.findById(viagemMarte.getId());
		    if(viagem.isPresent()) {
		    	viagem.get().setId(viagemMarte.getId());
		    	viagem.get().setDataDecolagem(viagemMarte.getDataDecolagem());
		    	viagem.get().setDiasEstadiaMarte(viagemMarte.getDiasEstadiaMarte());
		    	viagem.get().setAssentos(viagemMarte.getAssentos());
		    	viagem.get().setNomeModeloNave(viagemMarte.getNomeModeloNave());
		    	viagem.get().setNomePrimeiroComandante(viagemMarte.getNomePrimeiroComandante());
		    	viagem.get().setMatriculaInterespacialPrimeiroComandante(viagemMarte.getMatriculaInterespacialPrimeiroComandante());
		    	viagem.get().setNomeSegundoComandante(viagemMarte.getNomeSegundoComandante());
		    	viagem.get().setMatriculaInterespacialSegundoComandante(viagemMarte.getMatriculaInterespacialSegundoComandante());
		    	viagem.get().setDataRetorno(calculaDataRetornoTerra(viagemMarte.getDataDecolagem()));
		    }
		    return viagem.get();
	}
	
	public boolean isMultipleThree(int value) {
		if(value%3 == 0) {
			return true;
		}
		return false;
	}

}
