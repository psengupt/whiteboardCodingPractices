object FlipAndInvertImage {
  def main(args: Array[String]): Unit = {
    val A: Array[Array[Int]] = Array(Array(1, 1, 0), Array(1,0,1), Array(0, 0, 0))
    def complacent(x : Int) : Int = if(x == 0)1 else 0
    for (a <- A){
      var i=0
      var j = a.length-1
      while (i <= j){
        val t = a(j)
        a(j) = a(i)
        a(i) = t
        i = i+1
        j = j-1
      }
    }
    val res = A.map(x => x.map(complacent(_)))
    println(s"the result is:\n${res.map(x => x.mkString("[", ",", "]")).mkString("\n")}")
  }

}
