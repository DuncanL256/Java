public class ArrayAddition {
    public static int[][][] add3DArrays(int[][][] A, int[][][] B) {
        if (A.length != B.length || A[0].length != B[0].length || A[0][0].length != B[0][0].length)
            throw new IllegalArgumentException("Arrays have to be squares");
            
        int[][][] result = new int[A.length][A[0].length][A[0][0].length];
        
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                for (int k = 0; k < A[0][0].length; k++)
                    result[i][j][k] = A[i][j][k] + B[i][j][k];
                    
        return result;
    }
}
