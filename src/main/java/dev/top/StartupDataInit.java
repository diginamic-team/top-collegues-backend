package dev.top;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.top.entities.Collegues;
import dev.top.entities.Version;
import dev.top.repos.ColleguesRepo;
import dev.top.repos.VersionRepo;

@Component
public class StartupDataInit {

    @Autowired
    VersionRepo versionRepo;

    @Autowired
    ColleguesRepo colleguesRepo;

    @EventListener(ContextRefreshedEvent.class)
    public void init() {

        this.versionRepo.save(new Version("v1"));
        this.versionRepo.save(new Version("v2"));
        this.versionRepo.save(new Version("v3"));
        this.versionRepo.save(new Version("v4"));

        this.colleguesRepo.save(new Collegues("Licorne", 2, "https://www.eve-grenoble.fr/images/2018/passion-de-licorne-t-shirt-enfant-licorne-dab-3603071959097_740x.jpg"));
        this.colleguesRepo.save(new Collegues("Peter Pan", 3, "https://i.pinimg.com/originals/df/9a/91/df9a9108224cdfa518c8e517cb67c20f.jpg"));
        this.colleguesRepo.save(new Collegues("Shrek", 10, "https://pbs.twimg.com/profile_images/2293448946/image.jpg"));
        this.colleguesRepo.save(new Collegues("Chat Potte", 10, "https://i.pinimg.com/originals/0b/b7/33/0bb733d83ffdb51dae9317c45c8dba2b.jpg"));

    }
}


