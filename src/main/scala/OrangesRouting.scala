/*
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
*/
object OrangesRouting {
  def orangeRotting(grid: Array[Array[Int]]):Int = {
    def rottingOrange(rotten: Set[String], real: Set[String]) : Int = {
      if(rotten.isEmpty){
        if(real.isEmpty)0
        else -1
      }
      else{
        var resRotten = Set[String]();
        var resReal = real diff rotten

        for(s <- rotten){
          //resReal -= s
          val i = s.split(" ")(0).toInt
          val j = s.split(" ")(1).toInt
          val up = (i-1) +" "+ (j)
          val down = (i+1) +" "+ (j)
          val left = (i) +" "+ (j-1)
          val right = (i) +" "+ (j+1)
          if(real.contains(up))resRotten += up
          if(real.contains(down))resRotten += down
          if(real.contains(left))resRotten += left
          if(real.contains(right))resRotten += right

        }
        val r = rottingOrange(resRotten, resReal)
        if(r== -1)r else r+1
      }
    }
    if(grid.isEmpty  || grid(0).isEmpty ) return 0
    var realOranges = Set[String]()
    var rottenOranges = Set[String]()
    for(i <- (0 to grid.length-1)){
      for (j <- (0 to grid(0).length-1)) {
        if(grid(i)(j) == 2) {
          rottenOranges += (i +" "+j)
          //realOranges += (i + " "+j)
        }
        else if(grid(i)(j) == 1) realOranges += (i +" "+j)
      }
    }
    rottingOrange(rottenOranges, realOranges)

  }

  def main(args: Array[String]): Unit = {
    val grid: Array[Array[Int]] = Array(Array(2,1,1),Array(0,1,1),Array(0,1,1))
    println(s"The result is : ${orangeRotting(grid)-1}");
  }
}
