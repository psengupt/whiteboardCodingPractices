object SortedArray {
  def main(args: Array[String]): Unit = {
    val num = args.map(_.toInt)
    var posIndex = 0
    while (posIndex < num.length && num(posIndex)<0) posIndex = posIndex + 1
    var negIndex = posIndex - 1

    val res = Array.tabulate(num.length){
      _ =>
        if(negIndex <0 || posIndex < num.length && num(posIndex)< -num(negIndex)){
          val res = num(posIndex) * num(posIndex)
          posIndex += 1
          res
        } else {
          val res = num(negIndex)*num(negIndex)
          negIndex -= 1
          res
        }
    }
    println(s"the answer is: ${res.mkString(",")}")
  }

}
