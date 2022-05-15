import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LSTest extends TestCase{



    @ParameterizedTest
    @MethodSource("getPublications")
    void dataPublicationTest(Publication publication){
        Publication expectedPublication = new LinkSpringerLogIn(getDriver())
                .logIn("amamaev12@gmail.com","").
                getPublication(publication.name);
        System.out.println(expectedPublication);
        assertEquals(expectedPublication.date,publication.date);
        assertEquals(expectedPublication.doi, publication.doi);
    }

    private static List<Publication> getPublications() {
        List<Publication> publications = new DataHelper().getPublications();
        System.out.println("FFFF "+publications);
        return publications;
    }

}
