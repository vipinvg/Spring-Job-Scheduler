package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString

public class User {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	public void setName(String string) {
		// TODO Auto-generated method stub
		
	}

}
