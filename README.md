# RPM builder plugin [![Build status](https://api.travis-ci.org/ctron/kura-addons.svg)](https://travis-ci.org/ctron/kura-addons) ![Maven Central](https://img.shields.io/maven-central/v/de.dentrassi.kura.addons/kura-addons.svg)

This repository hosts a few addons for [Eclipse Kura™](https://eclipse.org/kura "Link to Eclipse Kura™").

# Compile it yourself

In order to compile all bundles yourself, simply clone this repository and issue the following command:

```shell
mvn clean install
```

This should build you all modules which also got uploaded to Maven Central.

In order to build other addons just change into the directory and issue `mvn install` manually:

```shell
cd examples
mvn clean install
```