package o1.mathocalypse

abstract class Boss(val name: String, initiallLocation: Area, initialHP: Int, val target: Player) {
  var location = initiallLocation
  private var HP = initialHP

  def heal() =
    this.HP += 10

  def harm(points: Int) =
    if this.HP > points then
      this.HP -= points
    else
      this.HP = 0

  def hitPoints =
    this.HP

  def react(playerAction: Action): String
}
