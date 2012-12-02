package com.tora.rpsls;

public enum Outcome {
	WIN, LOOSE, TIE;
	
	Outcome getNegation() {
		switch (this) {
		case WIN: return LOOSE;
		case LOOSE: return WIN;
		default: return TIE;
		}
	}
}
