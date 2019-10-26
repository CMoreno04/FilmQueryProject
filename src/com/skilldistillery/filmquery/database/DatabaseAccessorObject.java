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
	private static Connection conn;
	private static PreparedStatement stmnt;
	private static ResultSet rs;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String user = "student";
			String pass = "student";
			conn = DriverManager.getConnection(URL, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) {

		return null;
	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;

		String sqlTxt = "SELECT * FROM actor JOIN film_actor ON film_id = film.id JOIN actor ON actor.id = actor_id WHERE actor.id LIKE ?";

		try {
			stmnt = conn.prepareStatement(sqlTxt);
			stmnt.setInt(1, actorId);
			rs = stmnt.executeQuery();

			while (rs.next()) {
				actor = new Actor();

				actor.setId(rs.getInt("actor.id"));
				actor.setFirstName(rs.getString("actor.first_name"));
				actor.setLastName(rs.getString("actor.last_name"));
				actor.setFilms(findActorsFilms(actorId));

			}
			stmnt.close();
			rs.close();

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return actor;

	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {

		return null;
	}

	private List<Film> findActorsFilms(int actorId) {
		List<Film> films = new ArrayList<>();
		
		Film film;
		String sqlTxt = "SELECT * FROM actor JOIN film_actor ON film_id = film.id JOIN actor ON actor.id = actor_id WHERE actor.id LIKE ?";

		try {
			stmnt = conn.prepareStatement(sqlTxt);
			stmnt.setInt(1, actorId);
			rs = stmnt.executeQuery();

			while (rs.next()) {
				film = new Film();
				
				film.setDescription(rs.getString("film.description"));
				film.setId(rs.getInt("film.id"));
				film.setLanguageId(rs.getInt("film.language_id"));
				film.setLength(rs.getInt("film.length"));
				film.setActors(findActorsByFilmId(film.getId()));
				
				
				
				
				
				
				films.add(film);
			}
			stmnt.close();
			rs.close();

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return films;

	}

}
