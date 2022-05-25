package jobidcollector

import org.apache.spark.scheduler.{SparkListener, SparkListenerJobStart}
import org.apache.spark.sql.SparkSession
import scala.collection.mutable.ListBuffer

class JobListener extends SparkListener{

   val jobGroupIDList : ListBuffer[String] = ListBuffer.empty[String]
   val jobIDList : ListBuffer[Int] = ListBuffer.empty[Int]

   override def onJobStart(jobStart: SparkListenerJobStart): Unit = {
     jobGroupIDList.+=(jobStart.properties.getProperty("spark.jobGroup.id"))
     jobIDList.+=(jobStart.jobId)
   }
}

class CollectJobID(sparkSession: SparkSession) {

  val jobListener = new JobListener
  sparkSession.sparkContext.addSparkListener(jobListener)

  def getJobGroupId() : String = jobListener.jobGroupIDList.toList.toString()

  def getJobId() : List[Int] = jobListener.jobIDList.toList

  def getRandomString() : String = "iulknkrnqwirfw24jfjsdmffoksc"

  def cancelJobGroup(groupID: String): Unit = {
    sparkSession.sparkContext.cancelJobGroup(groupID)

  }

}
