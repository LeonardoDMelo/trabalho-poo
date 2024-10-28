package main.java.com.codelinetrouble.casaja.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.com.codelinetrouble.casaja.controllers.UsuarioController;
import main.java.com.codelinetrouble.casaja.dtos.PessoaDto;
import main.java.com.codelinetrouble.casaja.dtos.UsuarioDto;
import main.java.com.codelinetrouble.casaja.enums.TipoUsuario;
import main.java.com.codelinetrouble.casaja.views.interfaces.IView;

public class UsuarioView implements IView {
	private final UsuarioController usuarioController;
	private final Scanner scanner;

	public UsuarioView(UsuarioController usuarioController) {
		this.usuarioController = usuarioController;
		this.scanner = new Scanner(System.in);
	}

	@Override
	public void menu() {
		Integer option = 0;

		do {
			System.out.println("\nMENU DE OPÇÕES DE USUÁRIOS\n");
			System.out.println("1) Criar um usuário;");
			System.out.println("2) Criar vários usuários;");
			System.out.println("3) Procurar um usuário por id;");
			System.out.println("4) Procurar vários usuários por ids;");
			System.out.println("5) Procurar todos os usuários;");
			System.out.println("6) Remover um usuário por id;");
			System.out.println("7) Remover vários usuários por ids;");
			System.out.println("8) Atualizar um usuário por id;");
			System.out.println("9) Sair do menu de usuário;");

			System.out.print("\nDigite sua opção: ");
			option = scanner.nextInt();

			switch (option) {
				case 1 -> handleCriaUsuario();
				case 2 -> handleCriaUsuarios();
				case 3 -> handleProcuraUsuarioPorId();
				case 4 -> handleProcuraUsuariosPorId();
				case 5 -> handleProcuraUsuarios();
				case 6 -> handleRemoveUsuarioPorId();
				case 7 -> handleRemoveUsuariosPorId();
				case 8 -> handleAtualizaUsuarioPorId();
				case 9 -> handleExit();
				default -> System.out.println("Opção inválida!");
			}
		} while(option != 9);
	}

	private void handleCriaUsuario() {
		System.out.println("Opção de criar usuário selecionada!");
		
		System.out.print("Digite o id da pessoa: ");
		Integer idPessoa = scanner.nextInt();

		System.out.print("Digite o tipo do usuário (0 - noivo; 1 - cerimonial): ");
		Integer tipoPessoa = scanner.nextInt();
		TipoUsuario tipo = TipoUsuario.toEnum(tipoPessoa);

		System.out.print("Digite o login do usuário: ");
		String login = scanner.next();
		
		System.out.print("Digite a senha do usuário: ");
		String senha = scanner.next();

		UsuarioDto usuarioDto = new UsuarioDto(null, null, null, new PessoaDto(idPessoa, null, null, null, null, null), tipo, login, senha);
		if (usuarioController.create(usuarioDto)) {
			System.out.println("Usuário criado com sucesso");
		} else {
			System.out.println("Usuário não pode ser criado");
		}
	}

	private void handleCriaUsuarios() {
		System.out.println("Opção de criar pessoas selecionada!");

		Integer count = 1;
		Boolean next = true;

		List<UsuarioDto> usuariosDto = new ArrayList<>();

		while(next) {
			System.out.print(String.format("Digite o id da pessoa [%d]: ", count));
			Integer idPessoa = scanner.nextInt();

			System.out.print(String.format("Digite o tipo do usuário (0 - noivo; 1 - cerimonial) [%d]: ", count));
			Integer tipoPessoa = scanner.nextInt();
			TipoUsuario tipo = TipoUsuario.toEnum(tipoPessoa);

			System.out.print(String.format("Digite o login do usuário [%d]: ", count));
			String login = scanner.next();
			
			System.out.print(String.format("Digite a senha do usuário [%d]: ", count));
			String senha = scanner.next();

			usuariosDto.add(new UsuarioDto(null, null, null, new PessoaDto(idPessoa, null, null, null, null, null), tipo, login, senha));
			
			System.out.print("Deseja adicionar mais um usuário? (S/N) ");
			String option = scanner.next();
			next = option.equals("S");
			count++;
		}
		count--;

		Integer countUsuarios = usuarioController.create(usuariosDto);
		System.out.println(String.format("Dos %d usuários, foram criados %d usuários", count, countUsuarios));
	}

