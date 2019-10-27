package com.skilldistillery.filmquery.entities;

import java.util.List;

public class Film {
	private Integer id;
	private String title;
	private String description;
	private Integer releaseDate;
	private Integer languageId;
	private Integer rentalDuration;
	private Integer rentalRate;
	private Integer length;
	private Double replacemenytCost;
	private String rating;
	private String specialFeatures;
	private String language;
	private String category;
	private String condition;
	private List<Actor> actors;
	private List<Film> inventory;

	public Film() {
		super();
	}

	public Film(Integer id, String title, String description, Integer releaseDate, Integer languageId,
			Integer rentalDuration, Integer rentalRate, Integer length, Double replacemenytCost, String rating,
			String specialFeatures, String language, String category, String condition, List<Actor> actors) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseDate = releaseDate;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacemenytCost = replacemenytCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.language = language;
		this.category = category;
		this.condition = condition;
		this.actors = actors;
	}

	@Override
	public String toString() {
		return "\nTitle: " + getTitle() + "\nYear Released:" + getReleaseDate() + "\nRating: " + getRating()
				+ "\nLanguage: " + getLanguage() + "\nDiscription: " + getDescription() + "\n\nCast: " + showCast();

	}

	private String showCast() {
		StringBuilder cast = new StringBuilder();
		cast.append("\n");

		for (Actor actor : actors) {
			cast.append(actor.toString() + "  \n");
		}
		return cast.toString();
	}

	public String showAllDetails() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nFilm Id: ");
		builder.append(id);
		builder.append("\nTitle: ");
		builder.append(title);
		builder.append("\nDescription: ");
		builder.append(description);
		builder.append("\nRelease Date: ");
		builder.append(releaseDate);
		builder.append("\nLanguage Id: ");
		builder.append(languageId);
		builder.append("\nRental Duration: ");
		builder.append(rentalDuration);
		builder.append("\nRental Rate: ");
		builder.append(rentalRate);
		builder.append("\nLength: ");
		builder.append(length);
		builder.append("\nReplacemenyt Cost: ");
		builder.append(replacemenytCost);
		builder.append("\nRating: ");
		builder.append(rating);
		builder.append("\nSpecial Features: ");
		builder.append(specialFeatures);
		builder.append("\nLanguage: ");
		builder.append(language);
		builder.append("\nCategory: ");
		builder.append(category);
		builder.append("\n\nCast: ");
		builder.append(showCast());
		return builder.toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Integer releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public Integer getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(Integer rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public Integer getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(Integer rentalRate) {
		this.rentalRate = rentalRate;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Double getReplacemenytCost() {
		return replacemenytCost;
	}

	public void setReplacemenytCost(Double replacemenytCost) {
		this.replacemenytCost = replacemenytCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	public List<Film> getInvenotry() {
		return inventory;
	}
	
	public void setInventory(List<Film> inventory) {
		this.inventory = inventory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actors == null) ? 0 : actors.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((condition == null) ? 0 : condition.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((languageId == null) ? 0 : languageId.hashCode());
		result = prime * result + ((length == null) ? 0 : length.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((releaseDate == null) ? 0 : releaseDate.hashCode());
		result = prime * result + ((rentalDuration == null) ? 0 : rentalDuration.hashCode());
		result = prime * result + ((rentalRate == null) ? 0 : rentalRate.hashCode());
		result = prime * result + ((replacemenytCost == null) ? 0 : replacemenytCost.hashCode());
		result = prime * result + ((specialFeatures == null) ? 0 : specialFeatures.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (actors == null) {
			if (other.actors != null)
				return false;
		} else if (!actors.equals(other.actors))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (condition == null) {
			if (other.condition != null)
				return false;
		} else if (!condition.equals(other.condition))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (languageId == null) {
			if (other.languageId != null)
				return false;
		} else if (!languageId.equals(other.languageId))
			return false;
		if (length == null) {
			if (other.length != null)
				return false;
		} else if (!length.equals(other.length))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (releaseDate == null) {
			if (other.releaseDate != null)
				return false;
		} else if (!releaseDate.equals(other.releaseDate))
			return false;
		if (rentalDuration == null) {
			if (other.rentalDuration != null)
				return false;
		} else if (!rentalDuration.equals(other.rentalDuration))
			return false;
		if (rentalRate == null) {
			if (other.rentalRate != null)
				return false;
		} else if (!rentalRate.equals(other.rentalRate))
			return false;
		if (replacemenytCost == null) {
			if (other.replacemenytCost != null)
				return false;
		} else if (!replacemenytCost.equals(other.replacemenytCost))
			return false;
		if (specialFeatures == null) {
			if (other.specialFeatures != null)
				return false;
		} else if (!specialFeatures.equals(other.specialFeatures))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	

}
