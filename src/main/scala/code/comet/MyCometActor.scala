package code
package comet

import net.liftweb.http.CometActor
import net.liftweb.common.Logger
import net.liftweb.http.js.JE.Call

class MyCometActor extends CometActor with Logger {

  override def lowPriority = {
    case s: String => partialUpdate(Call("alert", s).cmd)
  }

  def render = Call("alert", ".").cmd
}
