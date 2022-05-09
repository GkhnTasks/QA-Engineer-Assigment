### Project Settings 

 I used Selenium to automate browser for this task.
 Language : Java 11 SE 
 Build Management Tool : Maven 
 Framework : BDD Cucumber-Java 


### How to run website 

I installed global server to run this website in local with following commands 
  npm i -g serve

In Intellij terminal I opened project folder with commands then with the help of this command( serve -s ./  )
I opened website locally in localhost:3000


### How to run project  

In CukesRunner class there is tags to run spesific feature from there.To run all features at a time 
I used @wip tag in feature level.If you want to run spesific one just remove this tag over related scenario 


### How to get Report for Cucumber 
After run testcases there is link to open cucumber-report in the cloud to see detail.
You will see this at the end of build execution.

To get cucumber report locally you need to run project from Maven --> Lifecycle --> Verify
I added maven plugins to get cucumber report locally in target folder