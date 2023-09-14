package com.noej.aug041f.file;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoejFile {
	private String title;
	private String img;
	private ArrayList<String> etc;
}
