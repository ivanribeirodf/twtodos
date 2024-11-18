package com.ivanribeiro.twtodos.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min = 3, max = 100)
	@Column(length = 100, nullable = false)
	private String title;
	
	@Column(nullable = false)
	private LocalDateTime createAt;
	
	@NonNull
	@FutureOrPresent
	@Column(nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")	
	private LocalDate deadLine ;
	
	@Column(nullable = true)
	private LocalDate fineshedAt;
	
	public Todo() {
		this.createAt = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public LocalDate getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(LocalDate deadLine) {
		this.deadLine = deadLine;
	}

	public LocalDate getFineshedAt() {
		return fineshedAt;
	}

	public void setFineshedAt(LocalDate fineshedAt) {
		this.fineshedAt = fineshedAt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + "]";
	}
	
	

}
