package jaraws.hibernate;

public class ReadMe {

	/*
	 * Hibernate Inheritance: JOIN STRATEGY
	 * ---------------------------------------------
	 *
	 * 
	 * This is achieved using annotation: 
	 * @Inheritance(strategy=InheritanceType.JOINED)
	 * 
	 * This strategy generates the most normalized structure of tables
	 * 
	 * This results into a normalized table structure with no redundant column in any of the table.
	 * 
	 * Joined strategy generates more normalized tables w.r.t. table per class strategy because
	 * the sub class tables generated in Joined strategy does not contain the columns corresponding
	 * to fields inherited from the super class.
	 * 
	 * Here, whatever properties inherited from the parent class their corresponding columns will remain
	 * with the parent class table only. However, in case of table per class strategy these inherited properties
	 * are not only inherited but their corresponding columns are also created in tables corresponding
	 * to the child classes.
	 */
}