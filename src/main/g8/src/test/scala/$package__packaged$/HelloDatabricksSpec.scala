package $organization$.$name;format="lower,word"$

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import org.apache.spark.sql.SparkSession

class HelloDatabricksPipelineSpec extends AnyFlatSpec with Matchers with TestHelper {
  it must "output dataframe must have etl_date column" in {
    new HelloDatabricksPipeline(localSpark, localConf).output.columns.toList must contain ("etl_date")
  }
}