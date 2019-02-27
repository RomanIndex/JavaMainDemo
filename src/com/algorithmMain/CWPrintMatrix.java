package com.algorithmMain;

import java.util.ArrayList;

public class CWPrintMatrix {

	public static void main(String[] args) {
		int[][] matrix = {
				{ 1, 2, 3, 4, 5 },
				{ 16, 17, 18, 19, 6 }, 
				{ 15, 24, 25, 20, 7 }, 
				{ 14, 23, 22, 21, 8 },
				{ 13, 12, 11, 10, 9 } 
				};
		ArrayList<Integer> list = printMatrix(matrix);
		list.stream().forEach(item -> System.out.print(item + " -- "));
	}

	public static ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		read(matrix, list, 0);
		return list;
	}

	public static void read(int[][] matrix, ArrayList<Integer> list, int start) {
		int row = matrix.length;
		int col = matrix[0].length;
		if (matrix == null || col < 1 || row < 1 || start < 0){
			return;
		}
		if (col <= 2 * start || row <= 2 * start){
			return;
		}
		int stopX = col - 1 - start;// 一圈最右列在坐标中的位置
		int stopY = row - 1 - start;// 一圈最大行在坐标中位置
		System.out.println("stopX："+ stopX +"，stopY："+ stopY);
		// 打印此圈中的最上行
		for (int i = start; i <= stopX; i++) {
			list.add(matrix[start][i]);
		}
		// 打印此圈中的最右列
		if (start <= stopX) {
			// 如果此圈中至少有一列
			for (int i = start + 1; i <= stopY; i++) {
				list.add(matrix[i][stopX]);
			}
		}
		// 打印次圈中的最下行
		if (start < stopX && start < stopY) {
			for (int i = stopX - 1; i >= start; i--) {
				list.add(matrix[stopY][i]);
			}
		}
		// 打印次圈中的最左列
		if (start < stopX && start < stopY - 1) {
			for (int i = stopY - 1; i >= start + 1; i--) {
				list.add(matrix[i][start]);
			}
		}
		read(matrix, list, start + 1);
	}

}