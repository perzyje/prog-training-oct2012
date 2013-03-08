package com.tora.cube;

import java.util.*;

enum Connections {
	LEFT, RIGHT, FRONT, BACK, TOP, BOTTOM;

	final static List<Connections> SNAKE = Arrays.asList(RIGHT, BOTTOM, BOTTOM,
			BOTTOM, RIGHT, BOTTOM, RIGHT, BOTTOM, RIGHT, BOTTOM, RIGHT, BOTTOM,
			RIGHT, BOTTOM, BOTTOM, RIGHT, BOTTOM, BOTTOM, BOTTOM, RIGHT,
			BOTTOM, RIGHT, BOTTOM, BOTTOM, BOTTOM, RIGHT, RIGHT, BOTTOM, RIGHT,
			BOTTOM, RIGHT, BOTTOM, RIGHT, RIGHT, BOTTOM, BOTTOM, RIGHT, BOTTOM,
			RIGHT, BOTTOM, RIGHT, BOTTOM, RIGHT, BOTTOM, RIGHT, RIGHT, BOTTOM,
			RIGHT, RIGHT, BOTTOM, RIGHT, RIGHT, BOTTOM, RIGHT, RIGHT, RIGHT,
			BOTTOM, RIGHT, BOTTOM, BOTTOM, RIGHT, BOTTOM, BOTTOM);
}
