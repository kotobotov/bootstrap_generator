import org.scalajs.dom._
import scala.util.Random._
import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}
@JSExportTopLevel("MainApp")
object MainApp extends {

  @JSExport
  def main(): Unit = {
    println("Starting 'bootstrap-generator'...")

    val p = document.createElement("p")
    val text = document.createTextNode("Hello!")
    p.appendChild(text)
    document.body.appendChild(p)
  }

  @JSExport
  def random(div: html.Div):Unit ={
    div.style.setProperty("--base", s"#${nextInt(256).toHexString}${nextInt(256).toHexString}${nextInt(256).toHexString}")
  }

}
