package liquibase.ext.sqlfire.database;

import org.junit.Test;

import static org.junit.Assert.*;

public class SQLFireDatabaseTest {

    @Test
    public void getShortName() throws Exception {
        assertEquals("sqlfire", new SQLFireDatabase().getShortName());
    }
}