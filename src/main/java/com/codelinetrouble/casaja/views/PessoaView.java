package main.java.com.codelinetrouble.casaja.views;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.com.codelinetrouble.casaja.controllers.PessoaController;
import main.java.com.codelinetrouble.casaja.dtos.PessoaDto;
import main.java.com.codelinetrouble.casaja.views.interfaces.IView;

public class PessoaView implements IView {
	private final PessoaController pessoaController;
	private final Scanner scanner;

	public PessoaView(PessoaController pessoaController) {
		this.pessoaController = pessoaController;
		this.scanner = new Scanner(System.in);
	}

	@Override
	public void menu() {
		Integer option = 0;

		do {
			System.out.println("\nMENU DE OPÇÕES DE PESSOAS\n");
			System.out.println("1) Criar uma pessoa;");
			System.out.println("2) Criar várias pessoas;");
			System.out.println("3) Procurar uma pessoa por id;");
			System.out.println("4) Procurar várias pessoas por ids;");
			System.out.println("5) Procurar todas as pessoas;");
			System.out.println("6) Remover uma pessoa por id;");
			System.out.println("7) Remover várias pessoas por ids;");
			System.out.println("8) Atualizar uma pessoa por id;");
			System.out.println("9) Sair do menu de pessoa;");

			System.out.print("Digite sua opção: ");
			option = scanner.nextInt();

			switch (option) {
				case 1 -> handleCriaPessoa();
				case 2 -> handleCriaPessoas();
				case 3 -> handleProcuraPessoaPorId();
				case 4 -> handleProcuraPessoasPorId();
				case 5 -> handleProcuraPessoas();
				case 6 -> handleRemovePessoaPorId();
				case 7 -> handleRemovePessoasPorId();
				case 8 -> handleAtualizaPessoaPorId();
				case 9 -> handleExit();
				default -> System.out.println("Opção inválida!");
			}
		} while(option != 9);
	}

	private void handleCriaPessoa() {
		System.out.println("Opção de criar pessoa selecionada!");
		
		System.out.print("Digite o nome da pessoa: ");
		String nome = scanner.next();

		System.out.print("Digite o dia da data de nascimento da pessoa: ");
		Integer dia = scanner.nextInt();

		System.out.print("Digite o mês da data de nascimento da pessoa: ");
		Integer mes = scanner.nextInt();
		
		System.out.print("Digite o ano da data de nascimento da pessoa: ");
		Integer ano = scanner.nextInt();

		LocalDate nascimento = LocalDate.of(ano, mes, dia);

		System.out.print("Digite o telefone da pessoa: ");
		String telefone = scanner.next();

		PessoaDto pessoaDto = new PessoaDto(null, null, null, nome, nascimento, telefone);
		if (pessoaController.create(pessoaDto)) {
			System.out.println(String.format("Pessoa criada: %s", pessoaDto.toString()));
		} else {
			System.out.println(String.format("Pessoa não pode ser criada: %s", pessoaDto.toString()));
		}
	}

	private void handleCriaPessoas() {
		System.out.println("Opção de criar pessoas selecionada!");

		Integer count = 1;
		Boolean next = true;

		List<PessoaDto> pessoasDto = new ArrayList<>();

		while(next) {
			System.out.print(String.format("Digite o nome da pessoa [%d]: ", count));
			String nome = scanner.next();

			System.out.print(String.format("Digite o dia da data de nascimento da pessoa [%d]: ", count));
			Integer dia = scanner.nextInt();

			System.out.print(String.format("Digite o mês da data de nascimento da pessoa [%d]: ", count));
			Integer mes = scanner.nextInt();
			
			System.out.print(String.format("Digite o ano da data de nascimento da pessoa [%d]: ", count));
			Integer ano = scanner.nextInt();

			LocalDate nascimento = LocalDate.of(ano, mes, dia);

			System.out.print(String.format("Digite o telefone da pessoa [%d]: ", count));
			String telefone = scanner.next();

			pessoasDto.add(new PessoaDto(null, null, null, nome, nascimento, telefone));
			
			System.out.print("Deseja adicionar mais uma pessoa? (S/N) ");
			String option = scanner.next();
			next = option.equals("S");
			count++;
		}
		count--;

		Integer countPessoas = pessoaController.create(pessoasDto);

		System.out.println(String.format("Das %d pessoas, foram criadas %d pessoas", count, countPessoas));
	}

