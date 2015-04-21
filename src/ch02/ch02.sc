val x = 1 + 2

println(x)
val msg = "Hello, world!"
val msg2: java.lang.String = "Hello again, world!"
val msg3: String = "Hello thrice, world!"
def max(x: Int, y: Int): Int = {
  if (x > y) x
  else y
}
println(max(2,3))
def max2(x: Int, y: Int) = if (x > y) x else y
max(7,4)
def greet() = println("Hey buddy")

val args = List("Bob", "Jane", "Stewie", "Donaldina")

var i = 0
while (i < args.length) {
  if (i != 0)
    print(" ")
  print(args(i))
  i += 1
}
println()





