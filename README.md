# complex

A Clojure library for doing calculations with complex numbers. Wraps the Java commons-math3 Complex library.

## Usage

A complex number can be created by invoking the complex number function. With one argument the function produces a complex number in which only the real component is non-zero. With two arguments, the first argument is the real part, the second argument is the imaginary part:

=> (complex-number 1)

Complex (1.0, 0.0)

=> (complex-number 1 2)

Complex (1.0, 2.0).

The library can be used to do complex arithmetic. The + function can have any number of real or complex arguments but always produces a complex result.

=> (+ 1 (complex-number 3 4))

Complex (4.0, 4.0).

The same is true of the other arithmetical operations *,-,/. The arithmetical functions are fastest on a per number basis when used on only two arguments at a time. They are also faster when their arguments are complex.

The library also provides other functions, such as (pow a b), which raises a to the power b, (sin a) which calculates the sine of a, and several other functions. For details, see the docs.

## License

Copyright © 2015 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
