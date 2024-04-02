import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class sonanetist {
    public static String valisuvasona() {
        String suvaSona = "";
        try {
            Document doc = Jsoup.connect("https://kodu.ut.ee/~tristanl/sõnad.html").get();
            Element pTag = doc.select("p").first();
            String tekst = pTag.text();
            List<String> words = Arrays.asList(tekst.split("\\s+"));
            Random rand = new Random();
            suvaSona = words.get(rand.nextInt(words.size()));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return suvaSona;
    }
}