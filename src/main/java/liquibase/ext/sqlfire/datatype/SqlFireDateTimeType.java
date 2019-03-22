package liquibase.ext.sqlfire.datatype;

import liquibase.database.core.*;
import liquibase.ext.sqlfire.database.SQLFireDatabase;
import liquibase.datatype.DataTypeInfo;
import liquibase.datatype.DatabaseDataType;
import liquibase.datatype.LiquibaseDataType;
import liquibase.datatype.core.DateTimeType;
import liquibase.statement.DatabaseFunction;
import liquibase.database.Database;

@DataTypeInfo(name = "datetime", aliases = {"java.sql.Types.DATETIME", "java.util.Date", "smalldatetime", "datetime2"}, minParameters = 0, maxParameters = 1, priority = 10)
public class SqlFireDateTimeType extends DateTimeType {

    @Override
    public DatabaseDataType toDatabaseDataType(Database database) {
        if (database instanceof SQLFireDatabase) {
            return new DatabaseDataType("TIMESTAMP");
        }
		
		return super.toDatabaseDataType(database);
    }

}
