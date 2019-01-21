![travis build](https://travis-ci.org/RoughTomato/CityGenerator.svg?branch=master)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)
[![codecov](https://codecov.io/gh/RoughTomato/CityGenerator/branch/master/graph/badge.svg)](https://codecov.io/gh/RoughTomato/CityGenerator)
[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/RoughTomato/CityGenerator.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/RoughTomato/CityGenerator/context:java)
[![Total alerts](https://img.shields.io/lgtm/alerts/g/RoughTomato/CityGenerator.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/RoughTomato/CityGenerator/alerts/)

# CityGenerator
City generator for RPG games

Aim of this project is to provide simple in use REST API allowing frontends to generate entire procedurally
generated cities with NPC's and shops.
Features consist of:
- Fully customisable learning data and per game system requirements.
- Generating city name.
- Generating npc's within the city (name, race, gender, stats).
- Generating city map with shops and buildings.
- Generating shop inventory, modeling prices, naming the building.

# Requirements
- JDK 8
- Gradle 4.1

# Getting started

- Build and run: `gradle bootRun`
- Run unit tests: `gradle test`
- Run full test suite: `gradle check`
