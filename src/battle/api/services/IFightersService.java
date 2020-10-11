package battle.api.services;

import battle.api.exceptions.NullParticipantsException;
import battle.entities.Animal;

import java.io.IOException;
import java.util.List;

public interface IFightersService {

    void addFighters() throws IOException, NullParticipantsException;

    List<Animal> getFighters();
}
