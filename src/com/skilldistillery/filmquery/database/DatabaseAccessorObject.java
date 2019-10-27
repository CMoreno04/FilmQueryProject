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
		Film film = null;

		String sqlTxt = "SELECT * " + "FROM film " + "JOIN film_actor ON film_id = film.id "
				+ "JOIN actor ON actor.id = actor_id " + "JOIN language ON film.language_id = language.id "
				+ "JOIN film_category ON film_category.film_id= film.id " + "JOIN category ON category.id=category_id "
				+ "WHERE film.id LIKE ?";

		try {
			PreparedStatement stmnt = conn.prepareStatement(sqlTxt);
			stmnt.setInt(1, filmId);
			ResultSet rs = stmnt.executeQuery();

			while (rs.next()) {
				film = new Film();

				film.setId(rs.getInt("film.id"));
				film.setTitle(rs.getString("film.title"));
				film.setDescription(rs.getString("film.description"));
				film.setLanguageId(rs.getInt("film.language_id"));
				film.setLength(rs.getInt("film.length"));
				film.setActors(findActorsByFilmId(rs.getInt("film.id")));
				film.setRating(rs.getString("film.rating"));
				film.setReleaseDate(rs.getInt("film.release_year"));
				film.setRentalDuration(rs.getInt("film.rental_duration"));
				film.setRentalRate(rs.getInt("film.rental_rate"));
				film.setReplacemenytCost(rs.getDouble("film.replacement_cost"));
				film.setSpecialFeatures(rs.getString("film.special_features"));
				film.setLanguage(rs.getString("name"));
				film.setCategory(rs.getString("category.name"));

			}
			stmnt.close();
			rs.close();

		}

		catch (SQLException e) {
			e.printStackTrace();
			return film;
		}

		return film;

	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		Actor actor = null;

		String sqlTxt = "SELECT * " + "FROM film " + "JOIN film_actor ON film_id = film.id "
				+ "JOIN actor ON actor.id = actor_id " + "JOIN language ON film.language_id = language.id "
				+ "JOIN film_category ON film_category.film_id = film.id WHERE film.id LIKE ?";

		try {
			PreparedStatement stmnt = conn.prepareStatement(sqlTxt);
			stmnt.setInt(1, filmId);
			ResultSet rs = stmnt.executeQuery();

			while (rs.next()) {
				actor = new Actor();

				actor.setId(rs.getInt("actor.id"));
				actor.setFirstName(rs.getString("actor.first_name"));
				actor.setLastName(rs.getString("actor.last_name"));

				actors.add(actor);
			}
			stmnt.close();
			rs.close();

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return actors;

	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;

		String sqlTxt = "SELECT * " + "FROM film " + "JOIN film_actor ON film_id = film.id "
				+ "JOIN actor ON actor.id = actor_id " + "JOIN language ON film.language_id = language.id "
				+ "JOIN film_category ON film_category.film_id = film.id WHERE film.id LIKE ?";

		try {
			PreparedStatement stmnt = conn.prepareStatement(sqlTxt);
			stmnt.setInt(1, actorId);
			ResultSet rs = stmnt.executeQuery();

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

	private List<Film> findActorsFilms(int actorId) {
		List<Film> films = new ArrayList<>();

		Film film = null;

		String sqlTxt = "SELECT * " + "FROM film " + "JOIN film_actor ON film_id = film.id "
				+ "JOIN actor ON actor.id = actor_id " + "WHERE actor.id LIKE ?";

		try {
			PreparedStatement stmnt = conn.prepareStatement(sqlTxt);
			stmnt.setInt(1, actorId);
			ResultSet rs = stmnt.executeQuery();

			while (rs.next()) {
				film = new Film();

				film.setId(rs.getInt("film.id"));
				film.setTitle(rs.getString("film.title"));
				film.setDescription(rs.getString("film.description"));
				film.setLanguageId(rs.getInt("film.language_id"));
				film.setLength(rs.getInt("film.length"));
				film.setActors(findActorsByFilmId(film.getId()));
				film.setRating(rs.getString("film.rating"));
				film.setReleaseDate(rs.getInt("film.release_year"));
				film.setRentalDuration(rs.getInt("film.rental_duration"));
				film.setRentalRate(rs.getInt("film.rental_rate"));
				film.setReplacemenytCost(rs.getDouble("film.replacement_cost"));
				film.setSpecialFeatures(rs.getString("film.special_features"));

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

	public List<Film> findFilmByKeyWord(String keyWord) {
		List<Film> films = new ArrayList<>();

		Film film = null;

		String sqlTxt = "SELECT * FROM film " + "JOIN language ON film.language_id = language.id "
				+ "JOIN film_category ON film_category.film_id= film.id "
				+ "WHERE film.description OR film.title LIKE ?";

		try {
			PreparedStatement stmnt = conn.prepareStatement(sqlTxt);
			stmnt.setString(1, "%" + keyWord + "%");
			ResultSet rs = stmnt.executeQuery();

			while (rs.next()) {
				film = new Film();

				film.setId(rs.getInt("film.id"));
				film.setTitle(rs.getString("film.title"));
				film.setDescription(rs.getString("film.description"));
				film.setLanguageId(rs.getInt("film.language_id"));
				film.setLength(rs.getInt("film.length"));
				film.setLanguage(rs.getString("name"));
				film.setActors(findActorsByFilmId(film.getId()));
				film.setRating(rs.getString("film.rating"));
				film.setReleaseDate(rs.getInt("film.release_year"));
				film.setRentalDuration(rs.getInt("film.rental_duration"));
				film.setRentalRate(rs.getInt("film.rental_rate"));
				film.setReplacemenytCost(rs.getDouble("film.replacement_cost"));
				film.setSpecialFeatures(rs.getString("film.special_features"));

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
