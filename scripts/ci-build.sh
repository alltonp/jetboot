#!/bin/sh

#sbt test "+ publishSigned" sonatypeReleaseAll
sbt test "publishSigned" sonatypeReleaseAll
