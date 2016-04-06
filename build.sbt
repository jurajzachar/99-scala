scalaVersion := "2.11.7"
name := "99-scala"
organization := "com.blueskiron"

lazy val commonSettings = Seq(
  javaOptions += "-Xmx2G",
  fork in Test := false,
  scalaVersion in ThisBuild := "2.11.7",
  version in ThisBuild := "1.0.0",
  resolvers ++=Seq(
    "Atlassian Releases" at "https://maven.atlassian.com/public",
    "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
    )
)

val root = (project in file(".")).settings(commonSettings: _*)

scalacOptions in ThisBuild ++= Seq(
  "-target:jvm-1.8",
  "-encoding", "UTF-8",
  "-deprecation", // warning and location for usages of deprecated APIs
  "-feature", // warning and location for usages of features that should be imported explicitly
  "-unchecked", // additional warnings where generated code depends on assumptions
  "-Xlint", // recommended additional warnings
  "-Ywarn-adapted-args", // Warn if an argument list is modified to match the receiver
  "-Ywarn-value-discard", // Warn when non-Unit expression results are unused
  "-Ywarn-inaccessible",
  "-Ywarn-dead-code"
)
