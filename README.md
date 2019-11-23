## G_Challenge

#### What is it?

This my submission for the Gambit Challenge (https://github.com/gambit-labs/challenge). This solution takes the second option offered: Retrieve and parse the data and present it as is in a mobile friendly format. More specifically, it's a simple Java web application that uses a Servlet (Serv.java) to retrieve and handle the content of the text feed containing the meter data (http://tuftuf.gambitlabs.fi/feed.txt), and then presents said data in a web page (index.jsp).

#### How it works?

Since the program is rather simple, we can do a step by step breakdown on how it works.

1. As the Serv.java (which has a url pattern of /Serv. When running on local Tomcat server, the url to run Serv.java is "http://localhost:8080/mittari_w/Serv") is invoked by a browser, the doGet() method is called.
2. A URL object "url" is created, taking the url of the TUF-2000M text feed (http://tuftuf.gambitlabs.fi/feed.txt) as an argument.
3. A Scanner "sc" is created, taking the contents of the text feed as an argument. Scanner is used as it's a simple and convenient tool for handling text where datapoints are predictably broken into lines.
4. A StringBuilder "body" is created to contain the data. A StringBuilder is used in lieu of standard String because of its inbuilt append() method, which is vastly more convenient way to append strings than the various concatenation methods available for standard String class.
5. The first line of the text feed, containing date and time is appended to "body".
6. A HTML HR (Horizontal Rule) element is appended in "body" in order to visually separate the date and time from register values.
7. A while loop will go through the rest of lines, containing register values, until there's no more lines left. Each line, along a HTML BR (Line break) element, will be appended to "body".
8. As it's no longer needed, the Scanner object "sc" is closed.
9. An attribute is set to the request, which is given "content" (matching the EL expression ${content} in the index.jsp) as a name and the contents of "body", converted to string as a value.
10. The request is then forwarded to index.jsp.
11. index.jsp receives the "content" attribute, matches it with the ${content} expression, and sets its contents in that place.
12. At this point, the user should be seeing a simple web page showing a date and time, a horizontal rule and the register values broken into lines.

#### Other notes

* The relevant code is in the "mittari_w" folder. "mittari" is a test project that simply reads the contents of "feed.txt" and prints them on a console. 
* Because this application uses entirely server side scripting, it should theoretically work without problems regardless of device or browser used, given that it's deployed on a compatible server like Apache Tomcat or JBoss.
* To account for various screen sizes, the font size is defined relative to viewport. As some mobile devices have pretty small screens, the font size is rather generous 6vw. This may look ridiculously huge in larger screens.
* index.jsp is placed in the WEB-INF folder in order to prevent users directly accessing it.
