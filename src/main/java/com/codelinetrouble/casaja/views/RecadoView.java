package main.java.com.codelinetrouble.casaja.views;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.com.codelinetrouble.casaja.controllers.RecadoController;
import main.java.com.codelinetrouble.casaja.dtos.PessoaDto;
import main.java.com.codelinetrouble.casaja.dtos.RecadoDto;
import main.java.com.codelinetrouble.casaja.dtos.UsuarioDto;
import main.java.com.codelinetrouble.casaja.enums.TipoUsuario;
import main.java.com.codelinetrouble.casaja.views.interfaces.IView;


public class RecadoView implements IView {
	private final RecadoController recadoController;
	private final Scanner scanner;

	public RecadoView(RecadoController recadoController) {
		this.recadoController = recadoController;
		this.scanner = new Scanner(System.in);
	}

	@Override
	public void menu() {
		Integer option = 0;

		do {
			System.out.println("\nMENU DE OPÇÕES DE RECADOS\n");
			System.out.println("1) Criar um recado;");
			System.out.println("2) Criar vários recados;");
			System.out.println("3) Procurar um recado por id;");
			System.out.println("4) Procurar vários recados por ids;");
			System.out.println("5) Procurar todos os recados;");
			System.out.println("6) Remover um recado por id;");
			System.out.println("7) Remover vários recados por ids;");
			System.out.println("8) Atualizar um recado por id;");
			System.out.println("9) Sair do menu de recado;");

			System.out.print("\nDigite sua opção: ");
			option = scanner.nextInt();

			switch (option) {
				case 1 -> handleCriaRecado();
				case 2 -> handleCriaRecados();
				case 3 -> handleProcuraRecadoPorId();
				case 4 -> handleProcuraRecadosPorId();
				case 5 -> handleProcuraRecados();
				case 6 -> handleRemoveRecadoPorId();
				case 7 -> handleRemoveRecadosPorId();
				case 8 -> handleAtualizaRecadoPorId();
				case 9 -> handleExit();
				default -> System.out.println("Opção inválida!");
			}
		} while(option != 9);
	}

	private void handleCriaRecado() {
		System.out.println("Opção de criar recado selecionada!");
		
		System.out.print("Digite o id da pessoa do recado: ");
		Integer idPessoa = scanner.nextInt();

		System.out.print("Digite o comentário do recado: ");
		String comentario = scanner.next();

		RecadoDto recadoDto = new RecadoDto(null, null, null, new PessoaDto(idPessoa, null, null, null, null, null), comentario);
		if (recadoController.create(recadoDto)) {
			System.out.println("Recado criado com sucesso");
		} else {
			System.out.println("Recado não pode ser criado");
		}
	}

	private void handleCriaRecados() {
		System.out.println("Opção de criar recados selecionada!");

		Integer count = 1;
		Boolean next = true;

		List<RecadoDto> recadosDto = new ArrayList<>();

		while(next) {
			System.out.print(String.format("Digite o id da pessoa do recado [%d]: ", count));
			Integer idPessoa = scanner.nextInt();

			System.out.print(String.format("Digite o comentario do recado [%d]: ", count));
			String comentario = scanner.next();

			recadosDto.add(new RecadoDto(null, null, null, new PessoaDto(idPessoa, null, null, null, null, null), comentario));
			System.out.print("Deseja adicionar mais um recado? (S/N) ");
			String option = scanner.next();
			next = option.equals("S");
			count++;
		}
		count--;

		Integer countRecados = recadoController.create(recadosDto);
		System.out.println(String.format("Dos %d recados, foram criados %d recados", count, countRecados));
	}

	private void handleProcuraRecadoPorId() {
		System.out.println("Opção de procurar um recado por id selecionada!");

		System.out.print("Digite o id do recado: ");
		Integer id = scanner.nextInt();

		RecadoDto recadoDto = recadoController.find(id);
		if (recadoDto != null)
			System.out.println(String.format("O recado procurado foi: %s", recadoDto.toString()));
	}

	private void handleProcuraRecadosPorId() {
		System.out.println("Opção de procurar vários recados por ids selecionada!");

		Integer count = 1;
		Boolean next = true;
		List<Integer> ids = new ArrayList<>();

		while(next) {
			System.out.print(String.format("Digite o id do recado [%d]: ", count));
			ids.add(scanner.nextInt());

			System.out.print("Deseja adicionar mais algum id? (S/N) ");
			String option = scanner.next();
			next = option.equals("S");
			count++;
		}

		List<RecadoDto> recadosDto = recadoController.find(ids);
		System.out.println(String.format("Os recados procurados foram: %s", recadosDto.toString()));
	}

	private void handleProcuraRecados() {
		System.out.println("Opção de procurar todos os recados selecionada!");

		List<RecadoDto> recadosDto = recadoController.find();
		System.out.println(String.format("Os recados procurados foram: %s", recadosDto.toString()));
	}

	private void handleRemoveRecadoPorId() {
		System.out.println("Opção de remover um recado por id selecionada!");

		System.out.print("Digite o id do recado a ser removido: ");
		Integer id = scanner.nextInt();

		if (recadoController.remove(id)) {
			System.out.println("Recado removido com sucesso!");
		} else {
			System.out.println("Não foi possível remover o recado");
		}
	}

	private void handleRemoveRecadosPorId() {
		System.out.println("Opção de remover vários recados por ids selecionada!");

		Integer count = 1;
		Boolean next = true;
		List<Integer> ids = new ArrayList<>();

		while(next) {
			System.out.print(String.format("Digite o id do recado [%d]: ", count));
			ids.add(scanner.nextInt());

			System.out.print("Deseja adicionar mais algum id? (S/N) ");
			String option = scanner.next();
			next = option.equals("S");
			count++;
		}
		count--;

		Integer countRecados = recadoController.remove(ids);

		System.out.println(String.format("Dos %d recados, foram removidos %d recados", count, countRecados));
	}

	private void handleAtualizaRecadoPorId() {
		System.out.println("Opção de atualizar um usuário por id foi selecionada!");

		System.out.print("Digite o id do recado: ");
		Integer id = scanner.nextInt();

		System.out.print("Digite o id da pessoa do recado: ");
		Integer idPessoa = scanner.nextInt();

		System.out.print("Digite o comentário do recado: ");
		String comentario = scanner.next();

		RecadoDto recadoDto = new RecadoDto(id, null, null, new PessoaDto(idPessoa, null, null, null, null, null), comentario);
		if (recadoController.update(recadoDto, id)) {
			System.out.println("Recado atualizado com sucesso");
		} else {
			System.out.println("Recado não pode ser atualizado");
		}
	}

	private void handleExit() {
		System.out.println("Opção de sair selecionada!");

		System.out.println("Obrigado por utilizar os serviços de Recado :)");
	}
}
