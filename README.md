# xian_apiserver全家桶
http apiserver all-in-one demo repository based on xian.  
基于xian框架的独立的全家桶java api服务端应用的代码模板

基于apiserver我们可以实现前后端分离的Java web应用。

## 构建
这里直接构建输出fatJar，即包含了所有依赖物的一个可运行jar文件。
关于gradle构建输出fatjar，请参考这里：https://www.baeldung.com/gradle-fat-jar。
```groovy
    //create a single Jar with all dependencies
    task fatJar(type: Jar) {
        manifest {
            attributes 'Implementation-Title': 'Gradle Jar File Example',
                    'Implementation-Version': version,
                    'Main-Class': 'info.xiancloud.core.init.start.StartServer'
        }
        baseName = project.name + '-all'
        from { configurations.runtime.collect { it.isDirectory() ? it : zipTree(it) } }
        with jar
    }
```

