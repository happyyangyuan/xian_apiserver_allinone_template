# xian_apiserver全家桶
http apiserver all-in-one demo repository based on xian.  
基于xian框架的独立的全家桶java api服务端应用的代码模板。

该代码模板非常适用于**前后端分离的JavaWeb全家桶应用**。

## 本地构建和启动
### 构建
```bash
./xian_runtime/demoApiApplication/build.sh
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
./xian_runtime/demoApiApplication/_start.sh
# 停止
ctrl+c
```
后台运行
```bash
# 后台启动
./xian_runtime/demoApiApplication/start.sh
# 后台停止
./xian_runtime/demoApiApplication/stop.sh
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

## 持续集成
### 使用rancher-pipeline进行持续集成
详见`.rancher-pipeline.yml`和`rancher-deployment.yaml`文件配置

## 快速开发指南
1. 对代码模板进行定制化
    1.1. 你可以修改`demoApiApplication`文件夹成你想要的java应用名称
    1.2. 修改src/main/java/内包路径名称`com.yourcompany.demoplugin01`等为你想要的包路径名称。
    1.3. 开发你的group和unit代码
2. 构建和运行
    2.1. 执行上述构建命令`build.sh`
    2.2. 然后在本地运行`_start.sh`
    2.3. 访问http://localhost:9123 查看效果
3. 可以直接将整个`xian_runtime`包复制到服务器上去运行。注意服务器上必须安装了jre8。

[详见xian框架文档](https://github.com/xiancloud/xian/blob/master/doc/zh_CN/quickStart.md#%E7%BC%96%E5%86%99%E4%B8%80%E4%B8%AA%E5%BE%AE%E6%9C%8D%E5%8A%A1%E5%8D%95%E5%85%83)