def mapReduce(f: Double => Double, compose:(Double, Double)=>Double,
              zero: Double)(a: Double, b:Double) : Double = {
  if(a > b) zero
  else compose(f(a), mapReduce(f, compose, zero)(a+1, b))
}

mapReduce(x=>x, (x,y)=>x+y, 0)(1,5)

def sum(f: Double => Double) : (Double, Double) => Double =
  mapReduce(f, (x, y)=> x+y, 0)
def square_sum = sum(x => x*x)
square_sum(1, 3)

def product(f: Double => Double) = mapReduce(f, (x, y) => x*y, 1)(_,_)
def factorial(n : Double) = product(x=>x)(1, n)
factorial(2)
factorial(4)

def mapReduce2(f: Double => Double, compose:(Double, Double)=>Double,
              zero: Double) : (Double, Double) => Double = {
  def do_mapReduce(a: Double, b: Double): Double = {
    if (a > b) zero
    else compose(f(a), do_mapReduce(a + 1, b))
  }
  do_mapReduce
}

def square_sum2 = mapReduce2(x=>x*x, (x,y)=>x+y, 0)

square_sum2(1,2)

def product2(f: Double=>Double) = mapReduce2(f, (x,y)=>x*y, 1)

product2(x=>x)(1, 4)






"""

def sum(f: Double => Double) = mapReduce(f, (x, y)=> x+y, 0)
def square_sum = sum(x => x*x)

def product(f: Double => Double) = mapReduce(f, (x, y) => x*y, 1)

def factorial(n : Double) = product(x=>x)(1, n)
factorial(2)
square_sum(1, 2)
"""
"hello world"
