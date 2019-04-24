FROM docker.io/java

RUN /usr/sbin/useradd --comment Developer \
                  --home-dir /home/developer \
                  --non-unique --uid 1000 --user-group --system \
                  --shell /bin/bash developer && mkdir -p /home/developer

RUN chown -R developer:developer /home/developer && mkdir -p /opt/app && chown -R developer:developer /opt/app

RUN echo 'developer ALL=(ALL) NOPASSWD: ALL' >> /etc/sudoers

USER developer
ENV HOME /home/developer
VOLUME /opt/app
