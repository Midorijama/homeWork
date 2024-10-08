package src.Model.FileHandling;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public interface Writer extends Serializable {

        public void write(Serializable serial) throws FileNotFoundException, IOException;

        public Object read() throws ClassNotFoundException, IOException;

}