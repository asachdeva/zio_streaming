import sbt._

object Dependencies {

  object Versions {
    val cats                = "2.0.0"
    val catsMeowMtl         = "0.2.0"
    val catsPar             = "0.2.1"
    val catsEffect          = "2.0.0"
    val circe               = "0.12.2"
    val doobie              = "0.7.1"
    val flyway              = "6.0.8"
    val fs2                 = "2.1.0"
    val h2                  = "1.4.200"
    val http4s                = "0.20.13"
    val pureConfig          = "0.12.1"
    val zio                 = "1.0.0-RC16"
    val zioCats             = "2.0.0.0-RC7"

    val betterMonadicFor    = "0.3.0"

    val logback             = "1.2.3"
    val scalaCheck          = "1.14.2"
    val scalaMock           = "4.4.0"
    val scalaTest           = "3.0.8"
  }

  object Libraries {
    def circe(artifact: String): ModuleID = "io.circe"      %% artifact % Versions.circe
    def doobie(artifact: String): ModuleID = "org.tpolecat" %% artifact % Versions.doobie
    def http4s(artifact: String): ModuleID = "org.http4s"   %% artifact % Versions.http4s
    def zio(artifact: String): ModuleID = "dev.zio"         %% artifact % Versions.zio

    lazy val cats                = "org.typelevel"         %% "cats-core"                  % Versions.cats
    lazy val catsMeowMtl         = "com.olegpy"            %% "meow-mtl"                   % Versions.catsMeowMtl
    lazy val catsPar             = "io.chrisdavenport"     %% "cats-par"                   % Versions.catsPar
    lazy val catsEffect          = "org.typelevel"         %% "cats-effect"                % Versions.catsEffect

    lazy val circeCore           = circe("circe-core")
    lazy val circeGeneric        = circe("circe-generic")
    lazy val circeGenericExt     = circe("circe-generic-extras")
    lazy val circeLiteral        = circe("circe-literal")
    lazy val circeParser         = circe("circe-parser")

    lazy val doobieCore          = doobie("doobie-core")
    lazy val doobieH2            = doobie("doobie-h2")
    lazy val doobieHikari        = doobie("doobie-hikari")
    lazy val doobieTest          = doobie("doobie-scalatest")

    lazy val fs2                 = "co.fs2"                %% "fs2-core"                   % Versions.fs2
    lazy val flyway              = "org.flywaydb"          %  "flyway-core"                % Versions.flyway
    lazy val h2                  = "com.h2database"        %  "h2"                         % Versions.h2

    lazy val http4sDsl           = http4s("http4s-dsl")
    lazy val http4sServer        = http4s("http4s-blaze-server")
    lazy val http4sCirce         = http4s("http4s-circe")
    lazy val http4sClient        = http4s("http4s-blaze-client")

    lazy val pureConfig          = "com.github.pureconfig" %% "pureconfig"                 % Versions.pureConfig

    lazy val zioCore             = zio("zio")
    lazy val zioCats             = "dev.zio"               %% "zio-interop-cats"           % Versions.zioCats

    // Compiler plugins
    lazy val betterMonadicFor    = "com.olegpy"            %% "better-monadic-for"         % Versions.betterMonadicFor

    // Runtime
    lazy val logback             = "ch.qos.logback"        %  "logback-classic"            % Versions.logback

    // Test
    lazy val catsEffectLaws      = "org.typelevel"         %% "cats-effect-laws"           % Versions.catsEffect
    lazy val scalaCheck          = "org.scalacheck"        %% "scalacheck"                 % Versions.scalaCheck
    lazy val scalaMock           = "org.scalamock"         %% "scalamock"                  % Versions.scalaMock
    lazy val scalaTest           = "org.scalatest"         %% "scalatest"                  % Versions.scalaTest
  }
}
