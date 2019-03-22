package liquibase.ext.sqlfire.sqlgenerator;

import liquibase.database.Database;
import liquibase.ext.sqlfire.database.SQLFireDatabase;
import liquibase.sql.Sql;
import liquibase.sqlgenerator.SqlGeneratorChain;
import liquibase.sqlgenerator.SqlGeneratorFactory;
import liquibase.sqlgenerator.core.CreateDatabaseChangeLogLockTableGenerator;
import liquibase.statement.core.CreateDatabaseChangeLogLockTableStatement;
import liquibase.statement.core.RawSqlStatement;

public class CreateDatabaseChangeLogLockTableGeneratorSqlFire extends CreateDatabaseChangeLogLockTableGenerator {
    @Override
    public int getPriority() {
        return PRIORITY_DATABASE;
    }

    @Override
    public boolean supports(CreateDatabaseChangeLogLockTableStatement statement, Database database) {
        return database instanceof SQLFireDatabase;
    }

    @Override
    public Sql[] generateSql(CreateDatabaseChangeLogLockTableStatement statement, Database database, SqlGeneratorChain sqlGeneratorChain) {

        RawSqlStatement createTableStatement = new RawSqlStatement("CREATE TABLE \"" + database.getLiquibaseSchemaName() + "\".\"" + database.getDatabaseChangeLogLockTableName() + "\" " +
                "(" +
                "   ID int PRIMARY KEY NOT NULL, " +
                "   LOCKED smallint NOT NULL, " +
                "   LOCKGRANTED timestamp, " +
                "   LOCKEDBY varchar(255) " +
                ") REPLICATE PERSISTENT;");

        return SqlGeneratorFactory.getInstance().generateSql(createTableStatement, database);
    }
}
