package Services.Parser.Intf;

import javax.xml.bind.JAXBException;

public interface Parser {

    Object readFile(String filepath, Class c) throws JAXBException;

    void writeFile(String filepath, Object o) throws JAXBException;
}
