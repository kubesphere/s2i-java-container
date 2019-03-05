### Source-to-Image Builder images [![Docker Hub](https://img.shields.io/docker/pulls/kubespheredev/java-8-centos7.svg?style=for-the-badge)](https://hub.docker.com/r/kubespheredev/java-8-centos7/) [![Docker Hub](https://img.shields.io/docker/pulls/kubespheredev/java-11-centos7.svg?style=for-the-badge)](https://hub.docker.com/r/kubespheredev/java-11-centos7/) 




#### Java S2I Builder image

The S2I Java builder can be used to use generate Java S2I builds for
flat classpath applications. It supports flat-classpath and fat-jar packaged applications, leveraging the [run-java-sh project](https://github.com/fabric8io-images/run-java-sh).

#### Development

The project use [fish-pepper](https://github.com/fabric8io-images/fish-pepper) to generete images/Dockerfiles, so do not directly change `run-java.sh`. 
Instead:
- makes your change in [run-java-sh project](https://github.com/fabric8io-images/run-java-sh).
- download and install [fish-pepper](https://github.com/fabric8io-images/fish-pepper) from `master`.
- run it like `path/to/fishpepperrepo/fish-pepper.js` both in `./java` and `.karaf` directories.

If you have errors please remove `.fp-git-blocks/` direcoties under both `./java` and `.karaf`.


##### Release Notes

Please keep the [CHANGELOG.md](CHANGELOG.md) up-to-date.

##### Release Process


Jenkins auto push a release of [kubespheredev/java-*-centos7 to Docker Hub](https://hub.docker.com/u/kubespheredev/):

