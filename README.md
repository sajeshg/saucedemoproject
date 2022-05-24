# saucedemoproject
About the project:

This project automates the functionalities in https://www.saucedemo.com/

The login, product listing, shopping cart, checkout and confirmation pages are validated for positive scenarios. A single product is added to cart, and the item details in the cart are validated against the details of the item added. The item is then checked out with sample user details and the confirmation page is also validated. There are a total of 6 test cases.

To achieve maintainability and to avoid redundancy, Page Object Model is used to store the locators of the webelements.

The "data.properties" file contains the data to provide the values globally to the tests.

The events and failures are logged as info and error respectively in the "prints.log" document in the logs folder.

When a test fails, the failure is logged, and screenshot of the same is taken and saved in the reports folder as well as in extent reports. 

The extent reports can be found in the reports folder by opening the "index.html" page in a browser.

For best experience the project can be run as a TestNg Suite from TestNg.xml file. It can also be run with Maven commands.

Built with:

Eclipse IDE
Java
Selenium
TestNg 
Maven

Contact:
sajesh20@gmail.com

Project link:
https://github.com/sajeshg/saucedemoproject.git