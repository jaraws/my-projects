package jaraws.hibernate;

public class ReadMe {

	/*
	 * @Id Annotation
	 * --------------------------------------
	 * @Id: It represents that the given particular field is a primary key, then this primary
	 * key could be used to fetch the value from the database table.
	 * 
	 * @GeneratedValue(strategy=GenerationType.AUTO)
	 * --------------------------------------
	 * It basically tells the Hibernate to generate the id value for us, we will not generate this value.
	 * Hibernate at runtime will generate a value depending up the type of id and will save it along with 
	 * the other values of an entity object in database.
	 * 
	 * GenerationType.AUTO: Hibernate generates the id depending upon the underlying database used inside 
	 * application. And hibernate determines this from the dialect mentioned in hibernate configuration
	 * file.
	 * 
	 * @GeneratedValue(GenerationType.IDENTITY): 
	 * --------------------------------------
	 * The GenerationType.IDENTITY is the easiest to use but not the best one from a 
	 * performance point of view. It relies on an auto-incremented database column and lets the database generate 
	 * a new value with each insert operation. From a database point of view, this is very efficient because the 
	 * auto-increment columns are highly optimized, and it doesn’t require any additional statements.
	 * 
	 * This approach has a significant drawback if you use Hibernate. Hibernate requires a primary key value for 
	 * each managed entity and therefore has to perform the insert statement immediately. This prevents it from 
	 * using different optimization techniques like JDBC batching and "transaction write behind"
	 * 
	 * @GeneratedValue(GenerationType.SEQUENCE): 
	 * --------------------------------------
	 * It requires additional select statements to get the next value from a database sequence. But this has no 
	 * performance impact for most applications. And if your application has to persist a huge number of new 
	 * entities, you can use some Hibernate specific optimizations to reduce the number of statements.
	 * 
	 * If you don’t provide any additional information, Hibernate will request the next value from its default sequence. 
	 * You can change that by referencing the name of a @SequenceGenerator in the generator attribute of the 
	 * @GeneratedValue annotation. The @SequenceGenerator annotation lets you define the name of the generator, the name, 
	 * and schema of the database sequence and the allocation size of the sequence.
	 * 
	 * 
	 * @GeneratedValue(GenerationType.TABLE): 
	 * --------------------------------------
	 * The GenerationType.TABLE gets only rarely used nowadays. It simulates a sequence by storing and updating its 
	 * current value in a database table which requires the use of pessimistic locks which put all transactions into a 
	 * sequential order. This slows down your application, and you should, therefore, prefer the GenerationType.SEQUENCE, 
	 * if your database supports sequences, which most popular databases do.
	 * 
	 * 
	 * SCHEMA VS DATABASE
	 * --------------------------------------
	 * In MySQL, physically, a schema is synonymous with a database. You can substitute the keyword SCHEMA 
	 * instead of DATABASE in MySQL SQL syntax, for example using CREATE SCHEMA instead of CREATE DATABASE.
	 * 
	 * Some other database products draw a distinction. For example, in the Oracle Database product, a schema 
	 * represents only a part of a database: the tables and other objects owned by a single user.
	 * 
	 * 
	 * MySQL vs Microsoft SQL Server
	 * --------------------------------------
	 * Both MySQL and MS SQL Server are widely used enterprise database systems. MySQL is an open source RDBMS, 
	 * whereas SQL Server is a Microsoft product.
	 * 
	 */

}