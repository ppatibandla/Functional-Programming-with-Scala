object rationals{
  val x = new Rational(1,2)
  x.numer
  x.denom
  x.numer + x.denom


}

"hello world"
val x = 3
x
val y = x+1
val z = new Rational(1, 2)
z.denom
z.numer

val a = z + new Rational(2, 3)
a - new Rational(2, 3)

-z
a.max(z)

val v1 = z+z
val v2 = a+a
val negv = -v2

val v3 = v1 - v2

(z + z) - (a + a)


//val strange = new Rational(1, 0)
//strange.add(strange)

val integer = new Rational(2)

class Rational(x: Int, y: Int){
  require(y > 0, "denominator must be positive" )
  // Used to enforce pre condition
  // assert(y >0 , "must be positive") // used to verify evaluation.

  def this(x : Int) = this(x, 1)
  // Implicit constructor exexutes class body
  def gcd(x: Int, y: Int): Int =
    if (y == 0) x else gcd(y, x%y)
  private val g = gcd(x, y)
  val numer = if (g < 0) -x / g else x / g
  val denom = if (g < 0) -y / g else y / g // Computed once
  // def numer = x /g // computed every time numer is used
  def < (that : Rational) : Boolean =
    numer * that.denom < that.numer * denom

  def max(that : Rational): Rational =
    if (this < that) that else this

  def +(that: Rational) =
    new Rational(numer  *  that.denom + that.numer * denom,
      denom * that.denom)
  def -(that : Rational) = this + -that

  override def toString = numer + "/" + denom

  def unary_- = new Rational(-numer, denom)
}