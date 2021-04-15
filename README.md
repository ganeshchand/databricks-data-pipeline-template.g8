# databricks-data-pipeline-template.g8

## A [Databricks][databricks] Data Pipeline project template using [Giter8][g8]

This template project is intended for data engineers developing data pipelines using [Apache Spark][spark] and [Delta][delta]

[g8]: http://www.foundweekends.org/giter8/
[sbt]: https://www.scala-sbt.org
[scala]: https://wwww.scala-lang.org
[spark]: https://spark.apache.org/
[delta]: https://delta.io/
[databricks]: https://databricks.com/
[installSBT]: https://www.scala-sbt.org/1.x/docs/Setup.html

## What does this template provide?

* An SBT Scala project with the following dependencies:

    * `spark-sql` for developing your ETL pipeline
    * `delta-core` for creating Delta Table
    * `dbutils-api` for accessing [Databricks Utilities](https://docs.databricks.com/dev-tools/databricks-utils.html#databricks-utilities)
    * `scalatest` for unit test

* It also provides `sbt-assembly` sbt plugin in case you need to build an uber jar.

## Getting started

### Using template

1. [Install SBT](installSBT) in case you don't have it installed on your local machine
2. create a project using the template `$ sbt new ganeshchand/databricks-data-pipeline-template.g8`
Note: you will be prompted to fill-in the values required for the template. You can provide and/or accept the defaults
   Alternatively, you can simply provide the parameters you wish to customize as shown below: 
```$ sbt new ganeshchand/databricks-data-pipeline-template.g8 --name=ganesh --organization=com.databricks```

3. `$ cd <YOUR_PROJECT_NAME>`
4. Run test `$ sbt test`. The first test will take about a minute or less depending on your internet speed because it will download the project dependencies jars from maven
5. Open your project in IDE:
    * VS CODE: `$ code .`
    * IntelliJ: `$ idea .`
6. If you are a Databricks customer, you can deploy your jar to Databricks by following instructions [here](https://docs.databricks.com/jobs.html#create-a-job)  
### Contributing to this template
1. Fork this repo and clone it on your local machine
2. Make changes to the template and make sure to clean the previous build `sbt clean compile`
3. Test the template on your local machine
  *  `sbt new file://databricks-data-pipeline-template.g8 --name=template-test --organization=com.example`
  * `cd template-test`
  * `sbt test`
4. Send the pull request