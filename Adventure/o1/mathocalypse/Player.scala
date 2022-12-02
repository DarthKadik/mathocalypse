package o1.mathocalypse

import scala.collection.mutable.Map

/** A `Player` object represents a player character controlled by the real-life user
  * of the program.
  *
  * A player object’s state is mutable: the player’s location and possessions can change,
  * for instance.
  *
  * @param startingArea  the player’s initial location */
class Player(startingArea: Area):

  private var currentLocation = startingArea        // gatherer: changes in relation to the previous location
  private var quitCommandGiven = false              // one-way flag
  private var backpack = Map[String, Item](
    "beer" -> Item("beer", messages.beer),
    "notebook" -> Item("notebook", messages.notebook),
    "keys" -> Item("keys", messages.keys),
    "mug" -> Item("mug", messages.mug),
    "banana" -> Item("banana", messages.banana),
    "laptop" -> Item("laptop", messages.laptop),
    "bowling ball" -> Item("bowling ball", messages.bowlingBall)
  )

  private var HP = 70 // 0-100

  def heal() =
    this.HP += 10

  def harm(points: Int) =
    this.HP -= points

  def hitPoints =
    this.HP

  def get(itemName: String): String =
    if this.currentLocation.contains(itemName) then
      this.backpack(itemName) = this.currentLocation.removeItem(itemName).get
      f"You pick up the ${itemName}."
    else
      f"There is no ${itemName} here to pick up."

  def has(itemName: String) =
    this.backpack.keys.exists(_ == itemName)

  def drop(itemName: String): String =
    if this.has(itemName) then
      this.currentLocation.addItem(this.backpack(itemName))
      this.backpack -= itemName
      f"You drop the ${itemName}."
    else
      f"You don't have that!"

  def examine(itemName: String): String =
    if this.has(itemName) then
      f"You look closely at the ${itemName}.\n${this.backpack(itemName).description}"
    else
      "If you want to examine something, you need to pick it up first."

  def throwItem(itemName: String): String =
    if this.has(itemName) then
      this.currentLocation.addItem(this.backpack(itemName))
      this.backpack -= itemName
      f"You throw the ${itemName}."
    else
      f"You don't have that!"

  def inventory: String =
    if this.backpack.keys.isEmpty then
      "You have nothing in your backpack."
    else
      val items = this.backpack.keys.mkString("\n")
      f"You are carrying:\n$items"



  /** Determines if the player has indicated a desire to quit the game. */
  def hasQuit = this.quitCommandGiven

  /** Returns the player’s current location. */
  def location = this.currentLocation


  /** Attempts to move the player in the given direction. This is successful if there
    * is an exit from the player’s current location towards the direction name. Returns
    * a description of the result: "You go DIRECTION." or "You can't go DIRECTION." */
  def go(direction: String) =
    val destination = this.location.neighbor(direction)
    this.currentLocation = destination.getOrElse(this.currentLocation)
    if destination.isDefined then messages.transition(direction) else messages.cantGo(direction)


  /** Causes the player to rest for a short while (this has no substantial effect in game terms).
    * Returns a description of what happened. */
  def rest() =
    "You rest for a while. Better get a move on, though."


  /** Signals that the player wants to quit the game. Returns a description of what happened within
    * the game as a result (which is the empty string, in this case). */
  def quit() =
    this.quitCommandGiven = true
    ""

  /** Returns a brief description of the player’s state, for debugging purposes. */
  override def toString = "Now at: " + this.location.name

end Player

