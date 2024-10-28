package main.java.com.codelinetrouble.casaja.views;

import java.util.Scanner;

import main.java.com.codelinetrouble.casaja.controllers.IgrejaController;
import main.java.com.codelinetrouble.casaja.views.interfaces.IView;

public class IgrejaView implements IView {
	private final IgrejaController igrejaController;
	private final Scanner scanner;

	public IgrejaView(IgrejaController igrejaController) {
		this.igrejaController = igrejaController;
		this.scanner = new Scanner(System.in);
	}

	@Override
	public void menu() {
	}
}
