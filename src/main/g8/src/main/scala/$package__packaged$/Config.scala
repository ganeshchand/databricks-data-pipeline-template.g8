package $organization$.$name;format="word"$

import com.typesafe.config.ConfigFactory

// example config
object Config {
  case class DeltalakeConfig(raw: String, cleansed: String, consumption: String)
  def forEnv(env: String): DeltalakeConfig = {
    val envs: List[String] = List("dev", "qa", "prod")
    require(envs.contains(env), s"env value must be one of \${envs.mkString(",")}")
    val deltaLakeConf = ConfigFactory.load().getConfig(s"""deltalake.conf.\$env""")
    DeltalakeConfig(
      deltaLakeConf.getString("raw"),
      deltaLakeConf.getString("cleansed"),
      deltaLakeConf.getString("consumption")
    )
  }
}