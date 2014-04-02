package liquibase.ext.sqlfire.sqlgenerator;

import liquibase.database.Database;
import liquibase.ext.sqlfire.database.SQLFireDatabase;
import liquibase.sql.Sql;
import liquibase.sqlgenerator.SqlGeneratorChain;
import liquibase.sqlgenerator.SqlGeneratorFactory;
import liquibase.sqlgenerator.core.CreateDatabaseChangeLogTableGenerator;
import liquibase.statement.core.CreateDatabaseChangeLogTableStatement;
import liquibase.statement.core.RawSqlStatement;

public class CreateDatabaseChangeLogTableGeneratorSqlFire extends CreateDatabaseChangeLogTableGenerator {
    @Override
    public int getPriority() {
        return PRIORITY_DATABASE;
    }

    @Override
    public boolean supports(CreateDatabaseChangeLogTableStatement statement, Database database) {
        return database instanceof SQLFireDatabase;
    }

    @Override
    public Sql[] generateSql(CreateDatabaseChangeLogTableStatement statement, Database database, SqlGeneratorChain sqlGeneratorChain) {

        RawSqlStatement rawStatement = new RawSqlStatement("CREATE TABLE \"" + database.getLiquibaseSchemaName() + "\".\"" + database.getDatabaseChangeLogTableName() + "\"\n" +
                "(" +
                "   ID varchar(" + getIdColumnSize() + ") NOT NULL, " +
                "   AUTHOR varchar(" + getAuthorColumnSize() + ") NOT NULL, " +
                "   FILENAME varchar(" + getFilenameColumnSize() + ") NOT NULL, " +
                "   DATEEXECUTED timestamp NOT NULL, " +
                "   ORDEREXECUTED int NOT NULL, " +
                "   EXECTYPE varchar(10) NOT NULL, " +
                "   MD5SUM varchar(35), " +
                "   DESCRIPTION varchar(255), " +
                "   COMMENTS varchar(255), " +
                "   TAG varchar(255), " +
                "   LIQUIBASE varchar(20) " +
                ") REPLICATE PERSISTENT;");

        return SqlGeneratorFactory.getInstance().generateSql(rawStatement, database);
    }

}
