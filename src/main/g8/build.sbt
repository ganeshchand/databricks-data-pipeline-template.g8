lazy val root = (project in file("."))
.settings(
    inThisBuild(List(
      organization := "$organization$",
      scalaVersion := "$scalaVersion$"
    )),
    name := "$name$",
    version := "$version$",

    javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),
    javaOptions ++= Seq("-Xms512M", "-Xmx2048M", "-XX:MaxPermSize=2048M", "-XX:+CMSClassUnloadingEnabled"),
    scalacOptions ++= Seq("-deprecation", "-unchecked"),
    
    parallelExecution in Test := false,
    fork := true,

    libraryDependencies ++= Seq(
      "com.typesafe" % "config" % "$typesafeConfigVersion$" % "provided",
//      "com.databricks" %% "dbutils-api" % "$dbutilsApiVersion$" % "provided",
      "io.delta" %% "delta-core" % "$deltaVersion$" % "provided",
      "org.apache.spark" %% "spark-sql" % "$sparkVersion$" % "provided",
      "org.scalatest" %% "scalatest" % "$scalatestVersion$" % "test",
    ),
  )