# Api-Test-Rest-Assured-TestNG
API Test with Rest Assured and TestNG

This API testing framwork is built using Rest Assured with Eclipse as IDE tools and integrate with Maven and TestNG. 

**Step by step guide for the setup of Rest Assured.io**

1) Install Java. 

2) Download an IDE Eclipse.

3) Install Maven and set up your eclipse. Refer https://www.guru99.com/maven-jenkins-with-selenium-complete-tutorial.html.

**Add Depedencies on POM.xml**

Add the below dependency to your POM.xml:

```
<dependency>
  <groupId>io.rest-assured</groupId>
  <artifactId>rest-assured</artifactId>
  <version>4.3.3</version>
  <scope>test</scope>
</dependency>

<dependency>
  <groupId>org.testng</groupId>
	<artifactId>testng</artifactId>
	<version>7.3.0</version>
	<scope>test</scope>
</dependency>

<dependency>
	<groupId>org.json</groupId>
	<artifactId>json</artifactId>
	<version>20201115</version>
</dependency>
```

**How to Install Maven**

You can refer to this => https://www.journaldev.com/2348/install-maven-mac-os

**How To Run from Eclipse**

1) Clone the project : `git clone https://github.com/yafifaisal/Api-Test-Rest-Assured-TestNG.git`

2) Open project with Eclipse.

3) Right click on the project folder. 

4) Select Mvn test.

**How To Run from Command Line**

1) Open Terminal. 

2) Make sure you already on the path project.

3) type `mvn test`

**How to get Report**

1) Open Project. 

2) Open folder test-output.

3) Then open emailable-report.html
