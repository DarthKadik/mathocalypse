package o1.mathocalypse
import scala.collection.immutable.Vector
import scala.collection.mutable.Buffer

// TODO Choose between sima and text ui

/** The class `Adventure` represents text adventure games. An adventure consists of a player and
  * a number of areas that make up the game world. It provides methods for playing the game one
  * turn at a time and for checking the state of the game.
  *
  * N.B. This version of the class has a lot of “hard-coded” information that pertains to a very
  * specific adventure game that involves a small trip through a twisted forest. All newly created
  * instances of class `Adventure` are identical to each other. To create other kinds of adventure
  * games, you will need to modify or replace the source code of this class. */
class Adventure:

  /** the name of the game */
  val title = "Mathocalypse"
  val possibleActions = Vector[String]("go","rest","get","drop","examine","throw","quit")

  // e.g.: "You are somewhere in the forest. A tangle of bushes blocks further passage north.\nBirds are singing."
  private val undergradCenter = Area("Undergraduate Center", messages.undergradCenter)
  private val CSBuilding = Area("CS Building", messages.CSBuilding)
  private val alepa = Area("Alepa", messages.alepa)
  private val BYHouse = Area("BY House", messages.BYHouse)

  undergradCenter.setNeighbors(Vector("north" -> BYHouse, "south" -> alepa, "west" -> CSBuilding))
  CSBuilding.setNeighbors(Vector("east" -> undergradCenter))
  alepa.setNeighbors(Vector("north" -> undergradCenter))
  BYHouse.setNeighbors(Vector("south" -> undergradCenter))

  /** The character that the player controls in the game. */
  val player = Player(undergradCenter)

  /** Bosses */
  val iguana = ImaginaryIguana("Imaginary Iguana",player.location, 100, this.player)

  /** Summoning bosses */
  var aliveBosses = Buffer[Boss]()
  var deadBosses = Buffer[Boss]()
  def summonBosses() =
    /** If a certain condition is met, summon bosses */
    if player.location == undergradCenter && !aliveBosses.contains(iguana) && !deadBosses.contains(iguana) then
      this.aliveBosses = this.aliveBosses :+ iguana

    /** delete dead bosses */
    this.aliveBosses.filter(_.hitPoints > 0)

  /** The number of turns that have passed since the start of the game. */
  var turnCount = 0


  /** Determines if the adventure is complete, that is, if the player has won. */
  // TODO
  def isComplete = false

  /** Determines whether the player has won, lost, or quit, thereby ending the game. */
  def isOver =
    player.hitPoints <= 0

  /** Returns a message that is to be displayed to the player at the beginning of the game. */
  def welcomeMessage = messages.welcome



  /** Returns a message that is to be displayed to the player at the end of the game. The message
    * will be different depending on whether or not the player has completed their quest. */
  def goodbyeMessage =
    if this.isComplete then
      messages.complete
    else if this.isOver then
      messages.died
    else  // game over due to player quitting
      messages.quit


  /** Plays a turn by executing the given in-game command, such as “go west”. Returns a textual
    * report of what happened, or an error message if the command was unknown. In the latter
    * case, no turns elapse. */
  def playTurn(command: String) =
    this.summonBosses()

    val action = Action(command)
    val outcomeReport = action.execute(this.player)
    val bossReactions = this.aliveBosses.map(_.react(action))
    if outcomeReport.isDefined then
      this.turnCount += 1

    println(this.aliveBosses.length)
    outcomeReport.getOrElse(s"Unknown command: \"$command\".") + "\n\n" + bossReactions.mkString("\n")

end Adventure