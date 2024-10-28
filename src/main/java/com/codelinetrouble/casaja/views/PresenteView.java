package main.java.com.codelinetrouble.casaja.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.com.codelinetrouble.casaja.controllers.PresenteController;
import main.java.com.codelinetrouble.casaja.dtos.PessoaDto;
import main.java.com.codelinetrouble.casaja.dtos.PresenteDto;
import main.java.com.codelinetrouble.casaja.views.interfaces.IView;

public class PresenteView implements IView {
	private final PresenteController presenteController;
	private final Scanner scanner;

	public PresenteView(PresenteController presenteController) {
		this.presenteController = presenteController;
		this.scanner = new Scanner(System.in);
	}

	@Override
	public void menu() {
		Integer option = 0;

		do {
			System.out.println("\nMENU DE OPÇÕES DE PRESENTES\n");
			System.out.println("1) Criar um presente;");
			System.out.println("2) Criar vários presentes;");
			System.out.println("3) Procurar um presente por id;");
			System.out.println("4) Procurar vários presentes por ids;");
			System.out.println("5) Procurar todos os presentes;");
			System.out.println("6) Remover um presente por id;");
			System.out.println("7) Remover vários presentes por ids;");
			System.out.println("8) Atualizar um presente por id;");
			System.out.println("9) Sair do menu de presente;");

			System.out.print("\nDigite sua opção: ");
			option = scanner.nextInt();

			switch (option) {
				case 1 -> handleCriaPresente();
				case 2 -> handleCriaPresentes();
				case 3 -> handleProcuraPresentePorId();
				case 4 -> handleProcuraPresentesPorId();
				case 5 -> handleProcuraPresentes();
				case 6 -> handleRemovePresentePorId();
				case 7 -> handleRemovePresentesPorId();
				case 8 -> handleAtualizaPresentePorId();
				case 9 -> handleExit();
				default -> System.out.println("Opção inválida!");
			}
		} while (option != 9);
	}

	private void handleCriaPresente() {
		System.out.println("Opção de criar usuário selecionada!");

		System.out.print("Digite o id da pessoa: ");
		Integer idPessoa = scanner.nextInt();

		System.out.print("Digite o nome do presente: ");
		String nome = scanner.next();

		System.out.print("Digite o tipo do presente: ");
		String tipo = scanner.next();

		System.out.print("Digite o valor do presente: ");
		Double valor = scanner.nextDouble();

		PresenteDto presenteDto = new PresenteDto(null, null, null, nome, tipo, valor,
				new PessoaDto(idPessoa, null, null, null, null, null));
		if (presenteController.create(presenteDto)) {
			System.out.println("Presente criado com sucesso");
		} else {
			System.out.println("Presente não pode ser criado");
		}
	}

	private void handleCriaPresentes() {
		System.out.println("Opção de criar presentes selecionada!");

		Integer count = 1;
		Boolean next = true;

		List<PresenteDto> presentesDto = new ArrayList<>();

		while (next) {
			System.out.print(String.format("Digite o id da pessoa do presente [%d]: ", count));
			Integer idPessoa = scanner.nextInt();

			System.out.print(String.format("Digite o nome do presente [%d]: ", count));
			String nome = scanner.next();

			System.out.print(String.format("Digite o tipo do presente [%d]: ", count));
			String tipo = scanner.next();

			System.out.print(String.format("Digite valor do presente [%d]: ", count));
			Double valor = scanner.nextDouble();

			presentesDto.add(
					new PresenteDto(null, null, null, nome, tipo, valor, new PessoaDto(idPessoa, null, null, null, null, null)));

			System.out.print("Deseja adicionar mais um presente? (S/N) ");
			String option = scanner.next();
			next = option.equals("S");
			count++;
		}
		count--;

		Integer countPresentes = presenteController.create(presentesDto);
		System.out.println(String.format("Dos %d presentes, foram criados %d presentes", count, countPresentes));
	}

	private void handleProcuraPresentePorId() {
		System.out.println("Opção de procurar um presente por id selecionada!");

		System.out.print("Digite o id do presente: ");
		Integer id = scanner.nextInt();

		PresenteDto presenteDto = presenteController.find(id);
		if (presenteDto != null)
			System.out.println(String.format("O presente procurado foi: %s", presenteDto.toString()));
	}

	private void handleProcuraPresentesPorId() {
		System.out.println("Opção de procurar vários presentes por ids selecionada!");

		Integer count = 1;
		Boolean next = true;
		List<Integer> ids = new ArrayList<>();

		while (next) {
			System.out.print(String.format("Digite o id do presente [%d]: ", count));
			ids.add(scanner.nextInt());

			System.out.print("Deseja adicionar mais algum id? (S/N) ");
			String option = scanner.next();
			next = option.equals("S");
			count++;
		}

		List<PresenteDto> presentesDto = presenteController.find(ids);
		System.out.println(String.format("Os presentes procurados foram: %s", presentesDto.toString()));
	}

	private void handleProcuraPresentes() {
		System.out.println("Opção de procurar todos os presentes selecionada!");

		List<PresenteDto> presentesDto = presenteController.find();
		System.out.println(String.format("Os presentes procurados foram: %s", presentesDto.toString()));
	}

	private void handleRemovePresentePorId() {
		System.out.println("Opção de remover um presente por id selecionada!");

		System.out.print("Digite o id do presente a ser removido: ");
		Integer id = scanner.nextInt();

		if (presenteController.remove(id)) {
			System.out.println("Presente removido com sucesso!");
		} else {
			System.out.println("Não foi possível remover o presente");
		}
	}

	private void handleRemovePresentesPorId() {
		System.out.println("Opção de remover vários presentes por ids selecionada!");

		Integer count = 1;
		Boolean next = true;
		List<Integer> ids = new ArrayList<>();

		while (next) {
			System.out.print(String.format("Digite o id do presente [%d]: ", count));
			ids.add(scanner.nextInt());

			System.out.print("Deseja adicionar mais algum id? (S/N) ");
			String option = scanner.next();
			next = option.equals("S");
			count++;
		}
		count--;

		Integer countPresentes = presenteController.remove(ids);

		System.out.println(String.format("Dos %d presentes, foram removidas %d presentes", count, countPresentes));
	}

	private void handleAtualizaPresentePorId() {
		System.out.println("Opção de atualizar um presente por id foi selecionada!");

		System.out.print("Digite o id do presente: ");
		Integer id = scanner.nextInt();

		System.out.print("Digite o id da pessoa: ");
		Integer idPessoa = scanner.nextInt();

		System.out.print("Digite o nome do presente: ");
		String nome = scanner.next();

		System.out.print("Digite o tipo do presente: ");
		String tipo = scanner.next();

		System.out.print("Digite o valor do presente: ");
		Double valor = scanner.nextDouble();

		PresenteDto presenteDto = new PresenteDto(null, null, null, nome, tipo, valor,
				new PessoaDto(idPessoa, null, null, null, null, null));
		if (presenteController.update(presenteDto, id)) {
			System.out.println("Presente atualizado com sucesso");
		} else {
			System.out.println("Presente não pode ser atualizado");
		}
	}

	private void handleExit() {
		System.out.println("Opção de sair selecionada!");

		System.out.println("Obrigado por utilizar os serviços de Presente :)");
	}
}
