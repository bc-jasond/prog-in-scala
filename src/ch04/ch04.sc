val hi: String = "Hi"

def hi2: String = "Hi"

import ChecksumAccumulator

ChecksumAccumulator.calculate("Sandwiches don't come easy. Buddy.")

val acc = new ChecksumAccumulator
val csa = new ChecksumAccumulator

acc.add(105)
acc.add(b = 127)

acc.checksum()

def f(): Unit = "This gets lost"
f()

def g() { "Also gets lost" }
g()

def h() = { "Not I, I'm good" }
h


import ChecksumAccumulator.calculate

object Summer {
  def main(args: Array[String]): Unit = {
    for (arg <- args)
      println(arg +": "+ calculate(arg))
  }
}

