import Command.Command;
import Parser.Parser;
import Storage.Storage;
import TaskList.TaskList;
import Ui.Ui;

import java.io.IOException;

public class Duke {

        private Storage storage;
        private TaskList tasks;
        private Ui ui;

        public Duke(String filePath) {
            ui = new Ui();
            storage = new Storage(filePath);
            try {
                tasks = new TaskList(storage.load());
            } catch (IOException e) {
                ui.showLoadingError();
                tasks = new TaskList();
            }
        }

        public void run() {
            ui.showWelcome();
            boolean isExit = false;
            while (!isExit) {
                try {
                    String fullCommand = ui.readCommand();
                    ui.showLine(); // show the divider line ("_______")
                    Command c = Parser.parse(fullCommand);
                    c.execute(tasks, ui, storage);
                    isExit = c.isExit();
                } catch (IOException e) {
                    ui.showError(e.getMessage());
                } finally {
                    ui.showLine();
                }
            }
        }

        public static void main(String[] args) {
            new Duke("/Users/jhchen/Documents/GitHub/duke/src/main/java/duke.txt").run();
        }
    }












