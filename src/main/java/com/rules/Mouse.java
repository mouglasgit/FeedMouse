package com.rules;

import java.util.LinkedList;

public class Mouse {
	private Types types;
	private String status;
	private int X, Y;
	private LinkedList<int[]> pathMemory;

	public Mouse(String status) {
		this.status = status;
		this.pathMemory = new LinkedList<>();
	}

	public void setRun() {
		this.status = "run";
	}

	public void setDanger() {
		this.status = "danger";
	}

	public void setFood() {
		this.status = "food";
	}

	public void setStop() {
		this.status = "stop";
	}

	public String getStatus() {
		return status;
	}

	public int getX() {
		return this.X;
	}

	public void setX(int x) {
		this.X = x;
	}

	public int getY() {
		return this.Y;
	}

	public void setY(int y) {
		this.Y = y;
	}

	public int[] getLocation() {
		int xy[] = new int[2];
		xy[0] = this.X / types.STEP;
		xy[1] = this.Y / types.STEP;
		return xy;
	}

	public void addPathMemory() {
		int xy[] = new int[2];
		xy[0] = this.X;
		xy[1] = this.Y;

		this.pathMemory.add(xy);
	}

	public void returnLastStep() {
		int xy[] = new int[2];
		xy = this.pathMemory.getLast();

		this.X = xy[0];
		this.Y = xy[1];

		this.pathMemory.removeLast();
	}

	public boolean isCheese() {
		int i, j;
		i = this.X / types.STEP;
		j = this.Y / types.STEP;
		if (i == 9 && j == 8) {
			// if (i == 1 && j == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isSmellMousetrap() {
		int i, j;
		i = this.X / types.STEP;
		j = this.Y / types.STEP;
		if ((i == 0 && j == 3) || (i == 1 && j == 4) || (i == 0 && j == 5) || (i == 3 && j == 9) || (i == 4 && j == 8)
				|| (i == 5 && j == 9)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isSmellCheese() {
		int i, j;
		i = this.X / types.STEP;
		j = this.Y / types.STEP;
		// if (i == 1 && j == 0) {
		if ((i == 9 && j == 7) || (i == 8 && j == 8) || (i == 9 && j == 9)) {
			return true;
		} else {
			return false;
		}
	}

	public void goForFood() {
		this.status = "eating";
		this.X = 9 * types.STEP;
		this.Y = 8 * types.STEP;

	}

}
