import java.util.List;
import java.util.Arrays;
import java.util.Objects;

/**
 * SongRecord class that represents a song with various attributes like valence, year, artists, danceability, and more.
 * It includes constructors for both the default and CSV string-based initialization, along with methods to retrieve and modify song attributes.
 * This class also includes methods for equality comparison and hashing.
 * 
 * @author Hemant Kulkarni
 * @date 11/18/24
 */
public class SongRecord {

    // Instance variables
    private double valence;
    private int year;
    private double acousticness;
    private List<String> artists;
    private double danceability;
    private int durationMs;
    private double energy;
    private int explicit;
    private String id;
    private double instrumentalness;
    private int key;
    private double liveness;
    private double loudness;
    private int mode;
    private String name;
    private int popularity;
    private String releaseDate;
    private double speechiness;
    private double tempo;

    /**
     * Default constructor that initializes a song record with default values.
     * Preconditions: None.
     * Postconditions: A new SongRecord object is created with default attribute values, such as "Unknown Title" for name and 0 for numerical attributes.
     */
    public SongRecord() {
        this.valence = 0.0;
        this.year = 0;
        this.acousticness = 0.0;
        this.artists = Arrays.asList("Unknown Artist");
        this.danceability = 0.0;
        this.durationMs = 0;
        this.energy = 0.0;
        this.explicit = 0;
        this.id = "";
        this.instrumentalness = 0.0;
        this.key = 0;
        this.liveness = 0.0;
        this.loudness = 0.0;
        this.mode = 0;
        this.name = "Unknown Title";
        this.popularity = 0;
        this.releaseDate = "0";
        this.speechiness = 0.0;
        this.tempo = 0.0;
    }

    /**
     * Constructor that initializes a song record using a CSV string.
     * The CSV string should be in the following format: <valence>,<year>,<acousticness>,<artists>,<danceability>,<durationMs>,<energy>,<explicit>,<id>,<instrumentalness>,<key>,<liveness>,<loudness>,<mode>,<name>,<popularity>,<releaseDate>,<speechiness>,<tempo>
     * 
     * Preconditions: The CSV string should contain the correct number of comma-separated fields (19 fields).
     * Postconditions: A new SongRecord object is created with the values parsed from the CSV string.
     * 
     * @param data the CSV string containing song data
     */
    public SongRecord(String data) {
        String[] fields = data.split(","); // Assuming comma-separated values
        
        this.valence = Double.parseDouble(fields[0]);
        this.year = Integer.parseInt(fields[1]);
        this.acousticness = Double.parseDouble(fields[2]);
        this.artists = Arrays.asList(fields[3].replaceAll("[\\[\\]']", "").split(";"));
        this.danceability = Double.parseDouble(fields[4]);
        this.durationMs = Integer.parseInt(fields[5]);
        this.energy = Double.parseDouble(fields[6]);
        this.explicit = Integer.parseInt(fields[7]);
        this.id = fields[8];
        this.instrumentalness = Double.parseDouble(fields[9]);
        this.key = Integer.parseInt(fields[10]);
        this.liveness = Double.parseDouble(fields[11]);
        this.loudness = Double.parseDouble(fields[12]);
        this.mode = Integer.parseInt(fields[13]);
        this.name = fields[14];
        this.popularity = Integer.parseInt(fields[15]);
        this.releaseDate = fields[16];
        this.speechiness = Double.parseDouble(fields[17]);
        this.tempo = Double.parseDouble(fields[18]);
    }

    // Getters and setters for each field
    public double getValence() { return valence; }
    public void setValence(double valence) { this.valence = valence; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public double getAcousticness() { return acousticness; }
    public void setAcousticness(double acousticness) { this.acousticness = acousticness; }

    public List<String> getArtists() { return artists; }
    public void setArtists(List<String> artists) { this.artists = artists; }

    public double getDanceability() { return danceability; }
    public void setDanceability(double danceability) { this.danceability = danceability; }

    public int getDurationMs() { return durationMs; }
    public void setDurationMs(int durationMs) { this.durationMs = durationMs; }

    public double getEnergy() { return energy; }
    public void setEnergy(double energy) { this.energy = energy; }

    public int getExplicit() { return explicit; }
    public void setExplicit(int explicit) { this.explicit = explicit; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public double getInstrumentalness() { return instrumentalness; }
    public void setInstrumentalness(double instrumentalness) { this.instrumentalness = instrumentalness; }

    public int getKey() { return key; }
    public void setKey(int key) { this.key = key; }

    public double getLiveness() { return liveness; }
    public void setLiveness(double liveness) { this.liveness = liveness; }

    public double getLoudness() { return loudness; }
    public void setLoudness(double loudness) { this.loudness = loudness; }

    public int getMode() { return mode; }
    public void setMode(int mode) { this.mode = mode; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPopularity() { return popularity; }
    public void setPopularity(int popularity) { this.popularity = popularity; }

    public String getReleaseDate() { return releaseDate; }
    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }

    public double getSpeechiness() { return speechiness; }
    public void setSpeechiness(double speechiness) { this.speechiness = speechiness; }

    public double getTempo() { return tempo; }
    public void setTempo(double tempo) { this.tempo = tempo; }

    /**
     * Converts the SongRecord object to a string representation.
     * Preconditions: None.
     * Postconditions: A string representation of the SongRecord is returned.
     * 
     * @return a string representing the SongRecord object
     */
    @Override
    public String toString() {
        return "SongRecord{" +
                "valence=" + valence +
                ", year=" + year +
                ", acousticness=" + acousticness +
                ", artists=" + artists +
                ", danceability=" + danceability +
                ", durationMs=" + durationMs +
                ", energy=" + energy +
                ", explicit=" + explicit +
                ", id='" + id + '\'' +
                ", instrumentalness=" + instrumentalness +
                ", key=" + key +
                ", liveness=" + liveness +
                ", loudness=" + loudness +
                ", mode=" + mode +
                ", name='" + name + '\'' +
                ", popularity=" + popularity +
                ", releaseDate=" + releaseDate +
                ", speechiness=" + speechiness +
                ", tempo=" + tempo +
                '}';
    }

    /**
     * Checks if two SongRecord objects are equal based on their attribute values.
     * Preconditions: None.
     * Postconditions: Returns true if the two SongRecord objects are identical based on their attribute values, otherwise false.
     * 
     * @param o the object to compare with
     * @return true if the SongRecord objects are equal, otherwise false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongRecord that = (SongRecord) o;
        return Double.compare(that.valence, valence) == 0 &&
                year == that.year &&
                Double.compare(that.acousticness, acousticness) == 0 &&
                Objects.equals(artists, that.artists) &&
                Double.compare(that.danceability, danceability) == 0 &&
                durationMs == that.durationMs &&
                Double.compare(that.energy, energy) == 0 &&
                explicit == that.explicit &&
                Objects.equals(id, that.id) &&
                Double.compare(that.instrumentalness, instrumentalness) == 0 &&
                key == that.key &&
                Double.compare(that.liveness, liveness) == 0 &&
                Double.compare(that.loudness, loudness) == 0 &&
                mode == that.mode &&
                Objects.equals(name, that.name) &&
                popularity == that.popularity &&
                releaseDate == that.releaseDate &&
                Double.compare(that.speechiness, speechiness) == 0 &&
                Double.compare(that.tempo, tempo) == 0;
    }


