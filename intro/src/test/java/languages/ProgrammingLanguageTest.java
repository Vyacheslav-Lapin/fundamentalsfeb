package languages;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class ProgrammingLanguageTest {

    @Test
    void tooManyProgrammingLanguages() {
        List<ProgrammingLanguage> programmingLanguages =
                ProgrammingLanguage.getAll();
        assertThat(programmingLanguages.size(), is(716));
    }

}