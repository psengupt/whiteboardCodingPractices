object repeatedNTimes {
  def main(A: Array[String]): Unit = {
    def func (i : Int): Boolean = (A(i)==A(i-1)) || A(i) == A(i-2)
    val objects : List[Int] = (2 to A.size).toList
    def res(objects : List[Int]) : Option[String]= objects match {
      case first :: _ if func(first) => Some(A(first))
      case _ :: rest => res (rest)
      case Nil => Option(A(0))
    }
    val result = res(objects)

    println( "The answer is : " + result.getOrElse("Did not find"))
  }
}