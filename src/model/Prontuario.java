package model;

public class Prontuario {
	// Dados paciente
	private String nomePaciente;
	private String nomeSocial;
	private String codProntuario;
	private String codReferencia;
	private String codLeito;
	private String dataNascimento;
	private String especialidade;
	private String unidade;
	private String numeroSUS;
	// Dados Atendimento
	private String nomeResponsavel;
	private String dataCriacao;
	private String dataConfirmacao;
	private String atendimento;
	private String CRM;
	// Anamnese
	private String diagnostico;
	// Notas
	private String notasAdicionais;

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public String getCodProntuario() {
		return codProntuario;
	}

	public void setCodProntuario(String codProntuario) {
		this.codProntuario = codProntuario;
	}

	public String getCodReferencia() {
		return codReferencia;
	}

	public void setCodReferencia(String codReferencia) {
		this.codReferencia = codReferencia;
	}

	public String getCodLeito() {
		return codLeito;
	}

	public void setCodLeito(String codLeito) {
		this.codLeito = codLeito;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getNumeroSUS() {
		return numeroSUS;
	}

	public void setNumeroSUS(String numeroSUS) {
		this.numeroSUS = numeroSUS;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getDataConfirmacao() {
		return dataConfirmacao;
	}

	public void setDataConfirmacao(String dataConfirmacao) {
		this.dataConfirmacao = dataConfirmacao;
	}

	public String getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(String atendimento) {
		this.atendimento = atendimento;
	}

	public String getCRM() {
		return CRM;
	}

	public void setCRM(String cRM) {
		CRM = cRM;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getNotasAdicionais() {
		return notasAdicionais;
	}

	public void setNotasAdicionais(String notasAdicionais) {
		this.notasAdicionais = notasAdicionais;
	}

}
