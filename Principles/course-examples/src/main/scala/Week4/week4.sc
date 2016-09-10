
abstract class Nat {
  def isZero : Boolean
  def predecessor : Nat
  def successor : Nat = Succ(this)
  def +(that : Nat) : Nat
  def -(that : Nat) : Nat
}

object Zero extends Nat{
  def isZero : Boolean = true
  def predecessor = throw new Error("0.predecessor")
  def +(that : Nat) : Nat = that
  def -(that: Nat) : Nat = if (that.zero) this else throw new Error("0.-")
}

class Succ(n : Nat) extends Nat {
  def isZero : Boolean = false
  def predecessor : Nat = n
  def +(that : Nat) : Nat = new Succ(n+that)
  def -(that : Nat) : Nat =
    if (that.isZero) this
    else new Succ(predecessor - that.predecessor)
}

object List {
  def apply[T](x1 : T, x2 : T) :  List[T] = new Cons(x1, new Cons(x2, new Nil))
  def apply[T]() : List[T] = new Nil
}
