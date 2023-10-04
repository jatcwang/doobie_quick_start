val doobieVersion = "<SET_THIS_DOOBIE_VERSION>"
// val doobieVersion = "1.0.0-RC4"

lazy val root = Project("root", file("."))
  .settings(commonSettings)
  .settings(
    name := "Doobie",
    libraryDependencies ++= Seq(
      "org.tpolecat" %% "doobie-core" % doobieVersion,
      "org.tpolecat" %% "doobie-postgres" % doobieVersion,
      "org.postgresql" % "postgresql" % "42.5.3",
    ),
  )

lazy val commonSettings = Seq(
  version := "0.1.0",
  scalaVersion := "<SET_THIS_SCALA_VERSION>",
//  scalaVersion := "3.3.1",
//  scalaVersion := "2.13.12",
  scalacOptions --= {
    if (sys.env.get("CI").isDefined) {
      Seq.empty
    } else {
      Seq("-Xfatal-warnings")
    }
  },
  scalacOptions ++= Seq("-Xsource:3"),
)
