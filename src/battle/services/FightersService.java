package battle.services;

import battle.api.exceptions.NullParticipantsException;
import battle.api.services.IFightersService;
import battle.dao.FightersDao;
import battle.entities.Animal;
import battle.utils.InputOutput;

import java.io.IOException;
import java.util.List;

public class FightersService implements IFightersService {

    private final FightersDao fightersDao = new FightersDao();

    @Override
    public void addFighters() throws IOException, NullParticipantsException {

        List<Animal> fightersReadFromFile = InputOutput.readFile();

        if (!fightersReadFromFile.isEmpty()) {
            fightersDao.addFighters(fightersReadFromFile);
        } else {
            throw new NullParticipantsException();
        }
    }

    @Override
    public List<Animal> getFighters() {

        return fightersDao.getFighters();
    }
}