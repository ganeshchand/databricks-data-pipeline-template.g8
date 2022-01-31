package $organization$.$name;format="lower,word"$

import org.apache.spark.sql.SparkSession

trait TestHelper {
  lazy val localSpark: SparkSession = SparkSession.builder().master("local[*]")
    .config("spark.driver.bindAddress", "127.0.0.1").getOrCreate()
  private lazy val localRootDir = scala.sys.env("HOME") + "/temp/$name$"
  lazy val localConf = Config.DeltalakeConfig(localRootDir + "/raw", localRootDir + "/cleansed",localRootDir + "/consumption")
  localSpark.sparkContext.setLogLevel("error")
  import localSpark.implicits._
}