package TinyMatrix4J;

public class MatrixMismatchException extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    MatrixMismatchException(String s){
        super(s);
    }
}