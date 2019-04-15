# xian_apiserver
http apiserver all-in-one demo repository based on xian.  
基于xian框架的独立的全家桶java api服务端应用的代码模板。

该代码模板非常适用于**前后端分离的JavaWeb全家桶应用**，详见与之配合的[前端模板代码](https://github.com/happyyangyuan/xian_static_website_template)

## 架构设计
前后端分离，后端为纯API服务能力，不提供静态资源。
### apiserver应用架构图
![图图图](http://processon.com/chart_image/5cb35752e4b0b62750fa5f4e.png)

### 前后端分离部署架构
![图图图](http://processon.com/chart_image/5cb35c0ee4b069ac5a269a2d.png?_=1555261080590)
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
    task fatJar(type: Jar) {
        manifest {
            attributes 'Main-Class': 'info.xiancloud.core.init.start.StartServer'
        }
        baseName = project.name + '-all'
        from { configurations.runtime.collect { it.isDirectory() ? it : zipTree(it) } }
        with jar
    }
```

## 快速开发指南
1. 对代码模板进行定制化
    1. 你可以修改`demoApiApplication`文件夹成你想要的java应用名称
    2. 修改src/main/java/内包路径名称`com.yourcompany.demoplugin01`等为你想要的包路径名称。
    3. 开发你的group和unit代码
2. 构建和运行
    1. 执行上述构建命令`build.sh`
    2. 然后在本地运行`_start.sh`
    3. 访问http://localhost:9123 查看效果
    4. 访问demoUnit01接口：http://localhost:9123/demoGroup01/demoUnit01
    5. 访问demoUnit02接口：http://localhost:9123/demoGroup02/demoUnit02
3. 可以直接将整个`xian_runtime`包复制到服务器上去运行`_start.sh`/`start.sh`。注意服务器上必须安装了jre8。

[详见xian框架文档](https://github.com/xiancloud/xian/blob/master/doc/zh_CN/quickStart.md#%E7%BC%96%E5%86%99%E4%B8%80%E4%B8%AA%E5%BE%AE%E6%9C%8D%E5%8A%A1%E5%8D%95%E5%85%83)

## 高级用法
### 持续集成
#### 使用rancher-pipeline进行持续集成
详见`.rancher-pipeline.yml`和`rancher-deployment.yaml`文件配置

#### 使用jenkins进行持续集成
步骤同上述快速开发指南第3步。
