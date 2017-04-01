package seedu.task.logic.parser;

import static seedu.task.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.task.logic.parser.CliSyntax.KEYWORDS_ARGS_FORMAT;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
import java.util.regex.Matcher;

import seedu.task.commons.core.LogsCenter;
import seedu.task.commons.exceptions.IllegalValueException;
import seedu.task.commons.util.DateUtil;
import seedu.task.logic.commands.Command;
import seedu.task.logic.commands.FindCommand;
import seedu.task.logic.commands.IncorrectCommand;
import seedu.task.model.task.Date;

/**
 * Parses input arguments and creates a new FindCommand object
 */
public class FindCommandParser extends CommandParser {

//    private static final Logger logger = LogsCenter.getLogger(LogsCenter.class);

    /**
     * Parses the given {@code String} of arguments in the context of the FindCommand
     * and returns an FindCommand object for execution.
     */
    public Command parse(String args) {
        final Matcher matcher = KEYWORDS_ARGS_FORMAT.matcher(args.trim());
        if (!matcher.matches()) {
            return new IncorrectCommand(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
        }
        
        Date targetDate = null;
//        if(Date.isValidDate(args)){
//            try {
//                targetDate = new Date(args);
//            } catch (IllegalValueException ive) {
//                // TODO Auto-generated catch block
//                logger.info(ive.getMessage());
//            }
//        }
//        System.out.println(targetDate.toString());

        // keywords delimited by whitespace
        String[] keywords = matcher.group("keywords").split("\\s+");
        // if a targetDate is successfully extracted, the used words in the keywords are removed
        targetDate = DateUtil.extractValidDate(keywords);
        final Set<String> keywordSet = new HashSet<>(Arrays.asList(keywords));
        if(targetDate!=null)System.out.println(targetDate.toString());
        System.out.println(Arrays.toString(keywords));
        
        return targetDate==null? new FindCommand(keywordSet):new FindCommand(keywordSet,targetDate);
    }

}
