# xian_apiserver全家桶
http apiserver all-in-one demo repository based on xian.  
基于xian框架的独立的全家桶java api服务端应用的代码模板

基于apiserver我们可以实现前后端分离的Java web应用。

## 构建和启动
### 构建
```bash
./demoApiApplication/build.sh
```
该脚本执行了如下几步：
- 清除历史构建内容
- 执行gradle task，构建fatJar
- 执行gradle task，将fatJar从build/libs/内移动至输出包中
构建输出的fatJar能启动apiserver，这个fatJar是包含了所有依赖物的一个可运行jar文件。

### 启动
前台启动
```bash
# 启动
./demoApiApplication/_start.sh
# 停止
ctrl+c
```
后台运行
```bash
# 后台启动
./demoApiApplication/start.sh
# 后台停止
./demoApiApplication/stop.sh
```

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

