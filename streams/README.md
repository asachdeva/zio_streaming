# Explore Streams

This project is an attempt to explore streams and/or other aspects of the zio system.
It does so, through a worked example related to real-life problems I deal with.

# Problem Statement

We are interested in monitoring the temperature in a range of Devices.

Each device has a  sensor that give rise to a record every 10 seconds, comprising

* DeviceId
* Time
* GPS data (position, speed, bearing)
* Temperature of device

These records are sent to a database run by the Telematics service provider.

The database cannot be queried across the internet. However, we can install a daemon process on the Telematics
providers system, that polls the database and sends the latest records to our
own servers every few seconds.

In our application, we wish to examine the input data and raise alerts
if any of the following occur:

1. The temperature exceeds threshold A at any time
2. The temperature exceeds threshold B for more than 10 minutes based on consecutive signals
3. The temperature exceeds threshold C for more than one hour in any two hour period
4. We lose contact with a device for more than 20 minutes

# This Project

This is an exploratory/tutorial project. All the above would provide useful learning for me and I'm happy to share what I find out along the way as a series of documented examples.

# Proposed method
(initial notes)

## Simulating the Devices

Each device is implemented as a stream. The events will be generated every 10 seconds (but using zio mock clock). The generators will be written to expose the specific error conditions we're looking for over a period of time.
An intermediate step will build in message delays to cover the loss of contact.

Streams will then be combined into a single stream and written to database (or file) for reproducible testing.

## Daemon process
This will read the persisted data to simulate polling a database. It will then push data to the main application server as a stream. Medium, term it is my intention to use ZIO-kafka,
in the meantime, it will simply provide stream in process

## Service

