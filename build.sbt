scalaVersion := "3.8.3"

name := "emergencesystemsofcities"

version := "0.1-SNAPSHOT"

//mainClass in (Compile, run) := Some("emergencesystemsofcities.")

// model as openmole plugin
enablePlugins(SbtOsgi)
OsgiKeys.exportPackage := Seq("emergencesystemsofcities.*")
OsgiKeys.importPackage := Seq("*;resolution:=optional")
OsgiKeys.privatePackage := Seq("!scala.*,*")
OsgiKeys.requireCapability := """osgi.ee;filter:="(&(osgi.ee=JavaSE)(version=1.8))""""

//resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
//resolvers += "Sonatype OSS Releases" at "https://oss.sonatype.org/content/repositories/releases"
//resolvers += "Sonatype OSS Staging" at "https://oss.sonatype.org/content/repositories/staging"

libraryDependencies ++= Seq(
  "org.apache.commons" % "commons-math3" % "3.6.1",
  "org.apache.commons" % "commons-rng-sampling" % "1.4",
  "org.apache.commons" % "commons-rng-simple" % "1.4",
  "org.jgrapht" % "jgrapht-core" % "1.5.1",
  "org.locationtech.jts" % "jts-core" % "1.19.0"
)
