name := "Lift-empty-session"

scalaVersion := "2.9.1"

scalacOptions += "-deprecation"

scalacOptions += "-unchecked"

resolvers += "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"

// Akka
resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.0.2" % "compile->default"

libraryDependencies += "junit" % "junit" % "4.10" % "test"

libraryDependencies += "net.liftweb" %% "lift-mapper" % "2.4" % "compile->default"
 
libraryDependencies += "net.liftweb" %% "lift-webkit" % "2.4" % "compile->default"

libraryDependencies += "net.liftweb" %% "lift-wizard" % "2.4" % "compile->default"

libraryDependencies += "org.eclipse.jetty" % "jetty-webapp" % "8.1.0.v20120127" % "container"

libraryDependencies += "org.eclipse.jetty" % "jetty-webapp" % "8.1.0.v20120127" % "test->default"

libraryDependencies += "org.scalatest" %% "scalatest" % "1.7.1" % "test"

libraryDependencies += "org.scala-tools.testing" %% "specs" % "1.6.9" % "test"

libraryDependencies += "com.typesafe.akka" % "akka-actor" % "2.0.2"

libraryDependencies += "com.typesafe.akka" % "akka-agent" % "2.0.2"

libraryDependencies += "com.typesafe.akka" % "akka-slf4j" % "2.0.2"

libraryDependencies += "com.typesafe.akka" % "akka-testkit" % "2.0.2"

// coffeescrpted-sbt
seq(coffeeSettings: _*)

seq(webSettings :_*)

// CoffeeScript-Skripte nach webapp/scripts kompilieren
(resourceManaged in (Compile, CoffeeKeys.coffee)) <<= (webappResources in Compile)(_.get.head / "scripts")
