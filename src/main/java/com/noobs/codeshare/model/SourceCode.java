package com.noobs.codeshare.model;

public class SourceCode {

	private int Id;
	private int language;
	private int visibility;
	private int created_by;
	private String created_by_alt;
	private String created_at;
	private String expire_at;
	private int is_deleted;



	public SourceCode(int id, int language, int visibility, int created_by, String created_by_alt, String created_at,
			String expire_at, int is_deleted) {
		super();
		Id = id;
		this.language = language;
		this.visibility = visibility;
		this.created_by = created_by;
		this.created_by_alt = created_by_alt;
		this.created_at = created_at;
		this.expire_at = expire_at;
		this.is_deleted = is_deleted;
	}

	public String getCreated_by_alt() {
		return created_by_alt;
	}

	public void setCreated_by_alt(String created_by_alt) {
		this.created_by_alt = created_by_alt;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getLanguage() {
		return language;
	}

	public void setLanguage(int language) {
		this.language = language;
	}

	public int getVisibility() {
		return visibility;
	}

	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getExpire_at() {
		return expire_at;
	}

	public void setExpire_at(String expire_at) {
		this.expire_at = expire_at;
	}

	public int getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(int is_deleted) {
		this.is_deleted = is_deleted;
	}
}
