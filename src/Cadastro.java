import java.text.SimpleDateFormat;
import java.util.Date;

public class Cadastro {
	String nome;
	Date dataNascimento;
	Date dataCadastro = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNascimento() {
		return formatter.format(dataNascimento);
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getDataCadastro() {
		SimpleDateFormat formatterCadastro = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		return formatterCadastro.format(dataCadastro);
	}

	
	
}
