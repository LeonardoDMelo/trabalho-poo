package main.java.com.codelinetrouble.casaja.views;

import java.util.Scanner;

import main.java.com.codelinetrouble.casaja.controllers.ConviteFamiliarController;
import main.java.com.codelinetrouble.casaja.views.interfaces.IView;

public class ConviteFamiliarView implements IView {
	private final ConviteFamiliarController conviteFamiliarViewController;
	private final Scanner scanner;

	public ConviteFamiliarView(ConviteFamiliarController conviteFamiliarViewController) {
		this.conviteFamiliarViewController = conviteFamiliarViewController;
		this.scanner = new Scanner(System.in);
	}

	@Override
	public void menu() {
	}
}
