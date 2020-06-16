package uk.co.meridenspares.persistence.dao.hibernate;

import java.io.FileInputStream;
import java.sql.Connection;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.XmlDataSet;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration(locations="classpath:/test-app-context.xml")
public abstract class BaseDaoTestCase extends AbstractTransactionalJUnit4SpringContextTests {

	final String sampleDataLocation = "src/test/resources/test-data.xml";
	
	@Autowired
	DataSource dataSource;
	
	@Before
	public void prepareDatabase() throws Exception
	{
		IDatabaseConnection connection = null;
		
		try {
			Connection conn = DataSourceUtils.getConnection(dataSource);
			connection = new DatabaseConnection(conn, "msdb");
			DatabaseConfig config = connection.getConfig();
			config.setFeature(DatabaseConfig.FEATURE_CASE_SENSITIVE_TABLE_NAMES, Boolean.TRUE);
			config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());
			XmlDataSet xmlDataSet = new XmlDataSet(new FileInputStream(sampleDataLocation));
			DatabaseOperation.CLEAN_INSERT.execute(connection, xmlDataSet);
//			DatabaseOperation.INSERT.execute(connection, xmlDataSet);
			IDataSet dataSet = connection.createDataSet();
			ITable table = dataSet.getTable("contact");

			System.out.println("ROWs = " + table.getRowCount());
			logger.info("Data successfully loaded from [" + sampleDataLocation + "]");
		}
		catch (Exception e) {
			System.out.println("Error preparing database: " + e.getMessage());
			logger.error("Failed to prepare database", e);
		}
		catch (Throwable e) {
			System.out.println("Error preparing database: " + e.getMessage());
			logger.error("Failed to prepare database", e);
		}
		finally {
			if (connection != null) {
				connection.close();
				logger.info("Database connection closed");
			}
		}
	}
}
