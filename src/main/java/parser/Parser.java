package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Parser {

    public static final String FILE_PATH_IS_EMPTY = "File path is empty";
    public static final String THERE_IS_NO_FILE = "There is no file in path %s";
    private ArrayList<String> words = new ArrayList<>();

    public void parseFile(String filePath) {
        if (Objects.isNull(filePath)) {
            throw new RuntimeException(FILE_PATH_IS_EMPTY);
        }
        ClassLoader classLoader = this.getClass().getClassLoader();

        URL resource = classLoader.getResource(filePath);
        if (Objects.isNull(resource)) {
            throw new RuntimeException(String.format(THERE_IS_NO_FILE, filePath));
        }
        File songFile = new File(resource.getFile());
        try (BufferedReader br = new BufferedReader(new FileReader(songFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                List<String> split = Arrays.stream(line.split("[.,()\\s]"))
                        .filter(x->x.length() > 0).map(String::toLowerCase).collect(Collectors.toList());
                words.addAll(split);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void setWords(ArrayList<String> words) {
        this.words = words;
    }
}
