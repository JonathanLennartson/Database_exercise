package main;

import java.sql.SQLException;
import java.util.Scanner;

import main.presentation.MenuJDBC;

public class Main {

	public static void main(String[] args) throws NumberFormatException, SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hej och välkommen!");

		while (true) {
			System.out.println("Vill du använda JDBC eller Hibernate eller avsluta");

			String choice = scanner.nextLine();

			switch (choice.toUpperCase()) {
				case "JDBC": {
					System.out.println("Du har valt att hantera persistens med JDBC\n");
					MenuJDBC.jdbc();
					continue;
				}
	
				case "HIBERNATE": {
					System.out.println("Du har valt att hantera persistens med Hibernate\n");
	
					continue;
				}
	
				case "AVSLUTA": {
					System.out.println("Hej då!");
					break;
				}
	
				default:
					System.out.println("Ogiltigt val, försök igen");
					continue;
			}

			
			break;
		
		}
		
	}
}
