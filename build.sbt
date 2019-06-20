name := "Getschema"

version := "0.1"

scalaVersion := "2.11.12"

// https://mvnrepository.com/artifact/org.apache.spark/spark-core
// https://mvnrepository.com/artifact/org.apache.hbase/hbase-client
libraryDependencies ++= Seq("org.apache.spark" %% "spark-core" % "2.4.0.cloudera2",
  "org.apache.hbase" % "hbase-client" % "1.2.0-cdh5.16.2",
  "org.apache.hbase" % "hbase-server" % "1.2.0-cdh5.16.2",
  "org.apache.hbase" % "hbase-common" % "1.2.0-cdh5.16.2",
  "org.apache.hadoop" % "hadoop-common" % "2.6.0-cdh5.16.2",
  "org.apache.spark" %% "spark-sql" % "2.4.0.cloudera2"
)


resolvers ++= Seq(
  "Apache Repository" at "https://repository.apache.org/content/repositories/releases/",
  "Cloudera repo" at "https://repository.cloudera.com/artifactory/cloudera-repos/"
)

