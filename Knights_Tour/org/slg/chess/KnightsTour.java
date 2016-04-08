package org.slg.chess;

import java.awt.Point;

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

	public Point nextMove(int x, int y, int moveNumber) {
		int next_x;
		int next_y;
		Point point = null; // TODO: Is it really good manners to return null?
							// Or should we return (0, 0) or (-1, -1)?

		for (int i = 0; i < N; i++) {
			next_x = x + xKnightMoves[i];
			next_y = y + yKnightMoves[i];
			if (can_move(next_x, next_y)) {
				chessBoardArray[next_x][next_y] = moveNumber;
				point = new Point(next_x, next_y);
				break;
			}
		}
		return point;
	}
	
	public void run() {
		if (walk_board(0, 0, 1) == false) {
			System.out.print("no solution.\n");
		} else {
			print_board();
		}
	}

	private boolean can_move(int x, int y) {
		return ((x >= 0) 
				&& (x < N) 
				&& (y >= 0) 
				&& (y < N) 
				&& (chessBoardArray[x][y] == -1));
	}

	private boolean walk_board(int x, int y, int m) {
		int next_x;
		int next_y;

		if (m == N * N) {
			return true;
		}

		for (int i = 0; i < N; i++) {
			next_x = x + xKnightMoves[i];
			next_y = y + yKnightMoves[i];
			if (can_move(next_x, next_y)) {
				chessBoardArray[next_x][next_y] = m;
				if (walk_board(next_x, next_y, m + 1) == true) {
					return true;
				} else {
					chessBoardArray[next_x][next_y] = -1;
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


            
