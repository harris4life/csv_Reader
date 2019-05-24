# csv_Reader
ms3 coding challenge ; csv_Reader


Approach to challenge : 
Two main classes - 

csv_reader.java
-Create instance of database (SQLite.java)
-initialize variables for failedCount, successfulCount, recievedCount
-initialize log file and error_csv files using FileWriter to also write to respective files
-Use fileReader wrapped in a bufferedReader (For large dataset) to read in csv file data
-for every row in csv file, parse the line/row using String.split(,) and comma as delimiter; returns array of column entries
-iterate through each generated row's array, and first check to see if any missing columns; if so, add to error csv file
-if all columns filled, pass to SQLite addRow() method to add a row using strings within row's array
-append failedCount, successfulCount, recievedCount values to log file

SQLite.java
-establish connection to embedded database using driver 
-verify connection 
-using Statement object, execute raw queries. Create table with A-J columns
-wrap in try-catch for SQLite errors
-addRow() method takes in array of captured parsed csv strings; Using passed in Statement, execute raw update query statement
with values from array to add row

NOTE: 
Unfortunately could not get this to run; SQL_Lite Error remained...my guess is something to do with poorly place JAR file or driver 

DDL: 
CSV Table
