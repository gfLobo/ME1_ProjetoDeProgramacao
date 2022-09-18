
public class Dentista extends Cadastro {
	String CRO;

	public String getCRO() {
		return CRO;
	}

	public void setCRO(String cRO) {
		CRO = cRO;
	}

	@Override
	public String toString() {
		return "Dentista{" +
				"CRO='" + CRO + '\'' +
				", nome='" + nome + '\'' +
				", dataNascimento=" + getDataNascimento() +
				", dataCadastro=" + getDataCadastro() +
				'}';
	}
}
