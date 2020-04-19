package TinyMatrix4J;

class Matrix{
    int rows; //number of matrix rows
    int cols; //number of matrix of columns
    float matrix[][]; //2D array containing the matrix's values
    
    /**
     * Constructor to initiaize the Matrix object with the size of the matrix as it's parameters
     * @param rows Number of rows in the matrix
     * @param cols Number of colums in the matrix
     */
    Matrix(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        this.matrix = new float[rows][cols];
        for(int i = 0; i < this.rows; i++) 
            for(int j=0; j < this.cols; j++)
                matrix[i][j] = 0;
    }

    /**
     * Fills all elements of the matrix with random numbers between 0 and 1
     */
    void randomize(){
        for(int i = 0; i<this.rows; i++)
            for(int j=0; j<this.cols; j++)
                this.matrix[i][j] = (float)(Math.random());

    }

    /**
     * Fills all elements of the matrix with random numbers between a and b
     * @param a lower bound (inclusive)
     * @param b upper bound (exclusive)
     */
    void randomize(int a , int b){
        for(int i = 0; i<this.rows; i++)
            for(int j = 0; j<this.cols; j++)
                this.matrix[i][j] = (float)(a + ((b-a)*Math.random()));
    }

    /**
     * Multiplies all elements of the matrix with a scalar
     * @param n The scalar value (integer)
     */
    void multiply(int n){
        for(int i=0; i<this.rows; i++)
            for(int j=0; j<this.cols; j++)
                this.matrix[i][j] *= n;
    }

    /**
     * Multiplies all elements of the matrix with a scalar
     * @param n The scalar value (float)
     */
    void multiply(float n){
        for(int i=0; i<this.rows; i++)
            for(int j=0; j<this.cols; j++)
                this.matrix[i][j] *= n;
    }

    /**
     * static matrix multiplication between two matrices m1 and m2
     * @param m1 Multiplicand Matrix
     * @param m2 Multiplier Matrix
     * @return The Product Matrix
     * @throws MatrixMismatchException If the columns of the multiplicand does not equal the rows of the multiplier
     */
    static Matrix multiply(Matrix m1, Matrix m2) throws MatrixMismatchException{
            if(m1.cols != m2.rows)
                throw new MatrixMismatchException("The matrices cannot be multiplied with each other as the number of rows of the first matrix does not equal the number of columns of the second matrix");
            Matrix result = new Matrix(m1.rows, m2.cols);

            for(int i =0; i < result.rows; i++)
                for(int j=0; j < result.cols; j++){
                    float sum = 0;
                    for(int k = 0; k < m1.cols; k++)
                        sum += m1.matrix[i][k] * m2.matrix[k][j];
                    result.matrix[i][j] = sum;
                }
        return result;
    }

    /**
     * performs hadamard multiplication with matrix m
     * @param m Multiplier Matrix
     */
    void hadamard(Matrix m){
        for(int i=0; i<m.rows; i++)
            for(int j=0; j<m.cols; j++)
                this.matrix[i][j] *= m.matrix[i][j];
    }

    /**
     * performs scalar matrix addition
     * @param n Addend scalar
     */
    void add(int n){
        for(int i=0; i<this.rows; i++)
            for(int j=0; j<this.cols; j++)
                this.matrix[i][j] += n;
    }

    /**
     * Performs matrix addition
     * @param m The addend matrix
     * @throws MatrixMismatchException If the addend and the augend matrices do not have the same size
     */
    void add(Matrix m)throws MatrixMismatchException{
        if(this.rows != m.rows || this.cols != m.cols){
            throw new MatrixMismatchException("Cannot perform addition. The size of the two matrices do not match each other")
        }
        
        for(int i=0;i<this.rows;i++)
            for(int j=0; j<this.cols; j++)
                this.matrix[i][j] += m.matrix[i][j];
    }

    /**
     * Performs matrix subtraction
     * @param m1 The minuend matrix
     * @param m2 The subtrahend matrix
     * @return The difference matrix
     */
    static Matrix subtract(Matrix m1, Matrix m2){
        if(m1.rows != m2.rows || m1.cols != m2.cols)
            System.out.println(m1.rows+" "+m1.cols+"\n"+m2.rows+" "+m2.cols);
        
        Matrix result = new Matrix(m2.rows, m2.cols);

        for(int i = 0; i<m2.rows; i++)
            for(int j = 0; j<m2.cols; j++)
                result.matrix[i][j] = m1.matrix[i][j] - m2.matrix[i][j];
        
        return result;   
    }

    /**
     * Performs matrix subtraction with the current matrix
     * @param m The subtrahend matrix
     * @return The difference matrix
     */
    Matrix subtract(Matrix m){
        if(m.rows != this.rows || m.cols != this.cols)
            System.out.println(m.rows+" "+m.cols+"\n"+this.rows+" "+this.cols);
        
        Matrix result = new Matrix(m.rows, m.cols);

        for(int i = 0; i<m.rows; i++)
            for(int j = 0; j<m.cols; j++)
                result.matrix[i][j] = m.matrix[i][j] - this.matrix[i][j];
        
        return result;   
    }

    /**
     * Static function to transpose the given matrix
     * @param m The matrix to transpose
     * @return The transposed matrix
     */
    static Matrix transpose(Matrix m){
        Matrix transposedMatrix = new Matrix(m.cols, m.rows);
        for(int i = 0; i<m.rows; i++)
            for(int j = 0; j<m.cols; j++)
                transposedMatrix.matrix[j][i] = m.matrix[i][j];
        return transposedMatrix;
    }
    
    /**
     * Prints the matrix to the console
     */
    void print(){
            for(int i=0;i<this.rows;i++){
                for(int j=0; j<this.cols; j++)
                    System.out.print(this.matrix[i][j] + " ");
                System.out.println("\n");
                }
    }

    /**
     * Creates a Matrix object from a 1D array
     * @param array The float array to be converted into a matrix
     * @return The matrix filled with the contents of the array
     */
    static Matrix fromArray(float[] array){
        Matrix m = new Matrix(array.length,1);
        for(int i = 0; i < array.length; i++)
            m.matrix[i][0] = array[i];
        return m;
    }

    /**
     * Creates a Matrix object from a 2D array
     * @param array The float array to be converted into a matrix
     * @return The matrix filled with the contents of the array
     */
    static Matrix fromArray(float[][] array){
        Matrix m = new Matrix(array.length,array[0].length);
        m.matrix = array;
        return m;
    }

    /**
     * Returns a 2D array from a Matrix object
     * @param m The matrix to be converted into an array
     * @return The array converted from a matrix
     */
    static float[][] toArray(Matrix m){
        float[][] arr = new float[m.rows][m.cols];
        for(int i = 0; i< m.rows; i++)
            for(int j = 0; j< m.cols; j++)
                arr[i][j] = m.matrix[i][j];
        return arr;
    }

}