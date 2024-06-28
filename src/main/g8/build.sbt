ThisBuild / scalaVersion     := "$scalaVersion$"
ThisBuild / version          := "$version$"
ThisBuild / organization     := "$organization$"

lazy val root = (project in file("."))
.settings(
    name := "$name$",
    Compile / javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),
    Compile / scalacOptions ++= Seq("-deprecation", "-unchecked"),
    Test / javaOptions ++= Seq("-Xms512M", "-Xmx2048M", "-XX:MaxPermSize=2048M", "-XX:+CMSClassUnloadingEnabled"),
    Test / fork := true,

    libraryDependencies ++= Seq(
      "com.typesafe" % "config" % "$typesafeConfigVersion$" % "provided",
      "com.databricks" %% "dbutils-api" % "$dbutilsApiVersion$" % "provided",
      "io.delta" %% "delta-core" % "$deltaVersion$" % "provided",
      "org.apache.spark" %% "spark-sql" % "$sparkVersion$" % "provided",
      "org.scalatest" %% "scalatest" % "$scalatestVersion$" % "test",
      "com.outr" %% "scribe" % "$scribeVersion$"
    ),
  )