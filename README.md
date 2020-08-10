# Java-MVC-E-Commerce
## A E-Commerce website built upon Java basic MVC pattern

### Main functions
* User registration/login service including username/password authentication and email activation
* Accessibility restriction for those non-login users
* User purchase service, including add & delete shopping cart, orders and delivery address system
* Admin administration service, including operation to modify user information, add & delete product type, products,shopping carts and orders through database CRUD operations

### Toolkit
*Platform:Eclipse for JavaEE
*Front-end pages:Html,CSS, Javascript, Jquery, Ajax, JSP, Bootstrap
*Back-end service:Servlets, JavaBean, MySQL
*Server:Apache Tomcat Server

### Installation

*Clone the repository and import it to a platform
*Download platform: [eclipse ee](https://www.eclipse.org/downloads/)/[IntelliJ Idea](https://www.jetbrains.com/idea/)
*Download Database : [MySQL](https://www.mysql.com/downloads/)
*Download Server:[Apache Tomcat Server](https://tomcat.apache.org/)

#### Database configuration(Using c3p0)
  <c3p0-config>
	<default-config>
		<property name="driverClass">com.mysql.jdbc.Driver</property>
		<property name="jdbcUrl">jdbc:mysql://your db address/Myshop</property>
		<property name="user">your db username</property>
		<property name="password">your db password</property>
		<property name="checkoutTimeout">30000</property>
		<property name="initialPoolSize">2</property>
		<property name="maxIdleTime">30</property>
		<property name="maxPoolSize">100</property>
		<property name="minPoolSize">10</property>
	</default-config> 
 </c3p0-config>
 

 









