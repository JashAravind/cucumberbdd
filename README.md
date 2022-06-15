# cucumberbdd

Cucumber BDD Framework for evaluation

# How to Run

In terminal run below command

    # Chrome
        mvn clean test -Dbrowser=chrome
    # Firefox
        mvn clean test -Dbrowser=firefox
    # Default - Chrome
        mvn clean test -Dbrowser=chrome
To choose different environment run below command

mvn clean test -Denv=STAGE  or mvn clean test -Denv=PROD

# Report
    
    After run - in terminal - reports link will be available