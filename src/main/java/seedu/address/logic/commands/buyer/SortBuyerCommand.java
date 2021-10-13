package seedu.address.logic.commands.buyer;

import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.SortCommand;
import seedu.address.model.Model;
import seedu.address.model.field.SortDirection;
import seedu.address.model.field.SortType;

import static java.util.Objects.requireNonNull;

public class SortBuyerCommand extends SortCommand {
    public static final String MESSAGE_SUCCESS = "Sorted all buyers by %s in %s order.";

    public SortBuyerCommand(SortType sortType, SortDirection sortDirection) {
        super(sortType, sortDirection);
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        SortType sortType = getSortType();
        SortDirection sortDirection = getSortDirection();

        if (sortType == SortType.PRICE && sortDirection == SortDirection.ASC) {
            model.sortBuyersPrice();
        } else if (sortType == SortType.PRICE && sortDirection == SortDirection.DESC) {
            model.sortBuyersPriceDesc();
        } else if (sortType == SortType.NAME && sortDirection == SortDirection.ASC) {
            model.sortBuyersName();
        } else if (sortType == SortType.NAME && sortDirection == SortDirection.DESC) {
            model.sortBuyersNameDesc();
        } else {
            assert false;
        }

        return new CommandResult(String.format(MESSAGE_SUCCESS, sortType, sortDirection));
    }
}
