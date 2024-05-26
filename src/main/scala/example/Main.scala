package example

import cats.effect.{IO, IOApp}
import doobie.Transactor
import doobie.implicits.*

object Main extends IOApp.Simple {

  override def run: IO[Unit] = {
    val transactor: Transactor[IO] = Transactor.fromDriverManager[IO](
      driver = "org.postgresql.Driver", // driver classname
      url = "jdbc:postgresql:repro", // connect URL (driver-specific)
      user = "postgres", // user
      password = "postgres", // password
      logHandler = None
    )

    sql"SELECT name FROM person".query[String].to[List].transact(transactor).map { names =>
      println(names)
    }
  }

}
