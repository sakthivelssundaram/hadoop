package scala

import org.apache.hadoop.hbase.client.Scan
import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.spark.sql._



object GetSchema{
  def main(Args: Array[String]) = {
    val spark = SparkSession.builder().getOrCreate()
    val conf = HBaseConfiguration.create()
    conf.set("hbase.zookeeper.quorum", "")
    conf.set("hbase.zookeeper.property.clientPort", "2181")
    conf.set("hadoop.security.authentication", "kerberos")
    conf.set("hbase.security.authentication", "kerberos")
    conf.set("hbase.master.kerberos.principal", "")
    conf.set("hbase.regionserver.kerberos.principal", "")
    conf.set("hbase.cluster.distributed", "true")
    conf.set("hadoop.ssl.enabled", "true")
    conf.set("hbase.client.scanner.timeout.period", "600000")
    conf.set("hbase.rpc.timeout", "600000")

    val tableName = ""
    val colFamily = "Main"



  }
}





