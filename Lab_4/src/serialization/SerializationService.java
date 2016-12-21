package serialization;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Andrew on 21.12.2016.
 */
public class SerializationService<T> {

    public T deSerialize(String pathInSystemToFile) {
        Path path = Paths.get(pathInSystemToFile);
        if (Files.exists(path)) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()))) {
                return (T) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace(System.err);
            }
        }
        return null;
    }


    public void serialize(T obj, String pathToSave) {
        Path path = Paths.get(pathToSave);

        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
            ous.writeObject(obj);
            ous.flush();
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
}
