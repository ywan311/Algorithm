package net.skhu.jump;

public class Jump {
	static long path[][];

	public static long go(int[][] a, int row, int col) {
		if(path==null) path = new long[a.length][a.length];
		if (row>a.length-1||col>a.length-1) return 0;
		else if(path[row][col]!=0)return path[row][col];
		int value = a[row][col];
		if(row==a.length-1&&col==a.length-1) {
			return 1;
		}else {
			return path[row][col]=go(a,row,col+value)+go(a,row+value,col);

		}
	}

	public static void main(String arg[]) {
		int[][] a = {{1,1,1},{1,1,1},{1,1,0}};
		System.out.println(Jump.go(a,0,0));
	}
}
