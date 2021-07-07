package dev.top;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.top.entities.Collegue;
import dev.top.entities.Version;
import dev.top.repos.CollegueRepo;
import dev.top.repos.VersionRepo;

@Component
public class StartupDataInit {

    @Autowired
    VersionRepo versionRepo;
    
    @Autowired
    CollegueRepo collegueRepo;

    @EventListener(ContextRefreshedEvent.class)
    public void init() {

        this.versionRepo.save(new Version("v1"));
        this.versionRepo.save(new Version("v2"));
        this.versionRepo.save(new Version("v3"));
        this.versionRepo.save(new Version("v4"));
        
        this.collegueRepo.save(new Collegue("Rod",100,"https://images.pexels.com/photos/265036/pexels-photo-265036.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb","e353c696","RODN","RodP","rod@rod.fr", "1987-06-08T07:08:08 -02:00","male","10 rue de Nantes 34000 Montpellier","$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra",null,"DSI/INDUS/Windows"));
        this.collegueRepo.save(new Collegue("Alice",800,"https://static1.squarespace.com/static/528b9077e4b076ee0b892f2f/t/579ce7ab5016e10ca2a21547/1469900728497/border-collie-close-up?format=750w","e353c697","ALICEN","AliceP","alice@alice.fr", "1986-06-08T07:08:08 -02:00","female","20 rue de Nantes 34000 Montpellier","$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra",null,"DSI/INDUS/Windows"));
        

    }
}
