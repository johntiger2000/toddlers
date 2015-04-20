package jun.dungeon

import org.scalatest._
import jun.dungeon.Direction._

class WorldSpec extends UnitSpec {
  
  "The world" should "move player into next room in the direction" in {
    var world = new World
    world.player.current = world.rooms(0)
    world.movePlayer(East)
    assert(world.player.current === world.rooms(1))
  }
  
  it should "move dragon into next room along the shortest path" in {
    var world = new World
    world.player.current = world.rooms(0)
    world.dragon.current = world.rooms(8)
    world.moveDragon()
    assert(world.dragon.current === world.rooms(3))
  }
  
  it should "have player gem increased when player hit dragon" in {
    var world = new World
    world.player.current = world.rooms(0)
    world.player.gem = 100
    world.dragon.current = world.rooms(1)
    world.movePlayer(East)
    assert(world.player.current === world.rooms(1))
    assert(world.player.gem === 101)
  }
  
  it should "have player lost all gem and re-inited when dragon hit player" in {
    var world = new World
    world.player.current = world.rooms(1)
    world.player.gem = 100
    world.dragon.current = world.rooms(0)
    world.moveDragon
    assert(world.player.gem === 0)
  }
  
}
