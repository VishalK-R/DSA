package leet.arrays.easy;

public class FindRotation {

	public static void main(String[] args) {
		int [][] mat = {{0,0,0},{0,1,0},{1,1,1}};
		int [][] target = {{1,1,1},{0,1,0},{0,0,0}};
		System.out.println(findRotation(mat,target));
	}
	public static boolean findRotation(int[][] mat, int[][] target) {
        if (mat.length!=target.length) return false;
		boolean rotationPossible = false;
        int[][] rotatedArray = new int[mat.length][mat.length];
        int rotationsLeft = 4;
        while(rotationsLeft>0&&!rotationPossible) {
        	rotationPossible=true;
        	for (int i = 0; i < mat.length; i++) {
        		for (int j = 0; j < mat.length; j++) {
        			int element = mat[i][j];
        			if(element!=target[j][mat.length-1-i])
        				rotationPossible=false;
        			rotatedArray[j][mat.length-1-i]=element;
        		}
        	}
        	for (int i = 0; i < mat.length; i++) {
        		for (int j = 0; j < mat.length; j++) {
                	mat[i][j]=rotatedArray[i][j];
        		}
        	}
        	rotationsLeft--;
        }
		return rotationPossible;
    }
}
