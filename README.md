# GUI-
GUI Medical Management System 

This project is a result of the assignment given by CCT on 3rd Semester of Computing Science.

Assignment Introduction
A doctor has contacted you to develop a solution for managing the patient records of his practice. The
doctor is having issues finding records of current patients and would like a solution that will make finding
the patients easier, allowing for a faster turnaround time with the billing for clients.
The system that will be developed is an all-encompassing solution which all of the different staff members
in the doctors practice will be using.
Account Types
The system should have three user account types, each of which can all login from the same login window.
Depending on their account type, they will be sent to a different dashboard where they can choose the task
they wish to complete.
 Receptionist – Mainly focused on making appointments in the system and taking different
messages which have been left for the doctor.
 Doctor – The doctor can view all of the messages which have been left for him, search for different
patients in the database, and take notes about the current patient and make notes about the time
they visited and details of the different medication which have been prescribed to them.
 Billing Department – This account type is only focused upon the billing aspects of the practice.
Every week, all of the bills for each customer will be added up and a complete total should be added
which is then printed and given to the customer. A method should exist which will create the letter
structure for the client to make it easier to see what they are being billed for, when they visited and
how much the current bill totals to.
System Requirements
 A method must exist in the system which allows the billing manager of the practice to search for a
client. After they have found the client they are interested in, all of the bills for that client up to the
current date must be shown. The current status of each bill should be shown, outlining if they are
paid or unpaid. A method should exist to change the status of a bill to PAID or UNPAID.
 A method should exist which allows the receptionist keep a log of all of the phone calls which are
made to the doctors practice. A note taking system should be included which allows the receptionist
to take a note, the current date and time and also the phone number which the customer can be
reached on.
 When the doctor logs into the system, the main dashboard of the system should contain a list of all
the messages that have been left for the doctor. If the doctor has received the message, the doctor
should be able to flag the message to say that it has been received and it should not appear again
on his dashboard.
 The doctor should be able to search the system for each of the different clients he has been working
with. When the doctor selects the client they are interested in, all of client profile window should
open showing the doctor all of the information about the client including their name, address and
telephone number, any messages which have been left with the receptionist regarding the current
client and also a list of all of the medical history and medications which have been prescribed to
them.
 The doctor is very concerned about the different medications which are prescribed to each of the
clients. At the end of this document is a list of the different medications which are prescribed to
different clients. If two medications from the same category are prescribed to a client, a method
must exist in the system which will alert the doctor in the future whenever the doctor opens their
dashboard.
 All of the information which is entered by the receptionist, doctor and billing manager must all be
stored in individual database tables. Each table must contain an ID column which is unique and
auto incremented. This will allow the process of deleting individual records to be much simpler.
 As human errors often occur, options should exist in the system which will allow patient records to
be deleted and also different bills in the system. When they are deleted, they should be removed
from the database and also from the GUI the user is currently viewing. You may need to fresh the
GUI to ensure that the latest information is being shown.
 When the program first opens, all of the information relative to that users dash board must be
loaded.
 The customer is interested in having menus added to the top of their application to make the
process of technical support easier. Devise a collection of menus which can be added to the top of
the application, and each of the elements which should be added. Each of the dashboard for each
user type should have their own menu items added.
 A method should exist in the program which will allow the current user to logout of the system.
When this happens, the current window should close and the login screen should be opened.
 The entire project should be packaged as a single runnable jar file which can easily be installed on
a users’ system.
 When a client is finished with the doctor, they must settle their bill. To do this, when a client leaves
they will speak to the receptionist who will create a new bill for the customer. The bill should contain
a list of each different type of service they just received and the price which is associated to it. e.g, 
general doctors visit: 50 euro, prescription requested: 30 euro etc. Each of these options should be
available to the receptionist from a drop down menu, preventing them to randomly enter in their
own types of fees. Fields for the current date and time must also be added. These should be
populated by calling Java libraries to get the current date and time. A reference to the patient’s
medical file should be stored with the bill in the database to ensure they can be tracked in the
future.
 The fields to enter the username and password into the system must be validated to ensure the
user does not attempt to login without details or incorrect details. Use a JOptionPane to prompt
information to the user if a login was unsuccessful
