object DiStringMatch {
  def main(args: Array[String]): Unit = {
    val S = args(0)
    var ans = List[Int]()
    val index = (0 to S.length).toList
    def getIndex (s: String, indexes: List[Int]): Unit = {
      if(s.isEmpty) {
        ans = ans ++ indexes
      }
      else if (s(0) == 'D') {
        ans = ans ++ indexes.takeRight(1)
        getIndex(s.drop(1), indexes.dropRight(1))
      }
      else {
        ans = ans ++ indexes.take(1)
        getIndex(s.drop(1), indexes.drop(1))
      }
    }

    getIndex(S, index)
    println(s"the result is: ${ans.mkString(",")}")
  }

}
