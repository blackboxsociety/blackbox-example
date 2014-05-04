import sbt._
import sbt.Keys._

import spray.revolver.RevolverPlugin._
import less.Plugin._
import sbtclosure.SbtClosurePlugin._
import sbtclosure.SbtClosurePlugin.ClosureKeys._
import less.Plugin.LessKeys._
import sbtassembly.Plugin._

object Build extends Build {

  val appSettings = Revolver.settings ++ lessSettings ++ closureSettings ++ Seq(
    crossPaths := false,
    (resourceManaged in (Compile, less)) <<= (crossTarget in Compile)(_ / "resource_managed" / "main" / "public" / "css"),
    (resourceManaged in (Compile, closure)) <<= (crossTarget in Compile)(_ / "resource_managed" / "main" / "public" / "javascript"),
    (filter in (Compile, less)) := "main.less"
  )

  val root = Project("root", file("."))
    .settings(appSettings: _*)
    .settings(assemblySettings: _*)
    .settings(
      name                  := "blackbox-example",
      organization          := "com.blackboxsociety",
      version               := "0.1.0",
      scalaVersion          := "2.10.3",
      licenses              += ("MIT", url("http://opensource.org/licenses/MIT")),
      //scalacOptions       += "-feature",
      //scalacOptions       += "-deprecation",
      scalacOptions in Test ++= Seq("-Yrangepos"),
      resolvers             += "Black Box Society Repository" at "http://dl.bintray.com/blackboxsociety/releases",
      libraryDependencies   += "com.blackboxsociety" %% "blackbox" % "0.1.0"
    )

}
