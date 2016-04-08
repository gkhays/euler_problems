package org.slg.chess;

public class KnightsTour {

	private int N = 8;
	private int[][] chessBoardArray = new int[8][8];
	private int[] xKnightMoves = { 2, 1, -1, -2, -2, -1, 1, 2 };
	private int[] yKnightMoves = { 1, 2, 2, 1, -1, -2, -2, -1 };
	
    public static void main(String[] args) {
    	KnightsTour tour = new KnightsTour();
        tour.run();        
    }
	
	public KnightsTour() {
		initialize_board();
        chessBoardArray[0][0] = 0;
	}

	public void run() {
		if (walk_board(0, 0, 1, chessBoardArray, xKnightMoves, yKnightMoves) == false) {
			System.out.print("no solution.\n");
		} else {
			print_board();
		}
	}

	private boolean can_move(int x, int y, int[][] a) {
		return (x >= 0 && x < N && y >= 0 && y < N && a[x][y] == -1);
	}

	private boolean walk_board(int x, int y, int m, int[][] a, int[] xm,
			int[] ym) {
		int next_x;
		int next_y;

		if (m == N * N) {
			return true;
		}

		for (int i = 0; i < N; i++) {
			next_x = x + xm[i];
			next_y = y + ym[i];
			if (can_move(next_x, next_y, a)) {
				a[next_x][next_y] = m;
				if (walk_board(next_x, next_y, m + 1, a, xm, ym) == true) {
					return true;
				} else {
					a[next_x][next_y] = -1;
				}
			}
		}
		return false;
	}

	private void print_board() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.printf("%3d", chessBoardArray[i][j]);
			}
			System.out.println();
		}
	}

	private void initialize_board() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				chessBoardArray[i][j] = -1;
			}
		}
	}
}


            
