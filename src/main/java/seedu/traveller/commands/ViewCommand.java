package seedu.traveller.commands;

import seedu.traveller.TripsList;
import seedu.traveller.Ui;
import seedu.traveller.exceptions.NoTripsCreatedException;
import seedu.traveller.exceptions.TravellerException;
import seedu.traveller.exceptions.TripNotFoundException;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ViewCommand extends Command {
    private static final Logger logger = Logger.getLogger(ViewCommand.class.getName());
    private final String tripName;

    public ViewCommand(String tripName) {
        logger.setLevel(Level.INFO);
        this.tripName = tripName;
        logger.log(Level.INFO, "Created a view command");
    }

    /**
     * Performs the action of printing all trips in the <code>TripsList</code> to the console.
     * @param tripsList The <code>TripsList</code> that the command will be executed on.
     * @param ui The <code>Ui</code> that will be used to print out the outcome of the execution.
     */
    public void execute(TripsList tripsList, Ui ui) throws TravellerException {
        if (tripsList.getSize() == 0) {
            throw new NoTripsCreatedException();
        }

        if (Objects.equals(tripName, "all")) {
            ui.printAllTrips(tripsList);
        } else {
            int tripIndex = tripsList.getTripIndex(tripName);
            assert tripIndex < tripsList.getSize() : "The trip index is out of bound.";
            if (tripIndex == -1) {
                throw new TripNotFoundException();
            }

            ui.printTrip(tripsList.getTrip(tripIndex));
        }
    }

    @Override
    public String toString() {
        return "View command:"
                + "\n\ttripName: " + tripName;
    }
}