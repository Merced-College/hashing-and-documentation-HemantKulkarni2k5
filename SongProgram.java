import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * SongProgram class that manages a collection of SongRecord objects.
 * Provides methods to load songs from a CSV file, retrieve a song by its ID,
 * and display a graphical user interface (GUI) to search for songs by ID.
 */
public class SongProgram {

    // HashMap to store SongRecords with the song's ID as the key
    private HashMap<String, SongRecord> songMap;

    /**
     * Constructor that initializes the SongProgram with an empty
     * HashMap to store song records.
     * Preconditions: None.
     * Postconditions: A new SongProgram object is created with an
     *    empty HashMap to store SongRecord objects, where each
     *    SongRecord is indexed by its unique ID.
     */
    public SongProgram() {
        songMap = new HashMap<>();
    }

    /**
     * Method to load songs from a CSV file into the songMap.
     * Reads each line from the CSV, creates a SongRecord object, and adds it to the songMap.
     * Preconditions: The CSV file exists and is properly formatted with the expected columns.
     * Postconditions: The songMap is populated with SongRecord objects, where each song is indexed
     *    by its unique ID.
     * @param filePath the path to the CSV file containing song data
     */
    public void loadSongsFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            // Skip the first line (header)
            br.readLine();
            
            while ((line = br.readLine()) != null) {
                // Create a SongRecord from the line and add it to the map
                SongRecord song = new SongRecord(line);
                songMap.put(song.getId(), song);
            }
            System.out.println("Songs successfully loaded from CSV.");
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }

    /**
     * Method to retrieve a SongRecord by its unique ID.
     * Preconditions: The songMap has been populated with SongRecord objects.
     * Postconditions: The SongRecord corresponding to the given ID is returned, or null if the ID is not found.
     * @param id the ID of the song to retrieve
     * @return the SongRecord object with the given ID, or null if not found
     */
    public SongRecord getSongById(String id) {
        return songMap.get(id);
    }

    /**
     * Method to print all songs currently in the songMap.
     * This is useful for debugging or displaying all loaded songs.
     * Preconditions: The songMap has been populated with SongRecord objects.
     * Postconditions: Each SongRecord in the songMap is printed to the console.
     */
    public void printAllSongs() {
        for (SongRecord song : songMap.values()) {
            System.out.println(song);
        }
    }

    /**
     * GUI method to search for a song by its ID.
     * Creates a window with a text field to enter the song ID and a button to initiate the search.
     * Preconditions: None.
     * Postconditions: A GUI window is displayed that allows the user to search for songs by ID.
     */
    public void openSearchGui() {
        // Create the main frame
        JFrame frame = new JFrame("Song Lookup");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold input and button
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Label, Text Field, and Button
        JLabel label = new JLabel("Enter Song ID:");
        JTextField idField = new JTextField(20);
        JButton searchButton = new JButton("Search");

        // Add label, text field, and button to panel
        panel.add(label);
        panel.add(idField);
        panel.add(searchButton);

        // Result area to display song details
        JTextArea resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(scrollPane);

        // Add action listener for the search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                SongRecord song = getSongById(id);
                if (song != null) {
                    resultArea.setText("Song Found:\n" + song.toString());
                } else {
                    resultArea.setText("Song with ID " + id + " not found.");
                }
            }
        });

        // Add panel to frame
        frame.add(panel);
        frame.setVisible(true);
    }

    /**
     * Main method to demonstrate the functionality of the SongProgram.
     * Loads songs from a CSV file, retrieves a song by its ID, and prints all songs.
     * Preconditions: The CSV file exists and contains valid data.
     * Postconditions: Songs are loaded from the CSV, a song is retrieved by ID, and all songs are printed.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        SongProgram program = new SongProgram();

        // Load songs from a CSV file
        String filePath = "data.csv";  // replace with actual file path
        program.loadSongsFromCSV(filePath);

        // Demonstrate retrieving a song by ID
        String testId = "4BJqT0PrAfrxzMOxytFOIz";  // replace with an actual ID from your file
        SongRecord song = program.getSongById(testId);
        if (song != null) {
            System.out.println("Retrieved song: " + song);
        } else {
            System.out.println("Song with ID " + testId + " not found.");
        }

        // Print all songs
        program.printAllSongs();
    }

    /**
     * Alternate main method to demonstrate the SongProgram with a graphical interface.
     * Loads songs from a CSV file and opens a GUI for searching songs by ID.
     * Preconditions: The CSV file exists and contains valid data.
     * Postconditions: The GUI for searching songs is opened.
     * @param args command line arguments (not used)
     */
    public static void main2(String[] args) {
        SongProgram program = new SongProgram();

        // Load songs from a CSV file
        String filePath = "data.csv";  // replace with actual file path
        program.loadSongsFromCSV(filePath);

        // Open GUI for searching songs by ID
        program.openSearchGui();
    }
}

