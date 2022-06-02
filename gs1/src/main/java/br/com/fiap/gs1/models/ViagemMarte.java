package br.com.fiap.gs1.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

@Entity
public class ViagemMarte {
	
	public ViagemMarte() {}

	public ViagemMarte(Long id,
			@NotBlank @Pattern(regexp = RegexModelConstants.DATA_NASCIMENTO) String dataDecolagem,
			@NotNull @PositiveOrZero Integer diasEstadiaMarte, @NotNull @PositiveOrZero Integer assentos,
			@NotBlank @Pattern(regexp = RegexModelConstants.NOME_MODELO_NAVE) String nomeModeloNave,
			@NotNull String nomePrimeiroComandante,
			@Pattern(regexp = RegexModelConstants.MATRICULA_INTERESPACIAL) String matriculaInterespacialPrimeiroComandante,
			@NotNull String nomeSegundoComandante,
			@Pattern(regexp = RegexModelConstants.MATRICULA_INTERESPACIAL) String matriculaInterespacialSegundoComandante,
			@NotNull String dataRetorno) {
		setId(id);
		setDataDecolagem(dataDecolagem);
		setDiasEstadiaMarte(diasEstadiaMarte);
		setAssentos(assentos);
		setNomeModeloNave(nomeModeloNave);
		setNomePrimeiroComandante(nomePrimeiroComandante);
		setMatriculaInterespacialPrimeiroComandante(matriculaInterespacialPrimeiroComandante);
		setNomeSegundoComandante(nomeSegundoComandante);
		setMatriculaInterespacialSegundoComandante(matriculaInterespacialSegundoComandante);
		setDataRetorno(dataRetorno);
	}

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="viagemMarteSequence")
	@SequenceGenerator(name="viagemMarteSequence", sequenceName="viagemMarteSequence")
	@Id
	private Long id;

	@NotBlank
	@Pattern(regexp = RegexModelConstants.DATA_NASCIMENTO)
	private String dataDecolagem;
	
	@NotNull
	@PositiveOrZero
	private Integer diasEstadiaMarte;
	
	@NotNull
	@PositiveOrZero
	private Integer assentos;
	
	@NotBlank
	@Pattern(regexp = RegexModelConstants.NOME_MODELO_NAVE)
	private String nomeModeloNave;
	
	@NotNull
	private String nomePrimeiroComandante;
	
	@Pattern(regexp = RegexModelConstants.MATRICULA_INTERESPACIAL)
	private String matriculaInterespacialPrimeiroComandante;
	
	@NotNull
	private String nomeSegundoComandante;	

	@Pattern(regexp = RegexModelConstants.MATRICULA_INTERESPACIAL)
	private String matriculaInterespacialSegundoComandante;
	
	@NotNull
	private String dataRetorno;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataDecolagem() {
		return dataDecolagem;
	}

	public void setDataDecolagem(String dataFormatada) {
		this.dataDecolagem = dataFormatada;
	}

	public Integer getDiasEstadiaMarte() {
		return diasEstadiaMarte;
	}

	public void setDiasEstadiaMarte(Integer diasEstadiaMarte) {
		this.diasEstadiaMarte = diasEstadiaMarte;
	}

	public Integer getAssentos() {
		return assentos;
	}

	public void setAssentos(Integer assentos) {
		this.assentos = assentos;
	}

	public String getNomeModeloNave() {
		return nomeModeloNave;
	}

	public void setNomeModeloNave(String nomeModeloNave) {
		this.nomeModeloNave = nomeModeloNave;
	}

	public String getNomePrimeiroComandante() {
		return nomePrimeiroComandante;
	}

	public void setNomePrimeiroComandante(String nomePrimeiroComandante) {
		this.nomePrimeiroComandante = nomePrimeiroComandante;
	}

	public String getMatriculaInterespacialPrimeiroComandante() {
		return matriculaInterespacialPrimeiroComandante;
	}

	public void setMatriculaInterespacialPrimeiroComandante(String matriculaInterespacialPrimeiroComandante) {
		this.matriculaInterespacialPrimeiroComandante = matriculaInterespacialPrimeiroComandante;
	}

	public String getNomeSegundoComandante() {
		return nomeSegundoComandante;
	}

	public void setNomeSegundoComandante(String nomeSegundoComandante) {
		this.nomeSegundoComandante = nomeSegundoComandante;
	}

	public String getMatriculaInterespacialSegundoComandante() {
		return matriculaInterespacialSegundoComandante;
	}

	public void setMatriculaInterespacialSegundoComandante(String matriculaInterespacialSegundoComandante) {
		this.matriculaInterespacialSegundoComandante = matriculaInterespacialSegundoComandante;
	}




	public String getDataRetorno() {
		return dataRetorno;
	}




	public void setDataRetorno(String dataRetorno) {
		this.dataRetorno = dataRetorno;
	}
	
	
	
}
