name := "trivial-web"

version := "1.0"

lazy val `trivial-web` = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq( javaJdbc ,
                              javaEbean ,
                              cache ,
                              javaWs,
                              "net.vz.mongodb.jackson" % "play-mongo-jackson-mapper_2.10" % "1.1.0",
                              "org.mongodb" % "mongo-java-driver" % "2.13.0",
                              "com.google.code.gson" % "gson" % "2.3.1")

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

fork in run := false