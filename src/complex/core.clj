(ns complex.core
  (:import [org.apache.commons.math3.complex Complex])
  (:refer-clojure :exclude [+ - * /]))

(defn complex
  "Takes one or two numbers and returns a complex number.
   If only one argument is supplied then the argument is the real part of the complex number and the imaginary part is zero.
   If two arguments are supplied, then the first is the real part and the second is the imaginary part."
  ([a] (if (number? a)
         (Complex. (double a))
         a))
  ([^double a ^double b] (Complex. a b)))

(defn add2c "Adds two complex numbers."
  [^Complex a ^Complex b]
  (.add a b))

(defn multiply2c "Multiplies two complex numbers."
  [^Complex a ^Complex b]
  (.multiply a b))

(defn subtract2c "Subtracts two complex numbers."
  [^Complex a ^Complex b]
  (.subtract a b))

(defn divide2c "Divides two complex numbers."
  [^Complex a ^Complex b]
  (.divide a b))

(defn powc "Raises the first argument to the power of the second, where both are complex numbers."
  [^Complex a ^Complex b]
  (.pow a b))

(defn +
  "Adds two numbers, which may or may not be complex and produces a complex result."
  ([] 0)
  ([a] (complex a))
  ([a b]
   (let [ac (complex a)
         bc (complex b)]
     (add2c ac bc)))
  ([a b & more] (reduce + (+ a b) more)))

(defn *
  "Adds two numbers, which may or may not be complex and produces a complex result."
  ([] 0)
  ([a] (complex a))
  ([a b]
   (let [ac (complex a)
         bc (complex b)]
     (multiply2c ac bc)))
  ([a b & more] (reduce * (* a b) more)))

(defn -
  "Subtracts the first argument from the second, either of which may or may not be complex and produces a complex result."
  ([a] (- 0 a))
  ([a b]
   (let [ac (complex a)
         bc (complex b)]
     (subtract2c ac bc)))
  ([a b & more] (reduce - (- a b) more)))

(defn /
  "Divides the first argument by the second, either of which may or may not be complex and produces a complex result."
  ([a] (/ 1 a))
  ([a b]
   (let [ac (complex a)
         bc (complex b)]
     (divide2c ac bc)))
  ([a b & more] (reduce / (/ a b) more)))

(defn pow
  "Converts numbers to complex numbers and then raises the first to the power of the second."
  [a b]
  (let [ac (complex a)
        bc (complex b)]
    (powc ac bc)))

(defn reciprocal "Returns the reciprocal of a number as a complex number."
  [a]
  (.reciprocal (complex a)))

(defn conjugate
  "Returns the complex conjugate of a complex number."
  [^Complex a]
  (.conjugate a))

(defn equals "Returns true if two complex numbers are equal, and false otherwise."
  ([^Complex a ^Complex b]
   (.equals a b))
  ([^Complex a ^Complex b ^double eps]
   (Complex/equals a b eps)))

(defn imaginary-part
  "Returns the imaginary part of a complex number."
  [^Complex a]
  (.getImaginary a))

(defn real-part
  "Returns the real part of a complex number."
  [^Complex a]
  (.getReal a))

(defn negate
  "Returns the negative of a complex number."
  [^Complex a]
  (.negate a))

(defn abs "Takes a complex number and returns its absolute value."
  [^Complex a]
  (.abs a))

(defn argument "Gives the angle in the polar form of a complex number."
  [^Complex a]
  (Math/atan (/ (imaginary-part a) (real-part a))))

(defn polar-form
  "Gives a complex number in polar form in a map."
  [^Complex a]
  {:magnitude (abs a) :argument (argument a)})

(defn nth-root
  "Computes the nth root of the first argument, which should be a complex number.
   The second argument should be a number."
  [^Complex a ^double n]
  (.nthRoot a n))

(defn sin
  "Computes the sine of the argument, which may or may not be complex, as a complex number."
  [a]
  (if (number? a)
    (.sin (complex a))
    ((fn [^Complex x] (.sin x)) a)))

(defn cos
  "Computes the cosine of the argument, which may or may not be complex, as a complex number."
  [a]
  (if (number? a)
    (.cos (complex a))
    ((fn [^Complex x] (.cos x)) a)))

(defn tan
  "Computes the tangent of the argument, which may or may not be complex, as a complex number."
  [a]
  (if (number? a)
    (.tan (complex a))
    ((fn [^Complex x] (.tan x)) a)))

(defn exp
  "Computes e^(the argument) where the argument may or may not be complex and returns a complex number."
  [a]
  (if (number? a)
    (.exp (complex a))
    ((fn [^Complex x] (.exp x)) a)))

(defn log
  "Computes the natural logarithm of the argument, which may or may not be complex, as a complex number."
  [a]
  (if (number? a)
    (.log (complex a))
    ((fn [^Complex x] (.log x)) a)))

(defn sinh
  "Computes the sinh of the argument, which may or may not be complex, as a complex number."
  [a]
  (if (number? a)
    (.sinh (complex a))
    ((fn [^Complex x] (.sinh x)) a)))

(defn cosh
  "Computes the cosh of the argument, which may or may not be complex, as a complex number."
  [a]
  (if (number? a)
    (.cosh (complex a))
    ((fn [^Complex x] (.cosh x)) a)))

(defn sqrt
  "Computes the square root of the argument, which may or may not be complex, as a complex number."
  [a]
  (if (number? a)
    (.sqrt (complex a))
    ((fn [^Complex x] (.sqrt x)) a)))

(defn tanh
  "Computes the tanh of the argument, which may or may not be complex, as a complex number."
  [a]
  (if (number? a)
    (.tanh (complex a))
    ((fn [^Complex x] (.tanh x)) a)))

(defn sqrt1z
  "Computes sqrt(1-argument^2) as a complex number, where the argument may or may not be complex."
  [a]
  (if (number? a)
    (.sqrt1z (complex a))
    ((fn [^Complex x] (.sqrt1z x)) a)))


(defn stringify
  "Prints a complex number a+bi in the format (a,b).
   Converts other kinds of arguments to strings as usual."
  [a]
  (.toString a))
