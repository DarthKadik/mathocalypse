package o1.mathocalypse

object messages:
  // general
  val welcome = "You are lying in your warm, comfortable bed. Suddenly, you hear a voice. It's your friend's, Gustav's voice:\n\"Come on! We have to go! The lecture starts in 15 minutes.\"\nYou rub your eyes and answer:\n\"Let me sleep! My headache is killing me!\"\nGustav laughs and says:\n\"All that milk you drank last night in Smökki, I am surprised you didn't throw up!\"\nYou hear him unwrapping something. You open your eyes and squint at him. \nHe raises the plastic bag he just unwrapped to his nose and sniffs in it deeply.\n\"Ah yes, this is good stuff\" - he smiles - \"A good sandwich always helps me with \nrough mornings.\"\nHe hands you one of the sandwiches from the bag.\nYou push his hands away and say:\n\"This is the most disgusting sandwich I've ever seen.\"\nHe pushes back on you and firmly adds:\n\"Just take it! I promise it'll make you feel better.\"\nYou reluctantly agree and take a bite. And another. And another. Before you know it, \nyou ate the whole thing.\nHe helps you up from the bed and says:\n\"See, I told you, you are not you when you are hungry.”\n\nYou feel a little better, get dressed, and make it to the lecture hall, but as you sit down in your chair, you feel the blood rushing through your veins as your heart starts\n pumping faster and faster, your vision blurs and your head hurts like it wants to \nexplode. You start shivering, but before you can finish your sentence:\n\"Why is it so cold in here?\"\nyou start sweating and the air becomes so hot that it burns your skin. \nYou stumble, but Gustav catches you. His face turns dark as he helps you sit down, he asks:\n\"Are you okay bro? What's wrong? I thought the sandwich helped.\"\nYou turn to him and angrily say:\n\"Helped? If anything it made things worse! It had that weird look and taste, I don't know where you got it, but you were scammed for sure, I think it was rotten or something.\"\n\nYou hear a rumbling sound from above. You look up just in time to see the burst of fire and explosion that opens a giant hole in the ceiling. A weird creature appears in the hole. It jumps through the opening and hits the floor just a few meters from you. As a sudden breeze starts blowing his cloak, it waves behind him, making sure that the scary giant \"i\" on it is clearly visible. \nYou don't know how, but you know who he is: it's Imaginary Iguana, the Keeper of the Imaginary Numbers. \n\nHe attacks you. In a shock, you scan the room for something useful to defend yourself with. Your eyes settle on your backpack. You wonder:\n\"Could there be something useful in it?\""
  val quit = "Quitter!"
  val complete = "The game is completed!"
  val died = "Meghaltál"
  def transition(direction: String) = f"Transition ${direction}"
  def cantGo(direction: String) = "Cant go"

  // place entry messages
  val undergradCenter = "UGC"
  val CSBuilding = "CS building"
  val alepa = "Ah, yes, Alepa. You know this place as the back of your hand. Shelfs full of the finest goods known to mankind, fast and convenient self-checkout, and your favourite pastries, just a few things Alepa has to offer."
  val BYHouse = "BY"

  // item descriptions
  val beer = "A can of rainbow beer. Kind of warm."
  val notebook = "A notebook with all the notes of your math class."
  val keys = "The keys for your apartment and bike."
  val mug = "Your favourite mug. You always use this to drink a tea."
  val banana = "A nice healthy banana."
  val laptop = "Your laptop. You use it to study."
  val bowlingBall = "Your lucky bowling ball. Wherever you go, you always carry it with yourself."

  // boss messages

  // iguana
  def iguanaMiss(item: String) = f"\nYou throw the ${item} at Imaginary Iguana, but it misses. He laughs and continue coming at you."
  def iguanaHarm(item: String) = f"\nThe ${item} hits Imaginary Iguana. It hurts him, he straggers, but after a while, he starts moving towards you again."
  def iguanaKill(item: String) = f"\nYou throw the ${item} at Imaginary Iguana. It hits him! He falls to the ground, and with his last breath says:\n\"You defeated me, but Captain Big-O and the League of Evil Mathematical Concepts are coming for you!\""
  val iguanaFollow = "\nThe Imaginary Iguana quickly follows you."
  val iguanaHit = "Aw! The Imaginary Iguana keeps hitting you."