	private void handleProcuraUsuarioPorId() {
		System.out.println("Opção de procurar um usuário por id selecionada!");

		System.out.print("Digite o id do usuário: ");
		Integer id = scanner.nextInt();

		UsuarioDto usuarioDto = usuarioController.find(id);
		if (usuarioDto != null)
			System.out.println(String.format("O usuário procurado foi: %s", usuarioDto.toString()));
	}

	private void handleProcuraUsuariosPorId() {
		System.out.println("Opção de procurar várias pessoa por ids selecionada!");

		Integer count = 1;
		Boolean next = true;
		List<Integer> ids = new ArrayList<>();

		while(next) {
			System.out.print(String.format("Digite o id do usuário [%d]: ", count));
			ids.add(scanner.nextInt());

			System.out.print("Deseja adicionar mais algum id? (S/N) ");
			String option = scanner.next();
			next = option.equals("S");
			count++;
		}

		List<UsuarioDto> usuariosDto = usuarioController.find(ids);
		System.out.println(String.format("Os usuários procurados foram: %s", usuariosDto.toString()));
	}

	private void handleProcuraUsuarios() {
		System.out.println("Opção de procurar todas as pessoas selecionada!");

		List<UsuarioDto> usuariosDto = usuarioController.find();
		System.out.println(String.format("Os usuários procurados foram: %s", usuariosDto.toString()));
	}

	private void handleRemoveUsuarioPorId() {
		System.out.println("Opção de remover um usuário por id selecionada!");

		System.out.print("Digite o id da pessoa a ser removida: ");
		Integer id = scanner.nextInt();

		if (usuarioController.remove(id)) {
			System.out.println("Usuário removido com sucesso!");
		} else {
			System.out.println("Não foi possível remover o usuário");
		}
	}

	private void handleRemoveUsuariosPorId() {
		System.out.println("Opção de remover vários usuários por ids selecionada!");

		Integer count = 1;
		Boolean next = true;
		List<Integer> ids = new ArrayList<>();

		while(next) {
			System.out.print(String.format("Digite o id do usuário [%d]: ", count));
			ids.add(scanner.nextInt());

			System.out.print("Deseja adicionar mais algum id? (S/N) ");
			String option = scanner.next();
			next = option.equals("S");
			count++;
		}
		count--;

		Integer countUsuarios = usuarioController.remove(ids);

		System.out.println(String.format("Dos %d usuários, foram removidas %d usuários", count, countUsuarios));
	}

	private void handleAtualizaUsuarioPorId() {
		System.out.println("Opção de atualizar um usuário por id foi selecionada!");

		System.out.print("Digite o id do usuário: ");
		Integer id = scanner.nextInt();

		System.out.print("Digite o id da pessoa: ");
		Integer idPessoa = scanner.nextInt();

		System.out.print("Digite o tipo do usuário (0 - noivo; 1 - cerimonial): ");
		Integer tipoPessoa = scanner.nextInt();
		TipoUsuario tipo = TipoUsuario.toEnum(tipoPessoa);

		System.out.print("Digite o login do usuário: ");
		String login = scanner.next();
		
		System.out.print("Digite a senha do usuário: ");
		String senha = scanner.next();

		UsuarioDto usuarioDto = new UsuarioDto(null, null, null, new PessoaDto(idPessoa, null, null, null, null, null), tipo, login, senha);

		if (usuarioController.update(usuarioDto, id)) {
			System.out.println("Usuário atualizado com sucesso");
		} else {
			System.out.println("Usuário não pode ser atualizado");
		}
	}

	private void handleExit() {
		System.out.println("Opção de sair selecionada!");

		System.out.println("Obrigado por utilizar os serviços de Usuário :)");
	}
}
