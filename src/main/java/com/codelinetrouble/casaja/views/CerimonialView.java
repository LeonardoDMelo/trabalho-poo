package main.java.com.codelinetrouble.casaja.views;

import java.util.Scanner;

import main.java.com.codelinetrouble.casaja.controllers.CerimonialController;
import main.java.com.codelinetrouble.casaja.views.interfaces.IView;

public class CerimonialView implements IView {
	private final CerimonialController cerimonialController;
	private final Scanner scanner;

	public CerimonialView(CerimonialController cerimonialController) {
		this.cerimonialController = cerimonialController;
		this.scanner = new Scanner(System.in);
	}

	@Override
	public void menu() {
	}
}
