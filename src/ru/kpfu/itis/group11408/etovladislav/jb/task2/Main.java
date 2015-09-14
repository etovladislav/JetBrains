package ru.kpfu.itis.group11408.etovladislav.jb.task2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Main {

	public static void main(String[] args) {
		Engine engine = new Engine();
		try {
			engine.process(new FileInputStream("in.txt"), new FileOutputStream(
					"out.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}