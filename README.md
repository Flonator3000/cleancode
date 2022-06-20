SETUP
- checkout project
- run "mvn clean install"
- make sure java is installed


RUN APPLICATION
- java -cp ./target/classes com.example.csvviewer1.CsvViewer1Application persons.csv 3
 
RUN TESTS
- mvn test