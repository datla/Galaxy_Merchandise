package com.galaxy;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class FileUtilityTest {

    @Test
    public void LoadLines_should_return_lines_from_given_file_path() throws Exception {
        List<String> lines = new FileUtility().loadLines("testData.txt");
        assertThat(lines.size(), is(12));

    }
}
