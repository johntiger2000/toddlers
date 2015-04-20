package jun.dungeon

import jun.dungeon.Direction._

class Creature (var current: Room, var gem: Int) {
  
  override def toString(): String = {
    "currently in %s Room, id = %d. Having %d gems".format(current.name, current.id, gem)
  }
}