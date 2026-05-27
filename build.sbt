scalaVersion := "3.3.1"

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
  "org.apache.commons" % "commons-math3" % "3.6.1"
)
