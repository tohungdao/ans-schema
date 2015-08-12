package com.washingtonpost.arc.ans.v0_2.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

/**
 * <p>Tests that JSON we expect to be a valid "Media" data file serializes correctly and validates
 * against the JSON schema</p>
 */
public class TestMedia extends AbstractTest<Media> {
    
    @Override
    String getSchemaName() {
        return "media";
    }

    @Override
    Class getTargetClass() {
        return Media.class;
    }

    @Test
    @Override
    public void testEqualsAndHashCode() {
        EqualsVerifier.forClass(getTargetClass())
                .suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
                .withRedefinedSuperclass()
                .verify();
    }

    @Test
    public void testMediaGood() throws Exception {
        testJsonValidation("media-fixture-good", true);
        Media media = testClassSerialization("media-fixture-good");
        assertThat(media.getTitle(), is("Tiffany M. Ingham (Maj. Dale Greer/Kentucky Air National Guard)"));
        assertThat(media.getGuid(), is("unique ANS id"));
        assertThat(media.getCreatedDate(), is(date("2015-06-25T09:50:50.52Z")));
        assertThat(media.getCredits().size(), is(1));
        assertThat(media.getCredits().get(0).getName(), is("Ansel Adams"));
        assertThat(media.getCredits().get(0).getRole(), is("Photographer"));
    }
}
