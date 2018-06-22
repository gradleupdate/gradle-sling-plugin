![Cognifide logo](docs/cognifide-logo.png)

[![Gradle Status](https://gradleupdate.appspot.com/Cognifide/gradle-sling-plugin/status.svg)](https://gradleupdate.appspot.com/Cognifide/gradle-sling-plugin/status)
[![Apache License, Version 2.0, January 2004](docs/apache-license-badge.svg)](http://www.apache.org/licenses/)
![Travis Build](https://travis-ci.org/Cognifide/gradle-sling-plugin.svg?branch=develop)

# Gradle Sling Plugin

<p align="center">
  <img src="docs/sling-logo.png" alt="Sling Logo"/>
</p>

## Description

Currently there is no popular way to build applications for Sling using Gradle build system. This project contains brand new Gradle plugin to assemble Vault package and deploy it on instance(s).

Incremental build which takes seconds, not minutes. Developer who does not loose focus between build time gaps. Extend freely your build system directly in project. 

Sling developer - it's time to meet Gradle! You liked or used plugin? Don't forget to **star this project** on GitHub :)


## Documentation

This project is a **fork** of [Gradle AEM Plugin](https://github.com/Cognifide/gradle-aem-plugin).

Almost all of its concepts are applicable to pure Sling so that all of features of GAP 4.x.x are available in GSP.
The maintenance and synchronization of two separate plugins may be exhausting, so that any **volunteers** that will take care about this fork are appreciated.
Generally to keep documentation up to date and occasionally transfer code from GAP to GSP and vice versa.

For now, just consider mapping word **aem** to **sling** while reading GAP documentation to be able to start work on GSP.
This is also applicable to build script, for instance:

```groovy
sling {
    config {
        bundlePath = '/apps/example/install'
        contentPath = file('src/main/content')
        // ...
    }
}
```

Task names also have just analogical prefix: `slingDeploy`, `slingSatisfy` etc.

## Installation

1. Build plugin locally using command `sh gradlew`.
2. Create own project using quickstart located in [Gradle Sling Single](https://github.com/Cognifide/gradle-sling-single).

## License

**Gradle Sling Plugin** is licensed under the [Apache License, Version 2.0 (the "License")](https://www.apache.org/licenses/LICENSE-2.0.txt)
