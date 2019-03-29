package dev.top;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.top.entities.Collegue;
import dev.top.repos.CollegueRepo;


@Component
public class StartupDataInit {
    @Autowired
    CollegueRepo collegueRepo;

    @EventListener(ContextRefreshedEvent.class)
    public void init() {
        
        this.collegueRepo.save(new Collegue(3, 5000, "https://media.giphy.com/media/8TRhWZqy5vmU0/giphy.gif", "Mabel"));
        this.collegueRepo.save(new Collegue(4, 4500, "https://media.giphy.com/media/12aZlLvMQtb9e0/giphy.gif", "Dipper"));
        this.collegueRepo.save(new Collegue(5, 3000, "https://media.giphy.com/media/g1PbvXNZnzQUE/giphy.gif", "Stanley"));
        this.collegueRepo.save(new Collegue(6, 20000, "https://media.giphy.com/media/mC2SBfNzJkdC8/giphy.gif", "Bill"));
        this.collegueRepo.save(new Collegue(7, 1000, "https://media.giphy.com/media/DbvmvdRnaPUOs/giphy.gif", "Gideon"));
        this.collegueRepo.save(new Collegue(8, 8000, "https://media.giphy.com/media/YC15BV6WJRqQo/giphy.gif", "Stanford"));

    }
}
