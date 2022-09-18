import java.text.SimpleDateFormat;
import java.util.Date;

public class Consulta {
	Dentista dentista;
	Paciente paciente;
	Date dataConsulta;
	boolean status = true;
	double valor = 300;
	boolean flagPrimeiraConsulta;



	public Dentista getDentista() {
		return dentista;
	}
	public void setDentista(Dentista dentista) {
		this.dentista = dentista;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Date getDataConsulta() {
		return  dataConsulta;
	}
	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setFlagPrimeiraConsulta(boolean flag) {
		this.flagPrimeiraConsulta = flag;
	}

	public String getNormalizeDate(){
		SimpleDateFormat formatterConsulta = new SimpleDateFormat("dd/MM/yyyy");
		return formatterConsulta.format(dataConsulta);
	}

	@Override
	public String toString() {
		SimpleDateFormat formatterConsulta = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		return "Consulta{\n" +
				 dentista +
				",\n" + paciente +
				",\ndataConsulta=" + formatterConsulta.format(dataConsulta) +
				",\nstatus=" + status +
				",\nvalor=" + valor +
				",\nflagPrimeiraConsulta=" + flagPrimeiraConsulta +
				"\n}";
	}
}
