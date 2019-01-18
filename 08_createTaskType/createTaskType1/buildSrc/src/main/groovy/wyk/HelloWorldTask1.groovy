package wyk
import org.gradle.api.*
import org.gradle.api.tasks.*

class HelloWorldTask1 extends DefaultTask {
    @Optional
    String message = 'I am wyk'

    @TaskAction
    def hello(){
        println "hello world $message"
    }
}