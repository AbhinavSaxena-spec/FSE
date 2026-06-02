ANSI SQL Using MySQL Exercises 
 
Database Schema 
 
1. Users 
Column Name Data Type Constraints Description 
user_id INT PRIMARY KEY, AUTO_INCREMENT Unique user identifier 
full_name VARCHAR(100) NOT NULL User’s full name 
email VARCHAR(100) UNIQUE, NOT NULL User’s email 
city VARCHAR(100) NOT NULL City of the user 
registration_date DATE NOT NULL Date when user registered 
 
2. Events 
Column 
Name 
Data Type Constraints Description 
event_id INT PRIMARY KEY, AUTO_INCREMENT Unique event identifier 
title VARCHAR(200) NOT NULL Title of the event 
description TEXT 
 
Event description 
city VARCHAR(100) NOT NULL City where event is held 
start_date DATETIME NOT NULL Start date and time of event 
end_date DATETIME NOT NULL End date and time of event 
status ENUM ('upcoming','completed','cancelled') Current status of the event 
organizer_id INT FOREIGN KEY → Users(user_id) User who organized the 
event 
 
3. Sessions 
Column Name Data Type Constraints Description 
session_id INT PRIMARY KEY, AUTO_INCREMENT Unique session identifier 
event_id INT FOREIGN KEY → Events(event_id) Associated event 
title VARCHAR(200) NOT NULL Title of the session 
speaker_name VARCHAR(100) NOT NULL Name of speaker 
start_time DATETIME NOT NULL Session start time 
end_time DATETIME NOT NULL Session end time 
 
4. Registrations 
Column Name Data Type Constraints Description 
registration_id INT PRIMARY KEY, AUTO_INCREMENT Unique registration ID 
user_id INT FOREIGN KEY → Users(user_id) User who registered 
event_id INT FOREIGN KEY → Events(event_id) Registered event 
registration_date DATE NOT NULL Date of registration 
 
5. Feedback 
Column Name Data Type Constraints Description 
feedback_id INT PRIMARY KEY, AUTO_INCREMENT Unique feedback ID 
user_id INT FOREIGN KEY → Users(user_id) User who gave feedback 
event_id INT FOREIGN KEY → Events(event_id) Event for which feedback is given 
rating INT CHECK (rating BETWEEN 1 AND 5) Rating out of 5 
comments TEXT 
 
Optional comments 
feedback_date DATE NOT NULL Date of feedback 
 
6. Resources 
Column Name Data Type Constraints Description 
resource_id INT PRIMARY KEY, AUTO_INCREMENT Unique resource ID 
event_id INT FOREIGN KEY → Events(event_id) Associated event 
resource_type ENUM ('pdf','image','link') Type of resource 
resource_url VARCHAR(255) NOT NULL Path or link to resource 
uploaded_at DATETIME NOT NULL Upload timestamp 
 
 
Sample Dataset 
 
1. Users 
 
user_id full_name email city registration_date 
1 Alice Johnson alice@example.com New York 2024-12-01 
2 Bob Smith bob@example.com Los Angeles 2024-12-05 
3 Charlie Lee charlie@example.com Chicago 2024-12-10 
4 Diana King diana@example.com New York 2025-01-15 
5 Ethan Hunt ethan@example.com Los Angeles 2025-02-01 
 
2. Events 
 
event_i
d 
title description city start_dat
e 
end_dat
e 
status organizer_i
d 
1 Tech 
Innovators 
Meetup 
A meetup for 
tech 
enthusiasts. 
New 
York 
2025-06
10 
10:00:00 
2025-06
10 
16:00:00 
upcoming 1 
2 AI & ML 
Conference 
Conference on 
AI and ML 
advancements
. 
Chicag
o 
2025-05
15 
09:00:00 
2025-05
15 
17:00:00 
complete
d 
3 
3 Frontend 
Developmen
t Bootcamp 
Hands-on 
training on 
frontend tech. 
Los 
Angele
s 
2025-07
01 
10:00:00 
2025-07
03 
16:00:00 
upcoming 2 
 
