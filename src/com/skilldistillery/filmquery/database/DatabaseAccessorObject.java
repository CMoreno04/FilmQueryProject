package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Film findFilmById(int filmId) {

		return null;
	}

	@Override
	public Actor findActorById(int actorId) {
		String user = "student";
		String pass = "student";
		String sqlTxt = "INSERT SQL COMMAND";

		Actor actor = null;

		try (Connection conn = DriverManager.getConnection(URL, user, pass);
				PreparedStatement stmnt = conn.prepareStatement(sqlTxt);
				ResultSet rs = stmnt.executeQuery();) {

			while (rs.next()) {
				actor.setFilms();
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			return actor;

		}
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> films = new ArrayList<>();

		return films;
	}

}
