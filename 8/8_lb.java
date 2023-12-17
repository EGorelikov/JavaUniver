import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import java.util.ArrayList;
import java.util.List;

public class RSSFeed {
    private List<RSSItem> items = new ArrayList<>();

    public List<RSSItem> getItems() {
        return items;
    }

    public void addItem(RSSItem item) {
        items.add(item);
    }
}

public class RSSItem {
    private String title;
    private String description;
    private String link;

    // геттеры и сеттеры
}

public class RSSHandler {
    private RSSFeed feed;
    private RSSItem currentItem;
    private StringBuilder currentText;

    public RSSFeed getFeed() {
        return feed;
    }

    public void startDocument() {
        feed = new RSSFeed();
    }

    public void startElement(String uri, String localName, String qName) {
        if ("item".equals(qName)) {
            currentItem = new RSSItem();
        }
        currentText = new StringBuilder();
    }

    public void characters(char[] ch, int start, int length) {
        currentText.append(ch, start, length);
    }

    public void endElement(String uri, String localName, String qName) {
        if (currentItem != null) {
            switch (qName) {
                case "title":
                    currentItem.setTitle(currentText.toString().trim());
                    break;
                case "description":
                    currentItem.setDescription(currentText.toString().trim());
                    break;
                case "link":
                    currentItem.setLink(currentText.toString().trim());
                    break;
                case "item":
                    feed.addItem(currentItem);
                    currentItem = null;
                    break;
            }
        }
    }
}

public class XMLParserExample {
    public static void main(String[] args) {
        String url = "http://news.tut.by/rss/index.rss";

        try {
            // DOM Parsing
            RSSFeed domFeed = parseWithDOM(url);
            System.out.println("DOM Parsing Result: " + domFeed.getItems().size() + " items");

            // SAX Parsing
            RSSFeed saxFeed = parseWithSAX(url);
            System.out.println("SAX Parsing Result: " + saxFeed.getItems().size() + " items");

            // StAX Parsing
            RSSFeed staxFeed = parseWithStAX(url);
            System.out.println("StAX Parsing Result: " + staxFeed.getItems().size() + " items");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static RSSFeed parseWithDOM(String url) throws Exception {
        URL xmlUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) xmlUrl.openConnection();
        InputStream inputStream = connection.getInputStream();

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        return parseDocument(dBuilder, inputStream);
    }

    private static RSSFeed parseWithSAX(String url) throws Exception {
        URL xmlUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) xmlUrl.openConnection();
        InputStream inputStream = connection.getInputStream();

        RSSHandler handler = new RSSHandler();
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        xmlReader.setContentHandler(handler);

        xmlReader.parse(new org.xml.sax.InputSource(inputStream));

        return handler.getFeed();
    }

    private static RSSFeed parseWithStAX(String url) throws Exception {
        URL xmlUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) xmlUrl.openConnection();
        InputStream inputStream = connection.getInputStream();

        RSSHandler handler = new RSSHandler();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(inputStream);

        while (reader.hasNext()) {
            int event = reader.next();

            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    handler.startElement(reader.getNamespaceURI(), reader.getLocalName(), reader.getLocalName());
                    break;
                case XMLStreamConstants.CHARACTERS:
                    handler.characters(reader.getTextCharacters(), 0, reader.getTextLength());
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    handler.endElement(reader.getNamespaceURI(), reader.getLocalName(), reader.getLocalName());
                    break;
            }
        }

        return handler.getFeed();
    }

    private static RSSFeed parseDocument(DocumentBuilder dBuilder, InputStream inputStream)
            throws Exception {
        RSSHandler handler = new RSSHandler();
        dBuilder.parse(inputStream, handler);
        return handler.getFeed();
    }
}