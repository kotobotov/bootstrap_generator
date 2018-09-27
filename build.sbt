lazy val root = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    inThisBuild(List(
      organization := "ru.kotobotov",
      version      := "0.1.0",
      scalaVersion := "2.12.6"
    )),
    name := "bootstrap-generator",
    libraryDependencies ++= Seq(
      "org.scala-js"  %%% "scalajs-dom"    % "0.9.5",
      "org.scalatest" %%% "scalatest"      % "3.0.5"    % "test"
    ),
    scalaJSUseMainModuleInitializer := true
  )


// Automatically generate index-dev.html which uses *-fastopt.js
resourceGenerators in Compile += Def.task {
  val source = (resourceDirectory in Compile).value / "index.html"
  val target = (resourceManaged in Compile).value / "index-dev.html"

  val fullFileName = (artifactPath in (Compile, fullOptJS)).value.getName
  val fastFileName = (artifactPath in (Compile, fastOptJS)).value.getName

  IO.writeLines(target,
    IO.readLines(source).map {
      line => line.replace(fullFileName, fastFileName)
    }
  )

  Seq(target)
}.taskValue
