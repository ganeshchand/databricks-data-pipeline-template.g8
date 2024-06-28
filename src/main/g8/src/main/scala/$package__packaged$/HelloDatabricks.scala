package $package$

import org.apache.spark.sql.{SparkSession, DataFrame}
import org.apache.spark.sql.functions.current_date
import scribe.Logging
// example pipeline
class HelloDatabricksPipeline(spark: SparkSession, deltalake: Config.DeltalakeConfig) extends Logging {
  logger.info("Hello Databricks Pipeline")
  def output: DataFrame = spark.range(10).withColumn("etl_date", current_date)
  def run = output.write.format("delta").mode("append").save(deltalake.raw + "/hello")
  logger.info(s"Wrote \${output.count} rows to \${deltalake.raw}/hello")
}

// main
object PipelineMain extends Logging {
  def main(args: Array[String]): Unit = {
    val env = args(0)
    logger.info(s"Running pipeline for env: \${env}")
    val spark = SparkSession.getActiveSession.get
    new HelloDatabricksPipeline(spark, Config.forEnv(env)).run
  }
}