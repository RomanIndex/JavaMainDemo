package com.algorithmMain;

public class Queen8 {
	//（国际象棋）棋盘格子的范围，以及皇后的数量
	static final int MAX_NUM = 8;
	//二维数组作为棋盘
	int chessBoard[][] = new int[MAX_NUM][MAX_NUM];
	
	//检查落点是否符合规则
	boolean check(int x, int y){
		for(int i = 0; i < y; i++){
			//检查纵向
			if(chessBoard[x][i] == 1){
				return false;
			}
			//检查左侧倾斜
			if(x - 1 - i >= 0 && chessBoard[x - 1 - i][y - 1 - i] == 1){
				return false;
			}
			//检查右侧倾斜
			if(x + 1 + i < MAX_NUM && chessBoard[x + 1 + i][y - 1 - i] == 1){
				return false;
			}
		}
		return true;
	}
	
	//递归回溯（算法核心）
	boolean settleQueen(int y){
		//行数超过8，说明已经找出答案
		if(y == MAX_NUM){
			return true;
		}
		//遍历当前行，逐一格子验证
		for(int i = 0; i < MAX_NUM; i++){
			//为当前行清零，以免在回溯的时候出现脏数据
			for(int x = 0; x < MAX_NUM; x++){
				chessBoard[x][y] = 0;
			}
			//检查是否符合规则，如果符合，更改元素值并进一步递归
			if(check(i, y)){
				chessBoard[i][y] = 1;
				//递归如果返回true，说明下层已经找到解决，无需继续循环
				if(settleQueen(y + 1)){
					return true;
				}
			}
		}
		return false;
	}
	
	//打印棋盘当前值
	void printChessBoard(){
		for(int x = 0; x < MAX_NUM; x++){
			for(int y = 0; y < MAX_NUM; y++){
				System.out.print(chessBoard[y][x]);
			}
			System.out.println();
		}
	}
	
	/**
	 * 第一步：初始化
	 * 第二步：递归摆放皇后
	 * 第三步：最后输出结果
	 */
	public static void main(String[] args) {
		Queen8 queen8 = new Queen8();
		queen8.settleQueen(0);
		queen8.printChessBoard();
	}

}
