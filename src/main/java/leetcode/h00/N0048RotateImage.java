package leetcode.h00;

public class N0048RotateImage {

    protected void rotateSquare(int[][] matrix, int offset) {
        if (offset > matrix.length / 2 - 1) {
            throw new IllegalArgumentException("Offset is greater than matrix lenght");
        }

        int squareLength = matrix.length - offset * 2 - 1;
        for (int i = 0; i < squareLength; i++) {
            swap(matrix, offset, i);
        }
    }

    protected static void swap(int[][] matrix, int squareOffset, int elementOffset) {
        int squareLength = matrix.length - squareOffset * 2 - 1;
        PositionCalculator calc = new PositionCalculator(squareOffset, squareLength, elementOffset);

        int top = matrix[calc.top().ri][calc.top().ci];
        int right = matrix[calc.right().ri][calc.right().ci];
        int bottom = matrix[calc.bottom().ri][calc.bottom().ci];
        int left = matrix[calc.left().ri][calc.left().ci];

        // make the swap
        matrix[calc.top().ri][calc.top().ci] = matrix[calc.left().ri][calc.left().ci];
        matrix[calc.left().ri][calc.left().ci] = matrix[calc.bottom().ri][calc.bottom().ci];
        matrix[calc.bottom().ri][calc.bottom().ci] = matrix[calc.right().ri][calc.right().ci];
        matrix[calc.right().ri][calc.right().ci] = top;

    }

    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            rotateSquare(matrix, i);
        }
    }

    private static class Position {
        int ri; // moves from top to bottom
        int ci; // moves from left to right

        public Position(int rowIndex, int columnIndex) {
            this.ri = rowIndex;
            this.ci = columnIndex;
        }
    }

    private static class PositionCalculator {
        private final int squareOffset;
        private final int squareLength;
        private final int elementOffset;

        public PositionCalculator(int squareOffset, int sqaureLength, int elementOffset) {
            this.squareOffset = squareOffset;
            this.squareLength = sqaureLength;
            this.elementOffset = elementOffset;
        }

        public Position left() {
            return new Position(squareOffset + squareLength - elementOffset, squareOffset);
        }

        public Position top() {
            return new Position(squareOffset, squareOffset + elementOffset);
        }

        public Position bottom() {
            return new Position(squareOffset + squareLength, squareOffset + squareLength - elementOffset);
        }

        public Position right() {
            return new Position(squareOffset + elementOffset, squareOffset + squareLength);
        }

    }
}
