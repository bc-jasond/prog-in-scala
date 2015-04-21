/**
 * Created by jason.dubaniewicz on 4/20/15.
 */

import scala.io.Source

if (args.length > 0) {
  for (line <- Source.fromFile(args(0)).getLines())
    println(line.length + " " + line)
}
else
  Console.err.println("Please enter a valid filename")
