package com.rules;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JFrame {
	private static final long serialVersionUID = 1L;

	private Timer updateGameTurn;
	private ImageIcon imaMouseDown, imaMouseUp, imaMouseRight, imaMouseLeft, imaCheese, imaBlock, imaMousetrap,
			imaSmellMausetrap, imaSmellCheese, imaBackGround, imaCrumbs;
	private JLabel labMouse, labCheese, labBlock, labMousetrap, labSmellMausetrap, labSmellCheese, labBackGround,
			labCrumbs;
	private JPanel panMain;

	private int[][] ground;

	private Types types;

	private Mouse mouse;
	private Utils utils;

	public Game(Mouse mouse, Cheese cheese, ArrayList<Mousetrap> listTraps) {
		super("Game");

		this.mouse = mouse;
		this.utils = new Utils();
		types = types;

		ground = new int[10][10];
		ground = utils.fillGound(ground);
		
		mouse.setGround(ground);

		panMain = new JPanel();
		panMain.setLayout(null);
		panMain.setBackground(Color.GRAY);

		{
			imaMouseDown = new ImageIcon(getClass().getClassLoader().getResource("imgs/mouse_down.png"));
			imaMouseUp = new ImageIcon(getClass().getClassLoader().getResource("imgs/mouse_up.png"));
			imaMouseRight = new ImageIcon(getClass().getClassLoader().getResource("imgs/mouse_right.png"));
			imaMouseLeft = new ImageIcon(getClass().getClassLoader().getResource("imgs/mouse_left.png"));
			imaCheese = new ImageIcon(getClass().getClassLoader().getResource("imgs/cheese.png"));
			imaBlock = new ImageIcon(getClass().getClassLoader().getResource("imgs/block.png"));
			imaMousetrap = new ImageIcon(getClass().getClassLoader().getResource("imgs/mousetrap.png"));
			imaSmellMausetrap = new ImageIcon(getClass().getClassLoader().getResource("imgs/smell_mausetrap.png"));
			imaSmellCheese = new ImageIcon(getClass().getClassLoader().getResource("imgs/smell_cheese.png"));
			imaBackGround = new ImageIcon(getClass().getClassLoader().getResource("imgs/back_ground.png"));
			imaCrumbs = new ImageIcon(getClass().getClassLoader().getResource("imgs/crumbs.png"));
		}

		this.addObjects(ground);

		updateGameTurn = new Timer(types.TIME, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labMouse.setLocation(mouse.getX(), mouse.getY());
				// randomWalking();
			}
		});
		updateGameTurn.start();

		this.add(panMain);

		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(types.WINDOW_SIZE, types.WINDOW_SIZE);
	}

	public void addObjects(int mtx[][]) {

		for (int i = 0; i < mtx.length; i++) {
			for (int j = 0; j < mtx[0].length; j++) {

				if (mtx[i][j] == types.MOUSE) {
					this.labMouse = new JLabel(this.imaMouseDown);
					this.panMain.add(labMouse);
					this.labMouse.setBounds(i * types.STEP, j * types.STEP, types.STEP, types.STEP);

				} else if (mtx[i][j] == types.CHEESE) {
					this.labCheese = new JLabel(this.imaCheese);
					this.panMain.add(labCheese);
					this.labCheese.setBounds(i * types.STEP, j * types.STEP, types.STEP, types.STEP);

				} else if (mtx[i][j] == types.BLOCK) {
					this.labBlock = new JLabel(this.imaBlock);
					this.panMain.add(labBlock);
					this.labBlock.setBounds(i * types.STEP, j * types.STEP, types.STEP, types.STEP);
				} else if (mtx[i][j] == types.MOUSETRAP) {
					this.labMousetrap = new JLabel(this.imaMousetrap);
					this.panMain.add(labMousetrap);
					this.labMousetrap.setBounds(i * types.STEP, j * types.STEP, types.STEP, types.STEP);
				} else if (mtx[i][j] == types.MOUSETRAP_SMELL) {
					this.labSmellMausetrap = new JLabel(this.imaSmellMausetrap);
					this.panMain.add(labSmellMausetrap);
					this.labSmellMausetrap.setBounds(i * types.STEP, j * types.STEP, types.STEP, types.STEP);
				} else if (mtx[i][j] == types.CHEESE_SMELL) {
					this.labSmellCheese = new JLabel(this.imaSmellCheese);
					this.panMain.add(labSmellCheese);
					this.labSmellCheese.setBounds(i * types.STEP, j * types.STEP, types.STEP, types.STEP);
				} else if (mtx[i][j] == types.CRUMBS) {
					this.labCrumbs = new JLabel(this.imaCrumbs);
					this.panMain.add(labCrumbs);
					this.labCrumbs.setBounds(i * types.STEP, j * types.STEP, types.STEP, types.STEP);
				}

				this.labBackGround = new JLabel(this.imaBackGround);
				this.panMain.add(labBackGround);
				this.labBackGround.setBounds(i * types.STEP, j * types.STEP, types.STEP, types.STEP);

			}
		}
	}

	@SuppressWarnings("static-access")
	public void walkDown() {

		boolean haveStep = utils.checkBlockD(this.ground, mouse.getX(), mouse.getY());
		if (haveStep == true) {

			try {
				labMouse.setIcon(imaMouseDown);
				if (mouse.getY() < types.WINDOW_SIZE - types.STEP) {
					mouse.setY(mouse.getY() + types.STEP);
				}
				Thread.currentThread().sleep(types.TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	@SuppressWarnings("static-access")
	public void walkUp() {

		boolean haveStep = utils.checkBlockU(this.ground, mouse.getX(), mouse.getY());
		if (haveStep == true) {

			try {
				labMouse.setIcon(imaMouseUp);
				if (mouse.getY() > types.STEP) {
					mouse.setY(mouse.getY() - types.STEP);
				}
				Thread.currentThread().sleep(types.TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("static-access")
	public void walkRight() {

		boolean haveStep = utils.checkBlockR(this.ground, mouse.getX(), mouse.getY());
		if (haveStep == true) {
			try {
				labMouse.setIcon(imaMouseRight);
				if (mouse.getX() < types.WINDOW_SIZE - types.STEP) {
					mouse.setX(mouse.getX() + types.STEP);
				}
				Thread.currentThread().sleep(types.TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("static-access")
	public void walkLeft() {
		boolean haveStep = utils.checkBlockL(this.ground, mouse.getX(), mouse.getY());
		if (haveStep == true) {
			try {
				labMouse.setIcon(imaMouseLeft);
				if (mouse.getX() > types.STEP) {
					mouse.setX(mouse.getX() - types.STEP);
				}
				Thread.currentThread().sleep(types.TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
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