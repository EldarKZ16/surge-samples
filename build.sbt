// Copyright © 2017-2021 UKG Inc. <https://www.ukg.com>

name := "surge-samples"

version := "0.1"

ThisBuild / scalaVersion := "2.13.5"

publish / skip := true

lazy val `surge-scala-sample` = (project in file("examples/scala"))
  .settings(libraryDependencies ++= Seq(Akka.http, akkaHttpPlayJson, surge), publish / skip := true)
  .enablePlugins(JavaServerAppPackaging)

