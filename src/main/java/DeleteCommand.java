import java.util.ArrayList;

public class DeleteCommand extends Command {
    public DeleteCommand() {
        super("delete");
    }

    /**
     * The execute() method in DeleteCommand deletes a given command.
     *
     * @param des the user input into the Duke chat-box.
     * @throws DukeException if input number is not valid or if too many arguments
     *                       are provided to deleteCommand().
     */
    @Override
    public void execute(String des, TaskList tList) throws DukeException {
        ArrayList<Task> tasks = tList.getTaskList();
        String sNum = des.substring(des.lastIndexOf(' ') + 1);
        int num = Integer.parseInt(sNum);
        if (num <= 0 || num > tasks.size()) {
            throw new DukeException("The input number is not a valid task number \nPlease refer to the task list using the \"list\" command");
        } else if (this.countSpaces(des) > 1) {
            throw new DukeException("Too many arguments being provided to \"delete\" \nPlease refer to proper usage of commands with \"allCmd\"");
        } else {
            tList.remove(num);
            System.out.println("Successfully removed task " + num);
        }
        Storage.createFile();
        Storage.writeToFile(tList);
    }
}
