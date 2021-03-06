package sample;

public class Controller {
    static int ROW = 9,COLUMN = 9,CELL = 81;
    public static void main(String[] args) {
        int [][] board={
                {7,0,0, 5,8,3, 0,0,6},
                {0,0,6, 0,0,1, 4,0,5},
                {0,5,2, 0,0,6, 0,8,3},
                {3,0,0, 2,0,0, 9,5,8},
                {5,0,0, 0,7,8, 0,6,0},
                {6,4,8, 0,1,0, 3,0,0},
                {0,6,0, 8,0,2, 5,0,0},
                {0,0,3, 1,5,0, 0,7,2},
                {2,1,5, 6,0,0, 0,3,0}
        };
        playSudoku(board);
        printBoard(board);
    }
    public static void playSudoku(int[][] a){
        int nonZero = countNonZero(a);
        while(nonZero < CELL){
            for(int i=0; i< ROW; i++){
                for (int j = 0; j < COLUMN ; j++) {
                    if(a[i][j]==0){//try all 1 to 9
                        for(int value =1; value<=9; value++){
                            if(isValidForSure(a,value,i,j)){
                                a[i][j] = value;
                                nonZero++;
                                break;//break value loop
                            }
                        }
                    }
                }
            }
        }
    }
    public static void printBoard(int[][] a){
        for(int i=0;i<ROW;i++){
            for (int j = 0; j < COLUMN ; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public static int countNonZero(int[][] a){
        int count=0;
        for(int i=0; i< ROW;i++){
            for (int j = 0; j < COLUMN ; j++) {
                if(a[i][j]!=0){
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isValid(int[][] a, int value, int rowX, int columnY) {
        //check rowX
        for (int i = 0; i < COLUMN; i++) {
            if (value == a[rowX][i]) {
                return false;
            }
        }
        //check columnY
        for (int i = 0; i < ROW; i++) {
            if (value == a[i][columnY]) {
                return false;
            }
        }
        //check inside the sub-square 3x3
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a[(rowX / 3) * 3 + i][(columnY / 3) * 3 + j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidForSure(int [][]a, int value,int rowX, int columnY){
        if( isValid(a, value,rowX,columnY)){
            int possible=0;
            for (int i = 0; i < 3 ; i++) {
                for (int j = 0; j < 3 ; j++) {
                    if(a[(rowX/3)*3+i][(columnY/3)*3+j]==0 && isValid(a,value,(rowX/3)*3+i,(columnY/3)*3+j)){
                        possible++;
                    }
                }

            }
            if(possible == 1 ){
                return true;
            }
        }
        return false;
    }
}

