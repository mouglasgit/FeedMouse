package com.rules;

import java.util.ArrayList;
import java.util.Random;

public class Game {
	private int[][] ground;
	private Types types;
	private Mouse mouse;
	private Utils utils;

	public Game(Mouse mouse, Cheese cheese, ArrayList<Mousetrap> listTraps) {

		this.mouse = mouse;
		this.utils = new Utils();
		types = types;
		ground = new int[10][10];
		ground = utils.fillGound(ground);
	}

	public void walkDown() {

		boolean haveStep = utils.checkBlockD(this.ground, mouse.getX(), mouse.getY());
		if (haveStep == true) {

			if (mouse.getY() < types.WINDOW_SIZE - types.STEP) {
				mouse.setY(mouse.getY() + types.STEP);
			}
		}
	}

	public void walkUp() {

		boolean haveStep = utils.checkBlockU(this.ground, mouse.getX(), mouse.getY());
		if (haveStep == true) {

			if (mouse.getY() > types.STEP) {
				mouse.setY(mouse.getY() - types.STEP);
			}
		}
	}

	public void walkRight() {

		boolean haveStep = utils.checkBlockR(this.ground, mouse.getX(), mouse.getY());
		if (haveStep == true) {

			if (mouse.getX() < types.WINDOW_SIZE - types.STEP) {
				mouse.setX(mouse.getX() + types.STEP);
			}
		}
	}

	public void walkLeft() {
		boolean haveStep = utils.checkBlockL(this.ground, mouse.getX(), mouse.getY());
		if (haveStep == true) {

			if (mouse.getX() > types.STEP) {
				mouse.setX(mouse.getX() - types.STEP);
			}
		}
	}

	public void randomWalking() {
		int randNum = (new Random()).nextInt(4);

		if (randNum == 0) {
			walkDown();
		} else if (randNum == 1) {
			walkUp();
		} else if (randNum == 2) {
			walkRight();
		} else if (randNum == 3) {
			walkLeft();
		}

	}
}