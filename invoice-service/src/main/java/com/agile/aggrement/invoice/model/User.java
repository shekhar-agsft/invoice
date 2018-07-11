package com.agile.aggrement.invoice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString(includeFieldNames = true)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = false)
@Entity
@Table(name="user")
public class User {

	@Id
	@Column(name="username")
	String username;
	
	@Column(name="password")
	String password;
	
	@JoinColumn(name="role_id")
	@ManyToOne
	UserRole userRole;
}
