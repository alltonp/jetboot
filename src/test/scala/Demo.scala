import im.mange.jetboot.R

object Demo extends App {
  println("Started")

  val rs = List(
    R(),
    R("x", "y", "z"),
//    R(List("x", "y", "z")),
    R(R("x"), R("y"), R("z")),
//    R(List(R("x"), R("y"), R("z"))),
    R(<b></b>, <b></b>, <b></b>),
    R(List(<b></b>, <b></b>, <b></b>))
  )

  rs.map(r => println(r.render))
  println("Finished")
}
