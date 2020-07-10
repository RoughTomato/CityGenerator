![travis build](https://travis-ci.org/RoughTomato/CityGenerator.svg?branch=master)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)
[![codecov](https://codecov.io/gh/RoughTomato/CityGenerator/branch/master/graph/badge.svg)](https://codecov.io/gh/RoughTomato/CityGenerator)
[![Maintainability](https://api.codeclimate.com/v1/badges/e80a10d5e9d11fcf5d51/maintainability)](https://codeclimate.com/github/RoughTomato/CityGenerator/maintainability)
[![Language grade: JavaScript](https://img.shields.io/lgtm/grade/javascript/g/RoughTomato/CityGenerator.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/RoughTomato/CityGenerator/context:javascript)
[![Total alerts](https://img.shields.io/lgtm/alerts/g/RoughTomato/CityGenerator.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/RoughTomato/CityGenerator/alerts/)

# CityGenerator
## City generator for RPG games

Aim of this project is to provide simple in use REST API allowing frontends to generate entire procedurally
generated cities with NPC's and shops.
Features consist of:
- Fully customisable learning data and per game system requirements.
- Generating city name.
- Generating npc's within the city (name, race, gender, stats).
- Generating city map with shops and buildings.
- Generating shop inventory, modeling prices, naming the building.

## Requirements
- MongoDB (listening on port 21017) # [issue #16](https://github.com/RoughTomato/CityGenerator/issues/16)

## Getting started
### Setting up Mongodb in a container
Simply run:
`docker run -it -v /data/db:/mongodata -p 27017:27017 --name mongodb -d mongo`

### Locally
- Set up repostiory and download dependencies: `npm install`
- Build and run dev: `npm start`
- Run tests: `npm test`
### Docker
- Build docker image: `docker build -t citygenerator .`
- Run docker image `docker run citygenerator`
