package com.transon.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

import com.transon.entity.common.Gender;


@Entity
public class Student implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private String ID;

	@Column(name = "fullName", nullable = false)
	private String fullName;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender", nullable = false)
	private Gender gender;

	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "phoneNumber", nullable = false, length = 10)
	private String phoneNumber;

	@Column(name = "email", unique = true, nullable = false)
	private String email;

	@Column(name = "birthday")
	private Date birthday;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Student)) return false;
		Student student = (Student) o;
		return Objects.equals(ID, student.ID) &&
				Objects.equals(fullName, student.fullName) &&
				gender == student.gender &&
				Objects.equals(address, student.address) &&
				Objects.equals(phoneNumber, student.phoneNumber) &&
				Objects.equals(email, student.email) &&
				Objects.equals(birthday, student.birthday);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID, fullName, gender, address, phoneNumber, email, birthday);
	}


}
