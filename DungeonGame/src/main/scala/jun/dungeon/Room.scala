package jun.dungeon

import jun.dungeon.Direction._
import scala.util.Random
import scala.collection.mutable.Queue
import scala.collection.mutable.HashMap

case class Room(val id: Int, val name: String) {
  
  var gem: Int = 0
  private var _corridors: Vector[Option[Room]] = _
  private var corridorMap: Map[Direction, Room] = Map.empty
  
  def buildCorridor(dir: Direction, room: Room) {
    corridorMap += (dir -> room)
  }
  
  def buildCorridor(directions: Vector[Option[Room]]) {
    Direction.values.foreach(e => {
      directions(e.id) match {
        case Some(room) => corridorMap += (e -> room)
        case _ =>
      }
    })
  }
  
  def enterCorridor(dir: Direction): Option[Room] = {
    corridorMap get dir
  }
  
  def enterRandomCorridor(): Option[Room] = {
    corridorMap.size match {
      case 0 => None
      case size => Some(corridorMap.values.toArray.apply(Random.nextInt(size)))
    }
  }
  
  def getNextRoom(dest: Room): Option[Room] = {
    var visited: Map[Room, List[Room]] = Map(this -> List.empty)
    var queue = new Queue[Room]()
    queue.enqueue(this)
    while (!queue.isEmpty) {
      var current = queue.dequeue
      current.corridorMap.values
      .filterNot(e => visited.contains(e))
      .foreach(e => {
        visited += (e -> (visited(current) :+ e))
        e match {
          case `dest` => return visited(e).headOption
          case _ => queue.enqueue(e)
        }
      })
    }
    None
  }
  
  def getFarthestRoom(): Option[Room] = {
    var visited: Set[Room] = Set(this)
    var current: Room = this
    var queue = new Queue[Room]()
    queue.enqueue(this)
    while (!queue.isEmpty) {
      current = queue.dequeue
      current.corridorMap.values
      .filterNot(e => visited.contains(e))
      .foreach(e => {
        visited += (e)
        queue.enqueue(e)
      })
    }
    if (this == current) {
      return None;
    }
    Some(current)
  }
  
//  def nextRoom(dir: Direction): Option[Room] = {
//    corridors(dir.id)
//  }
//  
//  def corridors = {
//    if (_corridors == null) {
//      throw new RuntimeException("Room %d (name = %s) has no corridors defined!".format(id, name))
//    }
//    _corridors
//  }
//  
//  def corridors_=(directions: Vector[Option[Room]]) = {
//    if (directions.size != Direction.size) {
//      throw new RuntimeException("Room %d (name = %s) needs to have %d corridors defined!".format(id, name, Direction.size))
//    }
//    _corridors = directions
//  }
//  
}