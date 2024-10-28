package main.java.com.codelinetrouble.casaja.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.com.codelinetrouble.casaja.controllers.FornecedorController;
import main.java.com.codelinetrouble.casaja.dtos.FornecedorDto;
import main.java.com.codelinetrouble.casaja.enums.EstadoPagamento;
import main.java.com.codelinetrouble.casaja.views.interfaces.IView;

public class FornecedorView implements IView {
	private final FornecedorController fornecedorController;
	private final Scanner scanner;

	public FornecedorView(FornecedorController fornecedorController) {
		this.fornecedorController = fornecedorController;
		this.scanner = new Scanner(System.in);
	}

	@Override
	public void menu() {
		Integer option = 0;

		do {
			System.out.println("\nMENU DE OPÇÕES DE FORNECEDOR\n");
			System.out.println("1) Criar um fornecedor;");
			System.out.println("2) Criar vários fornecedores;");
			System.out.println("3) Procurar um fornecedor por id;");
			System.out.println("4) Procurar vários fornecedores por ids;");
			System.out.println("5) Procurar todos os fornecedores;");
			System.out.println("6) Remover um fornecedor por id;");
			System.out.println("7) Remover vários fornecedores por ids;");
			System.out.println("8) Atualizar um fornecedor por id;");
			System.out.println("9) Sair do menu de fornecedor;");

			System.out.print("\nDigite sua opção: ");
			option = scanner.nextInt();

			switch (option) {
				case 1 -> handleCriaFornecedor();
				case 2 -> handleCriaFornecedores();
				case 3 -> handleProcuraFornecedorPorId();
				case 4 -> handleProcuraFornecedoresPorId();
				case 5 -> handleProcuraFornecedores();
				case 6 -> handleRemoveFornecedorPorId();
				case 7 -> handleRemoveFornecedoresPorId();
				case 8 -> handleAtualizaFornecedorPorId();
				case 9 -> handleExit();
				default -> System.out.println("Opção inválida!");
			}
		} while(option != 9);
	}

	private void handleCriaFornecedor() {
		System.out.println("Opção de criar fornecedor selecionada!");
		
		System.out.print("Digite o nome do fornecedor: ");
		String nome = scanner.next();

		System.out.print("Digite o cnpj do fornecedor: ");
		String cnpj = scanner.next();

		System.out.print("Digite o telefone do fornecedor: ");
		String telefone = scanner.next();

		System.out.print("Digite o valor a pagar para o fornecedor: ");
		Double valorAPagar = scanner.nextDouble();
		
		System.out.print("Digite as parcelas a pagar para o fornecedor: ");
		Integer parcelas = scanner.nextInt();
		
		System.out.print("Digite o estado de pagamento para o fornecedor (0 - pago; 1 - em pagamento): ");
		Integer estadoPagamento = scanner.nextInt();
		EstadoPagamento estado = EstadoPagamento.toEnum(estadoPagamento);

		FornecedorDto fornecedorDto = new FornecedorDto(null, null, null, nome, cnpj, telefone, valorAPagar, parcelas, estado);
		if (fornecedorController.create(fornecedorDto)) {
			System.out.println("Fornecedor criado");
		} else {
			System.out.println("Fornecedor não pode ser criado");
		}
	}

	private void handleCriaFornecedores() {
		System.out.println("Opção de criar fornecedores selecionada!");

		Integer count = 1;
		Boolean next = true;

		List<FornecedorDto> fornecedoresDto = new ArrayList<>();

		while(next) {
			System.out.print("Digite o nome do fornecedor: ");
			String nome = scanner.next();

			System.out.print("Digite o cnpj do fornecedor: ");
			String cnpj = scanner.next();

			System.out.print("Digite o telefone do fornecedor: ");
			String telefone = scanner.next();

			System.out.print("Digite o valor a pagar para o fornecedor: ");
			Double valorAPagar = scanner.nextDouble();
			
			System.out.print("Digite as parcelas a pagar para o fornecedor: ");
			Integer parcelas = scanner.nextInt();
			
			System.out.print("Digite o estado de pagamento para o fornecedor (0 - pago; 1 - em pagamento): ");
			Integer estadoPagamento = scanner.nextInt();
			EstadoPagamento estado = EstadoPagamento.toEnum(estadoPagamento);

			fornecedoresDto.add(new FornecedorDto(null, null, null, nome, cnpj, telefone, valorAPagar, parcelas, estado));
			
			System.out.print("Deseja adicionar mais um fornecedor? (S/N) ");
			String option = scanner.next();
			next = option.equals("S");
			count++;
		}
		count--;

		Integer countFornecedores = fornecedorController.create(fornecedoresDto);
		System.out.println(String.format("Dos %d fornecedores, foram criados %d fornecedores", count, countFornecedores));
	}

