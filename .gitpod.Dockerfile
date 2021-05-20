FROM gitpod/workspace-full

# More information: https://www.gitpod.io/docs/config-docker/
RUN sudo rm -rf /usr/bin/hd && \
    brew install linuxsuren/linuxsuren/hd && \
    hd install cli/cli && \
    hd install openshift/source-to-image v1.3.1 && \
    npm -g --unsafe-perm=true --allow-root install fish-pepper --build-from-source
