package com.noej.aug18rbe2.mp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "aug18_photo")
public class MyPhoto {

	@Id
	@Column(name = "p_title")
	private String title;

	@Column(name = "p_file")
	private String file;
}
