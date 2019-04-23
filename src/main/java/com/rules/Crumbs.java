package com.rules;

public class Crumbs extends Food {
	private int X, Y;
	private String smell = "crumbs";

	public Crumbs(int x, int y) {
		super();
		X = x;
		Y = y;
	}

	public void setX(int x) {
		X = x;
	}

	public int getX() {
		return X;
	}

	public void setY(int y) {
		Y = y;
	}

	public int getY() {
		return Y;
	}

	public String getSmell() {
		return smell;
	}

	public void setSmell(String smell) {
		this.smell = smell;
	}

}
