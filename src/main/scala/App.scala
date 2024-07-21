import org.apache.spark.sql.SparkSession

object App {
  def main(args: Array[String]): Unit = {
    // Create a Spark session
    val spark = SparkSession.builder.appName("ScalaSparkExample").master("local[*]").getOrCreate()

    // Create a DataFrame
    val data = Seq(("John", 28), ("Anna", 23), ("Mike", 34))
    val columns = Seq("Name", "Age")
    import spark.implicits._
    val df = data.toDF(columns: _*)

    // Show the DataFrame
    df.show()

    // Stop the Spark session
    spark.stop()
  }
}
