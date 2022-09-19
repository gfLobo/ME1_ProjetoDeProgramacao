import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
	// Criamos os arrays para salvar as informações coletadas.
	static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	static ArrayList<Dentista> dentistas = new ArrayList<>();
	static ArrayList<Consulta> consultas = new ArrayList<>();
	static ArrayList<Paciente> pacientes = new ArrayList<>();

	public static void main(String[] args) throws ParseException {
		Scanner myObj = new Scanner(System.in);

		System.out.println("---CONTROLE DE CONSULTAS---");

		while(true){
			// loop para escolher qual função do sistema vai ser utilizada.
			System.out.println("\n\nMenu (Digite qualquer tecla para continuar): [FINALIZAR]");

			String confirmMenu = myObj.nextLine().toLowerCase();
			if(!confirmMenu.equals("finalizar") ){
				System.out.println("""
						• Cadastro de Dentistas\s
						• Cadastro de Pacientes\s
						• Cadastro de Consultas\s
						• Cancelamento de Consultas
						• Relatório de Consultas Agendadas\s
						• Relatório Financeiro""");
				String menuOP = myObj.nextLine().toLowerCase();
				// Estrutura condicional para dizer ao programa qual função foi escolhida pelo usuário.
				if (menuOP.contains("dent") && !menuOP.contains("pacient") && !menuOP.contains("consult")){
					cadastroDentistas();
				} else if (menuOP.contains("pacient")) {
					cadastroPacientes();
				} else if (menuOP.contains("cadastr") && menuOP.contains("consult")) {
					novaConsulta();
				} else if (menuOP.contains("cancel")) {
					System.out.println("---Cancelamento de Consultas---");
					
					while(true){
						// Primeira Funcionalidade: Cancelamento de Consultas
						System.out.println("Filtros [CPF do Paciente | Data da Consulta (dd/MM/yyyy HH:mm) , CRO]: ");
						String cancelarOP = myObj.nextLine().toLowerCase();

						if (cancelarOP.length()>0){
							cancelarConsulta(cancelarOP); // confere se há alguma consulta e chama a função de cancelamento
							break;
						}
					}
				} else if (menuOP.contains("agenda")) {
					while (true){
						// Segunda Funcionalidade: Mostra as Consultas já agendadas
						System.out.println("---Relatório de Consultas Agendadas---");

						System.out.println("Filtros [Data da Consulta (dd/MM/yyyy HH:mm) , CRO]: ");
						String filtroConsultaOP = myObj.nextLine().toLowerCase();

						if (filtroConsultaOP.length()>0){
							getAgendamentos(filtroConsultaOP); // confere se há alguma e chama o relatório
							break;
						}
					}
				} else if (menuOP.contains("finan")) {
					System.out.println("---Relatório Financeiro---");
					while (true){
						// Terceira Funcionalidade: Relatório Financeiro
						System.out.println("Filtro [Data da Consulta (dd/MM/yyyy)]: ");
						String filtroConsultaOP = myObj.nextLine().toLowerCase();

						if (filtroConsultaOP.length()>0){
							getFinanceiro(filtroConsultaOP); // confere se há alguma e chama o relatório
							break;
						}
					}
				}

			}else{

				System.out.println("Encerrando...");
				break;
			}

			}

	}
	public static void cadastroDentistas() throws ParseException {

		Scanner myObj = new Scanner(System.in);
		while(true){
			// Quarta Funcionalidade: Cadastro de Dentistas
			System.out.println("\nCadastrar novo dentista? [FINALIZAR]");


			String confirmDentista = myObj.nextLine().toLowerCase();
			if(!confirmDentista.equals("finalizar")){
				Dentista dentista = new Dentista();

				System.out.println("Nome: ");
				String dentistaNome = myObj.nextLine();

				while(true) {
					try {
					System.out.println("Data de Nascimento: (dd/MM/yyyy)");
					String dentistaNascimento = myObj.nextLine();
					dentista.setDataNascimento(formatter.parse(dentistaNascimento));
					break;
					}
					catch(ParseException e) {
						System.err.println("\nDigite Novamente: (dd/MM/yyyy)");
					}
				}
				System.out.println("CRO: ");
				String dentistaCRO = myObj.nextLine();
				// Pegamos todas as informações necessárias sobre os dentistas
				
				//Dentista Set
				dentista.setNome(dentistaNome);
				dentista.setCRO(dentistaCRO);
				//salvamos as informações
				System.out.println("Cadastro realizado com sucesso!");
				System.out.println(dentista + "\n\n");

				dentistas.add(dentista); // adicionamos ao array

			}else{
				break;
			}
		}

	}

	public static void cadastroPacientes() throws ParseException{
		Scanner myObj = new Scanner(System.in);
		while(true){
			// Quinta Funcionalidade: Cadastro de Pacientes
			System.out.println("\nCadastrar novo paciente? [FINALIZAR]");
			String confirmPaciente = myObj.nextLine().toLowerCase();
			if(!confirmPaciente.equals("finalizar")){
				Paciente paciente = new Paciente();

				System.out.println("Nome: ");
				String pacienteNome = myObj.nextLine();
				
				while(true) {
					try {	
						System.out.println("Data de Nascimento: (dd/MM/yyyy)");
						String pacienteNascimento = myObj.nextLine();
						paciente.setDataNascimento(formatter.parse(pacienteNascimento));
						break;
					}
					catch(ParseException e) {
						System.err.println("\nDigite Novamente: (dd/MM/yyyy)");
					}
				}
				System.out.println("CPF: ");
				String pacienteCPF = myObj.nextLine();

				System.out.println("Endereço: ");
				String pacienteEndereco = myObj.nextLine();
				// Pegamos todas as informações necessárias sobre os pacientes

				//Paciente Set
				paciente.setNome(pacienteNome);
				paciente.setCPF(pacienteCPF);
				paciente.setEndereco(pacienteEndereco);
				//salvamos as informações
				pacientes.add(paciente); // adicionamos no array
				System.out.println("Cadastro realizado com sucesso!");
				System.out.println(paciente + "\n\n");
			}else{
				break;
			}
		}
	}

	public static void novaConsulta() throws ParseException{
		//Checagem de Pacientes e dentistas
		if (pacientes.size() == 0 || dentistas.size() == 0){
			System.out.println("Foram encontrados: " + dentistas.size() + " dentistas e " + pacientes.size() + "pacientes.");
		}else{
			SimpleDateFormat formatterConsulta = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			while(true) {
				// Sexta Funcionalidade: Cadastro de Consultas
				Scanner myObj = new Scanner(System.in);

				System.out.println("\nCadastrar nova consulta? [FINALIZAR]");

				String confirmConsulta = myObj.nextLine().toLowerCase();

				if (!confirmConsulta.equals("finalizar")) {

					Consulta consulta = new Consulta();

					var validarDentista = false;
					while (!validarDentista){ //loop para mostrar os dentistas disponiveis
						System.out.println("\n\nDentistas: ");
						for (Dentista dentista: dentistas) {
							System.out.println("CRO: " + dentista.getCRO() + " Nome: " + dentista.getNome());
						}
						String dentistaConsulta = myObj.nextLine();

						for (Dentista dentista: dentistas) {
							if (dentistaConsulta.contains(dentista.getCRO()) ||
									dentistaConsulta.contains(dentista.getNome())){
								validarDentista = true;
								consulta.setDentista(dentista); // escolher o dentista para a consulta em questão
							}
						}
					}
					var validarPaciente = false;
					while (!validarPaciente){
						System.out.println("\n\nPacientes: ");
						for (Paciente paciente: pacientes) { 
							System.out.println("CPF: " + paciente.getCPF() + " Nome: " + paciente.getNome());
						}
						String pacienteConsulta = myObj.nextLine();

						for (Paciente paciente: pacientes) {
							if (pacienteConsulta.contains(paciente.getCPF()) ||
									pacienteConsulta.contains(paciente.getNome())){
								validarPaciente = true;
								consulta.setPaciente(paciente); // escolher o paciente para a nova consulta
							}
						}
					}
					while(true) {
						try {
							System.out.println("Data e hora da consulta: (dd/MM/yyyy  HH:mm)");
							String consultaData = myObj.nextLine();
							consulta.setDataConsulta(formatterConsulta.parse(consultaData));
							break;
						}
						catch(ParseException e) {
							System.err.println("\nDigite Novamente: (dd/MM/yyyy HH:mm)");
						}
					}

					System.out.println("Primeira consulta? [S/N]");
					String consultaflagPrimeiraConsulta = myObj.nextLine().toUpperCase();
					// Outros detalhes da Consulta

					//Consulta Set
					if (consultaflagPrimeiraConsulta.contains("S")){
						consulta.setValor(consulta.getValor()+50); //aumento de 50 reais por ser a primeira consulta
					}
					consulta.setFlagPrimeiraConsulta(consultaflagPrimeiraConsulta.contains("S"));
					consulta.setStatus(consulta.getDataConsulta().after(new Date()));

					System.out.println("Consulta cadastrada com sucesso!\n");
					System.out.println(consulta);
					consultas.add(consulta); // salva no array a nova consulta com sucesso
				}else{
					break;
				}
			}
		}
	}

	public static void cancelarConsulta(String consultaCancelarFiltro){
		SimpleDateFormat formatterConsulta = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Scanner myObj = new Scanner(System.in);

		Consulta consultaCancelar;

		for (Consulta value: consultas) { // dados da consulta que quer ser cancelada
			if ((value.getPaciente().getCPF() + " , " + formatterConsulta.format(value.getDataConsulta()) + " , " + value.getDentista().getCRO()).equals(consultaCancelarFiltro)){
				System.out.println("Deseja cancelar a seguinte consulta? [S/N] \n" + value); // confirmação
				String confirmDelConsulta = myObj.nextLine().toUpperCase();

				if (confirmDelConsulta.contains("S")){
					consultaCancelar = value;
					consultaCancelar.setStatus(false);
					consultas.set(consultas.indexOf(value), consultaCancelar); // retira a consulta do array
					System.out.println("\nConsulta cancelada.");
				}else{
					System.out.println("\nNenhuma consulta foi deletada.");
				}

			}
		}
	}

	public static void  getAgendamentos(String agendamentosFiltro){
		SimpleDateFormat formatterConsulta = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		System.out.println("\nConsultas com filtro [" + agendamentosFiltro + "]:\n");
		for (Consulta value: consultas) { // dados para o relatório de agendamento
			if (value.isStatus() && (formatterConsulta.format(value.getDataConsulta()) + " , " + value.getDentista().getCRO()).equals(agendamentosFiltro)){
				System.out.println(value);
			}
		}
	}

	public static void getFinanceiro(String financeiroFiltro) {

		double total = 0;
		System.out.println("\nConsultas com filtro [" + financeiroFiltro + "]:\n");
		for (Consulta value: consultas) {

			if (value.getNormalizeDate().equals(financeiroFiltro)){ // acha as consultas feitas naquela data
				total+=value.getValor(); // soma os valores
				System.out.println(value);
			}
		}
		System.out.println("\nTOTAL: R$"+total); //resultado daquele dia
	}
}