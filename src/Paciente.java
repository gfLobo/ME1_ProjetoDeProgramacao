
public class Paciente extends Cadastro {
	String CPF, endereco;

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Paciente{" +
				"CPF='" + CPF + '\'' +
				", endereco='" + endereco + '\'' +
				", nome='" + nome + '\'' +
				", dataNascimento=" + getDataNascimento() +
				", dataCadastro=" + getDataCadastro() +
				'}';
	}
}