	private void handleProcuraFornecedorPorId() {
		System.out.println("Opção de procurar um fornecedor por id selecionada!");

		System.out.print("Digite o id do fornecedor: ");
		Integer id = scanner.nextInt();

		FornecedorDto fornecedorDto = fornecedorController.find(id);
		if (fornecedorDto != null)
			System.out.println(String.format("O fornecedor procurado foi: %s", fornecedorDto.toString()));
	}

	private void handleProcuraFornecedoresPorId() {
		System.out.println("Opção de procurar vários fornecedores por ids selecionada!");

		Integer count = 1;
		Boolean next = true;
		List<Integer> ids = new ArrayList<>();

		while(next) {
			System.out.print(String.format("Digite o id do fornecedor [%d]: ", count));
			ids.add(scanner.nextInt());

			System.out.print("Deseja adicionar mais algum id? (S/N) ");
			String option = scanner.next();
			next = option.equals("S");
			count++;
		}

		List<FornecedorDto> fornecedorDto = fornecedorController.find(ids);
		System.out.println(String.format("Os fornecedores procurados foram: %s", fornecedorDto.toString()));
	}

	private void handleProcuraFornecedores() {
		System.out.println("Opção de procurar todos os fornecedores selecionada!");

		List<FornecedorDto> fornecedoresDto = fornecedorController.find();
		System.out.println(String.format("Os fornecedores procurados foram: %s", fornecedoresDto.toString()));
	}

	private void handleRemoveFornecedorPorId() {
		System.out.println("Opção de remover um fornecedor por id selecionada!");

		System.out.print("Digite o id do fornecedor a ser removido: ");
		Integer id = scanner.nextInt();

		if (fornecedorController.remove(id)) {
			System.out.println("Fornecedor removido com sucesso!");
		} else {
			System.out.println("Não foi possível remover o fornecedor");
		}
	}

	private void handleRemoveFornecedoresPorId() {
		System.out.println("Opção de remover vários fornecedores por ids selecionada!");

		Integer count = 1;
		Boolean next = true;
		List<Integer> ids = new ArrayList<>();

		while(next) {
			System.out.print(String.format("Digite o id do fornecedor [%d]: ", count));
			ids.add(scanner.nextInt());

			System.out.print("Deseja adicionar mais algum id? (S/N) ");
			String option = scanner.next();
			next = option.equals("S");
			count++;
		}
		count--;

		Integer countFornecedores = fornecedorController.remove(ids);

		System.out.println(String.format("Dos %d fornecedores, foram removidos %d fornecedores", count, countFornecedores));
	}

	private void handleAtualizaFornecedorPorId() {
		System.out.println("Opção de atualizar um fornecedor por id foi selecionada!");

		System.out.print("Digite o id do fornecedor: ");
		Integer id = scanner.nextInt();

		System.out.print("Digite o nome do fornecedor: ");
		String nome = scanner.next();

		System.out.print("Digite o cnpj do fornecedor: ");
		String cnpj = scanner.next();

		System.out.print("Digite o telefone do fornecedor: ");
		String telefone = scanner.next();

		System.out.print("Digite o valor a pagar para o fornecedor: ");
		Double valorAPagar = scanner.nextDouble();
		
		System.out.print("Digite as parcelas a pagar para o fornecedor: ");
		Integer parcelas = scanner.nextInt();
		
		System.out.print("Digite o estado de pagamento para o fornecedor (0 - pago; 1 - em pagamento): ");
		Integer estadoPagamento = scanner.nextInt();
		EstadoPagamento estado = EstadoPagamento.toEnum(estadoPagamento);

		FornecedorDto fornecedorDto = new FornecedorDto(id, null, null, nome, cnpj, telefone, valorAPagar, parcelas, estado);
		if (fornecedorController.update(fornecedorDto, id)) {
			System.out.println("Fornecedor atualizado com sucesso");
		} else {
			System.out.println("Fornecedor não pode ser atualizado");
		}
	}

	private void handleExit() {
		System.out.println("Opção de sair selecionada!");

		System.out.println("Obrigado por utilizar os serviços de Fornecedor :)");
	}
}
