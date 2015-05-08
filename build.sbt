import scala.util.Try


name := "jetboot"

organization := "im.mange"

version := Try(sys.env("TRAVIS_BUILD_NUMBER")).map("0.0." + _).getOrElse("1.0-SNAPSHOT")

scalaVersion:= "2.11.6"

resolvers ++= Seq(
  "Sonatype OSS Releases" at "http://oss.sonatype.org/content/repositories/releases/"
)

//TODO: make this a dep that is needs version > x but doesnt bring in by default .. just need to cast the right sbt runes
//"provided" lookes like it might be it
//see: https://github.com/sbt/sbt-assembly
//and "run in Compile <<= Defaults.runTask(fullClasspath in Compile, mainClass in (Compile, run), runner in (Compile, run))"
//also, use with version ranges .. 1.0.+ or [1.0,2.0]
//see: https://www.safaribooksonline.com/library/view/scala-cookbook/9781449340292/ch18s06.html
libraryDependencies ++= Seq(
  "net.liftweb" %% "lift-webkit" % "2.6.1" % "provided",
  "im.mange" %% "little" % "0.0.7"
)

sonatypeSettings

publishTo <<= version { project_version ⇒
  val nexus = "https://oss.sonatype.org/"
  if (project_version.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

publishMavenStyle := true

publishArtifact in Test := false

homepage := Some(url("https://github.com/alltonp/jetboot"))

licenses +=("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0.html"))

credentials += Credentials("Sonatype Nexus Repository Manager", "oss.sonatype.org", System.getenv("SONATYPE_USER"), System.getenv("SONATYPE_PASSWORD"))

pomExtra :=
    <scm>
      <url>git@github.com:alltonp/jetboot.git</url>
      <connection>scm:git:git@github.com:alltonp/jetboot.git</connection>
    </scm>
    <developers>
      <developer>
        <id>alltonp</id>
      </developer>
    </developers>

