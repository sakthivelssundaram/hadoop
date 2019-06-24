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
    conf.set("hbase.master.kerberos.principal", "hbase/_HOST@HRBINC.HRBLOCK.NET")
    conf.set("hbase.regionserver.kerberos.principal", "hbase/_HOST@HRBINC.HRBLOCK.NET")
    conf.set("hbase.cluster.distributed", "true")
    conf.set("hadoop.ssl.enabled", "true")
    conf.set("hbase.client.scanner.timeout.period", "600000")
    conf.set("hbase.rpc.timeout", "600000")

    val tableName = "UAT:clz_v5_2019"
    val colFamily = "Main"


    @throws[IOException]
    def convertScanToString(scan: Scan) = {
      val proto = ProtobufUtil.toScan(scan)
      Base64.encodeBytes(proto.toByteArray)
    }

    val scanTable  = new Scan()
    scanTable.addFamily(Array("main".toByte))
    conf.set("TableInputFormat.INPUT_TABLE","clz_v5_2019")
    conf.set("TableInputFormat.SCAN",convertScanToString(scanTable))

    val HRDD = spark.sparkContext.newAPIHadoopRDD(conf,classOf[TableInputFormat],classOf[ImmutableBytesWritable],classOf[Result])



  }
}





