package com.master.formation.dto;

public class CommentaireDto {

	private Long id;
	private String commentaire;
	private FormationDto formation;
	private UserDto userDto;

	public CommentaireDto() {

	}

	public CommentaireDto(String commentaire, FormationDto formation, UserDto userDto) {
		super();
		this.commentaire = commentaire;
		this.formation = formation;
		this.userDto = userDto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public FormationDto getFormation() {
		return formation;
	}

	public void setFormation(FormationDto formation) {
		this.formation = formation;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	

}
