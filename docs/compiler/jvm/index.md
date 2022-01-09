# Learning JVM

## Resources

- Java™ Platform, Standard Edition 8 API Specification: https://docs.oracle.com/javase/8/docs/api/index.html
- Java EE at a Glance: https://www.oracle.com/java/technologies/java-ee-glance.html
- Java(TM) EE 8 Specification APIs: https://javaee.github.io/javaee-spec/javadocs/

HotSpot:


- [Java SE Core Technologies](https://www.oracle.com/java/technologies/javase/javase-core-technologies-apis.html)
- [OpenJDK The HotSpot Group](http://openjdk.java.net/groups/hotspot/): The HotSpot group is comprised of developers involved in the design, implementation, and maintanence of the HotSpot virtual machine.
- [HotSpot Glossary of Terms](http://openjdk.java.net/groups/hotspot/docs/HotSpotGlossary.html): HostSpot术语
- [Storage Management](http://openjdk.java.net/groups/hotspot/docs/StorageManagement.html): 存储管理
- [Compiler and JVM Research at JKU](http://ssw.jku.at/Research/Projects/JVM/): Johannes Kepler University (JKU).
- [Blog of Dave Dice](https://blogs.oracle.com/dave/): An Oracle blog about Transactional locks


GC:

- Richard Jones, Eliot Moss, Antony Hosking. **垃圾回收算法手册：自动内存管理的艺术** (The Garbage Collection Handbook: the Art of Automatic Memory Management). 机械工业出版社, 2016.
- [HotSpot Virtual Machine Garbage Collection Tuning Guide](https://docs.oracle.com/javase/8/docs/technotes/guides/vm/gctuning/title.html): Java SE 8 HotSpot虚拟机垃圾收集调优指南
- [Memory Management in the Java HotSpot™ Virtual Machine](https://www.oracle.com/technetwork/java/javase/tech/memorymanagement-whitepaper-1-150020.pdf): HotSpot内存管理白皮书
- CMS: Printezis, T. and Detlefs, D. 2000. **A generational mostly-concurrent garbage collector**. In Proceedings of the 2nd international Symposium on Memory Management (Minneapolis, Minnesota, United States, October 15 - 16, 2000)
- G1: Detlefs, D., Flood, C., Heller, S., and Printezis, T. 2004. **Garbage-first garbage collection**. In Proceedings of the 4th international Symposium on Memory Management (Vancouver, BC, Canada, October 24 - 25, 2004).<br>
[The Garbage First Garbage Collector](https://www.oracle.com/java/technologies/javase/hotspot-garbage-collection.html)<br>
[JEP 248: Make G1 the Default Garbage Collector](https://openjdk.java.net/jeps/248)


JVMTI:

- [Java 8 JVMTM Tool Interface](https://docs.oracle.com/javase/8/docs/platform/jvmti/jvmti.html): JVMTI的文档.
- [Building a Super Simple JVMTI Agent](http://saurabhbadhwar.xyz/blog/2019/02/18/building-super-simple-jvmti-agent/): 示例.

## Java EE 8 Technologies

|<div style="width:500px">Technologies</div>|JSR|
|:---|:---|
|**Java EE Platform**|
|Java Platform, Enterprise Edition 8 (Java EE 8) |JSR 366		 |
|**Web Application Technologies**|
|Java API for WebSocket 1.1	|JSR 356		|
|Java API for JSON Binding 1.0	|JSR 367		|
|Java API for JSON Processing 1.1	|JSR 374		|
|Java Servlet 4.0	|JSR 369		|
|JavaServer Faces 2.3	|JSR 372		|
|Expression Language 3.0	|JSR 341		|
|JavaServer Pages 2.3	|JSR 245		|
|Standard Tag Library for JavaServer Pages (JSTL) 1.2	|JSR 52		|
|**Enterprise Application Technologies**|
|Batch Applications for the Java Platform 1.0	|JSR 352		 |
|Concurrency Utilities for Java EE 1.0	|JSR 236		 |
|Contexts and Dependency Injection for Java 2.0	|JSR 365		|
|Dependency Injection for Java 1.0	|JSR 330		|
|Bean Validation 2.0	|JSR 380		|
|Enterprise JavaBeans 3.2	|JSR 345		|
|Interceptors 1.2 |JSR 318		|
|Java EE Connector Architecture 1.7	|JSR 322		 |
|Java Persistence 2.2	|JSR 338		|
|Common Annotations for the Java Platform 1.3	|JSR 250		|
|Java Message Service API 2.0	|JSR 343		 |
|Java Transaction API (JTA) 1.2	|JSR 907		|
|JavaMail 1.6 |JSR 919		 |
|**Web Services Technologies**|
|Java API for RESTful Web Services (JAX-RS) 2.1	|JSR 370		|
|Implementing Enterprise Web Services 1.3	|JSR 109		 |
|Web Services Metadata for the Java Platform 2.1	|JSR 181		 |
|Java API for XML-Based RPC (JAX-RPC) 1.1 (Optional)	|JSR 101		 |
|Java API for XML Registries (JAXR) 1.0 (Optional) |JSR 93		 |
|**Management and Security Technologies**|
|Java EE Security API 1.0	|JSR 375		|
|Java Authentication Service Provider Interface for Containers 1.1	|JSR 196		|
|Java Authorization Contract for Containers 1.5	|JSR 115		 |
|Java EE Application Deployment 1.2  (Optional)	|JSR 88		 |
|J2EE Management 1.1	|JSR 77		 |
|Debugging Support for Other Languages 1.0	|JSR 45		|
|**Java EE-related Specs in Java SE**|
|Java Management Extensions (JMX) 2.0	|JSR 3		 |
|SOAP with Attachments API for Java (SAAJ) Specification 1.3	|JSR 67		 |
|Streaming API for XML (StAX) 1.0	|JSR 173		 |
|Java API for XML Processing (JAXP) 1.6	|JSR 206		 |
|Java Database Connectivity 4.0	|JSR 221		 |
|Java Architecture for XML Binding (JAXB) 2.2	|JSR 222		 |
|Java API for XML-Based Web Services (JAX-WS) 2.2	|JSR 224		 |
|JavaBeans Activation Framework (JAF) 1.1	|JSR 925	|
