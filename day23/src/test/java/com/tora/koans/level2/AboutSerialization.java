package com.tora.koans.level2;

import java.io.*;

import org.junit.*;
import static com.tora.koans.ImplementationStub.*;

public class AboutSerialization {

	@Test
	public void simpleSerialization() throws FileNotFoundException,
			IOException, ClassNotFoundException {
		String s = "Hello world";
		// serialize
		ObjectOutputStream os = new ObjectOutputStream(getOutput());
		os.writeObject(s);
		os.close();

		// deserialize
		ObjectInputStream is = new ObjectInputStream(getInput());
		String otherString = (String) is.readObject();
		assertEquals(otherString, __);
	}

	static class Starship implements Serializable {

		// Although it is not enforced, you should define this constant
		// to make sure you serialize/deserialize only compatible versions
		// of your objects
		private static final long serialVersionUID = 1L;
		int maxWarpSpeed;
	}

	@Test
	public void customObjectSerialization() throws IOException,
			ClassNotFoundException {
		Starship s = new Starship();
		s.maxWarpSpeed = 9;
		ObjectOutputStream os = new ObjectOutputStream(getOutput());
		os.writeObject(s);
		os.close();

		ObjectInputStream is = new ObjectInputStream(getInput());
		Starship onTheOtherSide = (Starship) is.readObject();

		assertEquals(onTheOtherSide.maxWarpSpeed, __);
	}

	static class Engine {
		String type;

		public Engine(String t) {
			type = t;
		}
	};

	@SuppressWarnings("serial")
	static class Car implements Serializable {
		// Transient means: Ignore field for serialization
		transient Engine engine;

		// Notice these methods are private and will be called by the JVM
		// internally - as if they where defined by the Serializable interface
		// but they aren't defined as part of the interface
		private void writeObject(ObjectOutputStream os) throws IOException {
			os.defaultWriteObject();
			os.writeObject(engine.type);
		}

		private void readObject(ObjectInputStream is) throws IOException,
				ClassNotFoundException {
			is.defaultReadObject();
			engine = new Engine((String) is.readObject());
		}
	}

	@Test
	public void customObjectSerializationWithTransientFields()
			throws FileNotFoundException, IOException, ClassNotFoundException {
		// Note that this kind of access of fields is not good OO practice.
		// But let's focus on serialization here :)
		Car car = new Car();
		car.engine = new Engine("diesel");
		ObjectOutputStream os = new ObjectOutputStream(getOutput());
		os.writeObject(car);
		os.close();

		ObjectInputStream is = new ObjectInputStream(getInput());
		Car deserializedCar = (Car) is.readObject();

		assertEquals(deserializedCar.engine.type, __);
	}

	@SuppressWarnings("serial")
	class Boat implements Serializable {
		Engine engine;
	}

	@Test
	public void customSerializationWithUnserializableFields()
			throws FileNotFoundException, IOException {
		Boat boat = new Boat();
		boat.engine = new Engine("diesel");
		ObjectOutputStream os = new ObjectOutputStream(getOutput());
		String marker = "Start ";
		try {
			os.writeObject(boat);
		} catch (NotSerializableException e) {
			marker += "Exception";
		}
		os.close();
		assertEquals(marker, __);
	}

	@SuppressWarnings("serial")
	static class Animal implements Serializable {
		String name;

		public Animal(String s) {
			name = s;
		}
	}

	@SuppressWarnings("serial")
	static class Dog extends Animal {
		public Dog(String s) {
			super(s);
		}
	}

	@Test
	public void serializeWithInteritance() throws IOException,
			ClassNotFoundException {
		Dog d = new Dog("snoopy");
		ObjectOutputStream os = new ObjectOutputStream(getOutput());
		os.writeObject(d);
		os.close();

		ObjectInputStream is = new ObjectInputStream(getInput());
		Dog otherDog = (Dog) is.readObject();
		assertEquals(otherDog.name, __);
	}

	static class Plane {
		String name;

		public Plane(String s) {
			name = s;
		}

		public Plane() {
		};
	}

	@SuppressWarnings("serial")
	static class MilitaryPlane extends Plane implements Serializable {
		public MilitaryPlane(String s) {
			super(s);
		}
	}

	@Test
	public void serializeWithInheritanceWhenParentNotserializable()
			throws FileNotFoundException, IOException, ClassNotFoundException {
		MilitaryPlane p = new MilitaryPlane("F22");

		ObjectOutputStream os = new ObjectOutputStream(getOutput());
		os.writeObject(p);
		os.close();

		ObjectInputStream is = new ObjectInputStream(getInput());
		MilitaryPlane otherPlane = (MilitaryPlane) is.readObject();
		// Does this surprise you?
		assertEquals(otherPlane.name, __);

		// Think about how serialization creates objects...
		// It does not use constructors! But if a parent object is not
		// serializable
		// it actually uses contstructors and if the fields are not in a
		// serializable class...
		// unexpected things - like this - may happen
	}

	private ByteArrayOutputStream output;

	private OutputStream getOutput() {
		return output = new ByteArrayOutputStream();
	}

	private InputStream getInput() throws IOException {
		output.flush();
		return new ByteArrayInputStream(output.toByteArray());
	}
}