3. Sessions 
 
session_id event_id title speaker_name start_time end_time 
1 1 Opening Keynote Dr. Tech 2025-06-10 
10:00:00 
2025-06-10 
11:00:00 
2 1 Future of Web 
Dev 
Alice Johnson 2025-06-10 
11:15:00 
2025-06-10 
12:30:00 
3 2 AI in Healthcare Charlie Lee 2025-05-15 
09:30:00 
2025-05-15 
11:00:00 
4 3 Intro to HTML5 Bob Smith 2025-07-01 
10:00:00 
2025-07-01 
12:00:00 
 
4. Registrations 
 
registration_id user_id event_id registration_date 
1 1 1 2025-05-01 
2 2 1 2025-05-02 
3 3 2 2025-04-30 
4 4 2 2025-04-28 
5 5 3 2025-06-15 
 
5. Feedback 
 
feedback_id user_id event_id rating comments feedback_date 
1 3 2 4 Great insights! 2025-05-16 
2 4 2 5 Very informative. 2025-05-16 
3 2 1 3 Could be better. 2025-06-11 
 
6. Resources 
 
resource_i
d 
event_i
d 
resource_ty
pe 
resource_url uploaded_
at 
1 
2 
1 
2 
pdf 
image 
https://portal.com/resources/tech_meetup_agen
da.pdf 
https://portal.com/resources/ai_poster.jpg 
2025-05
01 
10:00:00 
2025-04
20 
09:00:00 
3 
3 
link 
https://portal.com/resources/html5_docs 
2025-06
25 
15:00:00 
Exercises 
1. User Upcoming Events 
Show a list of all upcoming events a user is registered for in their city, sorted by date. 
2. Top Rated Events 
Identify events with the highest average rating, considering only those that have received at 
least 10 feedback submissions. 
3. Inactive Users 
Retrieve users who have not registered for any events in the last 90 days. 
4. Peak Session Hours 
Count how many sessions are scheduled between 10 AM to 12 PM for each event. 
5. Most Active Cities 
List the top 5 cities with the highest number of distinct user registrations. 
6. Event Resource Summary 
Generate a report showing the number of resources (PDFs, images, links) uploaded for each 
event. 
7. Low Feedback Alerts 
List all users who gave feedback with a rating less than 3, along with their comments and 
associated event names. 
8. Sessions per Upcoming Event 
Display all upcoming events with the count of sessions scheduled for them. 
9. Organizer Event Summary 
For each event organizer, show the number of events created and their current status 
(upcoming, completed, cancelled). 
10. Feedback Gap 
Identify events that had registrations but received no feedback at all. 
11. Daily New User Count 
Find the number of users who registered each day in the last 7 days. 
12. Event with Maximum Sessions 
List the event(s) with the highest number of sessions. 
13. Average Rating per City 
Calculate the average feedback rating of events conducted in each city. 
14. Most Registered Events 
List top 3 events based on the total number of user registrations. 
15. Event Session Time Conflict 
Identify overlapping sessions within the same event (i.e., session start and end times that 
conflict). 
16. Unregistered Active Users 
Find users who created an account in the last 30 days but haven’t registered for any events. 
17. Multi-Session Speakers 
Identify speakers who are handling more than one session across all events. 
18. Resource Availability Check 
List all events that do not have any resources uploaded. 
19. Completed Events with Feedback Summary 
For completed events, show total registrations and average feedback rating. 
20. User Engagement Index 
For each user, calculate how many events they attended and how many feedbacks they 
submitted. 
21. Top Feedback Providers 
List top 5 users who have submitted the most feedback entries. 
22. Duplicate Registrations Check 
Detect if a user has been registered more than once for the same event. 
23. Registration Trends 
Show a month-wise registration count trend over the past 12 months. 
24. Average Session Duration per Event 
Compute the average duration (in minutes) of sessions in each event. 
25. Events Without Sessions 
List all events that currently have no sessions scheduled under them. 
