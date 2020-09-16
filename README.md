# TestTaskGetnada
There is a test-automation framework in accordance to the Test Task.
Test steps are:
1. Send RestApi GET requests and confirm that responses are avaliable (3 test methods);
2. Open temp mail page, save mail address and check that it is not empty(1 test method);
3. Get links from responses and check that they are not empty (1 test method);
4. Send links in mail message frome gmail account to temp-mail account.
	Recieve email with links and make sure that they are equals with original links.(1 test method).
After test there is browsing by links and making screenshots. Screenshots will be saved in root project folder(TestTaskGetnada\).

Tools

IntelliJ IDEA; 
Maven 3.6.3;
Git 2.25.0.windows.1;

Requirements

In order to utilise this project you need to have the following installed locally:

Git (https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
Java SDK 1.8 or higher (https://www.java.com/en/download/help/index_installing.xml)
Maven 3.6.3 or higher (https://maven.apache.org/index.html)

Getting Started

Clone this repository to your local machine with command:
"git clone https://github.com/zmiin-pm/TestTaskGetnada.git".

Copy or create file with credetials of gmail account in '..TestTaskGetnada\src\main\resources' folder.
Filename must be 'credentionals' without file extension.
File must contain two strings: 
1 - email address ('emailaddress@gmail.com' for example);
2 - password ('Password123?' for example).

Go to the root project folder ('E:\...\TestTaskGetnada' for example).

To run test from console please execute: 

'mvn clean test' - Chrome browser will be used; 
'mvn clean test -Ddriver.type=opera' - Opera browser will be used;
'mvn clean test -Ddriver.type=firefox' - Firefox browser will be used;
