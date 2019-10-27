package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
	private Scanner kb = new Scanner(System.in);
	private DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		app.launch();
	}

	private void launch() {
		startUserInterface(kb);
		kb.close();
	}

	private void startUserInterface(Scanner kb) {
		while (true) {
			System.out.println("********************MAIN MENU********************");
			System.out.println("1.Look up a film by its id.");
			System.out.println("2.Look up a film by a search keyword.");
			System.out.println("3.Exit the application.");
			System.out.println("********************************************");

			switch (kb.next()) {

			case "1":
				filmIDSubMenu();
				break;

			case "2":
				filmKeyWordSubMenu();
				break;

			case "3":
				db.closeConnection();
				System.out.println("Goodbye!");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid Entry, Please Try Again!");
				break;
			}
		}
	}

	private Object checkIfObjectIsNull(Object obj) {
		if (obj == null) {
			return obj = "No Such Selection Exists, Please Try Again!";
		} else {
			return obj;
		}
	}

	private void filmKeyWordSubMenu() {
		Boolean loop = true;
		List<Film> films = null;

		System.out.print("Please Enter Desired Keyword: ");
		films = db.findFilmByKeyWord(kb.next());

		for (int i = 0; i < films.size(); i++) {
			System.out.println(films.get(i).toString());
		}

		do {
			System.out.println("\n****************************");
			System.out.println("1.Return To Main Menu.");
			System.out.println("2.View all films details.");
			System.out.println("****************************");

			switch (kb.next()) {
			case "1":
				loop = false;
				break;

			case "2":
				for (Film film : films) {
					System.out.print(film.showAllDetails());
				}
				break;

			default:
				System.out.println("Invalid Entry, Please Try Again");
				break;
			}

		} while (loop);

	}

	private void filmIDSubMenu() {
		Boolean loop = true;
		Film film = null;

		System.out.print("Plase Input Desired Movie ID: \n");
		film = db.findFilmById(Integer.parseInt(kb.next()));

		checkIfObjectIsNull(film);
		System.out.print(film.toString());

		do {
			System.out.println("\n****************************");
			System.out.println("1.Return To Main Menu.");
			System.out.println("2.View all film details.");
			System.out.println("****************************");

			switch (kb.next()) {
			case "1":
				loop = false;
				break;
			case "2":
				System.out.println(film.showAllDetails());
				break;
			default:
				System.out.println("Invalid Entry, Please Try Again");
				break;
			}

		} while (loop);

	}
}
