package jun.dungeon

import org.scalatest._
import jun.dungeon.Direction._

class WorldSpec extends UnitSpec {
  
  "The world" should "have 9 rooms" in {
    var world = World
    world.rooms should have size 9
  }
  
  it should "have dragon in farthest room" in {
    var world = World
    world.player.current = world.rooms(0)
    world.dragon = world.initDragon
    assert(world.dragon.current === world.rooms(6))
  }
  
  it should "move player into next room in the direction" in {
    var world = World
    world.player.current = world.rooms(0)
    world.movePlayer(East)
    assert(world.player.current === world.rooms(1))
  }
  
  it should "move dragon into next room along the shortest path" in {
    var world = World
    world.player.current = world.rooms(0)
    world.dragon.current = world.rooms(8)
    world.moveDragon()
    assert(world.dragon.current === world.rooms(3))
  }
  
  it should "have player gem increased when player hit dragon" in {
    var world = World
    world.player.current = world.rooms(0)
    world.player.gem = 100
    world.dragon.current = world.rooms(1)
    world.movePlayer(East)
    assert(world.player.current === world.rooms(1))
    world.player.gem should be (101)
  }
  
  it should "have player lost all gem and re-inited when dragon hit player" in {
    var world = World
    world.player.current = world.rooms(1)
    world.player.gem = 100
    world.dragon.current = world.rooms(0)
    world.moveDragon
    assert(world.player.gem === 0)
  }
  
}
