package textFileApps;

import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import principal.Contato;

public class CreateTextFile {

    private static Formatter output; // outputs text to a file
    // open file clients.txt

    public static void openFile() {
        try {
            output = new Formatter("agendaPessoal.txt"); // open the file
        } catch (SecurityException securityException) {
            System.err.println("Write permission denied. Terminating.");
            System.exit(1); // terminate the program
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error opening file. Terminating.");
            System.exit(1); // terminate the program
        }
    }

    // add records to file
    public static void addRecords(Contato contato) {

        try {
            // output new record to file; assumes valid input
            output.format("%s;%s;%s;%s\n", contato.getNome(),
                    contato.getTelefone(), contato.getEndereco(), contato.getEmail());
        } catch (FormatterClosedException formatterClosedException) {
            System.err.println("Erro ao escrever no arquivo. Finalizando.");
        } catch (NoSuchElementException elementException) {
            System.err.println("Entrada inválida. Tente novamente!");
        }
    }

    // close file
    public static void closeFile() {
        if (output != null) {
            output.close();
        }
    }
} // end class CreateTextFile
