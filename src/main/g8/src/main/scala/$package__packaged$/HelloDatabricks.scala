package $organization$.$name;format="word"$

import org.apache.spark.sql.{SparkSession, DataFrame}
import org.apache.spark.sql.functions.current_date

// example pipeline
class HelloDatabricksPipeline(spark: SparkSession, deltalake: Config.DeltalakeConfig) {
  def output: DataFrame = spark.range(10).withColumn("etl_date", current_date)
  def run = output.write.format("delta").mode("append").save(deltalake.raw + "/hello")
}

// main
object PipelineMain {
  def main(args: Array[String]): Unit = {
    val env = args(0)
    val spark = SparkSession.getActiveSession.get
    new HelloDatabricksPipeline(spark, Config.forEnv(env)).run
  }
}