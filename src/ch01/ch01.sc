import java.math.BigInteger
import akka.actor.Actor

import scala.collection.immutable.TreeMap

var capital = Map("US" -> "Washington", "France" -> "Paris")
capital += ("Japan" -> "Tokyo")
println(capital("France"))


// scala
def factorial(x: BigInt): BigInt =
  if (x == 0) 1 else x * factorial(x - 1)

// java
def factorial2(x: BigInteger): BigInteger =
  if (x == BigInteger.ZERO)
    BigInteger.ONE
  else
    x.multiply(factorial2(x.subtract(BigInteger.ONE)))



println(factorial(130))
println(factorial2(new BigInteger("1300")))


