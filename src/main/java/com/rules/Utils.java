package com.rules;

public class Utils {
	private Types types;

	public Utils() {
		types = types;
	}

	public int[][] fillGound(int ground[][]) {

		for (int i = 0; i < ground.length; i++) {
			for (int j = 0; j < ground[0].length; j++) {
				ground[i][j] = 0;
			}
		}

		ground[0][0] = types.MOUSE;

		ground[9][7] = types.CHEESE_SMELL;
		ground[9][8] = types.CHEESE;
		ground[8][8] = types.CHEESE_SMELL;
		ground[9][9] = types.CHEESE_SMELL;

		ground[7][7] = types.BLOCK;
		ground[7][8] = types.BLOCK;

		ground[7][2] = types.BLOCK;
		ground[8][3] = types.BLOCK;
		ground[9][2] = types.BLOCK;

		ground[3][1] = types.BLOCK;
		ground[2][4] = types.BLOCK;
		ground[2][7] = types.BLOCK;

		ground[5][2] = types.BLOCK;
		ground[5][3] = types.BLOCK;

		ground[0][3] = types.MOUSETRAP_SMELL;
		ground[0][4] = types.MOUSETRAP;
		ground[1][4] = types.MOUSETRAP_SMELL;
		ground[0][5] = types.MOUSETRAP_SMELL;
		
		
		ground[3][9] = types.MOUSETRAP_SMELL;
		ground[4][8] = types.MOUSETRAP_SMELL;
		ground[4][9] = types.MOUSETRAP;
		ground[5][9] = types.MOUSETRAP_SMELL;

		return ground;
	}

	public boolean checkBlockR(int mtx[][], int x, int y) {
		for (int i = 0; i < mtx.length; i++) {
			for (int j = 0; j < mtx[0].length; j++) {
				if (mtx[i][j] == types.BLOCK && (((x + types.STEP) == (i * types.STEP) && y == (j * types.STEP)))) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean checkBlockL(int mtx[][], int x, int y) {
		for (int i = 0; i < mtx.length; i++) {
			for (int j = 0; j < mtx[0].length; j++) {
				if (mtx[i][j] == types.BLOCK && (((x - types.STEP) == (i * types.STEP) && y == (j * types.STEP)))) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean checkBlockU(int mtx[][], int x, int y) {
		for (int i = 0; i < mtx.length; i++) {
			for (int j = 0; j < mtx[0].length; j++) {
				if (mtx[i][j] == types.BLOCK && ((x == (i * types.STEP) && (y - types.STEP) == (j * types.STEP)))) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean checkBlockD(int mtx[][], int x, int y) {
		for (int i = 0; i < mtx.length; i++) {
			for (int j = 0; j < mtx[0].length; j++) {
				if (mtx[i][j] == types.BLOCK && ((x == (i * types.STEP) && (y + types.STEP) == (j * types.STEP)))) {
					return false;
				}
			}
		}
		return true;
	}

	public void printMatrix(int mtx[][]) {

		for (int i = 0; i < mtx.length; i++) {
			for (int j = 0; j < mtx[0].length; j++) {
				System.out.printf("%d\t", mtx[i][j]);
			}
			System.out.print("\n");
		}
	}

}
