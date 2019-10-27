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
	private List<Actor> actors;

	public Film() {
		super();
	}

	public Film(Integer id, String title, String description, Integer releaseDate, Integer languageId,
			Integer rentalDuration, Integer rentalRate, Integer length, Double replacemenytCost, String rating,
			String specialFeatures, List<Actor> actors, String language) {
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
		this.actors = actors;
		this.language = language;
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
		builder.append("Film Id:");
		builder.append(id);
		builder.append("\n Title: ");
		builder.append(title);
		builder.append("\n Description: ");
		builder.append(description);
		builder.append("\n Release Date: ");
		builder.append(releaseDate);
		builder.append("\n Language Id: ");
		builder.append(languageId);
		builder.append("\n Rental Duration: ");
		builder.append(rentalDuration);
		builder.append("\n Rental Rate:");
		builder.append(rentalRate);
		builder.append("\n Length: ");
		builder.append(length);
		builder.append("\n Replacemenyt Cost: ");
		builder.append(replacemenytCost);
		builder.append("\n Rating: ");
		builder.append(rating);
		builder.append("\n Special Features: ");
		builder.append(specialFeatures);
		builder.append("\n Language: ");
		builder.append(language);
		builder.append("\n Cast: ");
		builder.append(showCast());
		return builder.toString();
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
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

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actors == null) ? 0 : actors.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
