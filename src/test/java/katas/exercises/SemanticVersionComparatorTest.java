package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SemanticVersionComparatorTest {

    @Test
    public void SemanticVersionComparatortest(){
        assertEquals(-1,SemanticVersionComparator.compareVersions("1.0.0", "1.0.1"));
        assertEquals(1,SemanticVersionComparator.compareVersions("2.1.0", "1.9.9"));
        assertEquals(0,SemanticVersionComparator.compareVersions("1.2.3", "1.2.3"));
        assertEquals(0,SemanticVersionComparator.compareVersions("0.0.0", "0.0.0"));
        assertEquals(-1,SemanticVersionComparator.compareVersions("2.2.1", "2.2.2"));
        assertEquals(1,SemanticVersionComparator.compareVersions("1.1.3", "1.1.2"));
    }


    @Test
    public void SemanticVersionComparatornulltest(){
        assertThrows(IllegalArgumentException.class, () -> SemanticVersionComparator.compareVersions(null,null));
        assertThrows(IllegalArgumentException.class, () -> SemanticVersionComparator.compareVersions(new String(""),new String("")));
    }


}
