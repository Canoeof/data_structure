package array;

public class Practiice {

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[] order = new int[rows * columns];
        int index = 0;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order[index++] = matrix[top][column];
            }
            for (int row = top + 1; row <= bottom; row++) {
                order[index++] = matrix[row][right];
            }
            //if(left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order[index++] = matrix[bottom][column];
                }
                for (int row = bottom; row > top; row--) {
                    order[index++] = matrix[row][left];
                }
            //}
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;

    }

    public static void main(String[] args) {
        int[][] s = { {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}};

        int[] order = spiralOrder(s);

        for (int i = 0; i < order.length; i++) {
            System.out.print(order[i] + "    ");
        }
    }

}
