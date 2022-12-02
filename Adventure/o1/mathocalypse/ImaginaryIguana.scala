package o1.mathocalypse
import scala.util.Random

class ImaginaryIguana(name: String, initiallLocation: Area, initialHP: Int, target: Player) extends Boss(name, initiallLocation, initialHP, target){
  def react(playerAction: Action): String =
    var message = messages.iguanaHit
    this.target.harm(10)

    if playerAction.verb == "throw" then
        if Random.nextInt(10) < 6 then
          this.harm(50)
          if this.hitPoints == 0 then
            message += messages.iguanaKill(playerAction.modifiers)
          else
            message += messages.iguanaHarm(playerAction.modifiers)
        else
          message += messages.iguanaMiss(playerAction.modifiers)
    else if playerAction.verb == "go" then
      this.location = this.target.location
      message += messages.iguanaFollow
    else
      message += f"${name}: Laughs hysterically."

    message
}
