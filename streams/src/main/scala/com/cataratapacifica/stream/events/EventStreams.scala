package com.cataratapacifica.stream.events

import com.cataratapacifica.stream.events.Generators._
import zio._
import zio.clock.Clock
import zio.duration.Duration
import zio.stream.ZStream
import Events._
import java.time.{ Duration => JDuration }

object EventStreams {
  def generatedStream[Evt, S](initialState: S, generator: EventGenerator[Evt, S], timing: JDuration) =
    ZStream
      .unfoldM(initialState)(generator.generate)
      .schedule(ZSchedule.spaced(Duration.fromJava(timing)))

  def randomEventDelayStream[Evt <: Event](inStream: ZStream[ZEnv with Clock, Nothing, Evt]) =
    inStream.mapM { ev =>
      randomDuration(JDuration.ofMillis(10), JDuration.ofSeconds(10)).map { d =>
        val receivedTime = ev.at.plus(d)
        ReceivedEvent(ev, receivedTime)
      }
    }

}
