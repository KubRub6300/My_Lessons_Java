package Base.Files.Serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TryWithResources {

    public static void main(String[] args) {
        // try с ресурасми. При использовании такого синтаксиса не надо закрывать поток, он закроется сам (не надо ois.close())
        try(ObjectInputStream ois = new ObjectInputStream( new FileInputStream("peoples.bin"))){


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
