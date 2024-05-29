//val doobieVersion = "<SET_THIS_DOOBIE_VERSION>"
//val doobieVersion = "1.0.0-RC5"
//val doobieVersion = "1.0-<COMMIT_SHORT_HASH>-SNAPSHOT"

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
  // scalaVersion := "<SET_THIS_SCALA_VERSION>",
  // scalaVersion := "3.4.2",
  // scalaVersion := "2.13.14",
  scalacOptions --= {
    if (sys.env.get("CI").isDefined) {
      Seq.empty
    } else {
      Seq("-Xfatal-warnings")
    }
  },
  scalacOptions ++= Seq("-Xsource:3"),
  resolvers ++= Resolver.sonatypeOssRepos("snapshots"),
)
