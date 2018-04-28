package Services.Parser.Intf;

import javax.xml.bind.JAXBException;
import java.io.File;

public interface Parser {

    Object readFile(String filepath, Class c) throws JAXBException;

    void writeFile(String filepath, Object o) throws JAXBException;
}
