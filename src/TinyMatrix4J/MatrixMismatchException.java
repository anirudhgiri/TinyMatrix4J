package TinyMatrix4J;

/**
 *Exception that is thrown when a matrix operation is being attempted between two incompatible matrices
 */
public class MatrixMismatchException extends Exception{

    private static final long serialVersionUID = 1L;
    
    MatrixMismatchException(String s){
        super(s);
    }
}