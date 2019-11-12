package com.cataratapacifica.server

import org.http4s.server.blaze._
import zio._
import zio.interop.catz._
import zio.interop.catz.implicits._

object Boot extends App {

  val z = ZEnv

  val server: ZIO[ZEnv, Throwable, Unit] = ZIO.runtime[ZEnv]
    .flatMap {
      implicit rts =>
        BlazeServerBuilder[Task]
          .bindHttp(8080, "localhost")
          .withHttpApp(BootService.service)
          .serve
          .compile
          .drain
    }

  def run(args: List[String]) =
    server.fold(_ => 1, _ => 0)
}
