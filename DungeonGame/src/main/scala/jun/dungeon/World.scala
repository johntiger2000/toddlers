package jun.dungeon

import jun.dungeon.Direction._
import scala.collection.mutable.Queue
import scala.util.Random

object World {
  
  var rooms = initWorld
  var player = initPlayer
  var dragon = initDragon
    
  def movePlayer(dir: Direction): Boolean = {
    player.current.enterCorridor(dir) match {
      case Some(room) => {
        if (room == dragon.current) {
          room.gem += dragon.gem
          dragon.current = room.enterRandomCorridor().get
        }
        player.current = room
        player.gem += room.gem
        room.gem = 0
        true
      }
      case _ => false
    }
  }
    
  def moveDragon(): Boolean = {
    dragon.current.getNextRoom(player.current) match {
      case Some(room) => {
        player.current match {
          case `room` => player = initPlayer; dragon = initDragon
          case _ => dragon.current = room
        }
        true
      }
      case _ => false
    }
  }
  
  def initWorld(): Vector[Room] = {
    var rooms = Vector(
        new Room(0, "Vermillion"),
        new Room(1, "Ochre"),
        new Room(2, "Chartreuse"),
        new Room(3, "Emerald"),
        new Room(4, "Cobalt"),
        new Room(5, "Aquamarine"),
        new Room(6, "Lavender"),
        new Room(7, "Violet"),
        new Room(8, "Burnt Sienna")
        )
    
    rooms(0).buildCorridor(Vector(None, Some(rooms(1)), Some(rooms(5)), None))
    rooms(1).buildCorridor(Vector(Some(rooms(0)), Some(rooms(2)), Some(rooms(1)), None))
    rooms(2).buildCorridor(Vector(Some(rooms(1)), None, Some(rooms(3)), None))
    rooms(3).buildCorridor(Vector(None, Some(rooms(6)), Some(rooms(5)), Some(rooms(4))))
    rooms(4).buildCorridor(Vector(Some(rooms(0)), None, Some(rooms(8)), Some(rooms(0))))
    rooms(5).buildCorridor(Vector(None, None, Some(rooms(7)), Some(rooms(4))))
    rooms(6).buildCorridor(Vector(None, Some(rooms(2)), None, Some(rooms(8))))
    rooms(7).buildCorridor(Vector(None, Some(rooms(8)), Some(rooms(8)), Some(rooms(2))))
    rooms(8).buildCorridor(Vector(Some(rooms(3)), Some(rooms(6)), None, None))
    
    rooms
  }
  
  def initPlayer(): Creature = {
    new Player(rooms(Random.nextInt(rooms.size)), 0)
  }
  
  def initDragon(): Creature = {
    if (player == null) {
      player = initPlayer
    }
    new Dragon(player.current.getFarthestRoom().get, 1)
  }

}

