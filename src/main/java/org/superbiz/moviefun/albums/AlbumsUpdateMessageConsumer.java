package org.superbiz.moviefun.albums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class AlbumsUpdateMessageConsumer {
    private final AlbumsUpdater albumsUpdater;
    private static final Logger log = LoggerFactory.getLogger( AlbumsUpdateMessageConsumer.class );

    public AlbumsUpdateMessageConsumer(AlbumsUpdater albumsUpdater) {
        this.albumsUpdater = albumsUpdater;
    }

    public void consume(Message<?> message) {
        try {
            log.debug("Starting albums update");
            albumsUpdater.update();
            log.debug("Finished albums update");
        } catch (Throwable e) {
            log.error("Error while updating albums", e);
        }
    }
}
