#!/bin/bash

CONTAINER='java-app'
APP_DIR=`pwd`

docker run -ti --rm \
        -e _JAVA_OPTIONS='-Dawt.useSystemAAFontSettings=lcd -Dswing.defaultlaf=com.sun.java.swing.plaf.gtk.GTKLookAndFeel' \
        -e DISPLAY=$DISPLAY \
        -v /tmp/.X11-unix:/tmp/.X11-unix \
        -v /usr/share/fonts:/usr/share/fonts:ro \
        -v ${APP_DIR}:/app \
        -v /home/${USER}/.config/dbvis:/home/developer/.dbvis:z \
        --security-opt label=type:container_runtime_t \
        --network=host \
        "${CONTAINER}" java -jar /app/app.jar

