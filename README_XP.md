### 使用新版本的idea(2024.1.4)启动springframework项目

配置如下：

1. Setting
```
Setting -> build,Execution,Deployment -> Compiler -> Kotlin Compiler
设置 Kotlin compiler version -> Bundled(1.9.24-release-822)
设置Target JVM version -> 17
```



2. Project Structure
```
Project Structure -> Project Setting
-> Project
    SDK -> 17
-> Facets
    Kotilin 所有的模块都设置为Use project settings
```

### gradle的配置不要轻易改动

#### 知识点
配置类增强：org.springframework.context.annotation.ConfigurationClassPostProcessor.enhanceConfigurationClasses