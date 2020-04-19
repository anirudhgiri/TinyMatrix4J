![TinyMatrix4J](https://i.imgur.com/oTqeexG.png)
# TinyMatrix4J
➕ A Lightweight Java Library To Handle Matrices ➗

## Usage

```java
Matrix m1 = new Matrix(3,3); //create a 3x3 matrix
Matrix m2 = new Matrix(3,3); //create another 3x3 matrix

m1.randomize(); //fill all slots in m1 with random numbers between 0 and 1
m2.randomize(1,10); //fill all slots in m2 with random numbers between 1 and 10

m3 = Matrix.multiply(m1,m2); //matrix multiply m1 and m2

m3.add(m1); //add the matrices m3 and m1

m3.substract(2); //subtract all elements in m3 by the scalar value '2'

m3.print(); //print the matrix m3 to the console
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License
[MIT](https://choosealicense.com/licenses/mit/)
