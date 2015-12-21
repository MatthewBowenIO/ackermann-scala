import scala.collection.mutable.ListBuffer

/**
  * Created by matthewbowen on 12/20/15.
  */
object Main {
  def main(args: Array[String]): Unit = {
    var funcStart = java.lang.System.currentTimeMillis()
    var ackVals = acks()
    var funcStop = java.lang.System.currentTimeMillis()

    System.out.println(funcStop - funcStart)
    ackVals.par.foreach {case (x: Int) => System.out.println(x)}
  }

  def ack(x: Int, y: Int): Int = {
    if(x == 0)
      return y + 1
    else if (y == 0)
      return ack(x - 1, 1)
    else
      return ack(x - 1, ack(x, y - 1))
  }

  def acks(): ListBuffer[Int] = {
    var input = Array(1, 2 ,3)
    var ackReturn = ListBuffer[Int]()
    input.par.foreach {case (x: Int) =>
      ackReturn += ack(x, x + 1)
    }

    return ackReturn
  }
}
