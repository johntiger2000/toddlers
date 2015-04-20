package jun.dungeon

object Main {

  def main(args: Array[String]): Unit = {
    
    var world = new World
    println("World created.")
    var step = 0
    while (true) {
      step += 1
      step % 5 match {
        case 0 => {
            println("Dragon move")
            println("== invisible to player == dragon is %s".format(world.dragon toString))
            world.moveDragon
            println("You are %s".format(world.player toString))
            println("== invisible to player == dragon is %s".format(world.dragon toString))
        }
        case _ => {
            println("You are %s".format(world.player toString))
            println("== invisible to player == dragon is %s".format(world.dragon toString))
            print("Input next move: ")
            // TODO: verify valid direction input
            while (!world.movePlayer(Direction(readInt))) {
              print("Invalid move. Try again: ")
            }
            println("You are %s".format(world.player toString))
            println("== invisible to player == dragon is %s".format(world.dragon toString))
            if (world.player.gem >= 5) {
              println("YOU WIN!!!")
              return
            }
        }
      }
    }
    
  }

}