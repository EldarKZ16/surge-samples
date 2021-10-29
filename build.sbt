// Copyright © 2017-2021 UKG Inc. <https://www.ukg.com>

name := "surge-samples"

version := "0.1"

ThisBuild / scalaVersion := "2.13.5"

publish / skip := true

lazy val `surge-scala-sample` = (project in file("examples/scala"))
  .settings(libraryDependencies ++= Seq(Akka.http, Akka.spray, akkaHttpPlayJson, surge, gatling, gatlingFramework), publish / skip := true)
  .enablePlugins(JavaServerAppPackaging)

lazy val `surge-gatling-sample` = (project in file("examples/surge-gatling"))
  .settings(libraryDependencies ++= Seq(gatling, gatlingFramework), publish / skip := true)
  .enablePlugins(GatlingPlugin)

lazy val kafka = (project in file("kafka"))
  .settings(
    libraryDependencies ++= Seq(
      "ch.qos.logback" % "logback-classic" % logbackVersion,
      "org.slf4j" % "log4j-over-slf4j" % "1.7.26",
      "io.github.embeddedkafka" %% "embedded-kafka" % embeddedKafkaVersion),
    cancelable := false)
