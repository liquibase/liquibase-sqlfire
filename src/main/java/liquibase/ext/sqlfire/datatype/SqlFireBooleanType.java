package liquibase.ext.sqlfire.datatype;

import liquibase.database.Database;
import liquibase.ext.sqlfire.database.SQLFireDatabase;
import liquibase.datatype.DataTypeInfo;
import liquibase.datatype.DatabaseDataType;
import liquibase.datatype.core.BooleanType;

@DataTypeInfo(name = "boolean", aliases = {"java.sql.Types.BOOLEAN", "java.lang.Boolean", "bit"}, minParameters = 0, maxParameters = 0, priority = 10)
public class SqlFireBooleanType extends BooleanType {

    @Override
    public DatabaseDataType toDatabaseDataType(Database database) {
		if (database instanceof SQLFireDatabase) {
			return new DatabaseDataType("SMALLINT");
		}

        return super.toDatabaseDataType(database);
    }

	@Override
    protected boolean isNumericBoolean(Database database) {
        if (database instanceof SQLFireDatabase) {
            return true;
        }
		
		return super.isNumericBoolean(database);
    }

}
