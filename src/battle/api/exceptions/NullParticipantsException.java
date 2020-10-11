package battle.api.exceptions;

public class NullParticipantsException extends Exception {

    @Override
    public String getMessage() {
        return "No fighters were found";
    }
}
