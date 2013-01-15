package com.tora.koans.level2;

import java.io.*;
import org.junit.*;
import static com.tora.koans.ImplementationStub.*;

public final class AboutFileIO {
	private File f;

	@Test
	public void fileObjectDoesntCreateFile() {
		assertEquals(f.exists(), __);
	}

	@Test
	public void fileCreationAndDeletion() throws IOException {
		f.createNewFile();
		assertEquals(f.exists(), __);
		f.delete();
		assertEquals(f.exists(), __);
	}

	@Test
	public void basicFileWritingAndReading() throws IOException {
		FileWriter fw = new FileWriter(f);
		fw.write("First line\nSecond line");
		fw.flush();
		fw.close();

		char[] in = new char[50];
		int size = 0;
		FileReader fr = new FileReader(f);
		size = fr.read(in);
		// No flush necessary!
		fr.close();
		assertEquals(size, __);
		assertEquals(new String(in), __);
		f.delete();
	}

	@Test
	public void betterFileWritingAndReading() throws IOException {
		FileWriter fw = new FileWriter(f);
		PrintWriter pw = new PrintWriter(fw);
		pw.println("First line");
		pw.println("Second line");
		pw.close();

		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		assertEquals(br.readLine(), __); // first line
		assertEquals(br.readLine(), __); // second line
		assertEquals(br.readLine(), __); // what now?
	}

	@Test
	public void directChainingForReadingAndWriting() throws IOException {
		PrintWriter pw = new PrintWriter(f);
		pw.println("1. line");
		pw.println("2. line");
		pw.close();

		StringBuilder sb = new StringBuilder();
		// Add the loop to go through the file line by line and add the line
		// to the StringBuilder
		assertEquals(sb.toString(), "1. line\n2. line");
	}

	@Before
	public void setUp() throws IOException {
		f = File.createTempFile("file", ".txt");
		f.deleteOnExit();
		f.delete();
	}
}
