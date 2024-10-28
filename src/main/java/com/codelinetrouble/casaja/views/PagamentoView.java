package main.java.com.codelinetrouble.casaja.views;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.com.codelinetrouble.casaja.controllers.PagamentoController;
import main.java.com.codelinetrouble.casaja.dtos.FornecedorDto;
import main.java.com.codelinetrouble.casaja.dtos.PagamentoDto;
import main.java.com.codelinetrouble.casaja.dtos.PessoaDto;
import main.java.com.codelinetrouble.casaja.views.interfaces.IView;

public class PagamentoView implements IView {
	private final PagamentoController pagamentoController;
	private final Scanner scanner;

	public PagamentoView(PagamentoController pagamentoController) {
		this.pagamentoController = pagamentoController;
		this.scanner = new Scanner(System.in);
	}

	@Override
	public void menu() {
		Integer option = 0;

		do {
			System.out.println("\nMENU DE OPÇÕES DE PAGAMENTOS\n");
			System.out.println("1) Criar um pagamento;");
			System.out.println("2) Criar vários pagamentos;");
			System.out.println("3) Procurar um pagamento por id;");
			System.out.println("4) Procurar vários pagamentos por ids;");
			System.out.println("5) Procurar todos os pagamentos;");
			System.out.println("6) Remover um pagamento por id;");
			System.out.println("7) Remover vários pagamentos por ids;");
			System.out.println("8) Atualizar um pagamento por id;");
			System.out.println("9) Sair do menu de pagamento;");

			System.out.print("\nDigite sua opção: ");
			option = scanner.nextInt();

			switch (option) {
				case 1 -> handleCriaPagamento();
				case 2 -> handleCriaPagamentos();
				case 3 -> handleProcuraPagamentoPorId();
				case 4 -> handleProcuraPagamentosPorId();
				case 5 -> handleProcuraPagamentos();
				case 6 -> handleRemovePagamentoPorId();
				case 7 -> handleRemovePagamentosPorId();
				case 8 -> handleAtualizaPagamentoPorId();
				case 9 -> handleExit();
				default -> System.out.println("Opção inválida!");
			}
		} while(option != 9);
	}

	private void handleCriaPagamento() {
		System.out.println("Opção de criar pagamento selecionada!");
		
		System.out.print("Digite o id da pessoa do pagamento: ");
		Integer idPessoa = scanner.nextInt();

		System.out.print("Digite o dia da data do pagamento: ");
		Integer dia = scanner.nextInt();

		System.out.print("Digite o mês da data do pagamento: ");
		Integer mes = scanner.nextInt();
		
		System.out.print("Digite o ano da data do pagamento: ");
		Integer ano = scanner.nextInt();

		LocalDate data = LocalDate.of(ano, mes, dia);

		System.out.print("Digite a descrição do pagamento: ");
		String descricao = scanner.next();

		System.out.print("Digite o id do fornecedor do pagamento: ");
		Integer idFornecedor = scanner.nextInt();

		System.out.print("Digite o valor do pagamento: ");
		Double valor = scanner.nextDouble();
		
		System.out.print("Digite a quantidade de parcelas do pagamento: ");
		Integer parcelas = scanner.nextInt();

		PagamentoDto pagamentoDto = new PagamentoDto(null, null, null, new PessoaDto(idPessoa, null, null, null, null, null), data, descricao, new FornecedorDto(idFornecedor, null, null, null, null, null, null, null, null), valor, parcelas);
		if (pagamentoController.create(pagamentoDto)) {
			System.out.println("Pagamento criado com sucesso");
		} else {
			System.out.println("Pagamento não pode ser criado");
		}
	}

	private void handleCriaPagamentos() {
		System.out.println("Opção de criar pagamentos selecionada!");

		Integer count = 1;
		Boolean next = true;

		List<PagamentoDto> pagamentosDto = new ArrayList<>();

		while(next) {
			System.out.print(String.format("Digite o id da pessoa do pagamento [%d]: ", count));
			Integer idPessoa = scanner.nextInt();

			System.out.print(String.format("Digite o dia da data do pagamento [%d]: ", count));
			Integer dia = scanner.nextInt();

			System.out.print(String.format("Digite o mês da data do pagamento [%d]: ", count));
			Integer mes = scanner.nextInt();
			
			System.out.print(String.format("Digite o ano da data do pagamento [%d]: ", count));
			Integer ano = scanner.nextInt();

			LocalDate data = LocalDate.of(ano, mes, dia);

			System.out.print(String.format("Digite a descrição do pagamento [%d]: ", count));
			String descricao = scanner.next();

			System.out.print(String.format("Digite o id do fornecedor do pagamento [%d]: ", count));
			Integer idFornecedor = scanner.nextInt();

			System.out.print(String.format("Digite o valor do pagamento [%d]: ", count));
			Double valor = scanner.nextDouble();
			
			System.out.print(String.format("Digite a quantidade de parcelas do pagamento [%d]: ", count));
			Integer parcelas = scanner.nextInt();

			pagamentosDto.add(new PagamentoDto(null, null, null, new PessoaDto(idPessoa, null, null, null, null, null), data, descricao, new FornecedorDto(idFornecedor, null, null, null, null, null, null, null, null), valor, parcelas));
			
			System.out.print("Deseja adicionar mais um pagamento? (S/N) ");
			String option = scanner.next();
			next = option.equals("S");
			count++;
		}
		count--;

		Integer countPagamentos = pagamentoController.create(pagamentosDto);
		System.out.println(String.format("Dos %d pagamentos, foram criados %d pagamentos", count, countPagamentos));
	}

