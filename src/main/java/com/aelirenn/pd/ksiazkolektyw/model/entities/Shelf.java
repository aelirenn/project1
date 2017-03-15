package com.aelirenn.pd.ksiazkolektyw.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="shelfs")
public class Shelf {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_shelf")
	private Long shelfId;
	
	@OneToOne
	@JoinColumn(name="id_user")
	private UserDao user;
	
	@Column(name="shelf_type")
	private String shelfType;

	public Shelf() {
	}

	public Long getShelfId() {
		return shelfId;
	}

	public void setShelfId(Long shelfId) {
		this.shelfId = shelfId;
	}

	public UserDao getUser() {
		return user;
	}

	public void setUser(UserDao user) {
		this.user = user;
	}

	public String getShelfType() {
		return shelfType;
	}

	public void setShelfType(String type) {
		this.shelfType = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((shelfId == null) ? 0 : shelfId.hashCode());
		result = prime * result + ((shelfType == null) ? 0 : shelfType.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Shelf other = (Shelf) obj;
		if (shelfId == null) {
			if (other.shelfId != null)
				return false;
		} else if (!shelfId.equals(other.shelfId))
			return false;
		if (shelfType != other.shelfType)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Shelf [user=" + user + ", shelfType=" + shelfType + "]";
	}

	
	
}
