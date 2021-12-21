// Copyright © 2017-2021 UKG Inc. <https://www.ukg.com>

name := "surge-samples"

version := "0.1"

ThisBuild / scalaVersion := "2.13.5"

publish / skip := true

lazy val `surge-scala-sample` = (project in file("examples/scala"))
  .settings(
    assembly / assemblyJarName := "surge-cmd-example-app.jar",
    assembly / mainClass := Some("com.example.boot"),
    libraryDependencies ++= Seq(Akka.http, Akka.spray, akkaHttpPlayJson, surge, gatling, gatlingFramework),
    publish / skip := true)
  .enablePlugins(JavaServerAppPackaging, AssemblySettings)

lazy val `surge-gatling-sample` = (project in file("examples/surge-gatling"))
  .settings(libraryDependencies ++= Seq(gatling, gatlingFramework), publish / skip := true)
  .enablePlugins(GatlingPlugin)

addCommandAlias("codeFormat", ";headerCreate;test:headerCreate;scalafmtAll;scalafmtSbt")