	private void handleProcuraPessoaPorId() {
		System.out.println("Opção de procurar uma pessoa por id selecionada!");

		System.out.print("Digite o id da pessoa: ");
		Integer id = scanner.nextInt();

		PessoaDto pessoaDto = pessoaController.find(id);
		if (pessoaDto != null)
			System.out.println(String.format("A pessoa procurada foi: %s", pessoaDto.toString()));
	}

	private void handleProcuraPessoasPorId() {
		System.out.println("Opção de procurar várias pessoa por ids selecionada!");

		Integer count = 1;
		Boolean next = true;
		List<Integer> ids = new ArrayList<>();

		while(next) {
			System.out.print(String.format("Digite o id da pessoa [%d]: ", count));
			ids.add(scanner.nextInt());

			System.out.print("Deseja adicionar mais algum id? (S/N) ");
			String option = scanner.next();
			next = option.equals("S");
			count++;
		}

		List<PessoaDto> pessoaDto = pessoaController.find(ids);
		System.out.println(String.format("As pessoas procuradas foram: %s", pessoaDto.toString()));
	}

	private void handleProcuraPessoas() {
		System.out.println("Opção de procurar todas as pessoas selecionada!");

		List<PessoaDto> pessoaDto = pessoaController.find();
		System.out.println(String.format("As pessoas procuradas foram: %s", pessoaDto.toString()));

	}

	private void handleRemovePessoaPorId() {
		System.out.println("Opção de remover uma pessoa por id selecionada!");

		System.out.print("Digite o id da pessoa a ser removida: ");
		Integer id = scanner.nextInt();

		if (pessoaController.remove(id)) {
			System.out.println("Pessoa removida com sucesso!");
		} else {
			System.out.println("Não foi possível remover a pessoa");
		}
	}

	private void handleRemovePessoasPorId() {
		System.out.println("Opção de remover várias pessoas por ids selecionada!");

		Integer count = 1;
		Boolean next = true;
		List<Integer> ids = new ArrayList<>();

		while(next) {
			System.out.print(String.format("Digite o id da pessoa [%d]: ", count));
			ids.add(scanner.nextInt());

			System.out.print("Deseja adicionar mais algum id? (S/N) ");
			String option = scanner.next();
			next = option.equals("S");
			count++;
		}
		count--;

		Integer countPessoas = pessoaController.remove(ids);

		System.out.println(String.format("Das %d pessoas, foram removidas %d pessoas", count, countPessoas));
	}

	private void handleAtualizaPessoaPorId() {
		System.out.println("Opção de atualizar uma pessoa por id foi selecionada!");

		System.out.print("Digite o id da pessoa: ");
		Integer id = scanner.nextInt();
		
		System.out.print("Digite o nome da pessoa: ");
		String nome = scanner.next();

		System.out.print("Digite o dia da data de nascimento da pessoa: ");
		Integer dia = scanner.nextInt();

		System.out.print("Digite o mês da data de nascimento da pessoa: ");
		Integer mes = scanner.nextInt();
		
		System.out.print("Digite o ano da data de nascimento da pessoa: ");
		Integer ano = scanner.nextInt();

		LocalDate nascimento = LocalDate.of(ano, mes, dia);

		System.out.print("Digite o telefone da pessoa: ");
		String telefone = scanner.next();

		PessoaDto pessoaDto = new PessoaDto(id, null, null, nome, nascimento, telefone);
		if (pessoaController.update(pessoaDto, id)) {
			System.out.println(String.format("Pessoa atualizada com sucesso: %s", pessoaDto.toString()));
		} else {
			System.out.println(String.format("Pessoa não pode ser atualizada: %s", pessoaDto.toString()));
		}
	}

	private void handleExit() {
		System.out.println("Opção de sair selecionada!");

		System.out.println("Obrigado por utilizar os serviços de Pessoa :)");
	}
}
