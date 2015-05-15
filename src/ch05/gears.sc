import math.abs

class Gear(teeth: Float) {
  private def degreesPerTooth: Float = 360 / teeth
  var left: Option[Gear] = None
  var right: Option[Gear] = None
  def getDegrees(numTeeth: Float) = degreesPerTooth * numTeeth
  def getTeeth(degrees: Float) = abs(degrees / degreesPerTooth)
}

class Spindle(val gears: List[Gear]) {
  var degrees: Float = 0
}

class GearSimulator(spindles: List[Spindle]) {
  private var currentTeeth: Float = 0
  private var direction = 1
  private var lastGear: Option[Gear] = None
  private var continue = true

  var result = new Array[Float](spindles.length)

  private def processGears(s: Spindle, toTheRight: Boolean = true) {
    s.gears.foreach { (gear: Gear) =>
      def comparisonGear = if (toTheRight) gear.left.get else gear.right.get
      def hasNextGear: Boolean = if (toTheRight) gear.right.nonEmpty else gear.left.nonEmpty

      if (s.degrees == 0 && comparisonGear == lastGear.get) {
        // spindle not spinning yet
        s.degrees = gear.getDegrees(currentTeeth) * direction
        direction = -direction
      }

      // only support one path
      if (hasNextGear && continue) {
        lastGear = Some(gear)
        currentTeeth = gear.getTeeth(s.degrees)
        continue = false
      }
    }
  }

  def run(degrees: Float, start: Int = 0) {
    result = new Array[Float](spindles.length)
    if (degrees == 0) {
      println("Enter a non-zero number of degrees")
    } else if (start < 0 || start > spindles.length - 1) {
      println("Enter a starting spindle between 0 and " + (spindles.length - 1))
    } else {
      direction = 1
      spindles(start).degrees = degrees

      // start at $start and get degrees rotated for all Spindles to the right
      for (i <- start to spindles.length - 1) {
        println(spindles(i).degrees)
        processGears(spindles(i))
        result.update(i, spindles(i).degrees)
      }

      // now get degrees rotated for all Spindles to the left
//      for (i <- start to 0 by -1) {
//        processGears(spindles(i), false)
//        result.update(i, spindles(i).degrees)
//      }
    }
  }

  def getResult = { result.toList.toString }
}

// define spindles, add gears
val s1 = new Spindle(List(new Gear(100)))
val s2 = new Spindle(List(new Gear(25), new Gear(50)))
val s3 = new Spindle(List(new Gear(150)))

// create doubly linked-list so simulation can start at any gear
// TODO: support more than one path
s1.gears.head.right = Option(s2.gears.head)
s2.gears.head.left = Option(s1.gears.head)
s2.gears(1).right = Option(s3.gears.head)
s3.gears.head.left = Option(s2.gears(1))

val gearSim = new GearSimulator(List(s1,s2,s3))

// test cases based on http://www.technologystudent.com/images5/gr7.gif
gearSim.run(-360, 0)
println(gearSim.getResult)
//gearSim.run(-480, 2)
//println(gearSim.getResult)
//gearSim.run(1440, 1)
//println(gearSim.getResult)
//gearSim.run(0, 1)
//println(gearSim.getResult)
//gearSim.run(1, 10)
//println(gearSim.getResult)
