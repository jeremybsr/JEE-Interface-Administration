package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="element")
public class Element {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
	@Column(name="ELE_ID")
	private int id;
	@Column(name="ELE_STATEMENT", length = 50)
	private String statement;
	
	
	@Column(name = "ELE_TYPE")
	@Enumerated(EnumType.ORDINAL) //.STRING POUR STOCKER EN VARCHAR
	private ElementType type;
	
	
	@Column(name="ELE_URL", length = 255)
	private String url;
	
	@Column(name="ELE_TEXT1",  length = 255)
	private String text1;
	
	@Column(name="ELE_TEXT2",  length = 255)
	private String text2;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getText1() {
		return text1;
	}
	public void setText1(String text1) {
		this.text1 = text1;
	}
	public String getText2() {
		return text2;
	}
	public void setText2(String text2) {
		this.text2 = text2;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
	}
	public ElementType getType() {
		return type;
	}
	public void setType(ElementType type) {
		this.type = type;
	}
}
