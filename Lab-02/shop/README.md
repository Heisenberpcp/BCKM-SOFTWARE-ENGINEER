to run the project run:
    .\mvnw 










## Task 3 - JDBC vs JdbcClient

With raw JDBC I have to open/close the Connection, PreparedStatement and
ResultSet myself, copy every column into the record by hand, and handle the
checked SQLException. JdbcClient does resource handling, row mapping
(columns → record fields) and exception translation for me.