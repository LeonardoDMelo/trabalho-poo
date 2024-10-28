package main.java.com.codelinetrouble.casaja.views;

import java.util.Scanner;

import main.java.com.codelinetrouble.casaja.controllers.CartorioController;
import main.java.com.codelinetrouble.casaja.views.interfaces.IView;

public class CartorioView implements IView {
	private final CartorioController cartorioController;
	private final Scanner scanner;

	public 	CartorioView(CartorioController cartorioController) {
		this.cartorioController = cartorioController;
		this.scanner = new Scanner(System.in);
	}

	@Override
	public void menu() {
	}
}
