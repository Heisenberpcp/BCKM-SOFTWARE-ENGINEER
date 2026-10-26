to run the project run:
    <!-- .\mvnw  -->
    ## Task 4: Packaging and JAR Size
* **Why is the JAR file so large?** 
The `spring-boot-maven-plugin` creates a "fat JAR" (or uber-JAR). Instead of just containing our compiled Java classes, it bundles all the third-party library dependencies and embeds a complete Tomcat web server inside the file. This allows the application to run completely standalone on any machine with Java installed, without needing a pre-configured web server.
## Task 5: Auto-Configuration Condition
* **Condition Evaluation Report for DataSourceAutoConfiguration:**
  `DataSourceAutoConfiguration matched:`
  `- @ConditionalOnClass found required classes 'javax.sql.DataSource', 'org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType' (OnClassCondition)`