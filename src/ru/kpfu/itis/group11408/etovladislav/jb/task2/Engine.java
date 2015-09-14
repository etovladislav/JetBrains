package ru.kpfu.itis.group11408.etovladislav.jb.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Engine implements StudentsSorter {
	private Map<String, Group> map = new LinkedHashMap<>();
	private List<String> list = new ArrayList<>();

	public void process(InputStream input, OutputStream output) {
		readFile(input);
		writeFile(output);
	}

	public void readFile(InputStream input) {

		try (BufferedReader read = new BufferedReader(new InputStreamReader(
				input, "windows-1251"))) {
			String line = "";
			while ((line = read.readLine()) != null) {
				list.add(line);
			}
		} catch (IOException e) {
			System.err.println("Error reading file");
			e.printStackTrace();
		}
		String[] array = new String[2];
		for (String string : list) {
			if (string.equals("")) {
				continue;
			}
			array = string.split(":");
			try {
				if (map.get(array[1]) == null) {
					map.put(array[1], new Group());
				}
				map.get(array[1]).addStudent(array[0]);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.err.println("Ошибка! Проверьте формат файла.");
				System.exit(0);
			}

		}
	}

	public void writeFile(OutputStream output) {
		int count;
		int index;
		try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				output, "windows-1251"))) {
			for (Entry<String, Group> entry : groupSort()) {
				entry.getValue().sortStudents();
				out.write(entry.getKey() + ": ");
				count = entry.getValue().countStudents();
				index = 0;
				for (String student : entry.getValue().getStudents()) {
					out.write(student);
					out.write(index == count - 1 ? ".\n" : ", ");
					index++;
				}
			}
		} catch (IOException e) {
			System.err.println("Error reading file");
			e.printStackTrace();
		}
	}

	public List<Entry<String, Group>> groupSort() {
		List<Entry<String, Group>> entries = new ArrayList<Entry<String, Group>>(
				map.entrySet());
		Collections.sort(entries, new Comparator<Entry<String, Group>>() {
			@Override
			public int compare(Entry<String, Group> e1, Entry<String, Group> e2) {
				int v1 = e1.getValue().countStudents();
				int v2 = e2.getValue().countStudents();
				return (v1 < v2) ? 1 : (v1 == v2) ? 0 : -1;
			}
		});
		return entries;
	}
}
