/**
 * Created by jason.dubaniewicz on 4/21/15.
 */
import ChecksumAccumulator.calculate

object Summer {
  def main(args: Array[String]): Unit = {
    for (arg <- args)
      println(arg +": "+ calculate(arg))
  }
}
