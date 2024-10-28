package main.java.com.codelinetrouble.casaja;

import main.java.com.codelinetrouble.casaja.configs.SetupCartorio;
import main.java.com.codelinetrouble.casaja.configs.SetupCerimonial;
import main.java.com.codelinetrouble.casaja.configs.SetupConviteFamiliar;
import main.java.com.codelinetrouble.casaja.configs.SetupConviteIndividual;
import main.java.com.codelinetrouble.casaja.configs.SetupEvento;
import main.java.com.codelinetrouble.casaja.configs.SetupFornecedor;
import main.java.com.codelinetrouble.casaja.configs.SetupIgreja;
import main.java.com.codelinetrouble.casaja.configs.SetupPagamento;
import main.java.com.codelinetrouble.casaja.configs.SetupPessoa;
import main.java.com.codelinetrouble.casaja.configs.SetupPresente;
import main.java.com.codelinetrouble.casaja.configs.SetupRecado;
import main.java.com.codelinetrouble.casaja.configs.SetupUsuario;

import main.java.com.codelinetrouble.casaja.views.CartorioView;
import main.java.com.codelinetrouble.casaja.views.CerimonialView;
import main.java.com.codelinetrouble.casaja.views.ConviteFamiliarView;
import main.java.com.codelinetrouble.casaja.views.ConviteIndividualView;
import main.java.com.codelinetrouble.casaja.views.EventoView;
import main.java.com.codelinetrouble.casaja.views.FornecedorView;
import main.java.com.codelinetrouble.casaja.views.IgrejaView;
import main.java.com.codelinetrouble.casaja.views.PagamentoView;
import main.java.com.codelinetrouble.casaja.views.PessoaView;
import main.java.com.codelinetrouble.casaja.views.PresenteView;
import main.java.com.codelinetrouble.casaja.views.RecadoView;
import main.java.com.codelinetrouble.casaja.views.UsuarioView;

public class CasaJaApplication {
	public static void main(String[] args) {
		SetupCartorio setupCartorio = new SetupCartorio();
		CartorioView cartorioView = setupCartorio.setup();
		cartorioView.menu();

		SetupCerimonial setupCerimonial = new SetupCerimonial();
		CerimonialView cerimonialView = setupCerimonial.setup();
		cerimonialView.menu();

		SetupConviteFamiliar setupConviteFamiliaSetupConviteFamiliar = new SetupConviteFamiliar();
		ConviteFamiliarView conviteFamiliaSetupConviteFamiliarView = setupConviteFamiliaSetupConviteFamiliar.setup();
		conviteFamiliaSetupConviteFamiliarView.menu();

		SetupConviteIndividual setupConviteInSetupConviteIndividual = new SetupConviteIndividual();
		ConviteIndividualView conviteInSetupConviteIndividualView = setupConviteInSetupConviteIndividual.setup();
		conviteInSetupConviteIndividualView.menu();

		SetupEvento setupEvento = new SetupEvento();
		EventoView eventoView = setupEvento.setup();
		eventoView.menu();

		SetupFornecedor setupFornecedor = new SetupFornecedor();
		FornecedorView fornecedorView = setupFornecedor.setup();
		fornecedorView.menu();

		SetupIgreja setupIgreja = new SetupIgreja();
		IgrejaView igrejaView = setupIgreja.setup();
		igrejaView.menu();

		SetupPagamento setupPagamento = new SetupPagamento();
		PagamentoView pagamentoView = setupPagamento.setup();
		pagamentoView.menu();

		SetupPessoa setupPessoa = new SetupPessoa();
		PessoaView pessoaView = setupPessoa.setup();
		pessoaView.menu();

		SetupPresente setupPresente = new SetupPresente();
		PresenteView presenteView = setupPresente.setup();
		presenteView.menu();

		SetupRecado setupRecado = new SetupRecado();
		RecadoView recadoView = setupRecado.setup();
		recadoView.menu();

		SetupUsuario setupUsuario = new SetupUsuario();
		UsuarioView usuarioView = setupUsuario.setup();
		usuarioView.menu();
	}
}
