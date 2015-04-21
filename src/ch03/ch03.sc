import java.math.BigInteger

import scala.collection.mutable
import scala.collection.parallel.immutable

val big = new BigInteger("12345")

val greetStrings: Array[String] = new Array[String](3)
greetStrings(0) = "Hello"
greetStrings(1) = ", "
greetStrings(2) = "world!\n"
//for (i <- (0).to(2))
for (i <- 0 to 2)
  print(greetStrings(i))


//Console.println(10)
Console println 10


//val numNames = Array.apply("one", "two", "three")
val numNames = Array("one", "two", "three")
val anyNames = Array("one", 2, true)


val oneTwoThree = List(1,2,3)
val oneTwo = List(1,2)
val threeFour = List(3,4)
val one234 = oneTwo ::: threeFour
val newOne2 = 1 :: threeFour
val one2three4 = 1L :: 2L :: 3000000000L :: Nil

one234(2)
one2three4.count(_ > 2L)
one234.init
one234 map(_ + 12)

val pair = (99, "luftballons")
pair._1
pair.swap
pair._2

var jetSet = Set("Boeing", "Airbus")
jetSet += "Lear"
jetSet.contains("Cessna")
jetSet


import scala.collection.mutable.Set
val movieSet = Set("Hitch", "Poltergeist")
movieSet += "Shrek"
println(movieSet)

import scala.collection.mutable.HashSet
val hashSet = HashSet("Tomatoes", "Chilies")
println(hashSet + "Coriander")


import scala.collection.mutable.Map
val treasureMap = Map[Int, String]()
treasureMap += (1 -> "Go to island.")
treasureMap += (2 -> "Find big X on ground.")
treasureMap += (3 -> "Dig.")
println(treasureMap(2))

val tMap2 = scala.collection.immutable.Map(1 -> "Go to island.", 2 -> "Find big X on ground.", 3 -> "Dig.")
println(tMap2(1))


val args = Array("Hey", "Boss", "You", "Owe", "Me")

def printArgs(args: Array[String]): Unit = {
  var i = 0
  while (i < args.length) {
    println(args(i))
    i += 1
  }
}
printArgs(args)

def printArgs2(args: Array[String]): Unit = {
  for (arg <- args)
    println(arg)
}
printArgs2(args)


def printArgs3(args: Array[String]): Unit = {
  args.foreach(println)
}
printArgs3(args)

def fmtArgs(args: Array[String]) = args.mkString("\n")
println(fmtArgs(args))

val res = fmtArgs(Array("zero", "one", "two"))
assert(res == "zero\none\ntwo")
