import Dependencies._

lazy val myScalacOptions = Seq(
  "-deprecation",
  "-encoding",
  "UTF-8",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-unchecked",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ypartial-unification",
  "-Xfuture",
  "-Xlint"
)

lazy val commonSettings = Seq(
  parallelExecution in Test := false,
  scalacOptions ++= myScalacOptions,
  organization := "com.cataratapacifica",
  testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework"),
  addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.8"),
  exportJars := true,
  updateOptions := updateOptions.value.withCachedResolution(true),
  libraryDependencies ++= Seq(
    Libraries.zioInteropCats,
    Libraries.zioCore,
    Libraries.zioTest,
    Libraries.zioTestSbt
  )
)

lazy val `streams` = (project in file ("streams"))
  .settings(commonSettings: _*)
  .settings(libraryDependencies ++= Seq(
    Libraries.http4sServer,
    Libraries.http4sClient,
    Libraries.http4sDsl,
    Libraries.catsEffect,
    Libraries.scalaXml,
    Libraries.zioKafka,
    Libraries.zioStreams
  )
)

