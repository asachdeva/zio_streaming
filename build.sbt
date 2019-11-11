import Dependencies._

lazy val scalaCompilerOptions = Seq(
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
  "-Xfuture",
  "-Xlint"
)

lazy val root = (project in file("."))
  .settings(
    inThisBuild(
      List(
        organization := "io.citrine",
        scalaVersion := "2.12.10",
        version := "0.1.0-SNAPSHOT"
      )
    ),
    scalacOptions ++= scalaCompilerOptions,
    name := "UnitsConversionSerrvice",
    scalafmtOnCompile := true,
    libraryDependencies ++= Seq(
      compilerPlugin(Libraries.betterMonadicFor),
      Libraries.cats,
      Libraries.catsMeowMtl,
      Libraries.catsPar,
      Libraries.catsEffect,
      Libraries.circeCore,
      Libraries.circeGeneric,
      Libraries.circeGenericExt,
      Libraries.circeLiteral,
      Libraries.circeParser,
      Libraries.doobieCore,
      Libraries.doobieH2,
      Libraries.doobieHikari,
      Libraries.h2,
      Libraries.flyway,
      Libraries.fs2,
      Libraries.http4sDsl,
      Libraries.http4sServer,
      Libraries.http4sCirce,
      Libraries.http4sClient,
      Libraries.logback,
      Libraries.pureConfig,
      Libraries.zioCore,
      Libraries.zioCats,
      Libraries.catsEffectLaws % Test,
      Libraries.doobieTest     % Test,
      Libraries.scalaCheck     % Test,
      Libraries.scalaMock      % Test,
      Libraries.scalaTest      % Test
    )
  )
