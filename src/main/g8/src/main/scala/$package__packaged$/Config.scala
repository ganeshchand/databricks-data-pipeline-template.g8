package $package$

import com.typesafe.config.ConfigFactory
import scribe.Logging
// example config
object Config extends Logging {
  val envs: List[String] = List("dev", "qa", "prod")
  case class DeltalakeConfig(raw: String, cleansed: String, consumption: String)
  def forEnv(env: String): DeltalakeConfig = {
    logger.info(s"Loading config for env: \${env}")
    require(envs.contains(env), s"env value must be one of \${envs.mkString(",")}")
    val deltaLakeConf = ConfigFactory.load().getConfig(s"""deltalake.conf.\$env""")
    DeltalakeConfig(
      deltaLakeConf.getString("raw"),
      deltaLakeConf.getString("cleansed"),
      deltaLakeConf.getString("consumption")
    )
  }
}