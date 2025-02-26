package chatbbg;
import chatbbg.tasktypes.Task;
import chatbbg.tasktypes.Deadline;
import chatbbg.tasktypes.Event;
import chatbbg.tasktypes.Todo;

import Exceptions.EmptyTodoException;
import Exceptions.CorruptedFileException;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Storage {

    public static void createFileDirectory () {
        File directory = new File("data");
        if (!directory.exists()) {
            try {
                directory.mkdirs(); // This will create the necessary directories
            } catch (SecurityException e) {
                System.out.println("Failed to create directory: " + e.getMessage());
            }
        }
    }

    public static void createOrReadOutputFile () {

        File f = new File("data/output.txt");
        try {
            readFile();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (EmptyTodoException e) {
            System.out.println("Todo task empty");
        } catch (CorruptedFileException e) {
            System.out.println("Output.txt file format is wrong. File corrupted.");
        }
    }

    public static void readFile() throws FileNotFoundException, CorruptedFileException, EmptyTodoException {
        //open file for reading
        File f = new File("data/output.txt");
        Scanner s = new Scanner(f);
        Task.initializeArray();
        //iteration required so that program knows which task to mark as done
        int iteration = 0;
        while (s.hasNextLine()) {
            String line = s.nextLine();
            // Process each line (splitting by "|", for example)
            String[] parts = line.split("\\|"); // Split the line by "|"
            if (parts.length < 3 || parts.length > 5 ) {
                throw new CorruptedFileException();
            }
            processFileText(parts, iteration);
            iteration++;
        }
        s.close();
    }


    public static void processFileText (String[] parts, int iteration) throws EmptyTodoException {
        String command;
        switch (parts[0].trim().charAt(0)) {
        case 'T':
            command = "todo " + parts[2].trim();
            Todo.addTodo(command);
            break;
        case 'D':
            command = "deadline " + parts[2].trim() + " /by " + parts[3].trim();
            Deadline.addDeadline(command);
            break;
        case 'E':
            command = "event " + parts[2].trim() + " /from " + parts[3].trim() + " /to " + parts[4].trim();
            Event.addEvent(command);
            break;
        }

        if (parts[1].trim().equals("1")) {
            command = "mark " + iteration;
            Task.modifyTaskTick(iteration, command);
        }
    }
}
