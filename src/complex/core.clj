(ns complex.core
  (:import [org.apache.commons.math3.complex Complex]))

(defn complex-number
  "Takes one or two numbers and returns a complex number.
   If only one argument is supplied then the argument is the real part of the complex number.
   If two arguments are supplied, then the first is the real part and the second is the imaginary part.
   In each case, the arguments are cast to a double."
  ([^double a] (Complex. a))
  ([^double a ^double b] (Complex. a b)))

(defn add2c "Adds two complex numbers."
  [^org.apache.commons.math3.complex.Complex a ^org.apache.commons.math3.complex.Complex b]
  (.add a b))

(defn multiply2c  "Multiplies two complex numbers."
  [^org.apache.commons.math3.complex.Complex a ^org.apache.commons.math3.complex.Complex b]
  (.multiply a b))

(defn subtract2c  "Subtracts two complex numbers."
  [^org.apache.commons.math3.complex.Complex a ^org.apache.commons.math3.complex.Complex b]
  (.subtract a b))

(defn divide2c  "Divides two complex numbers."
  [^org.apache.commons.math3.complex.Complex a ^org.apache.commons.math3.complex.Complex b]
  (.divide a b))

(defn powc  "Raises the first argument to the power of the second, where both are complex numbers."
  [^org.apache.commons.math3.complex.Complex a ^org.apache.commons.math3.complex.Complex b]
  (.pow a b))

(defn convert-to-complex [a]
  (if (number? a)
    (complex-number a)
    a))

(defn +
  "Adds two numbers, which may or may not be complex and produces a complex result."
  ([] 0)
  ([a] (convert-to-complex a))
  ([a b]
     (let [ac (convert-to-complex a)
           bc (convert-to-complex b)]
       (add2c ac bc)))
  ([a b & more] (reduce + (+  a b) more)))


(defn *
  "Adds two numbers, which may or may not be complex and produces a complex result."
  ([] 0)
  ([a] (convert-to-complex a))
  ([a b]
     (let [ac (convert-to-complex a)
           bc (convert-to-complex b)]
       (multiply2c ac bc)))
  ([a b & more] (reduce * (*  a b) more)))

(defn -
  "Subtracts the first argument from the second, either of which may or may not be complex."
  ([a] (- 0 a))
  ([a b]
     (let [ac (convert-to-complex a)
           bc (convert-to-complex b)]
       (subtract2c ac bc)))
  ([a b & more] (reduce - (- a b) more)))

(defn /
  "Divides the first argument by the second, either of which may or may not be complex."
  ([a] (/ 1 a))
  ([a b]
     (let [ac (convert-to-complex a)
           bc (convert-to-complex b)]
       (divide2c ac bc)))
  ([a b & more] (reduce / (/ a b) more)))

(defn pow
  "Converts numbers to complex numbers and then raises the first to the power of the second."
  [a b]
   (let [ac (convert-to-complex a)
           bc (convert-to-complex b)]
       (pow ac bc)))

(defn reciprocal "Returns the reciprocal of a number as a complex number."
  [a]
  (.reciprocal (convert-to-complex a)))

(defn conjugate
  "Returns the complex conjugate of a complex number."
  [^org.apache.commons.math3.complex.Complex a]
  (.conjugate a))

(defn equals "True if two complex numbers are equal, and false otherwise."
  [^org.apache.commons.math3.complex.Complex a ^org.apache.commons.math3.complex.Complex b]
  (.equals a b))

(defn imaginary-part
  "Returns the imaginary part of a complex number."
  [^org.apache.commons.math3.complex.Complex a]
  (.getImaginary a))

(defn real-part
  "Returns the real part of a complex number."
  [^org.apache.commons.math3.complex.Complex a]
  (.getReal a))

(defn negate
  "Returns the negative of a complex number."
  [^org.apache.commons.math3.complex.Complex a]
  (.negate a))

(defn abs "Takes a complex number and returns its absolute value."
  [^org.apache.commons.math3.complex.Complex a]
  (.abs a))

(defn argument "Gives the angle in the polar form of a complex number."
  [^org.apache.commons.math3.complex.Complex a]
  (Math/atan (/ (imaginary-part a) (real-part a))))

(defn polar-form
  "Gives a complex number in polar form in a vector.
   The first element is the magnitude.
   The second element is the argument."
  [^org.apache.commons.math3.complex.Complex a]
  [(abs a) (argument a)])

(defn nth-root
  "Computes the nth root of the first argument, which should be a complex number.
   The second argument should be a number."
  [^org.apache.commons.math3.complex.Complex a ^double n]
  (.nthRoot a n))

(defn one-arg-number-handler
  "Takes a number that may be real or complex and dispatches it to suitable functions in each case."
  [a realf comf]
  (if (number? a)
    (realf a)
    (comf a)))


(defn sin
  "Computes the sine of the argument, whether or not it is complex."
  [a]
  (one-arg-number-handler a
                          (fn [^double x] (Math/sin x))
                          (fn [^org.apache.commons.math3.complex.Complex x] (.sin x))))

(defn cos
  "Computes the sine of the argument, whether or not it is complex."
  [a]
  (one-arg-number-handler a
                          (fn [^double x] (Math/cos x))
                          (fn [^org.apache.commons.math3.complex.Complex x] (.cos x))))

(defn tan
  "Computes the tangent of the argument, whether or not it is complex."
  [a]
  (one-arg-number-handler a
                          (fn [^double x] (Math/tan x))
                          (fn [^org.apache.commons.math3.complex.Complex x] (.tan x))))

(defn exp
  "Computes e^argument, whether or not it is complex."
  [a]
  (one-arg-number-handler a
                          (fn [^double x] (Math/exp x))
                          (fn [^org.apache.commons.math3.complex.Complex x] (.exp x))))

(defn log
  "Computes the log of the argument, whether or not it is complex."
  [a]
  (one-arg-number-handler a
                          (fn [^double x] (Math/log x))
                          (fn [^org.apache.commons.math3.complex.Complex x] (.log x))))

(defn sinh
  "Computes the sinh of the argument, whether or not it is complex."
  [a]
  (one-arg-number-handler a
                          (fn [^double x] (Math/sinh x))
                          (fn [^org.apache.commons.math3.complex.Complex x] (.sinh x))))

(defn cosh
  "Computes the sinh of the argument, whether or not it is complex."
  [a]
  (one-arg-number-handler a
                          (fn [^double x] (Math/cosh x))
                          (fn [^org.apache.commons.math3.complex.Complex x] (.cosh x))))

(defn sqrt
  "Computes the square root of the argument, whether or not it is complex."
  [a]
  (one-arg-number-handler a
                          (fn [^double x] (Math/sqrt x))
                          (fn [^org.apache.commons.math3.complex.Complex x] (.sqrt x))))

(defn tanh
  "Computes the tanh of the argument, whether or not it is complex."
  [a]
  (one-arg-number-handler a
                          (fn [^double x] (Math/tanh x))
                          (fn [^org.apache.commons.math3.complex.Complex x] (.tanh x))))

(defn sqrt1z
  "Computes the square root of (1-arg^2), whether or not the argument is complex."
  [a]
  (one-arg-number-handler a
                          (fn [^double x] (.sqrt1z (complex-number x)))
                          (fn [^org.apache.commons.math3.complex.Complex x] (.sqrt1z x))))


(defn stringify
  "Prints a complex number a+bi in the format (a,b).
   Converts other kinds of arguments to strings as usual."
  [a]
  (.toString a))
