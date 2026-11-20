Part 2 video link 
https://www.dropbox.com/scl/fi/a3tcc8ejvppajk8h2xgvv/Part-2.mp4?rlkey=0kvtivui1mjk8fmszam7nejag&st=q1o2fyhm&dl=0

Part 3 video link 
https://www.dropbox.com/scl/fi/3gs77tkaqowehnx8ev0td/Part-3.mp4?rlkey=j5ibic7mrgdisg9biwyei5qqq&st=wv4ks39z&dl=0



AI Writeups Document
https://www.dropbox.com/scl/fi/b6reo9wolj7sjgvcb6yw3/AI-Use-Write-Up.pdf?rlkey=qlredsinjgke9ig88uenlygsg&st=xbaayi8a&dl=0

PlayStore Delopyment Prep
https://www.dropbox.com/scl/fi/d9046in35p741hsada6hn/App-Deployment-Prep.pdf?rlkey=1m1i6qkrbmca2bqcc531iq5m6&st=qwtindgr&dl=0





Contents
Introduction	3
Overview	4
Name:	4
Logo:	4
Innovative features:	4
Requirement:	6
User interface design:	7
API Design:	8
Overview:	8
GTFS:	8
WebSocket:	8
Rest APIs:	8
Database:	9
UML Diagram:	10
Data and Data types:	13
Project Plan:	14
Conclusion	15
References	16











 
Introduction
Technology has greatly improved the transportation system, considering the introduction of apps like Uber, inDrive, and Bolt, although public transport is a very big competitor in the market its still lacks some technological advancements to make it compete in today’s IT driven world.
This document serves the purpose of Explaining the planning and design processes of a mobile application named: “Busco.”, Which is aimed at adopting some features from the three ride-hailing app and implementing them into the “Busco.”, app, with aims of making using public bus transport for any one as easy as using one of the ride-hailing services.













 
Overview 
The proposed application is a digital public bus service application and transportation platform that lets users see bus schedules, plan out routes, use cashless payment, book tickets, track bus routes, and get updates on busses through a mobile application. The system will operate in a manner similar to ride-hailing platforms such as Uber, inDrive, and Bolt, but will focus primarily on public and shared transportation.
Name: 
Busco.
Logo:
 
Innovative features: 
Upfront- pricing - usually public bus fare is fixed, when the user wants to book a ticket or add credits to their in-app wallet the current price will be displayed and calculated for ither a return trip or a commute period.
Live racking / Real-time tracking 
– other that notifications the user should be able to see when the buss is approaching their location or chosen bus stop, and when on the bus be able to se where on the route the bus is currently at.
Cashless payment – in today’s system people have to line up in designated bus terminals to be able to buy tickets and add credits on their accounts, this feature allow the user to link to their bank account so they can buy and add credits whenever and wherever they are, wit the use of the application.
Schedule rides – regular commuters have the option to set reminders for whatever time they choose, and the will get reminded when their bus in on route, single users also have the option to schedule a ride at specific time and the app will remind them when that time has arrived.
Notifications – the platform needs to be able to alert the user when their scheduled ride is approaching, when they are running out of credits, when the bus is delayed for that hour or if the bus service is out of service.
Ticket buying – This option is for single users they have the option to buy a once off ticket instead of having to get a card from the bus terminus, using their payment information.
Trip payment QR scanning – as proof of payment the user can use their phone to tap or scan a generated QR code on their phone as proof of payment, once for single users and for commuters the balance will be deducted. 
GPS tracking – the app will have to access the phones GPS to suggest nearby buss stops and be able to also suggest routes and calculate fare prices and estimated time of arrival.
Route/location search – the user will be able to search for a location, and a bus timetable will be displayed with buses going through that location or close to it. A list of a specific bus timetable will be displayed through search. 
Trip history – the app keeps track of all trips you have taken and makes suggestions based on past information.
In app wallet – for commuters the platforms offers them a way to link their current bus cards with credits, and to have a wallet in app to keep their funds for future use.








 
Requirement: 
Log In and Register – for security reasons each user will have to register for an account on the app since it will uses sensitive banking information.
Single Sign on (SSO) – for ease of use, if the user has a social media account or email account they can choose to log in with either and the needed information will be automated. The user has the option to stay log in on their devices avoiding logging in each time they use the app.
Setting – uses have different presences some other like a bigger font size, some other want notifications and the settings page offers more control of the app to the user.
Rest API – the app needs to work over the internet to do that the app will use APIs to communicate with the backend system, to calculate fares, routes, and all the other features.
Offline/ online Mode – the app will function offline and online allowing users to use the app without data connectivity, but the app will have limited functionality.
Auto Synchronization – after offline use the app will automatically update with the main backend for accurate information.
Real-time Notification – some features on the app a designed to use a notification system, like updates, so the back-end systems will be linked to a notification system. 
Multi-language – in settings the user has the option to choose the language they prefer to use on the app’s interface. 
Route tracking - when the user is on the bus, they need to be able to see where on the route the bus is currently located.
Cashless payment - in today’s system people have to line up in designated bus terminals to be able to buy tickets and add credits on their accounts, this feature allow the user to link to their bank account so they can buy and add credits whenever and wherever they are, wit the use of the application
Schedule rides – regular commuters have the option to set reminders for whatever time they choose, and the will get reminded when their bus in on route, single users also have the option to schedule a ride at specific time and the app will remind them when that time has arrived.
Ticket buying – This option is for single users they have the option to buy a once off ticket instead of having to get a card from the bus terminus, using their payment information.
Trip payment QR scanning – as proof of payment the user can use their phone to tap or scan a generated QR code on their phone as proof of payment, once for single users and for commuters the balance will be deducted. 
Route planning – user will be able to type in their location / GPS  allocated and where they want to go and the app will offer the best rout to take and on which bus to get on to, to be able to get there or as close as possible. 

