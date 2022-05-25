# sparklistener_abc

Scala class implementing a custom SparkListener. The onJobStart is overridden to collect the JobIDs and JobGroupIDs.

A wrapper scala class takes SparkSession as argument. The addSparkListener method is used to add the customListener object to sparkSession.

The wrapper class also has methods to operate the customListener and the SparkSession. 

To use in pyspark, add the jar to the spark-submit or pyspark with --jars option.
Then get the scala class using sparkContext._jvm
    tt=spark.sparkContext._jvm.jobidcollector.CollectJobID(spark._jsparkSession)

