package example

import cats.effect.{IO, IOApp}
import doobie.Transactor
import doobie.implicits.*

object Main extends IOApp.Simple {

  override def run: IO[Unit] = {
    val transactor: Transactor[IO] = Transactor.fromDriverManager[IO](
      "org.postgresql.Driver", // driver classname
      "jdbc:postgresql:repro", // connect URL (driver-specific)
      "postgres", // user
      "postgres", // password
    )

    sql"SELECT name FROM person".query[String].to[List].transact(transactor).map { names =>
      println(names)
    }
  }

}