User interface design:
Log In Page:
The log in Screen where the user inputs their details to log on the application.
 



Registration page: 
 

Dashboard:
Dashboard screen where the user will land after logging In.
 

Settings:
Setting page.















Profile Settings: 
 
Loyalty Points:
 



Transfers:
 



Payment methods:
   





Language:
 
Theme:
 
Notification:
 


Cards:
 



Schedule:
 
 

API Design: 

Overview:
For an efficient and smooth experience, and performance of the application its designs uses a combination of API designs, considerations were made mainly that the app gas to have real time live tracking which needs An API that is instant, (WebSocket) combined with GTFS, GTFS-Realtime and sending data back and forth can easily be achieved using a rest API

GTFS:
This API severs as a storage for government transport data, as files / zipped files, its divide into two static and real-time which will allow the platform to know the routes of a specific municipality’s transportation data, where buses are and where are they going, but this API alone is not efficient when it comes to displaying data to the user for that, the next API will be used which are WebSocket which allow for instantaneous data transfers more on the nest section.
WebSocket:
For faster data transfers WebSocket are the decided upon APIs because their design keeps then online with very little time of refreshing and delays, the GPS location of the bus will be transmitted through to the use for them to track the bus and their location will be sent back to compare data whilst in transit with the data found on The GTFS data source.

Rest APIs:
For information transfer that are not time sensitive a rest API will work just fine like registration, bus timetable searches, logging trips.
POST Busco./api/v1/auth/register 
GET Busco./api/v1/auth/login 
POST Busco./api/v1/auth/logout 
POST Busco./api/v1/auth/otp 
GET Busco./api/v1/auth/search
GET Busco./api/v1/auth/Schedule
DELET Busco./api/v1/auth/DeleteAccount



Database:
Database considerations: for local storage room database will be used, with online since with both MongoDB and PostgreSQL DB, MongoDB will store user information since its non-SQL, PostgreSQL will store timetable, trips and all hierarchical information.











 
UML Diagram: 
                   


 
Data and Data types:
Email : String with Email validation.
Password: String with character limitation and validation.
Card number: Int.
Name on Card: String.
Card Expiration date: Int.
CVV Code: Int.
Location for Search: String.
GPS Location lat and long: double.
Images: binary.














 
Project Plan:
Lease see attached Excel File.!!














 
Conclusion
The ease of digital ride-hailing services is combined with the affordability and capacity of public transit in the proposed public bus application.
The main idea is to provide a platform that allows users to find, reserve, pay for, and monitor public transportation using their cell phones. Reliability, safety, affordability, simplicity, and real-time information should be the main priorities for successful adoption.
The long-term goal is to create a scalable transportation ecosystem that preserves the cost and capacity benefits of public transit while making bus travel as accessible and manageable as contemporary ride-hailing services.












 
References 


