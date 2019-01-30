package testTools;

import java.io.IOException;
import java.io.InputStream;

import citygenerator.model.DataLayer.BussinesLogic.namegenerator.CityNameTest;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class TestDataLoader {

    private String file;
    private String key;

    public TestDataLoader(String file) {
        this.file = file;
    }

    public TestDataLoader(String file, String key){
        this.file = file;
        this.key = key;
    }

    public void setTestData(String key) {
        this.key = key;
    }
    
    public List<String> getValues() throws DocumentException, IOException {
        List<String> list = new ArrayList<>();
        SAXReader reader = new SAXReader();
        Document document = reader.read(TestDataLoader.class.getResourceAsStream(file));
        Element element = document.getRootElement();
        for (int i = 0, size = element.nodeCount(); i < size; i++) {
            Node node = element.node(i);
            list.add(node.getText());
        }
        return list;
    }
}
