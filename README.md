# Doobie Quick Start 

This is a template to help you get started playing with doobie (or to reproduce doobie bugs 🫣)

## Getting started

1. Clone this repository
1. Edit `build.sbt` to set the Scala/doobie version you're using
1. Run `docker-compose up -d --force-recreate` to start the DB container
1. `sbt run`

## Next steps

Once you have the example running

- Edit `docker_db_init/setup.sql` to change the set of your database schema and data. Don't forget to to run `docker-compose up -d --force-recreate` to make sure the database is recreated with your updated setup.sql!
- Edit the Scala code. The entry point of the application is `src/main/scala/example/Main.scala`

