package org.slg.chess;
public class KnightsTour {

    public static int N = 8;

    public static int[][] ar  = new int[8][8];

    static int[] xm = { 2, 1, -1, -2, -2, -1,  1,  2 };
    static int[] ym = { 1, 2,  2,  1, -1, -2, -2, -1 };

    public static void main(String[] args) {

        initialize_board(ar);
        ar[0][0] = 0;
        if (walk_board(0, 0, 1, ar, xm, ym) == false) {
            System.out.print("no solution.\n"); 
        } else {
            print_board();
        }
    }

    public static boolean can_move(int x, int y, int[][] a) {
        return(x>=0 && x<N && y>=0 && y<N && a[x][y] == -1);
    }

	public static boolean walk_board(int x, int y, int m, int[][] a, int[] xm,
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

    public static void print_board() {
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                System.out.printf("%3d", ar[i][j]);
            }
            System.out.println(); 
        }
    }

    public static void initialize_board(int[][] ar) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                ar[i][j] = -1;
            }
        }
    }
}


            
