Gradle


- 1.创建简单的task
- 2.Gradle 中常用的task
- 3.创建Tasks的多种方法

	- 调用project的task()方法创建Task
	- 通过TaskContainer的create()方法创建Task
- 4.声明Task之间的依赖关系

		Task之间是可以存在依赖关系，比如TaskA依赖TaskB，那么在执行TaskA时，Gradle会先执行TaskB，再执行TaskA

- 5.配置Task的property

- 6.gradle怎么执行的?

	Gradle是一种声明式的构建工具。在执行时，Gradle并不会一开始便顺序执行build.gradle文件中的内容，而是分为两个阶段，第一个阶段是配置阶段，然后才是实际的执行阶段。在配置阶段，Gradle将读取所有build.gradle文件的所有内容来配置Project和Task等，比如设置Project和Task的Property，处理Task之间的依赖关系等

- 7.增量式构建

	在增量式构建中，我们为每个Task定义输入（inputs）和输出（outputs），如果在执行一个Task时，如果它的输入和输出与前一次执行时没有发生变化，那么Gradle便会认为该Task是最新的（UP-TO-DATE），因此Gradle将不予执行。 

- 8.自定义Property

 - 在build.gradle文件中定义Property
 
		在build.gradle文件中向Project添加额外的Property时，我们并不能直接定义，而是应该通过ext来定义。如果要添加一个名为property1的Property，我们应该：ext.property1 = "this is property1"

 - 通过命令行参数定义Property
 - 通过JVM系统参数定义Property
 - 通过环境变量设置Property

- 9.使用Java Plugin

 - 优点：
  
		- 在项目中引入了构建生命周期的概念,Gradle的项目构建生命周期并不是Gradle的内建机制，而是由Plugin自己引入的;
		- java Plugin还向Project中加入了一些额外的Property,比如，sourceCompatibility用于指定在编译Java源文件时所使用的Java版本，archivesBaseName用于指定打包成Jar文件时的文件名称

 - 配置source set,确立Java项目的目录结构

		通过配置sourceSet，可以调整Jvaa项目的目录结构，比如指定源于main目录的Java代码调整到哪个目录，指定源于main目录的resources资源调整到哪个项目目录

		```groovy

			sourceSets {
			   main {
			      java {
			         srcDir 'java-sources'
			      }
			      resources {
			         srcDir 'resources'
			      }
			   }
			}
		```
 - 创建新的source set


- 10.依赖管理

	- 配置Repository
	- Gradle将对依赖进行分组,每一组依赖称为一个Configuration

- 11.构建多个Project

	要创建多Project的Gradle项目，我们首先需要在根（Root）Project中加入名为settings.gradle的配置文件，该文件应该包含各个子Project的名称

	- 通过根Project的allprojects()方法将配置一次性地应用于所有的Project
	- Project提供了subprojects()方法用于配置所有的子Project（不包含根Project）

- 12.自定义Task类型

 - 在build.gradle文件中直接定义
 - 在当前工程的buildSrc/src/main/groovy/**目录下,Groovy文件中定义Task类型
 - 在单独的项目中定义Task类型,可以作为一个单独的库，供其他项目依赖

- 13.自定义Plugin 

 - 在build.gradle文件中直接定义Plugin,实现Plugin接口
 - 在当前工程的buildSrc/src/main/groovy/**目录下定义Plugin
 - 在单独的项目中创建Plugin

###other

Groovy语言中的两个概念: 

 - 1.Groovy中的Bean概念
 - 2.Groovy闭包的delegate机制



>借鉴文章：http://www.cnblogs.com/davenkin/p/gradle-learning-10.html