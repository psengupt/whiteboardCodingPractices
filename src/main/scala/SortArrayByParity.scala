object SortArrayByParity {
  def main(args: Array[String]): Unit = {
    val A = args.map(_.toInt)
    val res = new Array[Int](A.length)
    var evenIndex = 0
    var oddIndex = args.length-1
    Array.tabulate(A.length){
      x =>
        if(A(x)%2 ==0){
          res(evenIndex) = A(x)
          evenIndex += 1
        } else {
          res(oddIndex) = A(x)
          oddIndex -= 1
        }
    }
    println(s"The result is: ${res.mkString(",")}")
  }

}