	private void handleProcuraPagamentoPorId() {
		System.out.println("Opção de procurar um pagamento por id selecionada!");

		System.out.print("Digite o id do pagamento: ");
		Integer id = scanner.nextInt();

		PagamentoDto pagamentoDto = pagamentoController.find(id);
		if (pagamentoDto != null)
			System.out.println(String.format("O pagamento procurado foi: %s", pagamentoDto.toString()));
	}

	private void handleProcuraPagamentosPorId() {
		System.out.println("Opção de procurar vários pagamentos por ids selecionada!");

		Integer count = 1;
		Boolean next = true;
		List<Integer> ids = new ArrayList<>();

		while(next) {
			System.out.print(String.format("Digite o id do pagamento [%d]: ", count));
			ids.add(scanner.nextInt());

			System.out.print("Deseja adicionar mais algum id? (S/N) ");
			String option = scanner.next();
			next = option.equals("S");
			count++;
		}

		List<PagamentoDto> pagamentosDto = pagamentoController.find(ids);
		System.out.println(String.format("Os pagamentos procurados foram: %s", pagamentosDto.toString()));
	}

	private void handleProcuraPagamentos() {
		System.out.println("Opção de procurar todos os pagamentos selecionada!");

		List<PagamentoDto> pagamentosDto = pagamentoController.find();
		System.out.println(String.format("Os pagamentos procurados foram: %s", pagamentosDto.toString()));
	}

	private void handleRemovePagamentoPorId() {
		System.out.println("Opção de remover um pagamento por id selecionada!");

		System.out.print("Digite o id do pagamento a ser removido: ");
		Integer id = scanner.nextInt();

		if (pagamentoController.remove(id)) {
			System.out.println("Pagamento removido com sucesso!");
		} else {
			System.out.println("Não foi possível remover o pagamento");
		}
	}

	private void handleRemovePagamentosPorId() {
		System.out.println("Opção de remover vários pagamentos por ids selecionada!");

		Integer count = 1;
		Boolean next = true;
		List<Integer> ids = new ArrayList<>();

		while(next) {
			System.out.print(String.format("Digite o id do pagamento [%d]: ", count));
			ids.add(scanner.nextInt());

			System.out.print("Deseja adicionar mais algum id? (S/N) ");
			String option = scanner.next();
			next = option.equals("S");
			count++;
		}
		count--;

		Integer countPagamentos = pagamentoController.remove(ids);
		System.out.println(String.format("Dos %d pagamentos, foram removidas %d pagamentos", count, countPagamentos));
	}

	private void handleAtualizaPagamentoPorId() {
		System.out.println("Opção de atualizar um pagamento por id foi selecionada!");

		System.out.print("Digite o id do pagamento: ");
		Integer id = scanner.nextInt();
		
		System.out.print("Digite o id da pessoa do pagamento: ");
		Integer idPessoa = scanner.nextInt();

		System.out.print("Digite o dia da data do pagamento: ");
		Integer dia = scanner.nextInt();

		System.out.print("Digite o mês da data do pagamento: ");
		Integer mes = scanner.nextInt();
		
		System.out.print("Digite o ano da data do pagamento: ");
		Integer ano = scanner.nextInt();

		LocalDate data = LocalDate.of(ano, mes, dia);

		System.out.print("Digite a descrição do pagamento: ");
		String descricao = scanner.next();

		System.out.print("Digite o id do fornecedor do pagamento: ");
		Integer idFornecedor = scanner.nextInt();

		System.out.print("Digite o valor do pagamento: ");
		Double valor = scanner.nextDouble();
		
		System.out.print("Digite a quantidade de parcelas do pagamento: ");
		Integer parcelas = scanner.nextInt();

		PagamentoDto pagamentoDto = new PagamentoDto(null, null, null, new PessoaDto(idPessoa, null, null, null, null, null), data, descricao, new FornecedorDto(idFornecedor, null, null, null, null, null, null, null, null), valor, parcelas);
		
		if (pagamentoController.update(pagamentoDto, id)) {
			System.out.println("Pagamento atualizado com sucesso");
		} else {
			System.out.println("Pagamento não pode ser atualizado");
		}
	}

	private void handleExit() {
		System.out.println("Opção de sair selecionada!");

		System.out.println("Obrigado por utilizar os serviços de Pagamento :)");
	}
}
